package LD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import COMUN.itfProperty;
import LN.clsEquipacion;
import LN.clsEquipo;
import LN.clsEscudo;
import LN.clsIntercambio;
import LN.clsJugador;
import LN.clsPartidos;
import LN.clsTemporada;


public class GestorBD {
	public static List<clsEquipacion> cargarListaCoches()
	  {
	    ArrayList<clsEquipacion> vectorBD = new ArrayList<>();
	    
	    try
	    {
	      // Todos los accesos a bases de datos deben ir entre try/catch
	      // Establecemos una conexi�n con nuestra base de datos
	      GestorBD.getInstance().connect();
	         
	      // Creamos y ejecutamos una sentencia SQL
	      Statement stmt = GestorBD.getInstance().createStatement();
	       
	      //hay una tabla coches en la BD
	      ResultSet rs = stmt.executeQuery("SELECT * FROM Coches");
	       
	      // Tratamos los resultado obtenidos en la consulta SQL
	      while(rs.next())
	      {
	    	  
	        clsEquipacion nuevaEquipacion = new clsEquipacion(  	rs.getString("color1"),
	                                        rs.getString("color2"),
	                                        rs.getString("publicidad"),
	                                        rs.getString("serigrafiado"),
	                                        rs.getInt("dorsal"),
	                                        rs.getString("nombreEquipo"),
	                                        rs.getLocalDate("fundacionEquipo"));
	        vectorBD.add(nuevaEquipacion);
	      }  
	       
	    }
	    catch(SQLException se)
	    {
	         
	        se.printStackTrace();
	    }
	    
	    return vectorBD;
	  }
	   
	  
	  
	  private static Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}



	public static Coche buscarCoche(String matricula ) 
	  {
		try {
			GestorBD.getInstance().connect();

			Statement sentencia = GestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Coches where matricula = '" + matricula + "'");

			String propietario = rs.getString("propietario");
			int potencia = rs.getInt("potencia");

			Coche c = new Coche(matricula, propietario, potencia);

			return c;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		} 
	  }  
	  
	  public static boolean existeCoche(String matricula )
	  {
	    try
	    {
	       GestorBD.getInstance().connect();
	         
	      // Creamos y ejecutamos una sentencia SQL
	      Statement sentencia = 
	      GestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
	                                           ResultSet.CONCUR_UPDATABLE);
	            
	      ResultSet rs = sentencia.executeQuery("SELECT * FROM Coches where matricula = '" + matricula +"'" );
	       
	      System.out.println("SELECT * FROM Coches where matricula = '" + matricula +"'");
	      
	      if ( rs.first() == false )
	      {
	    	  return false;
	      }
	      else
	      {
	    	  return true;
	      }
	       
	    }
	    catch (SQLException se)
	    {
	        se.printStackTrace();
	        
	        return false;
	    }    
	  }
	 
	  public static void insertarCoche( String matricula , String propietario, int potencia )
	  {     
	    try
	    {
	      GestorBD.getInstance().connect();
	       
	      Statement sentencia =  GestorBD.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
	                                           ResultSet.CONCUR_UPDATABLE);
	 
	      boolean r = existeCoche( matricula );
	       
	      if(r == false)
	      {         
	    	 String query ="insert into Coches values('"+ matricula + "'" +
	                ",'"+ propietario+"',"+ potencia +")";
	             
	         sentencia.executeUpdate(query);
	      }
	      else
	      {
	          System.out.println("Coche Existente!");
	      }
	       
	      GestorBD.getInstance().disconnect();
	     
	    }
	    catch(SQLException se)
	    {
	        se.printStackTrace();
	    }
	 }

}
