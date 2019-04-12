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
	public clsExcepcionEscudoRepetido(String mensaje) {
		/**
		 * Este caso es que saque un error para cuando haya un escudo repetido Creamos
		 * un constructor vacio
		 * 
		 * @param mensaje
		 */
		super(mensaje);
		/**
		 * Aqui creamos el constructor donde pondremos el mensaje
		 */
	}

}
