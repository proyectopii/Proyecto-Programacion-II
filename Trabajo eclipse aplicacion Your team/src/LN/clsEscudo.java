package LN;

public class clsEscudo {
	/*
	 * Crearemos los atributos de clsEscudo
	 * Un String en formaEscudo porque cada escudo tendr� una forma
	 * Un String de colorescudo porque cada escudo de cada equipo tendr� un color
	 */
	private String formaEscudo;
	private String colorEscudo;
	/*
	 * Crearemos un constructo vac�o y otro con par�metros
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
