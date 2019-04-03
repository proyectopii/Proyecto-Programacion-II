package LN;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_NOMBRE;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_APELLIDO1;
import static COMUN.Constantes.PROPIEDAD_clsPERSONA_DNI;



import java.util.Comparator;

public class clsComparadorPorNombre implements Comparator<clsJugador>  {
	@Override
	public int compare(clsJugador p1, clsJugador p2) {
		if (((String) p1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)).compareTo((String) p2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)) == 0) {
			return ((String) p1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)).compareTo((String) p2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE));
		} else{ 
			return (((String) p1.getObjectProperty(PROPIEDAD_clsPERSONA_APELLIDO1)).compareTo((String) p2.getObjectProperty(PROPIEDAD_clsPERSONA_APELLIDO1)));
		
		
		}
	}
	}
	


