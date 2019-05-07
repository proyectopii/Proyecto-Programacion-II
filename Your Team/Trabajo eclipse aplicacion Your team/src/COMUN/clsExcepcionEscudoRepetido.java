package COMUN;

public class clsExcepcionEscudoRepetido extends Exception {
	/**
	 * Aqui crearemos todas las excepciones oportunas de Exceptions Será exceptions
	 * porque queremos que si hay una equipacion repetida nos salte la excepcion
	 * Aqui lanzamos la excepcion
	 * 
	 * @author Industria 4.0
	 *
	 */
	private String mensaje;

	/**
	 * Este caso es que saque un error para cuando haya un escudo repetido Creamos
	 * un constructor vacio
	 * 
	 * @param mensaje
	 */
	public clsExcepcionEscudoRepetido() {

	}

	public clsExcepcionEscudoRepetido(String mensaje) {

		this.mensaje = mensaje;
		/**
		 * Aqui creamos el constructor donde pondremos el mensaje
		 */
	}

	public String getMessage() {
		return mensaje;
	}

}
