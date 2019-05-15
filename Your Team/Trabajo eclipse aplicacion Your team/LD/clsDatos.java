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
 * Tambi?n importaremos todas las clases para poner todo
 * 
 * @author Industria 4.0
 *
 */
public class clsDatos {
	/**
	 * Crearemos metodos para cargar,buscar,si hay repetidos e insertar equipaciones
	 * 
	 * @return
	 */
	private static GestorBD gbd = new GestorBD();

	public ResultSet cargarEquipaciones() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Equipacion");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance() {

		return null;
	}

	/**
	 * Con este metodo buscaremos equipaciones a través de color1
	 * 
	 * @param color1
	 * @return
	 */

	public ResultSet buscarEquipacion(String color1P) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos una select de color1 en la base de datos
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Equipacion where color1 = '" + color1P + "'");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * A traves de esto miramos a ver si existe una equipacion a traves de color1
	 * 
	 * @param color1
	 * @return
	 */

	public boolean existeclsEquipacion(String color1P) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos otra select en equipacion
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Equipacion where color1P = '" + color1P + "'");

			System.out.println("SELECT * FROM Equipacion where color1 = '" + color1P + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * A traves de este metodo insertaremos equipaciones
	 * 
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param serigrafiado
	 * @param dorsal
	 */

	public void insertarEquipaciones(String color1P, String color2P, String color1S, String color2S, String publicidadP,
			String publicidadS, String serigrafiadoP, String serigrafiadoS, int dorsal) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeclsEquipacion(color1P);
			/**
			 * Para introducir hacemos una insert
			 */

			if (r == false) {
				String query = "insert into Equipacion values(null,'" + color1P +"','" + color2P+"','" + color1S +"','" + color2S +"','" +
						publicidadP +"','" + publicidadS +"','" + serigrafiadoP +"','" + serigrafiadoS +"'," + dorsal+ ")";
				/**
				 * Si ya existe una equipacion nos saldra equipo existente
				 */
				System.out.println(query);

				sentencia.executeUpdate(query);
			} else {
				String texto = "Equipacion existente";
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Crearemos m?todos para cargar,buscar,si hay repetidos
	 * 
	 * @return
	 */
	public ResultSet cargarEquipo() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * Hcemos una selec de equipo
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Equipo");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance1() {

		return null;
	}

	/**
	 * Crearemos un metodo para buscar un equipo a traves de su nombre
	 * 
	 * @param nombreEquipo
	 * @return
	 */

	public static ResultSet buscarEquipo(String nombreEquipo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Aqui haremos una select
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM  where 'Nombre equipo' = '" + nombreEquipo + "'");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Aqui comprobamos si existe el equipo
	 * 
	 * @param nombreEquipo
	 * @return
	 */

	public boolean existeclsEquipo(String nombreEquipo) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos una select de su nombre
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Equipo where 'Nombre equipo' = '" + nombreEquipo + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * Aqui insertaremos un equipo
	 * 
	 * @param nombreEquipo
	 * @param fundacionEquipo
	 */
	public void insertarEquipo(String nombreEquipo, Date fundacionEquipo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeclsEquipo(nombreEquipo);
			/**
			 * Haremos una insert para insertar un equipo
			 */

			if (r == false) {
				String query = "insert into Equipo(id,niombre,asdas) values(null,'" + nombreEquipo +"','" + fundacionEquipo + "','" +
						"')";
				

				sentencia.executeUpdate(query);
				/**
				 * Si no lo inserta es porque hay ya un equipo existente
				 */
			} else {
				System.out.println("Equipo Existente!");
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Crearemos metodos para cargar escudo
	 * 
	 * @return
	 */
	public ResultSet cargarEscudo() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * Hacemos la select de escudo
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Escudo");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	private Object getInstance2() {

		return null;
	}

	/**
	 * Aqui es por si queremos buscar escudos
	 * 
	 * @param formaEscudo
	 * @return
	 */

	public ResultSet buscarEscudo(String formaEscudo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos una selec de forma escudo para poder buscarlo
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM  where forma escudo = '" + formaEscudo + "'");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Aqui nos aseguramos de que existe
	 * 
	 * @param formaEscudo
	 * @return
	 */

	public boolean existescudo(String formaEscudo) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Aqui hacemos una select de forma escudo para saber si existe
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Escudo where forma escudo = '" + formaEscudo + "'");

			System.out.println("SELECT * FROM escudo where forma escudo = '" + formaEscudo + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * Crearemos este metodo para insertar escudo
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 */

	public void insertarEscudo(String formaEscudo, String colorEscudo) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeclsEquipo(formaEscudo);
			/**
			 * Hacemos una insert para añadir los escudos
			 */

			if (r == false) {
				String query = "insert into Escudo values(" + formaEscudo +"'" + colorEscudo+")";

				sentencia.executeUpdate(query);
				/**
				 * Esto es por si ya existiria
				 */
			} else {
				System.out.println("Escudo Existente!");
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	/**
	 * Crearemos m?todos para cargar intercambio
	 * 
	 * @return
	 */
	public ResultSet cargarIntercambio() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * aqui haremos una select de intercambio
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Intercambio");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance3() {

		return null;
	}

	/**
	 * Aqui buscaremos intercambios
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 */

	public ResultSet buscarIntercambio(String equipoOrigen, String equipoDestino) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Aqui haremos una select de equipo a trabés de origen y destino
			 */

			ResultSet rs = sentencia.executeQuery(
					"SELECT * FROM  where Equipo origen y Equipo destino = '" + equipoOrigen +"'" + equipoDestino + "'");

			String equiporigen = rs.getString("equipo origen");
			String equipodestino = rs.getString("equipo destino");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Este metodo sera para saber si existe un intercambio
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 */

	public boolean existeclsIntercambio(String equipoOrigen, String equipoDestino) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Intercambio where Equipo origen y Equipo destino = '"
					+ equipoOrigen + equipoDestino + "'");

			System.out.println("SELECT * FROM Intercambio where Equipo origen y Equipo destino = '" + equipoOrigen
					+"'" + equipoDestino + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * A traves de eso insertaremos un intercambio
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 */

	public void insertarIntercambio(String equipoOrigen, String equipoDestino) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeclsIntercambio(equipoOrigen, equipoDestino);
			/**
			 * Haremos una insert para insertar los valores
			 */

			if (r == false) {
				String query = "insert into Intercambio values(" + equipoOrigen +"'" + equipoDestino;

				sentencia.executeUpdate(query);
				/**
				 * si ya hay un equipo nos saltara este aviso
				 */
			} else {
				System.out.println("Intercambio Existente!");
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Crearemos m?todos para cargar jugador
	 * 
	 * @return
	 */
	public ResultSet cargarJugador() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * Haremos una select de jugador
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Jugador");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance4() {

		return null;
	}

	/**
	 * A traves de este metodo buscamos jugadores
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param skills
	 * @param formaFisica
	 * @return
	 */

	public ResultSet buscarJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			double skills, int formaFisica) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Haremos una select de jugador
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Jugador  where idJugador = '" + nombre + "'");

			skills = rs.getDouble("Skills");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Con este metodo miramos si existe el jugador
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param skills
	 * @param formaFisica
	 * @return
	 */

	public boolean existeclsJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			double skills, int formaFisica) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos una select de sus skills
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Jugador where Skills = '" + skills + "'");

			

			if (rs.first() == false) { // si retorna falso es que no existe
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * Aqui insertaremos jugadores
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param skills
	 * @param formaFisica
	 */

	public void insertarJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			double skills, int formaFisica) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeclsJugador(nombre, apellido1, apellido2, dni, sexo, skills, formaFisica);
			/**
			 * Aqui hacemos una insert a jugador
			 */

			if (r == false) {
				String query = "insert into Jugador values(" + nombre +"'" + apellido1 +"'" + apellido2 +"'" + dni +"'" + sexo +"'" + skills
						+"'" + formaFisica+")";

				sentencia.executeUpdate(query);
			} else {
				System.out.println("Jugador Existente!"); // Esto es por si hay un jugador repetido
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Crearemos m?todos para cargar partidos
	 * 
	 * @return
	 */
	public ResultSet cargarPartido() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * Haremos una select en partido
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Partido");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance5() {

		return null;
	}

	/**
	 * Con este metodo buscaremos partidos
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 * @return
	 */

	public ResultSet buscarPartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Aqui haremos una select de partido
			 */

			ResultSet rs = sentencia.executeQuery(
					"SELECT * FROM  where Partido  = '" + equipoLocal +"'" + equipoVisitante +"'" + fechaInicioPartido);

			String equipolocal = rs.getString("Equipo local");
			String equipodestino = rs.getString("Equipo local");
			Date fechainiciopartido = rs.getDate("Fecha partido");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Aqui veremos si existe el partido
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 * @return
	 */

	public boolean existepartido(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos una select de partidos
			 */

			ResultSet rs = sentencia.executeQuery(
					"SELECT * FROM Partido where  = '" + equipoLocal +"'" + equipoVisitante +"'" + fechaInicioPartido + "'");

			System.out.println("SELECT * FROM Partido where Equipo origen y Equipo destino y Fecha partido = '"
					+ equipoLocal + equipoVisitante + fechaInicioPartido + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * Aqui insertamos partidos
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 */

	public void insertarpartido(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existepartido(equipoLocal, equipoVisitante, fechaInicioPartido);
			/**
			 * Para insertar haremos una insert de partidos
			 */

			if (r == false) {
				String query = "insert into Partido values(" + equipoLocal +"'" + equipoVisitante +"'" + fechaInicioPartido;

				sentencia.executeUpdate(query);
			} else {
				System.out.println("partido Existente!");
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Crearemos m?todos para cargar temporada
	 * 
	 * @return
	 */
	public ResultSet cargarTemporada() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * Hacemos una selec de temporada
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Temporada");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance6() {

		return null;
	}

	/**
	 * Aqui buscaremos las temporadas
	 * 
	 * @param puestos
	 * @param trofeos
	 * @param anioTemporada
	 * @return
	 */

	public ResultSet buscartemporada(int puestos, String trofeos, Date anioTemporada) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Para ellos hacemos una select de temporada
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Temporada where Puestos y Trofeos y Anio temporada = '"
					+ puestos +"'" + trofeos +"'" + anioTemporada + "'");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Aqui miraremos si existe la temporada
	 * 
	 * @param puestos
	 * @param trofeos
	 * @param anioTemporada
	 * @return
	 */

	public boolean existeTemporada(int puestos, String trofeos, Date anioTemporada) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Aqui hacemos una select de temporada
			 */

			ResultSet rs = sentencia
					.executeQuery("SELECT * FROM temporada where Puestos y Trofeos y Anio temporada  = '" + puestos
							+ trofeos +"'" + anioTemporada + "'");

			System.out.println("SELECT * FROM Temporada where Puestos y Trofeos y Anio temporada = '" + puestos
					+ trofeos +"'" + anioTemporada + "'");

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * Aqui insertaremos temporadas
	 * 
	 * @param puestos
	 * @param trofeos
	 * @param anioTemporada
	 */

	public void insertarTemporada(int puestos, String trofeos, Date anioTemporada) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeTemporada(puestos, trofeos, anioTemporada);
			/**
			 * Para ello hacemos insert en la temporada
			 */

			if (r == false) {
				String query = "insert into temporada values(" + puestos +"'" + trofeos +"'" + anioTemporada+")";

				sentencia.executeUpdate(query);
			} else {
				System.out.println("Temporada Existente!");
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * A traves de este metodo cargaremos managers
	 * 
	 * @return
	 */

	public ResultSet cargarManager() {

		try {
			// Todos los accesos a bases de datos deben ir entre try/catch
			// Establecemos una conexi?n con nuestra base de datos

			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement stmt = gbd.createStatement();
			/**
			 * Hacemos una select de manager
			 */

			// hay una tabla coches en la BD
			ResultSet rs = stmt.executeQuery("SELECT * FROM Manager");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public Object getInstance7() {

		return null;
	}

	/**
	 * Aqui buscaremos managers
	 * 
	 * @param valoracion
	 * @return
	 */

	public ResultSet buscarManager(int valoracion) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/**
			 * Hacemos una select para buscar managers
			 */

			ResultSet rs = sentencia.executeQuery("SELECT * FROM  where valoracion = '" + valoracion + "'");

			return rs;
		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	/**
	 * Aqui vemos si existe el manager
	 * 
	 * @param dni
	 * @return
	 */

	public boolean existeclsManager(String dni) {
		try {
			gbd.connect();

			// Creamos y ejecutamos una sentencia SQL
			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = sentencia.executeQuery("SELECT * FROM Manager where  dni = '" + dni + "'");
			/**
			 * Aqui hacemos una select de manager
			 */

			

			if (rs.first() == false) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();

			return false;
		}
	}

	/**
	 * Aqui insertamos al manager con todos sus atributos
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param calidad
	 * @param valoracion
	 */

	public void insertarManager(String nombre, String apellido1, String apellido2, String dni, String sexo,
			String calidad, int valoracion) {
		try {
			gbd.connect();

			Statement sentencia = gbd.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			boolean r = existeclsManager(dni);
			/**
			 * Hacemos una insert
			 */

			if (r == false) {
				String query = "insert into manager values('" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + dni + "','" + 
				sexo + "','" + calidad + "'," + valoracion +")";
				
				sentencia.executeUpdate(query);
			} else {
				System.out.println("Manager Existente!"); // por si hay managers repetidos
			}

			gbd.disconnect();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
