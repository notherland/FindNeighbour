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
 * Class SignInServlet is responsible for interaction between user and model, when user wants to sign in
 * Can serve GET and POST requests
 */
public class SignInServlet extends HttpServlet {
    /**
     * Serves GET requests
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null)
            req.getRequestDispatcher("views/HomePage.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("views/SignIn.jsp").forward(req, resp);

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
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Model model = Model.getInstance();
        User user = null;
        try {
            user = model.SignIn(login, password);
        } catch (SQLException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            session.setAttribute("name", user.getName());
            session.setAttribute("surname", user.getSurname());
            session.setAttribute("user", user);
        }
        resp.sendRedirect(req.getContextPath() + "/signin");
    }
}