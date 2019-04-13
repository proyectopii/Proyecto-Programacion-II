package LN;

import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR1;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR2;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_DORSAL;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDAD;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADO;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsEquipacion implements itfProperty {
	/**
	 * Ponemos los atributos de la clase clsEquipaci?n color 1 y color 2 porque cada
	 * equipaci?n tendr? dos colores a elegir publicidad porque cada equipo tendr?
	 * derecho a ser patrocinado por algui?n aunque si no quiere no pasar? nada cada
	 * equipaci?n tendr? derecho a poder escribirse frases en las camisetas
	 */
	private String color1;
	private String color2;
	private String publicidad;
	private String serigrafiado;
	private int dorsal;

	/**
	 * Primeramente crearemos un constructor vac?o Despu?s crearemos un constructor
	 * con par?metros
	 */
	public clsEquipacion() {
		String color1 = "";
		String color2 = "";
		String publicidad = "";
		String serigrafiado = "";
		int dorsal = 0;
	}

	/**
	 * Aqui creamos el constructor con parametros
	 * 
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param serigrafiado
	 * @param dorsal
	 */

	public clsEquipacion(String color1, String color2, String publicidad, String serigrafiado, int dorsal) {
		super();
		this.color1 = color1;
		this.color2 = color2;
		this.publicidad = publicidad;
		this.serigrafiado = serigrafiado;
		this.dorsal = dorsal;
	}

	/**
	 * Creamos el hashcode and equals para poder poner un patrón de comparamiento
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color2 == null) ? 0 : color2.hashCode());
		result = prime * result + ((color1 == null) ? 0 : color1.hashCode());
		return result;
	}

	/**
	 * Generamos el hashcode por si da el caso que queremos buscar, eliminar o
	 * a?adir lo haremos a trav?s de sus colores
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsEquipacion other = (clsEquipacion) obj;
		if (color2 == null) {
			if (other.color2 != null)
				return false;
		} else if (!color2.equals(other.color2))
			return false;
		if (color1 == null) {
			if (other.color1 != null)
				return false;
		} else if (!color1.equals(other.color1))
			return false;
		return true;
	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	@Override
	public String toString() {
		return "clsEquipacion [color1=" + color1 + ", color2=" + color2 + ", publicidad=" + publicidad
				+ ", serigrafiado=" + serigrafiado + ", dorsal=" + dorsal + "]";
	}

	/**
	 * Aqui crearemos los getters and setters de los atributos
	 */

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsEQUIPACION_COLOR1:
			return this.color1;
		case PROPIEDAD_clsEQUIPACION_COLOR2:
			return this.color2;
		case PROPIEDAD_clsEQUIPACION_SERIGRAFIADO:
			return this.serigrafiado;
		case PROPIEDAD_clsEQUIPACION_PUBLICIDAD:
			return this.publicidad;
		case PROPIEDAD_clsEQUIPACION_DORSAL:
			return this.dorsal;
		/**
		 * Aqui es donde propagamos y lanzamos el runtime exception por si iria al
		 * default y cascaria
		 */

		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * Aqui estan los setobjectproperty
	 */

	@Override
	public void setObjectProperty(String propiedad, Object valor) {

		switch (propiedad) {
		case PROPIEDAD_clsEQUIPACION_COLOR1:
			color1 = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_COLOR2:
			color2 = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_SERIGRAFIADO:
			serigrafiado = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_PUBLICIDAD:
			publicidad = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_DORSAL:
			dorsal = ((int) valor);
			break;

		}

	}

}
