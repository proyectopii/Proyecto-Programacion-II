package COMUN;

public class clsExcepcionManagerRepetido extends Exception {
	/**
	 * Aqui crearemos todas las excepciones oportunas de Exceptions Crearemos un
	 * constructor vacio Será exceptions porque queremos que si hay una equipacion
	 * repetida nos salte la excepcion Aqui lanzamos la excepcion
	 * 
	 * @author Industria 4.0
	 *
	 */
	public clsExcepcionManagerRepetido(String mensaje) {
		/**
		 * Este caso es que saque un error para cuando haya un manager repetido Creamos
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
