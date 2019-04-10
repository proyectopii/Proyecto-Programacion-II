package COMUN;

/**
 * Aqui crearemos todas las excepciones oportunas de Runtime Exceptions
 * 
 * @author Industria 4.0
 *
 */
public class clsExcepcionEquipacionRepetida extends RuntimeException {
	private String mensaje="Equipaion repetida";// Crearemos un mensaje que hereda para poner cuando se de algo repetido

	/**
	 * Este caso es que saque un error para cuando haya una equipacion repetida
	 * 
	 * @param mensaje
	 */

	public void clsEquipacionRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}

	
}




