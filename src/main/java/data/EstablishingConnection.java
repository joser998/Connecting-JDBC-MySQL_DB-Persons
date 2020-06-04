/*In this class we define the methods to open and close objects like ResultSet, PreparedStatement, Connection, 
        so we can get connection with DB*/
package data;

import java.sql.*;

public class EstablishingConnection {
    /*We establish principal parameters for table in DB*/
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASS = "admin";
    
    /*getConnection method: Can throws exception from sql exception
       We can use this method to get connection with DB in MySQL WorkBench.*/
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS );
    }
    /*We define variable 'rs' and use try-catch block for any possible exception*/
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    /*We define variable 'stmt' and use try-catch block for any possible exception*/
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    /*We define variable 'con' and use try-catch block for any possible exception*/
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}