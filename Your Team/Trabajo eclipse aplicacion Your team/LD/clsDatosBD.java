package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static LD.clsConstantesBD.DRIVER;
import static LD.clsConstantesBD.PASS;
import static LD.clsConstantesBD.SCHEMA;
import static LD.clsConstantesBD.URL;
import static LD.clsConstantesBD.USER;
import static LD.clsConstantesBD.TIME;

public class clsDatosBD {
	
	/**
	 * Objeto para crear la conexi�n a base de datos.
	 */
	Connection conn = null;
	
	/**
	 * Objeto para crear la consulta a base de datos.
	 */
	PreparedStatement ps=null;
	
	/**
	 * Objeto para devolver el resultado de la consulta.
	 */
	ResultSet rs=null;
	
	
	public clsDatosBD()
	{
		//
	}
	
	/**
	 * M�todo para la conexi�n a la base de datos.
	 * 
	 */
	 public void Connect()
	 {
		 
		 
		 try 
		 {
		   Class.forName(DRIVER).newInstance();
		   conn = DriverManager.getConnection(URL+SCHEMA+TIME,USER,PASS);
		   System.out.println("Connected to the database");
		   
		   
		 }
		 catch (Exception e) 
		 {
		     System.out.println("NO CONNECTION ");
		 }
	 }
	 public void Disconnect()
	 {
		 
		 try 
		 {
			conn.close();
			ps.close(); // cerrar el statement tb cierra el resultset.
		 } 
		 catch (SQLException e) 
		 {
			
		 }
		 finally 
		 {
			 try {conn.close();} catch(Exception e){/*no hago nada*/}
			 try {ps.close();} catch(Exception e){/*no hago nada*/}
		 }
		 
		 
	 }
	 public int InsertarAlumno(String dni, String nombre, String apellido)
	 {
		 
		 int regActualizados=0;
		 int retorno=0;
		 
		 try 
		 {
			ps= conn.prepareStatement(SQL_INSERT_ALUMNO,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			
			regActualizados=ps.executeUpdate();
			
			if(regActualizados ==1)
			{
				ResultSet rs = ps.getGeneratedKeys();
	            if(rs.next())
	            {
	                retorno= rs.getInt(1);
	            }
			}
			
			
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 
		 return retorno;
		 
	 }

}