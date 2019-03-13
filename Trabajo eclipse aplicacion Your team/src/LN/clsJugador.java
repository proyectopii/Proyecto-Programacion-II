package LN;

import java.time.LocalDate;

public class clsJugador extends clsEquipo {
	/**
	 * Crearemos los atributos de clsJugador
	 * Cada jugador tendrá un nombre y edad
	 * Cada jugador podrá estar preparado a través de su forma física
	 * Cada jugador depende de lo habilidoso que sea tendrá unas skills
	 */
	private String nombreJugador;
	private int formaFisica;
	private int edad;
	private double skills;
	/**
	 * Crearemos un constructor vacío y otro con parámetros
	 */
	
	public clsJugador(String nombreEquipo, LocalDate fundacionEquipo, String nombreJugador, int formaFisica, int edad,
			double skills) {
		super(nombreEquipo, fundacionEquipo);
		this.nombreJugador = nombreJugador;
		this.formaFisica = formaFisica;
		this.edad = edad;
		this.skills = skills;
	}
	/**
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
	/**
	 * Crearemos el hashcode con nombre jugador por si queremos añadir buscar o eliminar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nombreJugador == null) ? 0 : nombreJugador.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsJugador other = (clsJugador) obj;
		if (nombreJugador == null) {
			if (other.nombreJugador != null)
				return false;
		} else if (!nombreJugador.equals(other.nombreJugador))
			return false;
		return true;
	}
	

}
