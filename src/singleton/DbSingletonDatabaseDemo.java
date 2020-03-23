package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingletonDatabaseDemo {

    private static volatile DbSingletonDatabaseDemo instance = null;
    private static volatile Connection conn = null;

    private DbSingletonDatabaseDemo(){
        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(conn != null){
            throw new RuntimeException("Use getConnection() method to create");
        }

        if(instance != null){
            throw new RuntimeException("Use getConnection() method to create");
        }
    }

    public static DbSingletonDatabaseDemo getInstance(){
        if(instance == null){
            synchronized (DbSingletonDatabaseDemo.class){
                if(instance == null){
                    instance = new DbSingletonDatabaseDemo();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        if(conn == null){
            synchronized (DbSingletonDatabaseDemo.class){
                if(conn == null){
                    try{
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }

}
