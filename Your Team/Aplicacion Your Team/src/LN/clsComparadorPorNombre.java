package LN;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_NOMBREJUGADOR;
import static COMUN.Constantes.PROPIEDAD_clsJUGADOR_EDAD;


import java.util.Comparator;

public class clsComparadorPorNombre implements Comparator<clsJugador>  {
	@Override
	public int compare(clsJugador p1, clsJugador p2) {
		if (((String) p1.getObjectProperty(PROPIEDAD_clsJUGADOR_NOMBREJUGADOR)).compareTo((String) p2.getObjectProperty(PROPIEDAD_clsJUGADOR_NOMBREJUGADOR)) == 0) {
			return ((String) p1.getObjectProperty(PROPIEDAD_clsJUGADOR_EDAD)).compareTo((String) p2.getObjectProperty(PROPIEDAD_clsJUGADOR_EDAD));
		} else { 
			return (((String) p1.getObjectProperty(PROPIEDAD_clsJUGADOR_NOMBREJUGADOR)).compareTo((String) p2.getObjectProperty(PROPIEDAD_clsJUGADOR_NOMBREJUGADOR)));
		}
	}
	

}
