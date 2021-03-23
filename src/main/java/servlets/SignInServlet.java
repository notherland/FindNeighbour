package servlets;

import entities.User;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SUGNIN GET");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null)
            req.getRequestDispatcher("views/HomePage.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("views/SignIn.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SIGNIN POST");
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Model model = Model.getInstance();
        User user = null;
        try {
            user = model.SignIn(login, password);
        } catch (SQLException throwables) {
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
