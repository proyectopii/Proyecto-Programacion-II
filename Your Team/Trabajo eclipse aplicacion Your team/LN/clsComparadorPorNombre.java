package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls persona y es con eso con los que ordenaremos
 */

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
		return (p1.getNombre().compareTo(p2.getNombre()));
	}
}