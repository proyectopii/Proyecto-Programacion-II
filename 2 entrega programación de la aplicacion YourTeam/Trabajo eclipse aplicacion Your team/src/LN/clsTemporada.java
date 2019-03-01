package LN;

import java.time.LocalDate;

public class clsTemporada extends clsPartidos {
	/**
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
	/**
	 * Crearemos un contructor vacío y un contructor con parámetros
	 */
	
	public clsTemporada() {
		int puestos=0;
		String trofeos="";
		LocalDate añoTemporada=LocalDate.now();
		String ganador="";
	}
	
	public clsTemporada(String equipoLocal, String equipoVisitante, LocalDate fechaInicioPartido,int puestos, String trofeos, LocalDate añoTemporada, String ganador) {
		super(equipoLocal,equipoVisitante,fechaInicioPartido);
		this.puestos = puestos;
		this.trofeos = trofeos;
		this.añoTemporada = añoTemporada;
		this.ganador = ganador;
	}
	/**
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
	/**
	 * Generaremos el hashcode con el añotemporada y los puestos para buscar añadir o eliminar
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((añoTemporada == null) ? 0 : añoTemporada.hashCode());
		result = prime * result + puestos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsTemporada other = (clsTemporada) obj;
		if (añoTemporada == null) {
			if (other.añoTemporada != null)
				return false;
		} else if (!añoTemporada.equals(other.añoTemporada))
			return false;
		if (puestos != other.puestos)
			return false;
		return true;
	}
	
	

}
