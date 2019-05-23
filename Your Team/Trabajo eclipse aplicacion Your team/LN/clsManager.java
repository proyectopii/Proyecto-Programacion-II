package LN;

import static COMUN.Constantes.PROPIEDAD_clsMANAGER_VALORACION;
import static COMUN.Constantes.PROPIEDAD_clsMANAGER_CALIDAD;
import static COMUN.Constantes.PROPIEDAD_clsMANAGER_CONTRASENIA;

import java.sql.Date;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsManager extends clsPersona implements itfProperty {
	/**
	 * Aqui estan los atributos tendra una calidad que puede ser muy buena buena
	 * media o mala Tambien tendra una valoracion que va del 0 al 100
	 */
	private String calidad;
	private int valoracion;
	private String contrasenia;

	/**
	 * Aqui tenemos el constructor vacio
	 */

	public clsManager() {

	}

	/**
	 * Aqui haremos un constructor con parametros
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param calidad
	 * @param valoracion
	 * @param contraseña
	 */

	public clsManager(String nombre, String apellido1, String apellido2, String dni, String sexo, String calidad,
			int valoracion, String contraseña) {
		super(nombre, apellido1, apellido2, dni, sexo);
		this.calidad = calidad;
		this.valoracion = valoracion;
		this.contrasenia = contraseña;
	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	
	@Override
	public String toString() {
		return "clsManager [calidad=" + calidad + ", valoracion=" + valoracion + ", contraseña=" + contrasenia + "]";
	}

	/**
	 * Aqui tenemos el get object property donde obtendremos los datos de manager
	 */
	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsMANAGER_VALORACION:
			return this.valoracion;
		case PROPIEDAD_clsMANAGER_CALIDAD:
			return this.calidad;
		case PROPIEDAD_clsMANAGER_CONTRASENIA:
			return this.contrasenia;
		/**
		 * Aqui es donde propagaremos y lanzaremos la excepcion de run time exception de
		 * itfproperty
		 */

		default:
			throw new PropiedadInexistente("No existe esa propiedad!");

		}

	}

	/**
	 * Aqui esta el set object property
	 */

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsMANAGER_VALORACION:
			valoracion = ((int) valor);
			break;
		case PROPIEDAD_clsMANAGER_CALIDAD:
			calidad = ((String) valor);
			break;
		case PROPIEDAD_clsMANAGER_CONTRASENIA:
			contrasenia = ((String) valor);
			break;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((calidad == null) ? 0 : calidad.hashCode());
		return result;
	}
}
