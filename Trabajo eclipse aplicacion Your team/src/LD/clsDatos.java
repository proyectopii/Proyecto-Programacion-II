package LD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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


public class clsDatos {
	public static List<clsEquipacion> cargarEquipaciones()
	  {
	    ArrayList<clsEquipacion> vectorBD = new ArrayList<>();
	    
	    try
	    {
	      // Todos los accesos a bases de datos deben ir entre try/catch
	      // Establecemos una conexi�n con nuestra base de datos
	    	GestorBD.getInstance().connect();
	         
	      // Creamos y ejecutamos una sentencia SQL
	      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
	       
	      //hay una tabla coches en la BD
	      ResultSet rs = stmt.executeQuery("SELECT * FROM Equipaciones");
	       
	      // Tratamos los resultado obtenidos en la consulta SQL
	      while(rs.next())
	      {
	    	  
	        clsEquipacion nuevaEquipacion = new clsEquipacion();
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
		
		return null;
	}



	public static clsEquipacion buscarEquipacion(String nombreEquipo) 
	  {
		try {
			((GestorBD) clsDatos.getInstance()).connect();

			Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM  where nombreEquipo = '" + nombreEquipo + "'");

			Date fundacionEquipo = rs.getDate("fundacionEquipo");
			String color1 = rs.getString("color1");
			String color2 = rs.getString("color2");
			String publicidad = rs.getString("publicidad");
			String serigrafiado = rs.getString("serigrafiado");
			int dorsal= rs.getInt("dorsal");

			clsEquipacion e = new clsEquipacion (nombreEquipo, fundacionEquipo,  color1,  color2,
					 publicidad,  serigrafiado,  dorsal);

			return e;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		} 
	  }  
	  
	  public static boolean existeclsEquipacion(String nombreEquipo )
	  {
	    try
	    {
	       ((GestorBD) clsDatos.getInstance()).connect();
	         
	      // Creamos y ejecutamos una sentencia SQL
	      Statement sentencia = 
	      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
	                                           ResultSet.CONCUR_UPDATABLE);
	            
	      ResultSet rs = sentencia.executeQuery("SELECT * FROM Coches where matricula = '" + nombreEquipo +"'" );
	       
	      System.out.println("SELECT * FROM equipacion where matricula = '" + nombreEquipo +"'");
	      
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
	 
	  public static void insertarEquipaciones(String nombreEquipo,LocalDate fundacionEquipo, String color1,  String color2,
				String publicidad,  String serigrafiado,  int dorsal)
	  {     
	    try
	    {
	      ((GestorBD) clsDatos.getInstance()).connect();
	       
	      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
	                                           ResultSet.CONCUR_UPDATABLE);
	 
	      boolean r = existeclsEquipacion( nombreEquipo );
	       
	      if(r == false)
	      {         
	    	 String query ="insert into equipaciones values("+ nombreEquipo +  
	                 fundacionEquipo + color1 + color2 + publicidad + serigrafiado + dorsal;
	             
	         sentencia.executeUpdate(query);
	      }
	      else
	      {
	          System.out.println("Equipo Existente!");
	      }
	       
	      ((GestorBD) clsDatos.getInstance()).disconnect();
	     
	    }
	    catch(SQLException se)
	    {
	        se.printStackTrace();
	    }
	 }

}
