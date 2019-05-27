package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls escudo y es con eso con los que ordenaremos
 */

import java.util.Comparator;

/**
 * Creamos el comparador
 * 
 * @author Industria 4.0
 *
 */

public class clsComparadorPorColores implements Comparator<clsEscudo> {
	/**
	 * Aqui comparamos dos colores de escudos de un sitio y de otro y lo ordenaremos
	 * alfabeticamente como vemos utilizando el String
	 */

	@Override
	public int compare(clsEscudo c1, clsEscudo c2) {
		return (c1.getColorEscudo().compareTo(c2.getColorEscudo() ));
	}

}
