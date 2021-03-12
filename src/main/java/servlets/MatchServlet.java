package servlets;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Model model = Model.getInstance();
        try {
            if (user == null) {
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                System.out.println(login + " " + password);
                user = model.SignIn(login, password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (user != null) {
            System.out.println("matched");
            try {
                List<User> Matches = model.findMatches(user);
                System.out.println(Matches.size());
                List<String> usersContacts = new ArrayList<String>();
                Iterator<User> iter = Matches.iterator();
                while (iter.hasNext()) {
                    //System.out.println(iter.next().getUserContact());
                    usersContacts.add(iter.next().getUserContact());
                }
                session.setAttribute("usersContacts", usersContacts);
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Match.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);

    }
}