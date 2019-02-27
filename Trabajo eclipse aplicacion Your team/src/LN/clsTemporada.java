package LN;

import java.time.LocalDate;

public class clsTemporada {
	/*
	 * Crearemos los atributos siguientes:
	 * puestos por el tema del n�mero que pueda quedar un equipo y tiene que ser entero
	 * trofeos porque al final de la temporada los tres primeros recibir�n un trofeo y cada trofeo tendr� un nombre
	 * un a�o de temporada para saber en que a�o estamos en dicha temporada
	 * un ganador que ser� el que quede primero y se coger� el nombre de ciho equipo
	 */
	private int puestos;
	private String trofeos;
	private LocalDate a�oTemporada;
	private String ganador;
	/*
	 * Crearemos un contructor vac�o y un contructor con par�metros
	 */
	
	public clsTemporada() {
		int puestos=0;
		String trofeos="";
		LocalDate a�oTemporada=LocalDate.now();
		String ganador="";
	}
	
	public clsTemporada(int puestos, String trofeos, LocalDate a�oTemporada, String ganador) {
		super();
		this.puestos = puestos;
		this.trofeos = trofeos;
		this.a�oTemporada = a�oTemporada;
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
	public LocalDate getA�oTemporada() {
		return a�oTemporada;
	}
	public void setA�oTemporada(LocalDate a�oTemporada) {
		this.a�oTemporada = a�oTemporada;
	}
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	

}
