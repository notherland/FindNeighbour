package model;

import DBAccess.UsersInteraction;
//import entities.Test;
import entities.Test;
import entities.User;

import java.sql.SQLException;
import java.util.List;

public class Model {
    private static Model instance = new Model();

    public static Model getInstance() {
        return instance;
    }

    public User SignIn(String login, String password) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        User user = ui.findByLogin(login);
        if (user != null) {
            System.out.println(user.getLogin());
            if (password.equals(user.getPassword()) == false)
                return null;
        }
        return user;
    }

    public boolean SignUp(User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        User newuser = ui.findByLogin(user.getLogin());
        if (newuser != null) return false;

        if (ui.addNewUser(user)) return true;

        return false;
    }

    public void saveTest(Test test, User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        ui.addNewTest(test, user);
    }

    public List<User> findMatches(User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        return ui.findMatches(user);
    }

}
