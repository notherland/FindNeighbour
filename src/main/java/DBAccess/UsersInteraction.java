package DBAccess;

import entities.Test;
import entities.User;
//import entities.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersInteraction {
    public User findByLogin(String login) throws SQLException {
        ConnectionManager cm = new ConnectionManager();
        Connection conn = cm.getConnection();
        PreparedStatement ps = null;
        User user = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM USERS.PERSON where LOGIN = ?");
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();//returns sql result

            if (resultSet.next()) {
                user = createNewUser(resultSet);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return user;
    }

    public boolean addNewUser(User user) throws SQLException {
        ConnectionManager cm = new ConnectionManager();
        Connection conn = cm.getConnection();
        PreparedStatement ps = null;

        if (conn != null) {//Check connection
            try {
                ps = conn.prepareStatement("insert into USERS.PERSON (SEX, LOGIN, PASSWORD, NAME, SURNAME, PH_NUMBER) values (?,?,?,?,?,?)");
                ps.setInt(1, user.getSex());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getPassword().getPassword());
                ps.setString(4, user.getName());
                ps.setString(5, user.getSurname());
                ps.setString(6, user.getPh_number());

                ps.executeUpdate();
                ps.close();
                conn.close();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            }
        }
        return false;
    }

    public boolean addNewTest(Test test, User user) throws SQLException {
        ConnectionManager cm = new ConnectionManager();
        Connection conn = cm.getConnection();
        PreparedStatement ps = null;

        if (conn != null) {
            try {
                ps = conn.prepareStatement("replace into USERS.TEST (ANS1, ANS2, ANS3, ANS4, ANS5, ANS6, ANS7, USER_ID) values (?, ?, ?, ?, ?, ?, ?, ?)");
                int[] Answers = test.getAnswers();
                for (int i = 0; i < 7; i++) {
                    ps.setInt(i + 1, Answers[i]);
                }
                ps.setInt(8, user.getPerson_id());
                ps.executeUpdate();

                ps.close();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            }
        }
        return false;
    }

    public List<User> findMatches(User user) throws SQLException {
        ConnectionManager cm = new ConnectionManager();
        Connection conn = cm.getConnection();
        PreparedStatement ps = null;
        Test test = null;
        List<User> Matches = null;

        if (conn != null) {
            //Get main users test
            try {
                ps = conn.prepareStatement("SELECT * FROM USERS.TEST WHERE USER_ID = ?");
                ps.setInt(1, user.getPerson_id());
                ResultSet resultSet = ps.executeQuery();//returns sql result
                if (resultSet.next())
                    test = createNewTest(resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //iterate on other user's tests list, choose best matches
            if (test != null) {
                Matches = new ArrayList<User>();
                try {
                    ps = conn.prepareStatement("SELECT * FROM USERS.TEST WHERE USER_ID != ?");
                    ps.setInt(1, user.getPerson_id());
                    ResultSet resultSet = ps.executeQuery();//Select tests
                    int BestCount = 0;
                    int count = -1;

                    while (resultSet.next()) {
                        //find user by foreign key
                        int user_id = resultSet.getInt(("USER_ID"));

                        PreparedStatement Userps = conn.prepareStatement("SELECT * FROM USERS.PERSON WHERE PERSON_ID = ? AND SEX = ?");
                        Userps.setInt(1, user_id);
                        Userps.setInt(2, user.getSex());
                        ResultSet UserResultSet = Userps.executeQuery();//Select user with test

                        if (UserResultSet.next()) {
                            User MatchUser = createNewUser(UserResultSet);
                            Test NewTest = createNewTest(resultSet);
                            count = test.countMatches(NewTest);

                            if (count == BestCount)
                                Matches.add(MatchUser);

                            if (count > BestCount) {
                                Matches.clear();
                                Matches.add(MatchUser);
                                BestCount = count;
                            }
                        }
                    }
                    return Matches;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();

                } finally {
                    if (ps != null)
                        ps.close();
                    if (conn != null)
                        conn.close();
                }
            }
        }
        return Matches;
    }

    private Test createNewTest(ResultSet resultSet) throws SQLException {
        Test test = new Test();
        int ans1 = resultSet.getInt("ans1");
        int ans2 = resultSet.getInt("ans2");
        int ans3 = resultSet.getInt("ans3");
        int ans4 = resultSet.getInt("ans4");
        int ans5 = resultSet.getInt("ans5");
        int ans6 = resultSet.getInt("ans6");
        int ans7 = resultSet.getInt("ans7");
        int[] Answers = {ans1, ans2, ans3, ans4, ans5, ans6, ans7};

        test.setAnswers(Answers);
        test.setUser_id(resultSet.getInt("user_id"));

        return test;
    }

    private User createNewUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        if (resultSet != null) {
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setSex(resultSet.getInt("SEX"));
            user.setPerson_id(resultSet.getInt("PERSON_ID"));
            user.setName(resultSet.getString("NAME"));
            user.setSurname(resultSet.getString("SURNAME"));
            user.setPh_number(resultSet.getString("PH_NUMBER"));
        }

        return user;
    }
}
