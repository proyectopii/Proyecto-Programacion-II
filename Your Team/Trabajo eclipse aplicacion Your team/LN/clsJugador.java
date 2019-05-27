package LN;

import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_SKILLS;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsJugador extends clsPersona implements itfProperty {
	/**
	 * Crearemos los atributos de clsJugador Cada jugador tendr? un nombre y edad
	 * Cada jugador podr? estar preparado a trav?s de su forma f?sica Cada jugador
	 * depende de lo habilidoso que sea tendr? unas skills
	 */

	private int formaFisica;
	private double skills;

	/**
	 * Crearemos un constructor vac?o y otro con par?metros
	 * 
	 * @param skills2
	 * @param formaFisica2
	 * @param skills2
	 * @param ensexo
	 * @param dni
	 * @param apellido2
	 * @param apellido1
	 * @param nombre
	 */
	public clsJugador(int formaFisica2, double skills2) {
		String nombre = "";
		String apellido1 = "";
		String apellido2 = "";
		String dni = "";
		String sexo = "";
		double skills = 0;
		int formaFisica = 0;

	}

	/**
	 * Aqui generaremos el constructor con parametros
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param skills
	 * @param formaFisica
	 */

	public clsJugador(String nombre, String apellido1, String apellido2, String dni, String sexo, double skills,
			int formaFisica) {
		super(nombre, apellido1, apellido2, dni, sexo);
		this.formaFisica = formaFisica;
		this.skills = skills;
	}

	
	/**
	 * Crearemos los getters y setters de los atributos
	 */

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsJUGADOR_FORMAFISICA:
			return this.formaFisica;
		case PROPIEDAD_clsJUGADOR_SKILLS:
			return this.skills;
		/**
		 * Aqui es donde lanzaremos y proparagaremos el runtime exception de itf
		 * property con el default
		 */

		default: return super.getObjectProperty(propiedad);

		}

	}

	/**
	 * Aqui estan los set object property para definir
	 */

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch (propiedad) {
		case PROPIEDAD_clsJUGADOR_FORMAFISICA:
			formaFisica = ((int) valor);
			break;
		case PROPIEDAD_clsJUGADOR_SKILLS:
			skills = ((double) valor);
			break;
		}

	}

	/**
	 * Generamos el getString para que no nos salgan las rutas de los objetos y nos
	 * salgan los nombres
	 */
	@Override
	public String toString() {
		return "clsJugador [formaFisica=" + formaFisica + ", skills=" + skills + "]";
	}
	/**
	 * Aqui generaremos los getters y setters
	 */

	public int getFormaFisica() {
		return formaFisica;
	}

	public void setFormaFisica(int formaFisica) {
		this.formaFisica = formaFisica;
	}

	public double getSkills() {
		return skills;
	}

	public void setSkills(double skills) {
		this.skills = skills;
	}

	

}
