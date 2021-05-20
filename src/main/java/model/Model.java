package model;

import DBAccess.UsersInteraction;
//import entities.Test;
import entities.Password;
import entities.Test;
import entities.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 * Model class is responsible for interaction between view and controller
 * Realized as Singleton
 */

public class Model {//Create as Singleton
    /**
     * Model instance
     */
    private static Model instance;

    /**
     * Hide default constructor
     */
    private Model() {}

    /**
     * Create instance if it is null
     * @return instance
     */
    public static Model getInstance() {

        if (instance == null)
            instance = new Model();

        return instance;
    }

    /**
     * Check if user was signed up
     * @param login
     * @param password
     * @return User object if he was found in database
     * @throws SQLException
     */
    public User SignIn(String login, String password) throws SQLException, NoSuchAlgorithmException {
        UsersInteraction ui = new UsersInteraction();
        User user = ui.findByLogin(login);

        if (user != null) {
            Password rightPass = new Password(password, login);
            if (rightPass.isEqual(user.getPassword()) == false)
                return null;
        }
        return user;
    }

    /**
     * Signing up new user
     * @param user
     * @return true if registration was successful else false
     * @throws SQLException
     */
    public boolean SignUp(User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        User newuser = ui.findByLogin(user.getLogin());

        if (newuser != null) return false;

        if (ui.addNewUser(user)) return true;

        return false;
    }

    /**
     * Saving test in database
     * @param test
     * @param user
     * @return true if saving was successful else false
     * @throws SQLException
     */
    public boolean saveTest(Test test, User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        return ui.addNewTest(test, user);
    }

    /**
     * @param user
     * @return count of matches for user
     * @throws SQLException
     */
    public List<User> findMatches(User user) throws SQLException {
        UsersInteraction ui = new UsersInteraction();
        return ui.findMatches(user);
    }

}
