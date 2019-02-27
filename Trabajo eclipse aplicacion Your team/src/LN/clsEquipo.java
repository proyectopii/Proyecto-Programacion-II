package LN;

import java.time.LocalDate;

public class clsEquipo extends clsJugador {
	/*
	 * Crearemos los atributos de la clase clsEquipo que hereda de la clase clsJugador
	 * un nombre equipo porque cada equipo obligatoriamente tendr� un nombreEquipo
	 * todos los equipos tendran una fecha de fundaci�n
	 */
	private String nombreEquipo;
	private LocalDate fundacionEquipo;
	/*
	 * Crearemos un constructor vac�o y otro con par�metros
	 */
	public clsEquipo() {
		String nombreEquipo="";
		LocalDate fundaci�nEquipo=LocalDate.now();
	}
	public clsEquipo(String nombreEquipo, LocalDate fundacionEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.fundacionEquipo = fundacionEquipo;
	}
	/*
	 * Generaremos los dichos getters and setters de los atributos
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public LocalDate getFundacionEquipo() {
		return fundacionEquipo;
	}
	public void setFundacionEquipo(LocalDate fundacionEquipo) {
		this.fundacionEquipo = fundacionEquipo;
	}
	

	
	
	
	

}
