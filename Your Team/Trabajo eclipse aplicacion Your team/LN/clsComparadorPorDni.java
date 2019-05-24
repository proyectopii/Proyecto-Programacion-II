package LN;

import static COMUN.Constantes.PROPIEDAD_clsPERSONA_DNI;

import java.util.Comparator;

public class clsComparadorPorDni implements Comparator<clsManager> {
	/**
	 * Creamos el comparador
	 * 
	 * @author Industria 4.0
	 *
	 */

	public int compare(clsManager m1, clsManager m2) {
		/**
		 * Aqui comparamos DNI del manager de un sitio y de otro y lo ordenaremos
		 * alfabeticamente como vemos utilizando el String
		 */
		return ((String) m1.getObjectProperty(PROPIEDAD_clsPERSONA_DNI)).compareTo( (String) m2.getObjectProperty(PROPIEDAD_clsPERSONA_DNI) );

}
}
