package servlets;

import entities.User;
import model.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/SignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User(req.getParameter("login"), req.getParameter("password"));
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


                req.getRequestDispatcher("/signin").forward(req, resp);
            } else {
                req.getRequestDispatcher("views/SignUp.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
            req.getRequestDispatcher("/views/PageNotFound.jsp").forward(req, resp);
        }

    }
}
