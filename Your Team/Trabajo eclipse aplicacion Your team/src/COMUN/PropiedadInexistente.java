package COMUN;

public class PropiedadInexistente extends RuntimeException {
	public PropiedadInexistente()
	{
		super();
	}
	
	public PropiedadInexistente( String texto )
	{
		super( texto);
	}

}
