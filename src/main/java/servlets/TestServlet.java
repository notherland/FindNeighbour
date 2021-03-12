package servlets;

import entities.Test;
import entities.User;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Test.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Model model = Model.getInstance();
        try {
            if (user == null) {
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                user = model.SignIn(login, password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (user != null) {
            Test test = new Test();
            int ans1 = Integer.parseInt(req.getParameter("ans1"));
            int ans2 = Integer.parseInt(req.getParameter("ans2"));
            int ans3 = Integer.parseInt(req.getParameter("ans3"));
            int ans4 = Integer.parseInt(req.getParameter("ans4"));
            int ans5 = Integer.parseInt(req.getParameter("ans5"));
            int ans6 = Integer.parseInt(req.getParameter("ans6"));
            int ans7 = Integer.parseInt(req.getParameter("ans7"));
            int[] Answers = {ans1, ans2, ans3, ans4, ans5, ans6, ans7};
            test.setAnswers(Answers);

            try {
                model.saveTest(test, user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
