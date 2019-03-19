package Comun;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBaseDatos {
	private static GestorBaseDatos miGestor = null;

	private Connection conexion = null;
	
	private Statement sentencia;

	private void comprobarConexion() {
		if (conexion == null)
			throw new IllegalStateException("La conexion a la BD no ha sido creada todavia.");
	}

	private GestorBaseDatos() {
	}

	public static GestorBaseDatos getInstance() {
		if (miGestor == null) {
			miGestor = new GestorBaseDatos();
		}
		return miGestor;
	}

	public static void releaseInstance() {
		miGestor = null;
	}

	public void conectar() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		// useSSL = true para que la conexion sea cifrada
		String sURL = "jdbc:mysql://localhost:3306/ui1_artupa?useSSL=true";

		conexion = java.sql.DriverManager.getConnection(sURL, "root", "root");

		//System.out.println("Conectado.");
	}

	public void desconectar() throws SQLException {
		comprobarConexion();
		conexion.close();
		//System.out.println("Desconectado.");
	}

	public Statement crearSentencia() throws SQLException {
		comprobarConexion();
		return conexion.createStatement();
	}

	public Statement crearSentencia(int resultSetType, int resultSetConcurrency) throws SQLException {
		comprobarConexion();
		return conexion.createStatement(resultSetType, resultSetConcurrency);
	}

	private boolean insertar(String sql) {
		boolean valor = true;
		try {
			conectar();
			sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			valor = false;
			e.printStackTrace();
		} finally {
			try {
				sentencia.close();
				conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valor;
	}

	private ResultSet consultar(String sql) {
	
		ResultSet resultado = null;
		try {
			
			conectar();
			resultado = sentencia.executeQuery(sql);
			desconectar();
			
		} catch (SQLException e) {
			System.out.println("Mensaje:" + e.getMessage());
			System.out.println("Estado:" + e.getSQLState());
			System.out.println("Codigo del error:" + e.getErrorCode());

			e.printStackTrace();
		}

		return resultado;
	}

}

	


