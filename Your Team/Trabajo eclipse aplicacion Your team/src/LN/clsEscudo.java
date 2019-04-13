package LN;

import static COMUN.Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO;
import static COMUN.Constantes.PROPIEDAD_clsESCUDO_FORMAESCUDO;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsEscudo implements itfProperty {
	/**
	 * Crearemos los atributos de clsEscudo Un formaEscudo porque cada escudo tendr?
	 * una forma Un colorescudo porque cada escudo de cada equipo tendr? un color
	 */
	private String formaEscudo;
	private String colorEscudo;

	/**
	 * Crearemos un constructo vac?o y otro con par?metros
	 */

	public clsEscudo() {
		String formaEscudo = "";
		String colorEscudo = "";
	}

	/**
	 * Aqui estara el constructor con parametros
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 */

	public clsEscudo(String formaEscudo, String colorEscudo) {
		super();
		this.formaEscudo = formaEscudo;
		this.colorEscudo = colorEscudo;
	}

	/**
	 * Ahora generaremos el hashcode con los atributos formaescudo y colorescudo por
	 * si se querr?a eliminar buscar o a?adir
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorEscudo == null) ? 0 : colorEscudo.hashCode());
		result = prime * result + ((formaEscudo == null) ? 0 : formaEscudo.hashCode());
		return result;
	}

	/**
	 * Aqui generaremos el equals para generar un patron de ordenamiento
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsEscudo other = (clsEscudo) obj;
		if (colorEscudo == null) {
			if (other.colorEscudo != null)
				return false;
		} else if (!colorEscudo.equals(other.colorEscudo))
			return false;
		if (formaEscudo == null) {
			if (other.formaEscudo != null)
				return false;
		} else if (!formaEscudo.equals(other.formaEscudo))
			return false;
		return true;
	}

	/**
	 * Crearemos los getters and setter de cada atributo
	 */
	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsESCUDO_FORMAESCUDO:
			return this.formaEscudo;
		case PROPIEDAD_clsESCUDO_COLORESCUDO:
			return this.colorEscudo;
		/**
		 * Aqui es donde propagaremos y lanzaremos el runtime exception por si casca en
		 * el default con el itf propert
		 */
		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * Aqui estan los setobjectproperty para definir
	 */

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsESCUDO_FORMAESCUDO:
			formaEscudo = ((String) valor);
			break;
		case PROPIEDAD_clsESCUDO_COLORESCUDO:
			colorEscudo = ((String) valor);
			break;
		}

	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	@Override
	public String toString() {
		return "clsEscudo [formaEscudo=" + formaEscudo + ", colorEscudo=" + colorEscudo + "]";
	}

}
