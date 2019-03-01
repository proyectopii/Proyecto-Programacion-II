package LN;

import java.time.LocalDate;

public class clsPartidos {
	/**
	 * Pondremos los atributos de clsPartidos
	 * Tendremos un equipo local y un equipo visitante que son los que compiten en un partido
	 * Podnremos también una fecha para saber en que hora ha empezado
	 */
	private String equipoLocal;
	private String equipoVisitante;
	private LocalDate fechaInicioPartido;
	/**
	 * A continuación pondremos un constructor con parámetros y sin parámetros
	 */
	public clsPartidos() {
		String equipoLocal="";
		String equipoVisitante="";
		LocalDate fechaInicioPartido=LocalDate.now();
	}
	public clsPartidos(String equipoLocal, String equipoVisitante, LocalDate fechaInicioPartido) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fechaInicioPartido = fechaInicioPartido;
	}
	/**
	 * También pondremos los getters y setters de los atributos
	 */
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public LocalDate getFechaInicioPartido() {
		return fechaInicioPartido;
	}
	public void setFechaInicioPartido(LocalDate fechaInicioPartido) {
		this.fechaInicioPartido = fechaInicioPartido;
	}
	/**
	 * Generaremos el hashcode con equipo local y equipo visitante para añadir eliminar o buscar
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipoLocal == null) ? 0 : equipoLocal.hashCode());
		result = prime * result + ((equipoVisitante == null) ? 0 : equipoVisitante.hashCode());
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
		clsPartidos other = (clsPartidos) obj;
		if (equipoLocal == null) {
			if (other.equipoLocal != null)
				return false;
		} else if (!equipoLocal.equals(other.equipoLocal))
			return false;
		if (equipoVisitante == null) {
			if (other.equipoVisitante != null)
				return false;
		} else if (!equipoVisitante.equals(other.equipoVisitante))
			return false;
		return true;
	}
	
	

}
