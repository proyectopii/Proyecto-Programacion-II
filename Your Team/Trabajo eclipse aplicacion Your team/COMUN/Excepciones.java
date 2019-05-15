package COMUN;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Excepciones {
	/**
	 * Aqui meteremos con try catch posibles excepciones que se puedan ocasionar para
	 * la base de datos
	 */
	private static Excepciones instance = null;
	/**
	 * Por ejemplo este por si ha habido fallos con la conexion
	 */

	private Connection connection = null;

	private void checkConnected() {
		if (connection == null)
			throw new IllegalStateException("La conexion a la BD no ha sido creada.");
	}

	private Excepciones() {
	}

	public static Excepciones getInstance() {
		/**
		 * Aqui ponemos excepcion por el tema de drivers
		 */
		if (instance == null) {
			instance = new Excepciones();
		}
		return instance;
	}

	public static void releaseInstance() {
		instance = null;
	}

	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		/**
		 * Aqui pondremos nuestra url usuario y contrasenia para el workbench
		 */
		// useSSL = true para que la conexion sea cifrada
		/**
		 * Aqui pondremos la url de nuestro server
		 */
		String sURL = "jdbc:mysql://localhost:3306/mydb?useSSL=true&serverTimezone=GMT";
		/**
		 * metemos la url nombre y contraseña
		 */

		connection = java.sql.DriverManager.getConnection(sURL, "root", "root");

		// System.out.println("Conectado.");
	}

	public void disconnect() throws SQLException {
		/**
		 * Con este metodo al desconectarnos guardamos bien todo y se cierra por miedo a
		 * que se pierda algo de imformacion
		 */
		checkConnected();
		connection.close();
		// System.out.println("Desconectado.");
	}

	public Statement createStatement() throws SQLException {
		checkConnected();
		return connection.createStatement();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		/**
		 * Este metodo es para saber si nuestra conexion este con on off
		 */
		checkConnected();
		return connection.createStatement(resultSetType, resultSetConcurrency);
	}
}


