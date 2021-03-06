package LD;

import static COMUN.clsConstantesBD.DELETE_SQL_EQUIPACION;
import static COMUN.clsConstantesBD.DELETE_SQL_EQUIPO;
import static COMUN.clsConstantesBD.DELETE_SQL_ESCUDO;
import static COMUN.clsConstantesBD.DELETE_SQL_INTERCAMBIO;
import static COMUN.clsConstantesBD.DELETE_SQL_JUGADOR;
import static COMUN.clsConstantesBD.DELETE_SQL_MANAGER;
import static COMUN.clsConstantesBD.DELETE_SQL_PARTIDOS;
import static COMUN.clsConstantesBD.DELETE_SQL_TEMPORADA;
import static COMUN.clsConstantesBD.DRIVER;
import static COMUN.clsConstantesBD.INSERT_SQL_EQUIPACION;
import static COMUN.clsConstantesBD.INSERT_SQL_EQUIPO;
import static COMUN.clsConstantesBD.INSERT_SQL_ESCUDO;
import static COMUN.clsConstantesBD.INSERT_SQL_INTERCAMBIO;
import static COMUN.clsConstantesBD.INSERT_SQL_JUGADOR;
import static COMUN.clsConstantesBD.INSERT_SQL_MANAGER;
import static COMUN.clsConstantesBD.INSERT_SQL_PARTIDOS;
import static COMUN.clsConstantesBD.INSERT_SQL_TEMPORADA;
import static COMUN.clsConstantesBD.PASS;
import static COMUN.clsConstantesBD.SCHEMA;
import static COMUN.clsConstantesBD.SELECT_SQL_EQUIPACION;
import static COMUN.clsConstantesBD.SELECT_SQL_EQUIPO;
import static COMUN.clsConstantesBD.SELECT_SQL_ESC;
import static COMUN.clsConstantesBD.SELECT_SQL_ESCUDO;
import static COMUN.clsConstantesBD.SELECT_SQL_INTERCAMBIO;
import static COMUN.clsConstantesBD.SELECT_SQL_JUGADOR;
import static COMUN.clsConstantesBD.SELECT_SQL_MANAGER;
import static COMUN.clsConstantesBD.SELECT_SQL_PARTIDOS;
import static COMUN.clsConstantesBD.SELECT_SQL_TEMPORADA;
import static COMUN.clsConstantesBD.TIME;
import static COMUN.clsConstantesBD.URL;
import static COMUN.clsConstantesBD.USER;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class clsDatosBD {

	/**
	 * Objeto para crear la conexi�n a base de datos.
	 */
	Connection conn = null;

	/**
	 * Objeto para crear la consulta a base de datos.
	 */
	PreparedStatement ps = null;

	/**
	 * Objeto para devolver el resultado de la consulta.
	 */
	ResultSet rs = null;

	public clsDatosBD() {
		//
	}

	/**
	 * M�todo para la conexi�n a la base de datos.
	 * 
	 */
	/**
	 * Con este metodo conectaremos para hacer lo que queramos
	 */
	public void Connect() {

		try {
			Class.forName(DRIVER).newInstance();
			conn = DriverManager.getConnection(URL + SCHEMA + TIME, USER, PASS);
			System.out.println("Connected to the database");

		} catch (Exception e) {
			System.out.println("NO CONNECTION ");
		}
	}

	/**
	 * Con este metodo descanecta de la base de datos
	 */

	public void Disconnect() {

		try {
			conn.close();
			ps.close(); // cerrar el statement tb cierra el resultset.
		} catch (SQLException e) {

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				/* no hago nada */}
			try {
				ps.close();
			} catch (Exception e) {
				/* no hago nada */}
		}
	}

	/**
	 * Aqui insertamos todos los datos de manager
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param calidad
	 * @param valoracion
	 * @param contrasenia
	 * @return
	 */

	public String InsertarManager(String nombre, String apellido1, String apellido2, String dni, String sexo,
			String calidad, int valoracion, String contrasenia) {

		int regActualizados = 0;
		String id_manager = "";

		try {
			ps = conn.prepareStatement(INSERT_SQL_MANAGER, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nombre);
			ps.setString(2, apellido1);
			ps.setString(3, apellido2);
			ps.setString(4, dni);
			ps.setString(5, sexo);
			ps.setString(6, calidad);
			ps.setInt(7, valoracion);
			ps.setString(8, contrasenia);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_manager = rs.getString(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_manager;

	}

	/**
	 * Aqui cargaremos todos los datos de manager
	 * 
	 * @return
	 */

	public ResultSet CargarManager() {

		rs = sendSelect(SELECT_SQL_MANAGER);

		return rs;

	}

	private ResultSet sendSelect(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Con este metodo eliminaremos los managers
	 */

	public void EliminarManager() {

		sendSelect(DELETE_SQL_MANAGER);

	}

	// --------------------------------------------------------------------------------------------------

	/**
	 * Aqui insertaremos equipos
	 * 
	 * @param nombreEquipo
	 * @param fundacionEquipo
	 * @return
	 */
	public int InsertarEquipo(String nombreEquipo, java.util.Date fundacionEquipo, String id_manager, int id_escudo, int id_intercambio, 
			int id_equipacion, int id_partido) {
		
		java.sql.Date dateequipo = new java.sql.Date(fundacionEquipo.getTime());

		int regActualizados = 0;
		int id_equipo = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_EQUIPO, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nombreEquipo);
			ps.setDate(2, dateequipo);
			ps.setString(3, id_manager);
			ps.setInt(4, id_escudo);
			ps.setInt(5, id_intercambio);
			ps.setInt(6, id_equipacion);
			ps.setInt(7, id_partido);
			
			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_equipo = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_equipo;

	}

	/**
	 * Aqui cargaremos equipos
	 * 
	 * @return
	 */

	public ResultSet CargarEquipo() {

		rs = sendSelect2(SELECT_SQL_EQUIPO);

		return rs;

	}

	private ResultSet sendSelect2(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Aqui eliminaremos equipos
	 */

	public void EliminarEquipo() {

		sendSelect2(DELETE_SQL_MANAGER);

	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * Aqui insertaremos equipaciones
	 * 
	 * @param color1P
	 * @param color2P
	 * @param color1S
	 * @param color2S
	 * @param publicidadP
	 * @param publicidadS
	 * @param serigrafiadoP
	 * @param serigrafiadoS
	 * @param dorsal
	 * @return
	 */
	public int InsertarEquipaciones(String color1P, String color2P, String color1S, String color2S, String publicidadP,
			String publicidadS, String serigrafiadoP, String serigrafiadoS, int dorsal) {

		int regActualizados = 0;
		int id_equipacion = 0;

		
		try {
			ps = conn.prepareStatement(INSERT_SQL_EQUIPACION, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, color1P);
			ps.setString(2, color2P);
			ps.setString(3, color1S);
			ps.setString(4, color2S);
			ps.setString(5, publicidadP);
			ps.setString(6, publicidadS);
			ps.setString(7, serigrafiadoP);
			ps.setString(8, serigrafiadoS);
			ps.setInt(9, dorsal);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_equipacion = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_equipacion;

	}

	/**
	 * Aqui cargaremos equipaciones
	 * 
	 * @return
	 */

	public ResultSet CargarEquipacion() {

		rs = sendSelect(SELECT_SQL_EQUIPACION);

		return rs;

	}

	private ResultSet sendSelect1(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Aqui eliminaremos equipaciones
	 */

	public void EliminarEquipaciones() {
		sendSelect1(DELETE_SQL_EQUIPACION);

	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * Aqui insertaremos escudo
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 * @return
	 */
	public int InsertarEscudo(String formaEscudo, String colorEscudo) {

		int regActualizados = 0;
		int id_escudo = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_ESCUDO, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, formaEscudo);
			ps.setString(2, colorEscudo);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_escudo = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_escudo;

	}

	/**
	 * Aqui cargaremos escudo
	 * 
	 * @return
	 */
	public ResultSet CargarEscudo() {

		rs = sendSelect(SELECT_SQL_ESCUDO);

		return rs;

	}

	private ResultSet sendSelect3(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Aqui eliminaremos escudp
	 */
	public void EliminarEscudo() {
		sendSelect3(DELETE_SQL_ESCUDO);

	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * Aqui insertaremos intercambio
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 */
	public int InsertarIntercambio(String equipoOrigen, String equipoDestino) {

		int regActualizados = 0;
		int id_intercambio = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_INTERCAMBIO, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, equipoOrigen);
			ps.setString(2, equipoDestino);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_intercambio = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_intercambio;

	}

	/**
	 * Aqui cargaremos intercambio
	 * 
	 * @return
	 */

	public ResultSet CargarIntercambio() {

		rs = sendSelect(SELECT_SQL_INTERCAMBIO);

		return rs;

	}

	private ResultSet sendSelect5(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Aqui eliminaremos intercambio
	 */
	public void EliminarIntercambio() {
		sendSelect5(DELETE_SQL_INTERCAMBIO);

	}

	// --------------------------------------------------------------------------------------------------
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
	 * @return
	 */
	public int InsertarJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			double skills, int formaFisica) {

		int regActualizados = 0;
		int id_jugador = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_JUGADOR, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nombre);
			ps.setString(2, apellido1);
			ps.setString(3, apellido2);
			ps.setString(4, dni);
			ps.setString(5, sexo);
			ps.setDouble(6, skills);
			ps.setInt(1, formaFisica);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_jugador = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_jugador;

	}

	/**
	 * Aqui cargaremos jugadores
	 * 
	 * @return
	 */
	public ResultSet CargarJugador() {

		rs = sendSelect(SELECT_SQL_JUGADOR);

		return rs;

	}

	private ResultSet sendSelect4(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * Aqui eliminaremos jugadores
	 */

	public void EliminarJugador() {
		sendSelect4(DELETE_SQL_JUGADOR);

	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * Aqui insertaremos partidos
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 * @return
	 */
	public int InsertarPartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {

		int regActualizados = 0;
		int id_partido = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_PARTIDOS, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, equipoLocal);
			ps.setString(2, equipoVisitante);
			ps.setDate(3, fechaInicioPartido);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_partido = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_partido;

	}

	/**
	 * Aqui cargaremos partido
	 * 
	 * @return
	 */
	public ResultSet CargarPartidos() {

		rs = sendSelect(SELECT_SQL_PARTIDOS);

		return rs;

	}

	private ResultSet sendSelect6(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Aqui eliminaremos partido
	 */

	public void EliminarPartido() {
		sendSelect6(DELETE_SQL_PARTIDOS);

	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * Aqui insertaremos temporada
	 * 
	 * @param puestos
	 * @param trofeos
	 * @param anioTemporada
	 * @return
	 */
	public int InsertarTemporada(int puestos, String trofeos, Date anioTemporada) {

		int regActualizados = 0;
		int id_temporada = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_TEMPORADA, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, puestos);
			ps.setString(2, trofeos);
			ps.setDate(3, anioTemporada);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id_temporada = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id_temporada;

	}

	/**
	 * Aqui cargaremos temporada
	 * 
	 * @return
	 */
	public ResultSet CargarTemporada() {

		rs = sendSelect(SELECT_SQL_TEMPORADA);

		return rs;

	}

	private ResultSet sendSelect7(String sql) {

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Aqui eliminaremos temporada
	 */

	public void EliminarTemporada() {
		sendSelect7(DELETE_SQL_TEMPORADA);
	}
}