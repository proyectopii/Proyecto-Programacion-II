package COMUN;

public class clsExcepciones extends RuntimeException {
	private String mensaje;

	public void clsEquipacionRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}

	public void clsEquipoRepetida(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage1() {
		return mensaje;
	}
}




