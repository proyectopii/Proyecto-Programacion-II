package LN;

import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_EDAD;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_NOMBREJUGADOR;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_SKILLS;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.itfProperty;

public class clsJugador extends clsEquipo implements itfProperty {
	/**
	 * Crearemos los atributos de clsJugador Cada jugador tendr? un nombre y edad
	 * Cada jugador podr? estar preparado a trav?s de su forma f?sica Cada jugador
	 * depende de lo habilidoso que sea tendr? unas skills
	 */
	private String nombreJugador;
	private int formaFisica;
	private int edad;
	private double skills;

	/**
	 * Crearemos un constructor vac?o y otro con par?metros
	 */
	public clsJugador() {
		
	}

	public clsJugador(String nombreJugador, int formaFisica, int edad, double skills, String nombreEquipo,
			Date fundacionEquipo) {
		super(nombreEquipo, fundacionEquipo);
		this.nombreJugador = nombreJugador;
		this.formaFisica = formaFisica;
		this.edad = edad;
		this.skills = skills;
	}



	/**
	 * Crearemos el hashcode con nombre jugador por si queremos a?adir buscar o
	 * eliminar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nombreJugador == null) ? 0 : nombreJugador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsJugador other = (clsJugador) obj;
		if (nombreJugador == null) {
			if (other.nombreJugador != null)
				return false;
		} else if (!nombreJugador.equals(other.nombreJugador))
			return false;
		return true;
	}
	/**
	 * Crearemos los getters y setters de los atributos
	 */
	
	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsJUGADOR_NOMBREJUGADOR:
			return this.nombreJugador;
		case PROPIEDAD_clsJUGADOR_FORMAFISICA:
			return this.formaFisica;
		case PROPIEDAD_clsJUGADOR_EDAD:
			return this.edad;
		case PROPIEDAD_clsJUGADOR_SKILLS:
			return this.skills;
		
		default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch(propiedad) {
		case PROPIEDAD_clsJUGADOR_NOMBREJUGADOR:nombreJugador=((String)valor);break;
		case PROPIEDAD_clsJUGADOR_FORMAFISICA:formaFisica=((int)valor);break;
		case PROPIEDAD_clsJUGADOR_EDAD:edad=((int)valor);break;
		case PROPIEDAD_clsJUGADOR_SKILLS:skills=((double)valor);break;
		}

	}

}
