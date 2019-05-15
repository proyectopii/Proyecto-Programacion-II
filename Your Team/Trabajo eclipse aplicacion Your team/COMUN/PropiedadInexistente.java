package COMUN;

/**
 * Aqui crearemos una excepcion de runtimeexception
 * 
 * @author Industria 4.0
 *
 */

public class PropiedadInexistente extends RuntimeException {
	/**
	 * Creamos un constructor vacio
	 */
	public PropiedadInexistente() {
		super();
	}

	/**
	 * y otro constructor con parametros que es donde metemos el mensaje
	 * 
	 * @param texto
	 */
	public PropiedadInexistente(String texto) {
		super(texto);
	}

}
