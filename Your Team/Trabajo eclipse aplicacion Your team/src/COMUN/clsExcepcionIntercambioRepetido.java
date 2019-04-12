package COMUN;

public class clsExcepcionIntercambioRepetido extends Exception {
	/**
	 * Aqui crearemos todas las excepciones oportunas de Exceptions Será exceptions
	 * porque queremos que si hay una equipacion repetida nos salte la excepcion
	 * Aqui lanzamos la excepcion
	 * 
	 * @author Industria 4.0
	 *
	 */
	public clsExcepcionIntercambioRepetido(String mensaje) {
		/**
		 * Este caso es que saque un error para cuando haya un intercambio repetido
		 * Creamos un constructor vacio
		 * 
		 * @param mensaje
		 */
		super(mensaje);
		/**
		 * Aqui creamos el constructor donde pondremos el mensaje
		 */
	}

}
