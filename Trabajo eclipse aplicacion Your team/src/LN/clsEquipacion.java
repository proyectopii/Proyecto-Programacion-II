package LN;

import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR1;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_COLOR2;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_DORSAL;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDAD;
import static COMUN.Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADO;



import java.time.LocalDate;

import COMUN.itfProperty;

public class clsEquipacion extends clsEquipo implements itfProperty {
	/**
	 * Ponemos los atributos de la clase clsEquipación color 1 y color 2 porque cada
	 * equipación tendrá dos colores a elegir publicidad porque cada equipo tendrá
	 * derecho a ser patrocinado por alguién aunque si no quiere no pasará nada cada
	 * equipación tendrá derecho a poder escribirse frases en las camisetas
	 */
	private String color1;
	private String color2;
	private String publicidad;
	private String serigrafiado;
	private int dorsal;

	/**
	 * Primeramente crearemos un constructor vacío Después crearemos un constructor
	 * con parámetros
	 */
	public clsEquipacion() {
		String color1 = "";
		String color2 = "";
		String publicidad = "";
		String serigrafiado = "";
		int dorsal = 0;
	}

	public clsEquipacion(String nombreEquipo, LocalDate fundacionEquipo, String color1, String color2,
			String publicidad, String seriagrafiado, int dorsal) {
		super(nombreEquipo, fundacionEquipo);
		this.color1 = color1;
		this.color2 = color2;
		this.publicidad = publicidad;
		this.serigrafiado = seriagrafiado;
		this.dorsal = dorsal;
	}

	/**
	 * Aquí crearemos los getters and setters de los atributos
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
	 * añadir lo haremos a través de sus colores
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
		
					default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
	
	switch( propiedad )
	{
	case PROPIEDAD_clsEQUIPACION_COLOR1:color1=((String) valor); break;
	case PROPIEDAD_clsEQUIPACION_COLOR2:color2=((String) valor); break;
	case PROPIEDAD_clsEQUIPACION_SERIGRAFIADO:serigrafiado=((String) valor); break;
	case PROPIEDAD_clsEQUIPACION_PUBLICIDAD:publicidad=((String) valor); break;
	case PROPIEDAD_clsEQUIPACION_DORSAL:dorsal=((int)valor);break;
	
	}
	
	}

}
