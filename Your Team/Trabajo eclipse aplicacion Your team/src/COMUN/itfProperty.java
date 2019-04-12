package COMUN;

public interface itfProperty {
	/**
	 * Con estos metodos crearemos los objetos que pueden ser de cualquier tipo para
	 * los get properties y set properties
	 * 
	 * @param propiedad
	 * @return
	 */
	Object getObjectProperty(String propiedad);

	void setObjectProperty(String propiedad, Object valor);
	/**
	 * Al crear esto ya no utilizaremos getters y setters y los sustituimos por el
	 * getobject y setobject
	 */

}
