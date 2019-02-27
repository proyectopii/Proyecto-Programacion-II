package LN;

public class clsEscudo {
	/*
	 * Crearemos los atributos de clsEscudo
	 * Un String en formaEscudo porque cada escudo tendrá una forma
	 * Un String de colorescudo porque cada escudo de cada equipo tendrá un color
	 */
	private String formaEscudo;
	private String colorEscudo;
	/*
	 * Crearemos un constructo vacío y otro con parámetros
	 */
	
	public clsEscudo() {
		String formaEscudo="";
		String colorEscudo="";
	}
	public clsEscudo(String formaEscudo, String colorEscudo) {
		super();
		this.formaEscudo = formaEscudo;
		this.colorEscudo = colorEscudo;
	}
	/*
	 * Crearemos los getters and setter de cada atributo
	 */
	public String getFormaEscudo() {
		return formaEscudo;
	}
	public void setFormaEscudo(String formaEscudo) {
		this.formaEscudo = formaEscudo;
	}
	public String getColorEscudo() {
		return colorEscudo;
	}
	public void setColorEscudo(String colorEscudo) {
		this.colorEscudo = colorEscudo;
	}
	
	

}
