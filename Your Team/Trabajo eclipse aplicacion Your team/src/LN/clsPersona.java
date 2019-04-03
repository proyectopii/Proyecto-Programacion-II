package LN;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_NOMBRE;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_APELLIDO1;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_APELLIDO2;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_DNI;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_SEXO;

import COMUN.itfProperty;

public class clsPersona implements itfProperty{
	private String nombre;// Un nombre para cada persona
	private String apellido1; //Un primer apellido para cada persona
	private String apellido2;//Un segundo apellido para cada persona
	private String dni;//Un dni para tener 
	private String sexo;//Un sexo para saber si es masculino o femenino
	
	/**
	 * Crearemos un constructor vacio
	 */
	
	public clsPersona() {
		
	}
	
	/**
	 * Crearemos un constructor donde tendremos todos los par?metros
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 */
	public clsPersona(String nombre, String apellido1, String apellido2, String dni, String sexo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.sexo = sexo;
	}


	@Override
	public Object getObjectProperty(String propiedad) {
		
		return null;
	}
	@Override
	public void setObjectProperty(String propiedad, Object valor) {
		// TODO Auto-generated method stub
		
	}

}
