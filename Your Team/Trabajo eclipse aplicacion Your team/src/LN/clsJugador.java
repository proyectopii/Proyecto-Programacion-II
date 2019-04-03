package LN;


import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_SKILLS;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.itfProperty;

public class clsJugador extends clsPersona  implements itfProperty {
	/**
	 * Crearemos los atributos de clsJugador Cada jugador tendr? un nombre y edad
	 * Cada jugador podr? estar preparado a trav?s de su forma f?sica Cada jugador
	 * depende de lo habilidoso que sea tendr? unas skills
	 */
	
	private int formaFisica;
	private double skills;

	/**
	 * Crearemos un constructor vac?o y otro con par?metros
	 */
	public clsJugador() {
		
	}

	public clsJugador( int formaFisica,double skills) {
		super();
		this.formaFisica = formaFisica;
		this.skills = skills;
	}



	/**
	 * Crearemos el hashcode con nombre jugador por si queremos a?adir buscar o
	 * eliminar
	 */
	
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
		
		default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch(propiedad) {
		case PROPIEDAD_clsJUGADOR_FORMAFISICA:formaFisica=((int)valor);break;
		case PROPIEDAD_clsJUGADOR_SKILLS:skills=((double)valor);break;
		}

	}


}
