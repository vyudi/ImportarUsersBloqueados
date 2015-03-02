package be.life.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	  	private static String LOGIN = “login”;   
	    private static String PASS  = “senha”;
	    private static String BANCO = "jdbc:mysql://localhost:3306/life";
	    	
		private static Connection con;  
	    
	    /**  
	     * Faz conex�o com o banco.  
	     *  
	     * @return Conexao.  
	     * @throws SQLException  
	     * @throws IOException  
	     */   
	    public static Connection connect() throws SQLException, IOException {   

	        try {   
  
	            Class.forName("com.mysql.jdbc.Driver"); 
	        	con = DriverManager.getConnection(BANCO,LOGIN,PASS); 
	            
	        } catch (ClassNotFoundException e) {   
	            System.out.print("\nNAo foi possivel estabelecer conexAo com a base de dados.\n");   
	            e.printStackTrace();   
	            return null;   
	        }   
	        return con;   
	    } 
	    
	    public static void close() throws SQLException{
	    	
			con.close(); 

	    }
   
}
