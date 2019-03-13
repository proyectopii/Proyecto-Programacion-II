package LN;

import java.time.LocalDate;

public class clsEscudo extends clsEquipo {
	/**
	 * Crearemos los atributos de clsEscudo
	 * Un formaEscudo porque cada escudo tendrá una forma
	 * Un colorescudo porque cada escudo de cada equipo tendrá un color
	 */
	private String formaEscudo;
	private String colorEscudo;
	/**
	 * Crearemos un constructo vacío y otro con parámetros
	 */
	
	public clsEscudo() {
		String formaEscudo="";
		String colorEscudo="";
	}
	public clsEscudo(String nombreEquipo, LocalDate fundacionEquipo, String formaEscudo, String colorEscudo) {
		super(nombreEquipo, fundacionEquipo);
		this.formaEscudo = formaEscudo;
		this.colorEscudo = colorEscudo;
	}
	/**
	 * Crearemos los getters and setter de cada atributo
	 */
	public String getFormaEscudo() {
		return formaEscudo;
	}
	public void setFormaEscudo(String formaEscudo) {
		this.formaEscudo = formaEscudo;
	}
	public String getColorEscudo() {
		return colorEscudo;
	}
	public void setColorEscudo(String colorEscudo) {
		this.colorEscudo = colorEscudo;
	}
	/**
	 * Ahora generaremos el hashcode con los atributos formaescudo y colorescudo por si se querría eliminar buscar o añadir
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorEscudo == null) ? 0 : colorEscudo.hashCode());
		result = prime * result + ((formaEscudo == null) ? 0 : formaEscudo.hashCode());
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
		clsEscudo other = (clsEscudo) obj;
		if (colorEscudo == null) {
			if (other.colorEscudo != null)
				return false;
		} else if (!colorEscudo.equals(other.colorEscudo))
			return false;
		if (formaEscudo == null) {
			if (other.formaEscudo != null)
				return false;
		} else if (!formaEscudo.equals(other.formaEscudo))
			return false;
		return true;
	}
	
	

}
