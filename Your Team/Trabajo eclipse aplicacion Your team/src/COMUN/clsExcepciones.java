package COMUN;
/**
 * Aqui crearemos todas las excepciones oportunas de Runtime Exceptions
 * @author Industria 4.0
 *
 */
public class clsExcepciones extends RuntimeException {
	private String mensaje;//Crearemos un mensaje que hereda para poner cuando se de algo repetido
	
	/**
	 * Este caso es que saque un error para cuando haya una equipacion repetida
	 * @param mensaje
	 */

	public void clsEquipacionRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}
/**
 *  Este caso es que saque un error para cuando haya un equipo repetido
 * @param mensaje
 */
	public void clsEquipoRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage1() {
		return mensaje;
	}
	/**
	 *  Este caso es que saque un error para cuando haya un escudo repetido
	 * @param mensaje
	 */
	public void clsEscudoRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage2() {
		return mensaje;
	}
	/**
	 *  Este caso es que saque un error para cuando haya un intercambio repetido
	 * @param mensaje
	 */
	
	public void clsIntercambiooRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage3() {
		return mensaje;
	}
	/**
	 *  Este caso es que saque un error para cuando haya un jugador repetido
	 * @param mensaje
	 */
	
	public void clsJugadorRepetido(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage4() {
		return mensaje;
	}
	/**
	 *  Este caso es que saque un error para cuando haya un manager repetido
	 * @param mensaje
	 */
	
	public void clsManagerRepetido(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage5() {
		return mensaje;
	}
	/**
	 *  Este caso es que saque un error para cuando haya un partido repetido
	 * @param mensaje
	 */
	
	public void clsPartidosRepetido(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage6() {
		return mensaje;
	}
	public void clsTemporadaRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage7() {
		return mensaje;
	}
}




