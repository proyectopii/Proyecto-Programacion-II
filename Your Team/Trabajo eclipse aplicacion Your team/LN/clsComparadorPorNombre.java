package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls persona y es con eso con los que ordenaremos
 */

import static COMUN.Constantes.PROPIEDAD_clsPERSONA_NOMBRE;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_APELLIDO1;


/**
 * Creamos el comparador
 * 
 * @author Industria 4.0
 *
 */

import java.util.Comparator;

public class clsComparadorPorNombre implements Comparator<clsJugador> {
	/**
	 * Aqui comparamos nombre de persona de un sitio y de otro y lo ordenaremos
	 * alfabeticamente como vemos utilizando el String
	 */
	@Override
	public int compare(clsJugador p1, clsJugador p2) {
		if (((String) p1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE))
				.compareTo((String) p2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)) == 0) {
			return ((String) p1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE))
					.compareTo((String) p2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE));
		} else {
			return (((String) p1.getObjectProperty(PROPIEDAD_clsPERSONA_APELLIDO1))
					.compareTo((String) p2.getObjectProperty(PROPIEDAD_clsPERSONA_APELLIDO1)));

		}
	}
}
	


