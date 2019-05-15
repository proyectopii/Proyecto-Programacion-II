package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls persona y es con eso con los que ordenaremos
 */

import static COMUN.Constantes.PROPIEDAD_clsPERSONA_NOMBRE;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_DNI;

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
		if (((String) m1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE))
				.compareTo((String) m2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)) == 0) {
			return 0;
		} else {
			return (((String) m1.getObjectProperty(PROPIEDAD_clsPERSONA_DNI))
					.compareTo((String) m2.getObjectProperty(PROPIEDAD_clsPERSONA_DNI)));
		}
	}

}
