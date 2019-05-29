package LN;

import static COMUN.Constantes.PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPO_NOMBREEQUIPO;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsEquipo implements itfProperty {
	private static final String fecha = null;
	/**
	 * Crearemos los atributos de la clase clsEquipo que hereda de la clase
	 * clsJugador un nombre equipo porque cada equipo obligatoriamente tendr? un
	 * nombreEquipo todos los equipos tendran una fecha de fundaci?n
	 */
	private String nombreEquipo;
	private Date fundacionEquipo;
	Date date = new Date(0);

	/**
	 * Crearemos un constructor vac?o y otro con par?metros
	 */
	public clsEquipo() {
		String nombreEquipo = "";
		Date fundacionEquipo = null;
	}

	/**
	 * Aqui creamos el constructor con parametros
	 * 
	 * @param nombreEquipo
	 * @param fundacionEquipo
	 */

	public clsEquipo(String nombreEquipo, Date fundacionEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.fundacionEquipo = fundacionEquipo;
	}

	/**
	 * Generaremos el hashcode de nombreEquipo y fundaci?n equipo por si queremos
	 * eliminar buscar o aniadir
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fundacionEquipo == null) ? 0 : fundacionEquipo.hashCode());
		result = prime * result + ((nombreEquipo == null) ? 0 : nombreEquipo.hashCode());
		return result;
	}

	/**
	 * Generamos el hashcode y equals para establecer un patron de ordenamiento
	 */

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
		/**
		 * Aqui es donde propagaremos y lanzaremos el runtime exception
		 */

		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * AAqui estan los setobjectproperty para definir
	 */

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsEQUIPO_NOMBREEQUIPO:
			nombreEquipo = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO:
			fundacionEquipo = ((Date) valor);
			break;
		}

	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	@Override
	public String toString() {
		return "clsEquipo [nombreEquipo=" + nombreEquipo + ", fundacionEquipo=" + fundacionEquipo + ", date=" + date
				+ "]";
	}

	/**
	 * Aqui generaremos los getters y setters
	 */

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Date getFundacionEquipo() {
		return fundacionEquipo;
	}

	public void setFundacionEquipo(Date fundacionEquipo) {
		this.fundacionEquipo = fundacionEquipo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static String getFecha() {
		return fecha;
	}
}