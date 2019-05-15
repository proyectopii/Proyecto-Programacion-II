package LN;

import static COMUN.Constantes.PROPIEDAD_clsPERSONA_NOMBRE;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_SKILLS;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_APELLIDO1;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_APELLIDO2;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_DNI;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_SEXO;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public abstract class clsPersona implements itfProperty {
	private String nombre;// Un nombre para cada persona
	private String apellido1; // Un primer apellido para cada persona
	private String apellido2;// Un segundo apellido para cada persona
	private String dni;// Un dni para tener
	private String sexo;// Un sexo para saber si es masculino o femenino

	/**
	 * Crearemos un constructor vacio
	 */

	public clsPersona() {

	}

	/**
	 * Crearemos un constructor donde tendremos todos los par?metros
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 */
	public clsPersona(String nombre, String apellido1, String apellido2, String dni, String sexo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * Aqui tenemos los getters para obtener los atributos
	 */

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsPERSONA_NOMBRE:
			return this.nombre;
		case PROPIEDAD_clsPERSONA_APELLIDO1:
			return this.apellido1;
		case PROPIEDAD_clsPERSONA_APELLIDO2:
			return this.apellido2;
		case PROPIEDAD_clsPERSONA_DNI:
			return this.dni;
		case PROPIEDAD_clsPERSONA_SEXO:
			return this.sexo;
		/**
		 * Aqui es donde lanzaremos las excepciones de run time por si entra por el
		 * default
		 */

		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * Aqui estan los set object property que estan para establecer
	 */
	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsPERSONA_NOMBRE:
			nombre = ((String) valor);
			break;
		case PROPIEDAD_clsPERSONA_APELLIDO1:
			apellido1 = ((String) valor);
			break;
		case PROPIEDAD_clsPERSONA_APELLIDO2:
			apellido2 = ((String) valor);
			break;
		case PROPIEDAD_clsPERSONA_DNI:
			dni = ((String) valor);
			break;
		case PROPIEDAD_clsPERSONA_SEXO:
			sexo = ((String) valor);
			break;

		}

	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */

	@Override
	public String toString() {
		return "clsPersona [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", sexo=" + sexo + "]";
	}

}
