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



/**
 * También importaremos todas las clases para poner todo
 * @author Industria 4.0
 *
 */
public class clsDatos {
	/**
	 * Crearemos métodos para cargar,buscar,si hay repetidos y insertar equipaciones
	 * @return
	 */
	 private static GestorBD gbd=new GestorBD();
	public  ResultSet cargarEquipaciones()
	  {
	   
	    
	    try
	    {
	      // Todos los accesos a bases de datos deben ir entre try/catch
	      // Establecemos una conexiï¿½n con nuestra base de datos
	    	
	    	gbd.connect();
	         
	      // Creamos y ejecutamos una sentencia SQL
	      Statement stmt = gbd.createStatement();
	       
	      //hay una tabla coches en la BD
	      ResultSet rs = stmt.executeQuery("SELECT * FROM clsEquipaciones");
	      /**
	       
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
	    */
	    
	    return rs;
	    }
	    catch(SQLException se)
	    {
	        se.printStackTrace();
	        
	        return null;
	    }
	    }
	 
	   
	  
	  
	  public  Object getInstance() {
		
		return null;
	}



	public  ResultSet buscarEquipacion(String nombreEquipo) 
	  {
		try {
		 gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM  where nombreEquipo = '" + nombreEquipo + "'");

			//Date fundacionEquipo = rs.getDate("fundacionEquipo");
			//String color1 = rs.getString("color1");
			//String color2 = rs.getString("color2");
			//String publicidad = rs.getString("publicidad");
			//String serigrafiado = rs.getString("serigrafiado");
			//int dorsal= rs.getInt("dorsal");

			//clsEquipacion e = new clsEquipacion (nombreEquipo, fundacionEquipo,  color1,  color2,
					// publicidad,  serigrafiado,  dorsal);

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		} 
	  }  
	  
	  public  boolean existeclsEquipacion(String nombreEquipo )
	  {
	    try
	    {
	       gbd.connect();
	         
	      // Creamos y ejecutamos una sentencia SQL
	      Statement sentencia = 
	      gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
	 
	  public  void insertarEquipaciones( String color1,  String color2,
				String publicidad,  String serigrafiado,  int dorsal)
	  {     
	    try
	    {
	      gbd.connect();
	       
	      Statement sentencia =   gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
	                                           ResultSet.CONCUR_UPDATABLE);
	 
	      boolean r = existeclsEquipacion( color1 );
	       
	      if(r == false)
	      {         
	    	 String query ="insert into equipaciones values(" + color1 + color2 + publicidad + serigrafiado + dorsal;
	             
	         sentencia.executeUpdate(query);
	      }
	      else
	      {
	          System.out.println("Equipo Existente!");
	      }
	       
	      gbd.disconnect();
	     
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
		public  ResultSet cargarEquipo()
		  {
		    
		    
		    try
		    {
		      // Todos los accesos a bases de datos deben ir entre try/catch
		      // Establecemos una conexiï¿½n con nuestra base de datos
		    	
		    	gbd.connect();
		         
		      // Creamos y ejecutamos una sentencia SQL
		      Statement stmt =gbd.createStatement();
		       
		      //hay una tabla coches en la BD
		      ResultSet rs = stmt.executeQuery("SELECT * FROM Equipo");
		      /* 
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
		    }*/
		    
		    return rs;
		    }
		    catch(SQLException se)
		    {
		        se.printStackTrace();
		        
		        return null;
		    }
		  }
		   
		  
		  
		  public  Object getInstance1() {
			
			return null;
		}



		public static ResultSet buscarEquipo(String nombreEquipo) 
		  {
			try {
				gbd.connect();

				Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);

				ResultSet rs = sentencia.executeQuery("SELECT * FROM  where nombreEquipo = '" + nombreEquipo + "'");

				//Date fundacionEquipo = rs.getDate("fundacionEquipo");
			

				//clsEquipo eq= new clsEquipo (nombreEquipo, fundacionEquipo);

				return  rs;
			} catch (SQLException se) {
				se.printStackTrace();

				return null;
			} 
		  }  
		  
		  public  boolean existeclsEquipo(String nombreEquipo )
		  {
		    try
		    {
		       gbd.connect();
		         
		      // Creamos y ejecutamos una sentencia SQL
		      Statement sentencia = 
		      gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
		 
		  public  void insertarEquipo(String nombreEquipo,Date fundacionEquipo)
		  {     
		    try
		    {
		      gbd.connect();
		       
		      Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
		       
		      gbd.disconnect();
		     
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
		    public  ResultSet cargarEscudo()
			  {
			   
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	
			    	gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = gbd.createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM Escudo");
			      /* 
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
			    */
			    return rs;
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			        
			        return null;
			    }
			  }
			   
			  
			  
			  private  Object getInstance2() {
				
				return null;
			}



			public  ResultSet buscarEscudo(String formaEscudo) 
			  {
				try {
					gbd.connect();

					Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where nombreEquipo = '" + formaEscudo + "'");

					//Date fundacionEquipo = rs.getDate("fundacionEquipo");
				

					//clsEquipo es= new clsEquipo (nombreEquipo, fundacionEquipo);

					return  rs;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public  boolean existescudo(String formaEscudo )
			  {
			    try
			    {
			       gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			 
			  public  void insertarEscudo(String formaEscudo,String colorEscudo)
			  {     
			    try
			    {
			      gbd.connect();
			       
			      Statement sentencia =  gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existeclsEquipo( formaEscudo );
			       
			      if(r == false)
			      {         
			    	 String query ="insert into escudo values("+ formaEscudo +  
			                 colorEscudo  ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("Escudo Existente!");
			      }
			       
			      gbd.disconnect();
			     
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
			  public  ResultSet cargarIntercambio()
			  {
			    
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	
			    	gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = gbd.createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM Intercambio");
			      /* 
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
			    */
			    return rs;
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			        
			        return null;
			    }
			  }
			   
			  
			  
			  public  Object getInstance3() {
				
				return null;
			}



			public  ResultSet buscarIntercambio(String equipoOrigen, String equipoDestino) 
			  {
				try {
					gbd.connect();

					Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where quipo origen y equipo destino = '" + equipoOrigen + equipoDestino+ "'");

					String equiporigen = rs.getString("equipo origen");
					String equipodestino=rs.getString("equipo destino");
				

					//clsIntercambio i= (clsIntercambio) new clsIntercambio (equipoOrigen, equipoDestino);

					return  rs;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public  boolean existeclsIntercambio(String equipoOrigen, String equipoDestino )
			  {
			    try
			    {
			       gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			     gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			 
			  public  void insertarIntercambio(String equipoOrigen,String equipoDestino)
			  {     
			    try
			    {
			     gbd.connect();
			       
			      Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			       
			      gbd.disconnect();
			     
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
			  public  ResultSet cargarJugador()
			  {
			    
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	
			    	gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = gbd.createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM Jugador");
			       /*
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
			    */
			    return rs;
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			        
			        return null;
			    }
			  }
			   
			  
			  
			  public  Object getInstance4() {
				
				return null;
			}



			public  ResultSet buscarJugador(String nombreJugador,int formaFisica,int edad,double skills,String nombreEquipo,Date fundacionEquipo) 
			  {
				try {
					gbd.connect();

					Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where jugador = '" + nombreJugador+ "'");

					String nombrejugador = rs.getString("nombre jugador");
				
					
				

					//clsJugador j= new clsJugador (nombreJugador,formaFisica,edad,skills,nombreEquipo,fundacionEquipo);

					return  rs;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public  boolean existeclsJugador(int formaFisica,double skills )
			  {
			    try
			    {
			       gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			     gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			            
			      ResultSet rs = sentencia.executeQuery("SELECT * FROM jugador where nombre jugador = '" + skills +"'" );
			       
			      System.out.println("SELECT * FROM intercambio where all = '" + formaFisica  + skills );
			      
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
			 
			  public  void insertarJugador(int formaFisica,double skills )
			  {     
			    try
			    {
			     gbd.connect();
			       
			      Statement sentencia =  gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
			                                           ResultSet.CONCUR_UPDATABLE);
			 
			      boolean r = existeclsJugador(formaFisica, skills );
			       
			      if(r == false)
			      {         
			    	 String query ="insert into jugador values("+ skills  
			                 ;
			             
			         sentencia.executeUpdate(query);
			      }
			      else
			      {
			          System.out.println("Jugador Existente!");
			      }
			       
			     gbd.disconnect();
			     
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
			  public  ResultSet cargarPartido()
			  {
			   
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	
			    	gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = gbd.createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM partido");
			       /*
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
			    */
			    return rs;
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			        
			        return null;
			    }
			  }
			   
			  
			  
			  public  Object getInstance5() {
				
				return null;
			}



			public  ResultSet buscarPartidos(String equipoLocal, String equipoVisitante,Date fechaInicioPartido) 
			  {
				try {
					gbd.connect();

					Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where partido  = '" + equipoLocal + equipoVisitante);

					String equipolocal = rs.getString("equipo local");
					String equipodestino=rs.getString("equipo local");
					Date fechainiciopartido=rs.getDate("fecha");
				

					//clsPartidos p= (clsPartidos) new clsPartidos (equipoLocal, equipoVisitante,fechaInicioPartido);

					return  rs;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public  boolean existepartido(String equipoLocal, String equipoVisitante,Date fechaInicioPartido )
			  {
			    try
			    {
			      gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			      gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			 
			  public  void insertarpartido(String equipoLocal,String equipoVisitante,Date fechaInicioPartido)
			  {     
			    try
			    {
			      gbd.connect();
			       
			      Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			       
			     gbd.disconnect();
			     
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
			  public  ResultSet cargarTemporada()
			  {
			
			    
			    try
			    {
			      // Todos los accesos a bases de datos deben ir entre try/catch
			      // Establecemos una conexiï¿½n con nuestra base de datos
			    	
			    	gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement stmt = gbd.createStatement();
			       
			      //hay una tabla coches en la BD
			      ResultSet rs = stmt.executeQuery("SELECT * FROM temporada");
			       /*
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
			    */
			    return rs;
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			        
			        return null;
			    }
			  }
			   
			  
			  
			  public  Object getInstance6() {
				
				return null;
			}



			public  ResultSet buscartemporada(int puestos,String trofeos,Date anioTemporada,String ganador) 
			  {
				try {
					gbd.connect();

					Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

					ResultSet rs = sentencia.executeQuery("SELECT * FROM  where temporada = '" + puestos+trofeos+anioTemporada+ganador+ "'");

					
					
				

					//clsTemporada t= new clsTemporada ();

					return  rs;
				} catch (SQLException se) {
					se.printStackTrace();

					return null;
				} 
			  }  
			  
			  public  boolean existeTemporada(int puestos,String trofeos,Date anioTemporada,String ganador )
			  {
			    try
			    {
			       gbd.connect();
			         
			      // Creamos y ejecutamos una sentencia SQL
			      Statement sentencia = 
			     gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			 
			  public  void insertarTemporada(int puestos,String trofeos,Date anioTemporada,String ganador  )
			  {     
			    try
			    {
			      gbd.connect();
			       
			      Statement sentencia =  gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,             
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
			       
			      gbd.disconnect();
			     
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
			  }
			    

}
