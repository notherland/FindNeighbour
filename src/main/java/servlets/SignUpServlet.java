package servlets;

import entities.User;
import model.Model;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


/**
 * Class MatchServlet is responsible for interaction between user and model, when user wants to sign up
 * Can serve GET and POST requests
 */
public class SignUpServlet extends HttpServlet {

    /**
     * Serves GET requests
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/SignUp.jsp").forward(req, resp);
    }

    /**
     * Serves POST requests
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = null;
        try {
            user = new User(req.getParameter("login"), req.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert user != null;
        user.setSex(Integer.parseInt(req.getParameter("sex")));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setPh_number(req.getParameter("ph_number"));
        user.setTest_id(0);

        Model model = Model.getInstance();

        try {
            if (model.SignUp(user)) { // Checking if user already exists
                HttpSession session = req.getSession();
                session.setAttribute("login", user.getLogin());
                session.setAttribute("name", user.getName());
                session.setAttribute("surname", user.getSurname());


                resp.sendRedirect(req.getContextPath() + "/signin");
            } else {
                req.getRequestDispatcher("views/SignUp.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
            req.getRequestDispatcher("/views/PageNotFound.jsp").forward(req, resp);
        }

    }
}