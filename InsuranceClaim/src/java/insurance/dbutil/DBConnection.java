
package insurance.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
           conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-V1FRB4J:1521/XE","insurance","insurance");
           System.out.println("Connection Opened");
        }
        catch(ClassNotFoundException cnf)
        {
            System.out.println("Problem in driver loading");
            cnf.printStackTrace();
        }
        
        catch(SQLException sqle)
        {
            System.out.println("Problem in Openeing the Connection");
            sqle.printStackTrace();
        }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        try{
            conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("Connection Closed!!");
            sqle.printStackTrace();
        }
    }
}
