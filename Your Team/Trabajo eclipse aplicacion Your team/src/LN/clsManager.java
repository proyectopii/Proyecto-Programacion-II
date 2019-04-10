package LN;

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
	

}
