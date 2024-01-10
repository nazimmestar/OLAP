package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection cnx(){

        String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "Rapidite";
        String password = "pwd";

        try {

            Connection connection = DriverManager.getConnection(dburl, username, password);
            System.out.println("Connection etablie ");
            return connection ;

        } catch (SQLException e) {
            
            System.out.println("Error");
            e.printStackTrace();
        }
        return null;
        
        


    }
    
}
