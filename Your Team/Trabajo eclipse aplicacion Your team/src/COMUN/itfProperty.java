package COMUN;

public interface itfProperty {
	/**
	 * Con estos m?todos crearemos los objetos que pueden ser de cualquier tipo para
	 * los get properties y set properties
	 * @param propiedad
	 * @return
	 */
	Object getObjectProperty( String propiedad );
	void setObjectProperty( String propiedad , Object valor );

}
