package LN;

import java.time.LocalDate;

public class clsTemporada {
	/*
	 * Crearemos los atributos siguientes:
	 * puestos por el tema del número que pueda quedar un equipo y tiene que ser entero
	 * trofeos porque al final de la temporada los tres primeros recibirán un trofeo y cada trofeo tendrá un nombre
	 * un año de temporada para saber en que año estamos en dicha temporada
	 * un ganador que será el que quede primero y se cogerá el nombre de ciho equipo
	 */
	private int puestos;
	private String trofeos;
	private LocalDate añoTemporada;
	private String ganador;
	/*
	 * Crearemos un contructor vacío y un contructor con parámetros
	 */
	
	public clsTemporada() {
		int puestos=0;
		String trofeos="";
		LocalDate añoTemporada=LocalDate.now();
		String ganador="";
	}
	
	public clsTemporada(int puestos, String trofeos, LocalDate añoTemporada, String ganador) {
		super();
		this.puestos = puestos;
		this.trofeos = trofeos;
		this.añoTemporada = añoTemporada;
		this.ganador = ganador;
	}
	/*
	 * Crearemos los getter y setters de los atributos que hemos puesto
	 */
	public int getPuestos() {
		return puestos;
	}
	public void setPuestos(int puestos) {
		this.puestos = puestos;
	}
	public String getTrofeos() {
		return trofeos;
	}
	public void setTrofeos(String trofeos) {
		this.trofeos = trofeos;
	}
	public LocalDate getAñoTemporada() {
		return añoTemporada;
	}
	public void setAñoTemporada(LocalDate añoTemporada) {
		this.añoTemporada = añoTemporada;
	}
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	

}
