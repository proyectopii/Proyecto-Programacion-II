package LN;

import java.time.LocalDate;

public class clsIntercambio extends clsEquipo{
	/**
	 * Crearemos los atributos de clsIntercambio 
	 * Para hacer un intercambio tendrá que haber un equipo origen y equipo destino
	 */
	private String equipoOrigen;
	private String equipoDestino;
	/**
	 * Ahora crearemos un constructor vacío y otro con parámetros
	 */
	public clsIntercambio() {
		String equipoOrigen="";
		String equipoDestino="";
	}
	public clsIntercambio(String nombreEquipo, LocalDate fundacionEquipo,String equipoOrigen, String equipoDestino) {
		super(nombreEquipo, fundacionEquipo);
		this.equipoOrigen = equipoOrigen;
		this.equipoDestino = equipoDestino;
	}
	/**
	 * Ahora crearemos los getters y setters de los atributos
	 */
	public String getEquipoOrigen() {
		return equipoOrigen;
	}
	public void setEquipoOrigen(String equipoOrigen) {
		this.equipoOrigen = equipoOrigen;
	}
	public String getEquipoDestino() {
		return equipoDestino;
	}
	public void setEquipoDestino(String equipoDestino) {
		this.equipoDestino = equipoDestino;
	}
	/**
	 * Generaremos el hashcode con equipo origen y equipo destino por si queremos buscar añadir o eliminar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoDestino == null) ? 0 : equipoDestino.hashCode());
		result = prime * result + ((equipoOrigen == null) ? 0 : equipoOrigen.hashCode());
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
		clsIntercambio other = (clsIntercambio) obj;
		if (equipoDestino == null) {
			if (other.equipoDestino != null)
				return false;
		} else if (!equipoDestino.equals(other.equipoDestino))
			return false;
		if (equipoOrigen == null) {
			if (other.equipoOrigen != null)
				return false;
		} else if (!equipoOrigen.equals(other.equipoOrigen))
			return false;
		return true;
	}
	
	
	
	

}
