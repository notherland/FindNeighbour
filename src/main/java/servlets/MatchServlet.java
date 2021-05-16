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

/**
 * Class MatchServlet is responsible for interaction between user and model, when user wants to see matches
 * Can serve GET and POST requests
 */
public class MatchServlet extends HttpServlet {
    /**
     * Serves GET requests
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Model model = Model.getInstance();

        if (user == null) {//If couldnt get user from session initialize him again
            try {
                String login = req.getParameter("login");
                String password = req.getParameter("password");

                user = model.SignIn(login, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (user != null) {
            List<User> Matches = null;
            try {
                Matches = model.findMatches(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (Matches != null) {
                List<String> usersContacts = new ArrayList<String>();
                Iterator<User> iter = Matches.iterator();

                while (iter.hasNext()) {
                    usersContacts.add(iter.next().getUserContact());
                }
                req.setAttribute("usersContacts", usersContacts);

                req.getRequestDispatcher("/views/Match.jsp").forward(req, resp);
            } else
                resp.sendRedirect(req.getContextPath() + "/test");
        } else {
            resp.sendRedirect(req.getContextPath() + "/signin");
        }
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
        resp.sendRedirect(req.getContextPath() + "/signin");
    }
}