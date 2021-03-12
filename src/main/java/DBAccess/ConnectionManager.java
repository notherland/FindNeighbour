package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    public Connection getConnection() {
        try{
            String url = "jdbc:mysql://localhost/users";
            String username = "root";
            String password = "xen930013";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            return DriverManager.getConnection(url, username, password);
        }
        catch(Exception ex){
            System.out.println(ex);
            System.out.println("Failed");
        }
        return null;
    }
}