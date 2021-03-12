package servlets;

import entities.User;
import model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        User user = new User();
        user.setSex(Integer.parseInt(req.getParameter("sex")));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setPh_number(req.getParameter("ph_number"));
        user.setTest_id(0);

        Model model = Model.getInstance();
        try {
             model.SignUp(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            session.setAttribute("name", user.getName());
            session.setAttribute("surname", user.getSurname());


            req.getRequestDispatcher("views/HomePage.jsp").forward(req, resp);
        }
        else
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
