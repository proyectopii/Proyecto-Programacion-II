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

	private String mensaje;

	/**
	 * Este caso es que saque un error para cuando haya una equipacion repetida
	 * Creamos un constructor vacio
	 * 
	 * @param mensaje
	 */
	public clsExcepcionEquipacionRepetida() {

	}

	public clsExcepcionEquipacionRepetida(String mensaje) {

		this.mensaje = mensaje;

	}

	/**
	 * Aqui creamos el constructor donde pondremos el mensaje
	 */

	public String getMessage() {
		return mensaje;
	}

}


