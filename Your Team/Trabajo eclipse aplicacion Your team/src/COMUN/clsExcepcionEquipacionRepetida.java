package COMUN;

/**
 * Aqui crearemos todas las excepciones oportunas de Exceptions Será exceptions
 * porque queremos que si hay una equipacion repetida nos salte la excepcion
 * Aqui lanzamos la excepcion
 * 
 * @author Industria 4.0
 *
 */
public class clsExcepcionEquipacionRepetida extends Exception {
	/**
	 * Este caso es que saque un error para cuando haya una equipacion repetida
	 * Creamos un constructor vacio
	 * 
	 * @param mensaje
	 */

	public clsExcepcionEquipacionRepetida(String mensaje) {
		super(mensaje);
	}
	/**
	 * Aqui creamos el constructor donde pondremos el mensaje
	 */

}


