package LN;

import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR1P;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR2P;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_DORSAL;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDADP;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDADS;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADOP;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADOS;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR1S;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR2S;

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
	private String color1P;
	private String color2P;
	private String color1S;
	private String color2S;
	private String publicidadP;
	private String publicidadS;
	private String serigrafiadoP;
	private String serigrafiadoS;
	private int dorsal;

	/**
	 * Primeramente crearemos un constructor vac?o Despu?s crearemos un constructor
	 * con par?metros
	 */
	public clsEquipacion() {
		String color1P = "";
		String color2P = "";
		String color1S = "";
		String color2S = "";
		String publicidad = "";
		String serigrafiado = "";
		int dorsal = 0;
	}

	/**
	 * Aqui creamos el constructor con parametros
	 * 
	 * @param color1P
	 * @param color2P
	 * @param color1S
	 * @param color2S
	 * @param publicidad
	 * @param serigrafiado
	 * @param dorsal
	 */

	public clsEquipacion(String color1P, String color2P, String color1S, String color2S, String publicidadP, String publicidadS,
			String serigrafiadoP, String serigrafiadoS, int dorsal) {
		super();
		this.color1P = color1P;
		this.color2P = color2P;
		this.color1S = color1S;
		this.color2S = color2S;		
		this.publicidadP = publicidadP;
		this.publicidadS = publicidadS;
		this.serigrafiadoP = serigrafiadoP;
		this.serigrafiadoS = serigrafiadoS;
		this.dorsal = dorsal;
	}

	/**
	 * Creamos el hashcode and equals para poder poner un patrón de comparamiento
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color2P == null) ? 0 : color2P.hashCode());
		result = prime * result + ((color1P == null) ? 0 : color1P.hashCode());
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
		if (color2P == null) {
			if (other.color2P != null)
				return false;
		} else if (!color2P.equals(other.color2P))
			return false;
		if (color1P == null) {
			if (other.color1P != null)
				return false;
		} else if (!color1P.equals(other.color1P))
			return false;
		return true;
	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	

	

	@Override
	public String toString() {
		return "clsEquipacion [color1P=" + color1P + ", color2P=" + color2P + ", color1S=" + color1S + ", color2S="
				+ color2S + ", publicidadP=" + publicidadP + ", publicidadS=" + publicidadS + ", serigrafiadoP="
				+ serigrafiadoP + ", serigrafiadoS=" + serigrafiadoS + ", dorsal=" + dorsal + "]";
	}

	/**
	 * Aqui crearemos los getters and setters de los atributos
	 */

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsEQUIPACION_COLOR1P:
			return this.color1P;
		case PROPIEDAD_clsEQUIPACION_COLOR2P:
			return this.color2P;
		case PROPIEDAD_clsEQUIPACION_COLOR1S:
			return this.color1S;
		case PROPIEDAD_clsEQUIPACION_COLOR2S:
			return this.color2S;
		case PROPIEDAD_clsEQUIPACION_SERIGRAFIADOP:
			return this.serigrafiadoP;
		case PROPIEDAD_clsEQUIPACION_SERIGRAFIADOS:
			return this.serigrafiadoS;
		case PROPIEDAD_clsEQUIPACION_PUBLICIDADP:
			return this.publicidadP;
		case PROPIEDAD_clsEQUIPACION_PUBLICIDADS:
			return this.publicidadS;
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
		case PROPIEDAD_clsEQUIPACION_COLOR1P:
			color1P = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_COLOR2P:
			color2P = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_COLOR1S:
			color1S = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_COLOR2S:
			color2S = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_SERIGRAFIADOP:
			serigrafiadoP = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_SERIGRAFIADOS:
			serigrafiadoS = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_PUBLICIDADP:
			publicidadP = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_PUBLICIDADS:
			publicidadS = ((String) valor);
			break;
		case PROPIEDAD_clsEQUIPACION_DORSAL:
			dorsal = ((int) valor);
			break;

		}

	}

}
