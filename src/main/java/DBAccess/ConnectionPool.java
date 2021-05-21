package DBAccess;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Class ConnectionPool contains connections with database
 * Realized as Singleton
 */
public class ConnectionPool {
    /**
     * Connection Pool instance
     */
    private static ConnectionPool instance = null;

    /**
     * Hidden default constructor
     */
    private ConnectionPool(){}

    /**
     * Create instance if it is null
     * @return ConnectionPool instance
     */
    public static ConnectionPool getInstance(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }

    /**
     * @return Connection
     */
    public Connection getConnection(){
        Context ctx;
        Connection c = null;
        try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MyPool");
            c = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

}
