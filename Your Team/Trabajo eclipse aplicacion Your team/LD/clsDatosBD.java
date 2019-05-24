package LD;

import java.sql.Connection;
import java.sql.Date;
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

import static LD.clsConstantesBD.INSERT_SQL_MANAGER;
import static LD.clsConstantesBD.INSERT_SQL_EQUIPO;
import static LD.clsConstantesBD.INSERT_SQL_EQUIPACION;
import static LD.clsConstantesBD.INSERT_SQL_TEMPORADA;
import static LD.clsConstantesBD.INSERT_SQL_ESCUDO;
import static LD.clsConstantesBD.INSERT_SQL_INTERCAMBIO;
import static LD.clsConstantesBD.INSERT_SQL_PARTIDOS;
import static LD.clsConstantesBD.INSERT_SQL_JUGADOR;

import static LD.clsConstantesBD.SELECT_SQL_MANAGER;
import static LD.clsConstantesBD.SELECT_SQL_EQUIPO;
import static LD.clsConstantesBD.SELECT_SQL_EQUIPACION;
import static LD.clsConstantesBD.SELECT_SQL_TEMPORADA;
import static LD.clsConstantesBD.SELECT_SQL_ESCUDO;
import static LD.clsConstantesBD.SELECT_SQL_INTERCAMBIO;
import static LD.clsConstantesBD.SELECT_SQL_PARTIDOS;
import static LD.clsConstantesBD.SELECT_SQL_JUGADOR;

import static LD.clsConstantesBD.DELETE_SQL_MANAGER;
import static LD.clsConstantesBD.DELETE_SQL_EQUIPACION;
import static LD.clsConstantesBD.DELETE_SQL_EQUIPO;
import static LD.clsConstantesBD.DELETE_SQL_ESCUDO;
import static LD.clsConstantesBD.DELETE_SQL_INTERCAMBIO;
import static LD.clsConstantesBD.DELETE_SQL_JUGADOR;
import static LD.clsConstantesBD.DELETE_SQL_PARTIDOS;
import static LD.clsConstantesBD.DELETE_SQL_TEMPORADA;

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
	public void Connect() {

		try {
			Class.forName(DRIVER).newInstance();
			conn = DriverManager.getConnection(URL + SCHEMA + TIME, USER, PASS);
			System.out.println("Connected to the database");

		} catch (Exception e) {
			System.out.println("NO CONNECTION ");
		}
	}

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

	public int InsertarManager(String nombre, String apellido1, String apellido2, String dni, String sexo,
			String calidad, int valoracion, String contrasenia) {

		int regActualizados = 0;
		int retorno = 0;

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
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarManager() {
		rs = sendSelect(DELETE_SQL_MANAGER);
		return rs;

	}

	// --------------------------------------------------------------------------------------------------
	public int InsertarEquipo(String nombreEquipo, java.util.Date fundacionEquipo) {
		java.sql.Date dateequipo = new java.sql.Date(fundacionEquipo.getTime());

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_EQUIPO, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, nombreEquipo);
			ps.setDate(2, dateequipo);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

	public ResultSet CargarEquipo() {

		rs = sendSelect(SELECT_SQL_EQUIPO);

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

	public ResultSet EliminarEquipo() {
		rs = sendSelect(DELETE_SQL_EQUIPO);
		return rs;

	}

	// --------------------------------------------------------------------------------------------------
	public int InsertarEquipaciones(String color1P, String color2P, String color1S, String color2S, String publicidadP,
			String publicidadS, String serigrafiadoP, String serigrafiadoS, int dorsal) {

		int regActualizados = 0;
		int retorno = 0;

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
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarEquipaciones() {
		rs = sendSelect(DELETE_SQL_EQUIPACION);
		return rs;

	}

	// --------------------------------------------------------------------------------------------------
	public int InsertarEscudo(String formaEscudo, String colorEscudo) {

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_ESCUDO, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, formaEscudo);
			ps.setString(2, colorEscudo);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarEscudo() {
		rs = sendSelect(DELETE_SQL_ESCUDO);
		return rs;

	}

	// --------------------------------------------------------------------------------------------------
	public int InsertarIntercambio(String equipoOrigen, String equipoDestino) {

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_INTERCAMBIO, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, equipoOrigen);
			ps.setString(2, equipoDestino);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarIntercambio() {
		rs = sendSelect(DELETE_SQL_INTERCAMBIO);
		return rs;

	}

	// --------------------------------------------------------------------------------------------------
	public int InsertarJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			double skills, int formaFisica) {

		int regActualizados = 0;
		int retorno = 0;

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
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarJugador() {
		rs = sendSelect(DELETE_SQL_JUGADOR);
		return rs;

	}
	// --------------------------------------------------------------------------------------------------

	public int InsertarPartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_PARTIDOS, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, equipoLocal);
			ps.setString(2, equipoVisitante);
			ps.setDate(3, fechaInicioPartido);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarPartido() {
		rs = sendSelect(DELETE_SQL_PARTIDOS);
		return rs;

	}
	// --------------------------------------------------------------------------------------------------

	public int InsertarTemporada(int puestos, String trofeos, Date anioTemporada) {

		int regActualizados = 0;
		int retorno = 0;

		try {
			ps = conn.prepareStatement(INSERT_SQL_TEMPORADA, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, puestos);
			ps.setString(2, trofeos);
			ps.setDate(3, anioTemporada);

			regActualizados = ps.executeUpdate();

			if (regActualizados == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					retorno = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

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

	public ResultSet EliminarTemporada() {
		rs = sendSelect(DELETE_SQL_TEMPORADA);
		return rs;

	}

}
