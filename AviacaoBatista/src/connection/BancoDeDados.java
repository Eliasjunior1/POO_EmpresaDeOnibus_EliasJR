package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDeDados {
	
	public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet resultset = null;
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/viacaobatista?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String pass = "admin";
        
        public static Connection getConnection() {
        	
        	try {
				Class.forName(driver);
				
				return DriverManager.getConnection(url, user, pass);
			} catch (ClassNotFoundException | SQLException e) {
				
				Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE,null, e);
			}
        	
			return connection;
        	
        }
        
        public static void closeConnection(Connection con) {
        	
        		try {
        			if(con != null) {
        				con.close();
        			}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
        	
        }
        
        public static void closeConnection(Connection con, PreparedStatement stmt) {
        	
    		closeConnection(con);
        	
        	try {
    			if(stmt != null) {
    				stmt.close();
    			}
			} catch (SQLException e) {
				
				Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE,null, e);
			}
    	
        }
        
        public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        	
    		closeConnection(con, stmt);
        	
        	try {
    			if(rs != null) {
    				rs.close();
    			}
			} catch (SQLException e) {
				
				Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE,null, e);
		}
    	
    }
}
