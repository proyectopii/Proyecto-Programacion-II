package LN;

import java.time.LocalDate;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_PUESTOS;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_TROFEOS;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_A�OTEMPORADA;
import static COMUN.Constantes.PROPIEDAD_clsTEMPORADA_GANADOR;

import COMUN.itfProperty;

public class clsTemporada extends clsPartidos implements itfProperty {
	/**
	 * Crearemos los atributos siguientes: puestos por el tema del n�mero que pueda
	 * quedar un equipo y tiene que ser entero trofeos porque al final de la
	 * temporada los tres primeros recibir�n un trofeo y cada trofeo tendr� un
	 * nombre un a�o de temporada para saber en que a�o estamos en dicha temporada
	 * un ganador que ser� el que quede primero y se coger� el nombre de ciho equipo
	 */
	private int puestos;
	private String trofeos;
	private LocalDate a�oTemporada;
	private String ganador;

	/**
	 * Crearemos un contructor vac�o y un contructor con par�metros
	 */

	public clsTemporada() {
		int puestos = 0;
		String trofeos = "";
		LocalDate a�oTemporada = LocalDate.now();
		String ganador = "";
	}

	public clsTemporada(int puestos, String trofeos, LocalDate a�oTemporada, String ganador) {
		super();
		this.puestos = puestos;
		this.trofeos = trofeos;
		this.a�oTemporada = a�oTemporada;
		this.ganador = ganador;
	}

	/**
	 * Crearemos los getter y setters de los atributos que hemos puesto
	 */
	

	/**
	 * Generaremos el hashcode con el a�otemporada y los puestos para buscar a�adir
	 * o eliminar
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a�oTemporada == null) ? 0 : a�oTemporada.hashCode());
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
		if (a�oTemporada == null) {
			if (other.a�oTemporada != null)
				return false;
		} else if (!a�oTemporada.equals(other.a�oTemporada))
			return false;
		if (puestos != other.puestos)
			return false;
		return true;
	}

	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsTEMPORADA_PUESTOS:
			return this.puestos;
		case PROPIEDAD_clsTEMPORADA_TROFEOS:
			return this.trofeos;
		case PROPIEDAD_clsTEMPORADA_A�OTEMPORADA:
			return this.a�oTemporada;
		case PROPIEDAD_clsTEMPORADA_GANADOR:
			return this.ganador;
		default:
			return null;
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch(propiedad) {
		case PROPIEDAD_clsTEMPORADA_PUESTOS:puestos=((int)valor);break;
		case PROPIEDAD_clsTEMPORADA_TROFEOS:trofeos=((String)valor);break;
		case PROPIEDAD_clsTEMPORADA_A�OTEMPORADA:a�oTemporada=((LocalDate)valor);break;
		case PROPIEDAD_clsTEMPORADA_GANADOR:ganador=((String)valor);break;
		}
	}

}
