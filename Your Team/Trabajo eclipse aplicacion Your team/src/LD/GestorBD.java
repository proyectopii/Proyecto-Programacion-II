package LD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 

public class GestorBD {
	/**
	 * Con est? clase nos conectaremos a la base de datos
	 */
	
	 
    private Connection connection = null;
 
    private void checkConnected()
    {
            if (connection == null)
                    throw new IllegalStateException(
                                    "La conexion a la BD no ha sido creada.");
    }
 
    public GestorBD()
    {
    }
 
    
    public void connect() throws SQLException
    {
    	  try
          {
              Class.forName("com.mysql.cj.jdbc.Driver");
          } 
          catch (ClassNotFoundException e) {
   
              e.printStackTrace();
          }  
        //useSSL = true para que la conexion sea cifrada
        String sURL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
         
        connection = java.sql.DriverManager.getConnection( sURL , "root", "bkn1959");
                 
        //System.out.println("Conectado.");
    }
 
    public void disconnect() throws SQLException
    {
        checkConnected();
        connection.close();
        //System.out.println("Desconectado.");
    }
 
    public Statement createStatement() throws SQLException
    {
        checkConnected();
        return connection.createStatement();
    }   
     
    public Statement createStatement(int resultSetType , int resultSetConcurrency ) throws SQLException
    {
        checkConnected();
        return connection.createStatement(resultSetType, resultSetConcurrency );
    }   
	

}
