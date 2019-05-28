package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls persona y es con eso con los que ordenaremos
 */

import java.util.Comparator;

public class clsComparadorPorNombreManagers implements Comparator<clsManager> {

	/**
	 * Creamos el comparador
	 * 
	 * @author Industria 4.0
	 *
	 */
	@Override
	public int compare(clsManager m1, clsManager m2) {
		/**
		 * Aqui comparamos nombre de persona de un sitio y de otro y lo ordenaremos
		 * alfabeticamente como vemos utilizando el String
		 */
		return ( m1.getNombre()).compareTo( m2.getNombre());
	}

}