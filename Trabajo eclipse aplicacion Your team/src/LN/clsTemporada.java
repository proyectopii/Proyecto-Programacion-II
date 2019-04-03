package LN;

import java.time.LocalDate;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_PUESTOS;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_TROFEOS;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA;


import COMUN.itfProperty;

public class clsTemporada  implements itfProperty {
	/**
	 * Crearemos los atributos siguientes: puestos por el tema del n?mero que pueda
	 * quedar un equipo y tiene que ser entero trofeos porque al final de la
	 * temporada los tres primeros recibir?n un trofeo y cada trofeo tendr? un
	 * nombre un a?o de temporada para saber en que a?o estamos en dicha temporada
	 * un ganador que ser? el que quede primero y se coger? el nombre de ciho equipo
	 */
	private int puestos;
	private String trofeos;
	private LocalDate anioTemporada;
	

	/**
	 * Crearemos un contructor vac?o y un contructor con par?metros
	 */

	public clsTemporada() {
		int puestos = 0;
		String trofeos = "";
		LocalDate anioTemporada = LocalDate.now();
		String ganador = "";
	}

	public clsTemporada(int puestos, String trofeos, LocalDate anioTemporada) {
		super();
		this.puestos = puestos;
		this.trofeos = trofeos;
		this.anioTemporada = anioTemporada;
		
	}


	

	/**
	 * Generaremos el hashcode con el a?otemporada y los puestos para buscar a?adir
	 * o eliminar
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anioTemporada == null) ? 0 : anioTemporada.hashCode());
		result = prime * result + puestos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsTemporada other = (clsTemporada) obj;
		if (anioTemporada == null) {
			if (other.anioTemporada != null)
				return false;
		} else if (!anioTemporada.equals(other.anioTemporada))
			return false;
		if (puestos != other.puestos)
			return false;
		return true;
	}
	/**
	 * Crearemos los getter y setters de los atributos que hemos puesto
	 */
	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsTEMPORADA_PUESTOS:
			return this.puestos;
		case PROPIEDAD_clsTEMPORADA_TROFEOS:
			return this.trofeos;
		case PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA:
			return this.anioTemporada;
		default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch(propiedad) {
		case PROPIEDAD_clsTEMPORADA_PUESTOS:puestos=((int)valor);break;
		case PROPIEDAD_clsTEMPORADA_TROFEOS:trofeos=((String)valor);break;
		case PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA:anioTemporada=((LocalDate)valor);break;
		}
	}

}
