package model;

import DBAccess.UsersInteraction;
//import entities.Test;
import entities.Password;
import entities.Test;
import entities.User;

import java.sql.SQLException;
import java.util.List;

public class Model {//Create as Singleton
    private static Model instance;

    private Model() {}

    public static Model getInstance() {

        if (instance == null)
            instance = new Model();

        return instance;
    }

    public User SignIn(String login, String password) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        User user = ui.findByLogin(login);

        if (user != null) {
            Password rightPass = new Password(password, login);
            if (rightPass.isEqual(user.getPassword()) == false)
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

    public boolean saveTest(Test test, User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        return ui.addNewTest(test, user);
    }

    public List<User> findMatches(User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        return ui.findMatches(user);
    }

}
