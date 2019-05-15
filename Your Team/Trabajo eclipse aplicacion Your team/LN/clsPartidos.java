package LN;

import static COMUN.Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL;
import static COMUN.Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE;
import static COMUN.Constantes.PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.Constantes;
import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsPartidos implements itfProperty, Comparable {
	/**
	 * Pondremos los atributos de clsPartidos Tendremos un equipo local y un equipo
	 * visitante que son los que compiten en un partido Podnremos tambi?n una fecha
	 * para saber en que hora ha empezado
	 */
	private String equipoLocal;
	private String equipoVisitante;
	private Date fechaInicioPartido;

	/**
	 * A continuaci?n pondremos un constructor con par?metros y sin par?metros
	 */
	public clsPartidos() {
		String equipoLocal = "";
		String equipoVisitante = "";
		Date fechaInicioPartido = null;
	}

	/**
	 * Aqui tenemos el constructor con parametros
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 */

	public clsPartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fechaInicioPartido = fechaInicioPartido;
	}

	/**
	 * Generaremos el hashcode con equipo local y equipo visitante para a?adir
	 * eliminar o buscar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoLocal == null) ? 0 : equipoLocal.hashCode());
		result = prime * result + ((equipoVisitante == null) ? 0 : equipoVisitante.hashCode());
		return result;
	}

	/**
	 * Generaremos el equals para ver como hacemos el patron de ordenacion
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsPartidos other = (clsPartidos) obj;
		if (equipoLocal == null) {
			if (other.equipoLocal != null)
				return false;
		} else if (!equipoLocal.equals(other.equipoLocal))
			return false;
		if (equipoVisitante == null) {
			if (other.equipoVisitante != null)
				return false;
		} else if (!equipoVisitante.equals(other.equipoVisitante))
			return false;
		return true;
	}

	/**
	 * Tambi?n pondremos los getters y setters de los atributos
	 */
	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL:
			return this.equipoLocal;
		case PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE:
			return this.equipoVisitante;
		case PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO:
			return this.fechaInicioPartido;
		/**
		 * Aqui es donde propagaremos y lanzaremos la excepcion de run time exception de
		 * itf property
		 */

		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * Aqui estan los set object property que estan para definir
	 */
	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL:
			equipoLocal = ((String) valor);
			break;
		case PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE:
			equipoVisitante = ((String) valor);
			break;
		case PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO:
			fechaInicioPartido = ((Date) valor);
			break;
		}

	}

	/**
	 * Aqui tenemos el comparable para comparar los partidos por fechas
	 */

	@Override
	public int compareTo(Object o) {
		return this.fechaInicioPartido.compareTo(
				(Date) ((itfProperty) o).getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO));
	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	@Override
	public String toString() {
		return "clsPartidos [equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", fechaInicioPartido=" + fechaInicioPartido + "]";
	}

}
