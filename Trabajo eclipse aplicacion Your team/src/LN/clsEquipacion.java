package LN;

import java.time.LocalDate;

public class clsEquipacion extends clsEquipo {
	/**
	 * Ponemos los atributos de la clase clsEquipaci�n
	 * color 1 y color 2 porque cada equipaci�n tendr� dos colores a elegir
	 * publicidad porque cada equipo tendr� derecho a ser patrocinado por algui�n aunque si no quiere no pasar� nada
	 * cada equipaci�n tendr� derecho a poder escribirse frases en las camisetas
	 */
	private String color1;
	private String colo2;
	private String publicidad;
	private String seriagrafiado;
	/**
	 * Primeramente crearemos un constructor vac�o
	 * Despu�s crearemos un constructor con par�metros
	 */
	public clsEquipacion() {
		String color1="";
		String color2="";
		String publicidad="";
		String serigrafiado="";
	}

	public clsEquipacion(String nombreEquipo, LocalDate fundacionEquipo,String color1, String colo2, String publicidad, String seriagrafiado) {
		super(nombreEquipo, fundacionEquipo);
		this.color1 = color1;
		this.colo2 = colo2;
		this.publicidad = publicidad;
		this.seriagrafiado = seriagrafiado;
	}

	/**
	 * Aqu� crearemos los getters and setters de los atributos
	 */
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColo2() {
		return colo2;
	}
	public void setColo2(String colo2) {
		this.colo2 = colo2;
	}
	public String getPublicidad() {
		return publicidad;
	}
	public void setPublicidad(String publicidad) {
		this.publicidad = publicidad;
	}
	public String getSeriagrafiado() {
		return seriagrafiado;
	}
	public void setSeriagrafiado(String seriagrafiado) {
		this.seriagrafiado = seriagrafiado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colo2 == null) ? 0 : colo2.hashCode());
		result = prime * result + ((color1 == null) ? 0 : color1.hashCode());
		return result;
	}
	/**
	 * Generamos el hashcode por si da el caso que queremos buscar, eliminar o a�adir lo haremos a trav�s de sus colores 
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
		if (colo2 == null) {
			if (other.colo2 != null)
				return false;
		} else if (!colo2.equals(other.colo2))
			return false;
		if (color1 == null) {
			if (other.color1 != null)
				return false;
		} else if (!color1.equals(other.color1))
			return false;
		return true;
	}
	
	
	
	

}
