package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls equipo y es con eso con los que ordenaremos
 */

import java.util.Comparator;

/**
 * Creamos el comparador
 * 
 * @author Industria 4.0
 *
 */
public class clsComparadorPorNombreEquipo implements Comparator<clsEquipo> {
	/**
	 * Aqui comparamos nombres equipo de equipo de un sitio y de otro y lo
	 * ordenaremos alfabeticamente como vemos utilizando el String
	 */

	@Override
	public int compare(clsEquipo e1, clsEquipo e2) {
		return (e1.getNombreEquipo().compareTo(e2.getNombreEquipo()) );
	}

}