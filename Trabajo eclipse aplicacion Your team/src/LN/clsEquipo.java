package LN;

import static COMUN.Constantes.PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPO_NOMBREEQUIPO;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.itfProperty;

public class clsEquipo implements itfProperty {
	/**
	 * Crearemos los atributos de la clase clsEquipo que hereda de la clase
	 * clsJugador un nombre equipo porque cada equipo obligatoriamente tendr? un
	 * nombreEquipo todos los equipos tendran una fecha de fundaci?n
	 */
	private String nombreEquipo;
	private Date fundacionEquipo;

	/**
	 * Crearemos un constructor vac?o y otro con par?metros
	 */
	public clsEquipo() {
		String nombreEquipo = "";
		Date fundacionEquipo = null;
	}

	public clsEquipo(String nombreEquipo, Date fundacionEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.fundacionEquipo = fundacionEquipo;
	}


	

	/**
	 * Generaremos el hashcode de nombreEquipo y fundaci?n equipo por si queremos
	 * eliminar buscar o a?adir
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
	/**
	 * Generaremos los dichos getters and setters de los atributos
	 */

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsEQUIPO_NOMBREEQUIPO:
			return this.nombreEquipo;
		case PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO:
			return this.fundacionEquipo;

		default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch(propiedad) {
		case PROPIEDAD_clsEQUIPO_NOMBREEQUIPO:nombreEquipo=((String) valor); break;
		case PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO:fundacionEquipo=((Date)valor);break;
		}
		
	}

}
