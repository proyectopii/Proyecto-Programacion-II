package LN;

public class clsJugador {
	/*
	 * Crearemos los atributos de clsJugador
	 * Cada jugador tendrá un nombre y edad
	 * Cada jugador podrá estar preparado a través de su forma física
	 * Cada jugador depende de lo habilidoso que sea tendrá unas skills
	 */
	private String nombreJugador;
	private int formaFisica;
	private int edad;
	private double skills;
	/*
	 * Crearemos un constructor vacío y otro con parámetros
	 */
	public clsJugador() {
		String nombreJugador="";
		int formaFísica=0;
		int edad=0;
		double skills=0.0;
	}
	public clsJugador(String nombreJugador, int formaFisica, int edad, double skills) {
		super();
		this.nombreJugador = nombreJugador;
		this.formaFisica = formaFisica;
		this.edad = edad;
		this.skills = skills;
	}
	/*
	 * Crearemos los getters y setters de los atributos
	 */
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public int getFormaFisica() {
		return formaFisica;
	}
	public void setFormaFisica(int formaFisica) {
		this.formaFisica = formaFisica;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSkills() {
		return skills;
	}
	public void setSkills(double skills) {
		this.skills = skills;
	}
	
	

}
