package LN;

public class clsEquipacion {
	/*
	 * Ponemos los atributos de la clase clsEquipaci�n
	 * color 1 y color 2 porque cada equipaci�n tendr� dos colores a elegir
	 * publicidad porque cada equipo tendr� derecho a ser patrocinado por algui�n
	 * cada equipaci�n tendr� derecho a poder escribirse frases en las camisetas
	 */
	private String color1;
	private String colo2;
	private String publicidad;
	private String seriagrafiado;
	/*
	 * Primeramente crearemos un constructor vac�o
	 * Despu�s crearemos un constructor con par�metros
	 */
	public clsEquipacion() {
		String color1="";
		String color2="";
		String publicidad="";
		String serigrafiado="";
	}
	public clsEquipacion(String color1, String colo2, String publicidad, String seriagrafiado) {
		super();
		this.color1 = color1;
		this.colo2 = colo2;
		this.publicidad = publicidad;
		this.seriagrafiado = seriagrafiado;
	}
	/*
	 * Aqu� crearemos los getters and setters de los atributos
	 */
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColo2() {
		return colo2;
	}
	public void setColo2(String colo2) {
		this.colo2 = colo2;
	}
	public String getPublicidad() {
		return publicidad;
	}
	public void setPublicidad(String publicidad) {
		this.publicidad = publicidad;
	}
	public String getSeriagrafiado() {
		return seriagrafiado;
	}
	public void setSeriagrafiado(String seriagrafiado) {
		this.seriagrafiado = seriagrafiado;
	}
	@Override
	public String toString() {
		return "clsEquipacion [color1=" + color1 + ", colo2=" + colo2 + ", publicidad=" + publicidad
				+ ", seriagrafiado=" + seriagrafiado + "]";
	}
	
	
	

}
