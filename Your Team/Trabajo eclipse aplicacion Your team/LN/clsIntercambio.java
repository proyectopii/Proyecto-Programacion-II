package LN;

import java.time.LocalDate;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;
import static COMUN.Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN;
import static COMUN.Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO;

public class clsIntercambio implements itfProperty {
	/**
	 * Crearemos los atributos de clsIntercambio Para hacer un intercambio tendr?
	 * que haber un equipo origen y equipo destino
	 */
	private String equipoOrigen;
	private String equipoDestino;

	/**
	 * Ahora crearemos un constructor vac?o y otro con par?metros
	 */
	public clsIntercambio() {
		String equipoOrigen = "";
		String equipoDestino = "";
	}

	/**
	 * Aqui generaremos el constructor con parametros
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 */

	public clsIntercambio(String equipoOrigen, String equipoDestino) {
		super();
		this.equipoOrigen = equipoOrigen;
		this.equipoDestino = equipoDestino;
	}

	/**
	 * Generaremos el hashcode con equipo origen y equipo destino por si queremos
	 * buscar a?adir o eliminar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoDestino == null) ? 0 : equipoDestino.hashCode());
		result = prime * result + ((equipoOrigen == null) ? 0 : equipoOrigen.hashCode());
		return result;
	}

	/**
	 * Generamos el equals para poner un patron de ordenamiento
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsIntercambio other = (clsIntercambio) obj;
		if (equipoDestino == null) {
			if (other.equipoDestino != null)
				return false;
		} else if (!equipoDestino.equals(other.equipoDestino))
			return false;
		if (equipoOrigen == null) {
			if (other.equipoOrigen != null)
				return false;
		} else if (!equipoOrigen.equals(other.equipoOrigen))
			return false;
		return true;
	}

	/**
	 * Ahora crearemos los getters y setters de los atributos
	 */

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN:
			return this.equipoOrigen;
		case PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO:
			return this.equipoDestino;
		/**
		 * Aqui es donde propagaremos y lanzaremos el run time exception con el itf
		 * property
		 */
		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * Aqui tenemos el set object propert
	 */

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN:
			equipoOrigen = ((String) valor);
			break;
		case PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO:
			equipoDestino = ((String) valor);
			break;
		}

	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	@Override
	public String toString() {
		return "clsIntercambio [equipoOrigen=" + equipoOrigen + ", equipoDestino=" + equipoDestino + "]";
	}
	/**
	 * Aqui generaremos los getters y setters
	 */

	public String getEquipoOrigen() {
		return equipoOrigen;
	}

	public void setEquipoOrigen(String equipoOrigen) {
		this.equipoOrigen = equipoOrigen;
	}

	public String getEquipoDestino() {
		return equipoDestino;
	}

	public void setEquipoDestino(String equipoDestino) {
		this.equipoDestino = equipoDestino;
	}

	

}
