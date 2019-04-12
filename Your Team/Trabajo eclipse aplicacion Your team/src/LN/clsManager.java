package LN;

import static COMUN.Constantes.PROPIEDAD_clsMANAGER_VALORACION;
import static COMUN.Constantes.PROPIEDAD_clsMANAGER_CALIDAD;

import java.sql.Date;

import COMUN.PropiedadInexistente;
import COMUN.itfProperty;

public class clsManager extends clsPersona implements itfProperty {
	private String calidad;
	private int valoracion;
	
	public clsManager() {
		
	}
	
	public clsManager(String nombre, String apellido1, String apellido2, String dni, String sexo,String calidad, int valoracion) {
		super(nombre,apellido1,apellido2,dni,sexo);
		this.calidad = calidad;
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "clsManager [calidad=" + calidad + ", valoracion=" + valoracion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calidad == null) ? 0 : calidad.hashCode());
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
		clsManager other = (clsManager) obj;
		if (calidad == null) {
			if (other.calidad != null)
				return false;
		} else if (!calidad.equals(other.calidad))
			return false;
		return true;
	}
	@Override
	public Object getObjectProperty(String propiedad) {
		switch (propiedad) {
		case PROPIEDAD_clsMANAGER_VALORACION:
			return this.valoracion;
		case PROPIEDAD_clsMANAGER_CALIDAD:
			return this.calidad;

		default:throw new PropiedadInexistente("No existe esa propiedad!");
			
		}

	}

	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		switch(propiedad) {
		case PROPIEDAD_clsMANAGER_VALORACION:valoracion=((int) valor); break;
		case PROPIEDAD_clsMANAGER_CALIDAD:calidad=((String)valor);break;
		
		}
		
	}
	
	

}
