package servlets;

import entities.Test;
import entities.User;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null)
            req.getRequestDispatcher("views/Test.jsp").forward(req, resp);
        else
            resp.sendRedirect(req.getContextPath() + "/signin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Model model = Model.getInstance();

        if (user == null) {//If could'not get user from session trying to get login and password
            try {
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                user = model.SignIn(login, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
                if (model.saveTest(test, user))
                    resp.sendRedirect(req.getContextPath() + "/signin");
                else {
                    resp.sendRedirect(req.getContextPath() + "/test");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                req.getRequestDispatcher("/PageNotFound.jsp").forward(req, resp);
            }
        } else {//If counld not initialize user then authenticate him again
            resp.sendRedirect(req.getContextPath() + "/signin");

        }
    }
}
