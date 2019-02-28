package LN;

import java.time.LocalDate;

public class clsEquipo  {
	/**
	 * Crearemos los atributos de la clase clsEquipo que hereda de la clase clsJugador
	 * un nombre equipo porque cada equipo obligatoriamente tendrá un nombreEquipo
	 * todos los equipos tendran una fecha de fundación
	 */
	private String nombreEquipo;
	private LocalDate fundacionEquipo;
	/**
	 * Crearemos un constructor vacío y otro con parámetros
	 */
	public clsEquipo() {
		String nombreEquipo="";
		LocalDate fundacionEquipo=LocalDate.now();
	}
	public clsEquipo(String nombreEquipo, LocalDate fundacionEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.fundacionEquipo = fundacionEquipo;
	}
	/**
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
	/**
	 * Generaremos el hashcode de nombreEquipo y fundación equipo por si queremos eliminar buscar o añadir
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fundacionEquipo == null) ? 0 : fundacionEquipo.hashCode());
		result = prime * result + ((nombreEquipo == null) ? 0 : nombreEquipo.hashCode());
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
		clsEquipo other = (clsEquipo) obj;
		if (fundacionEquipo == null) {
			if (other.fundacionEquipo != null)
				return false;
		} else if (!fundacionEquipo.equals(other.fundacionEquipo))
			return false;
		if (nombreEquipo == null) {
			if (other.nombreEquipo != null)
				return false;
		} else if (!nombreEquipo.equals(other.nombreEquipo))
			return false;
		return true;
	}
	
	

	
	
	
	

}
