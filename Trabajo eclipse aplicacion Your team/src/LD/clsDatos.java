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
	/**
	 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar equipaciones
	 * @return
	 */
	public static List<clsEquipacion> cargarEquipaciones()
	  {
	    ArrayList<clsEquipacion> vectorBD = new ArrayList<>();
	    
	    try
	    {
	      // Todos los accesos a bases de datos deben ir entre try/catch
	      // Establecemos una conexiï¿½n con nuestra base de datos
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
	            
	      ResultSet rs = sentencia.executeQuery("SELECT * FROM clsequipaciones where nombreequipo = '" + nombreEquipo +"'" );
	       
	      System.out.println("SELECT * FROM equipacion where nombreequipo = '" + nombreEquipo +"'");
	      
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
	  /**
		 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar equipos
		 * @return
		 */
		public static ArrayList<clsEquipo> cargarEquipo()
		  {
		    ArrayList<clsEquipo> vectorBD = new ArrayList<>();
		    
		    try
		    {
		      // Todos los accesos a bases de datos deben ir entre try/catch
		      // Establecemos una conexiï¿½n con nuestra base de datos
		    	GestorBD.getInstance().connect();
		         
		      // Creamos y ejecutamos una sentencia SQL
		      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
		       
		      //hay una tabla coches en la BD
		      ResultSet rs = stmt.executeQuery("SELECT * FROM Equipo");
		       
		      // Tratamos los resultado obtenidos en la consulta SQL
		      while(rs.next())
		      {
		    	  
		        clsEquipo nuevaEquipo = new clsEquipo();
		        vectorBD.add(nuevaEquipo);
		      }  
		       
		    }
		    catch(SQLException se)
		    {
		         
		        se.printStackTrace();
		    }
		    
		    return vectorBD;
		  }
		   
		  
		  
		  private static Object getInstance1() {
			
			return null;
		}



		public static clsEquipo buscarEquipo(String nombreEquipo) 
		  {
			try {
				((GestorBD) clsDatos.getInstance()).connect();

				Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);

				ResultSet rs = sentencia.executeQuery("SELECT * FROM  where nombreEquipo = '" + nombreEquipo + "'");

				Date fundacionEquipo = rs.getDate("fundacionEquipo");
			

				clsEquipo eq= new clsEquipo (nombreEquipo, fundacionEquipo);

				return  eq;
			} catch (SQLException se) {
				se.printStackTrace();

				return null;
			} 
		  }  
		  
		  public static boolean existeclsEquipo(String nombreEquipo )
		  {
		    try
		    {
		       ((GestorBD) clsDatos.getInstance()).connect();
		         
		      // Creamos y ejecutamos una sentencia SQL
		      Statement sentencia = 
		      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
		                                           ResultSet.CONCUR_UPDATABLE);
		            
		      ResultSet rs = sentencia.executeQuery("SELECT * FROM equipo where nombreequipo = '" + nombreEquipo +"'" );
		       
		      System.out.println("SELECT * FROM equipo where nombreequipo = '" + nombreEquipo +"'");
		      
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
		 
		  public static void insertarEquipo(String nombreEquipo,Date fundacionEquipo)
		  {     
		    try
		    {
		      ((GestorBD) clsDatos.getInstance()).connect();
		       
		      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
		                                           ResultSet.CONCUR_UPDATABLE);
		 
		      boolean r = existeclsEquipo( nombreEquipo );
		       
		      if(r == false)
		      {         
		    	 String query ="insert into equipo values("+ nombreEquipo +  
		                 fundacionEquipo ;
		             
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
		    /**
			 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar escudo
			 * @return
			 */
		    public static ArrayList<clsEscudo> cargarEscudo()
			  {
			    ArrayList<clsEscudo> vectorBD = new ArrayList<>();
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	GestorBD.getInstance().connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM Escudo");
			       
			      // Tratamos los resultado obtenidos en la consulta SQL
			      while(rs.next())
			      {
			    	  
			        clsEscudo nuevoEscudo = new clsEscudo();
			        vectorBD.add(nuevoEscudo);
			      }  
			       
			    }
			    catch(SQLException se)
			    {
			         
			        se.printStackTrace();
			    }
			    
			    return vectorBD;
			  }
			   
			  
			  
			  private static Object getInstance2() {
				
				return null;
			}



			public static clsEquipo buscarEscudo(String nombreEquipo) 
			  {
				try {
					((GestorBD) clsDatos.getInstance()).connect();

					Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where nombreEquipo = '" + nombreEquipo + "'");

					Date fundacionEquipo = rs.getDate("fundacionEquipo");
				

					clsEquipo es= new clsEquipo (nombreEquipo, fundacionEquipo);

					return  es;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public static boolean existescudo(String formaEscudo )
			  {
			    try
			    {
			       ((GestorBD) clsDatos.getInstance()).connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			            
			      ResultSet rs = sentencia.executeQuery("SELECT * FROM escudo where formaescudo = '" + formaEscudo +"'" );
			       
			      System.out.println("SELECT * FROM escudo where formaescudo = '" + formaEscudo +"'");
			      
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
			 
			  public static void insertarEscudo(String formaEscudo,Date colorEscudo, String nombreEscudo, Date fundacionEquipo)
			  {     
			    try
			    {
			      ((GestorBD) clsDatos.getInstance()).connect();
			       
			      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existeclsEquipo( formaEscudo );
			       
			      if(r == false)
			      {         
			    	 String query ="insert into escudo values("+ formaEscudo +  
			                 colorEscudo + nombreEscudo + fundacionEquipo ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("Escudo Existente!");
			      }
			       
			      ((GestorBD) clsDatos.getInstance()).disconnect();
			     
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
			    
		    
		 }
			  /**
				 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar intercambio
				 * @return
				 */	 
			  public static ArrayList<clsIntercambio> cargarIntercambio()
			  {
			    ArrayList<clsIntercambio> vectorBD = new ArrayList<>();
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	GestorBD.getInstance().connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM Intercambio");
			       
			      // Tratamos los resultado obtenidos en la consulta SQL
			      while(rs.next())
			      {
			    	  
			        clsEquipo nuevoIntercambio = new clsEquipo();
			        vectorBD.add((clsIntercambio) nuevoIntercambio);
			      }  
			       
			    }
			    catch(SQLException se)
			    {
			         
			        se.printStackTrace();
			    }
			    
			    return vectorBD;
			  }
			   
			  
			  
			  private static Object getInstance3() {
				
				return null;
			}



			public static clsEquipo buscarIntercambio(String equipoOrigen, String equipoDestino) 
			  {
				try {
					((GestorBD) clsDatos.getInstance()).connect();

					Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where quipo origen y equipo destino = '" + equipoOrigen + equipoDestino+ "'");

					String equiporigen = rs.getString("equipo origen");
					String equipodestino=rs.getString("equipo destino");
				

					clsIntercambio i= (clsIntercambio) new clsIntercambio (equipoOrigen, equipoDestino);

					return  i;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public static boolean existeclsIntercambio(String equipoOrigen, String equipoDestino )
			  {
			    try
			    {
			       ((GestorBD) clsDatos.getInstance()).connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			            
			      ResultSet rs = sentencia.executeQuery("SELECT * FROM intercambio where equipo origen y equipo destino = '" + equipoOrigen +equipoDestino+"'" );
			       
			      System.out.println("SELECT * FROM intercambio where equipo origen y equipo destino = '" + equipoOrigen +equipoDestino+"'");
			      
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
			 
			  public static void insertarIntercambio(String equipoOrigen,String equipoDestino)
			  {     
			    try
			    {
			      ((GestorBD) clsDatos.getInstance()).connect();
			       
			      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existeclsIntercambio( equipoOrigen,equipoDestino );
			       
			      if(r == false)
			      {         
			    	 String query ="insert into intercambio values("+ equipoOrigen +  
			                 equipoDestino ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("Intercambio Existente!");
			      }
			       
			      ((GestorBD) clsDatos.getInstance()).disconnect();
			     
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
			  }
			  /**
				 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar jugador
				 * @return
				 */	
			  public static ArrayList<clsJugador> cargarJugador()
			  {
			    ArrayList<clsJugador> vectorBD = new ArrayList<>();
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	GestorBD.getInstance().connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM Jugador");
			       
			      // Tratamos los resultado obtenidos en la consulta SQL
			      while(rs.next())
			      {
			    	  
			        clsJugador nuevoJugador = new clsJugador();
			        vectorBD.add (nuevoJugador);
			      }  
			       
			    }
			    catch(SQLException se)
			    {
			         
			        se.printStackTrace();
			    }
			    
			    return vectorBD;
			  }
			   
			  
			  
			  private static Object getInstance4() {
				
				return null;
			}



			public static clsEquipo buscarJugador(String nombreJugador,int formaFisica,int edad,double skills,String nombreEquipo,Date fundacionEquipo) 
			  {
				try {
					((GestorBD) clsDatos.getInstance()).connect();

					Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where jugador = '" + nombreJugador+ "'");

					String nombrejugador = rs.getString("nombre jugador");
				
					
				

					clsJugador j= new clsJugador (nombreJugador,formaFisica,edad,skills,nombreEquipo,fundacionEquipo);

					return  j;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public static boolean existeclsJugador(String nombreJugador,int formaFisica,int edad,double skills,String nombreEquipo,Date fundacionEquipo )
			  {
			    try
			    {
			       ((GestorBD) clsDatos.getInstance()).connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			            
			      ResultSet rs = sentencia.executeQuery("SELECT * FROM jugador where nombre jugador = '" + nombreJugador +"'" );
			       
			      System.out.println("SELECT * FROM intercambio where all = '" + nombreJugador + formaFisica + edad + skills + nombreEquipo + fundacionEquipo+"'");
			      
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
			 
			  public static void insertarJugador(String nombreJugador,int formaFisica,int edad,double skills,String nombreEquipo,Date fundacionEquipo )
			  {     
			    try
			    {
			      ((GestorBD) clsDatos.getInstance()).connect();
			       
			      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existeclsJugador(nombreJugador, formaFisica, edad, skills, nombreEquipo, fundacionEquipo );
			       
			      if(r == false)
			      {         
			    	 String query ="insert into jugador values("+ nombreJugador   
			                 ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("Jugador Existente!");
			      }
			       
			      ((GestorBD) clsDatos.getInstance()).disconnect();
			     
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
			  }
			  /**
				 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar partidos
				 * @return
				 */	
			  public static ArrayList<clsPartidos> cargarPartido()
			  {
			    ArrayList<clsPartidos> vectorBD = new ArrayList<>();
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	GestorBD.getInstance().connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM partido");
			       
			      // Tratamos los resultado obtenidos en la consulta SQL
			      while(rs.next())
			      {
			    	  
			        clsPartidos nuevoPartido = new clsPartidos();
			        vectorBD.add((clsPartidos) nuevoPartido);
			      }  
			       
			    }
			    catch(SQLException se)
			    {
			         
			        se.printStackTrace();
			    }
			    
			    return vectorBD;
			  }
			   
			  
			  
			  private static Object getInstance5() {
				
				return null;
			}



			public static clsPartidos buscarPartidos(String equipoLocal, String equipoVisitante,Date fechaInicioPartido) 
			  {
				try {
					((GestorBD) clsDatos.getInstance()).connect();

					Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where partido  = '" + equipoLocal + equipoVisitante);

					String equipolocal = rs.getString("equipo local");
					String equipodestino=rs.getString("equipo local");
					Date fechainiciopartido=rs.getDate("fecha");
				

					clsPartidos p= (clsPartidos) new clsPartidos (equipoLocal, equipoVisitante,fechaInicioPartido);

					return  p;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public static boolean existepartido(String equipoLocal, String equipoVisitante,Date fechaInicioPartido )
			  {
			    try
			    {
			       ((GestorBD) clsDatos.getInstance()).connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			            
			      ResultSet rs = sentencia.executeQuery("SELECT * FROM partido where  = '" + equipoLocal +equipoVisitante+fechaInicioPartido+"'" );
			       
			      System.out.println("SELECT * FROM intercambio where equipo origen y equipo destino = '" + equipoLocal +equipoVisitante+fechaInicioPartido+"'");
			      
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
			 
			  public static void insertarpartido(String equipoLocal,String equipoVisitante,Date fechaInicioPartido)
			  {     
			    try
			    {
			      ((GestorBD) clsDatos.getInstance()).connect();
			       
			      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existepartido(equipoLocal, equipoVisitante, fechaInicioPartido);
			       
			      if(r == false)
			      {         
			    	 String query ="insert into partidos values("+ equipoLocal +  
			                 equipoVisitante+fechaInicioPartido ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("partido Existente!");
			      }
			       
			      ((GestorBD) clsDatos.getInstance()).disconnect();
			     
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
			  }
			  /**
				 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar temporada
				 * @return
				 */	
			  public static ArrayList<clsTemporada> cargarTemporada()
			  {
			    ArrayList<clsTemporada> vectorBD = new ArrayList<>();
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	GestorBD.getInstance().connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = ((Connection) clsDatos.getInstance()).createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM temporada");
			       
			      // Tratamos los resultado obtenidos en la consulta SQL
			      while(rs.next())
			      {
			    	  
			        clsTemporada nuevaTemporada = new clsTemporada();
			        vectorBD.add (nuevaTemporada);
			      }  
			       
			    }
			    catch(SQLException se)
			    {
			         
			        se.printStackTrace();
			    }
			    
			    return vectorBD;
			  }
			   
			  
			  
			  private static Object getInstance6() {
				
				return null;
			}



			public static clsTemporada buscartemporada(int puestos,String trofeos,Date anioTemporada,String ganador) 
			  {
				try {
					((GestorBD) clsDatos.getInstance()).connect();

					Statement sentencia = ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where temporada = '" + puestos+trofeos+anioTemporada+ganador+ "'");

					
					
				

					clsTemporada t= new clsTemporada ();

					return  t;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public static boolean existeTemporada(int puestos,String trofeos,Date anioTemporada,String ganador )
			  {
			    try
			    {
			       ((GestorBD) clsDatos.getInstance()).connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			            
			      ResultSet rs = sentencia.executeQuery("SELECT * FROM temporada where  = '" + puestos +trofeos+anioTemporada+ganador+"'" );
			       
			      System.out.println("SELECT * FROM temporada where all = '"  + puestos +trofeos+anioTemporada+ganador+"'");
			      
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
			 
			  public static void insertarTemporada(int puestos,String trofeos,Date anioTemporada,String ganador  )
			  {     
			    try
			    {
			      ((GestorBD) clsDatos.getInstance()).connect();
			       
			      Statement sentencia =  ((Connection) clsDatos.getInstance()).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existeTemporada(puestos, trofeos, anioTemporada, ganador);
			       
			      if(r == false)
			      {         
			    	 String query ="insert into temproada values("+ puestos+trofeos+anioTemporada+ganador  
			                 ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("Temporada Existente!");
			      }
			       
			      ((GestorBD) clsDatos.getInstance()).disconnect();
			     
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
			  }
			    

}
