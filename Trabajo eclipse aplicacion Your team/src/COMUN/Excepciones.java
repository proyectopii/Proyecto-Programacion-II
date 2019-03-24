package COMUN;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 

public class Excepciones {
	/**
	 * Aquí meteremos con try catch posible excepciones que se puedan ocasionar para
	 * la base de datos
	 */
	 private static Excepciones instance = null;
	 /**
	  * Por ejemplo está por si ha habido fallos con la conexión
	  */
	 
	    private Connection connection = null;
	 
	    private void checkConnected()
	    {
	            if (connection == null)
	                    throw new IllegalStateException(
	                                    "La conexion a la BD no ha sido creada todavia.");
	    }
	 
	    private Excepciones()
	    {
	    }
	 
	    public static Excepciones getInstance()
	    {
	    	/**
	    	 * Aquí ponemos excepción por el tema de drivers
	    	 */
	        if (instance == null)
	        {
	                instance = new Excepciones();
	        }
	        return instance;
	    }
	 
	    public static void releaseInstance()
	    {
	        instance = null;
	    }
	 
	    public void connect() throws SQLException
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	        } 
	        catch (ClassNotFoundException e) {
	 
	            e.printStackTrace();
	        }
	         /**
	          * Aquí pondremos nuestra url usuario y contraseña para el workbench
	          */
	        //useSSL = true para que la conexion sea cifrada
	        String sURL = "jdbc:mysql://localhost:3306/coches?useSSL=true";
	         
	        connection = java.sql.DriverManager.getConnection( sURL , "root", "root");
	                 
	        //System.out.println("Conectado.");
	    }
	 
	    public void disconnect() throws SQLException
	    {
	    	/**
	    	 * Con este método al desconectarnos guardamos bien todo y se cierra por miedo a 
	    	 * que se pierda algo de imformación
	    	 */
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
	    	/**
	    	 * Este método es para saber si nuestra conexión está on o off
	    	 */
	        checkConnected();
	        return connection.createStatement(resultSetType, resultSetConcurrency );
	    }   
	}


