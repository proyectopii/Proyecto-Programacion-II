package LN;
/**
 * Importamos las constantes finales que necesitaremos de la clase cls escudo y es con eso con los que ordenaremos
 */

import static COMUN.Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO;
import static COMUN.Constantes.PROPIEDAD_clsESCUDO_FORMAESCUDO;

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
		return ((String) c1.getObjectProperty(PROPIEDAD_clsESCUDO_COLORESCUDO)).compareTo( (String) c2.getObjectProperty(PROPIEDAD_clsESCUDO_COLORESCUDO) );
	}

}
