package LN;

import static COMUN.Constantes.PROPIEDAD_clsPERSONA_NOMBRE;

import java.util.Comparator;

public class clsComparadorPorNombreManagers  implements Comparator<clsManager>  {
	
	@Override
	public int compare(clsManager m1, clsManager m2) {
		if (((String) m1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)).compareTo((String) m2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)) == 0) {
		return 0;
	}else { 
		return (((String) m1.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)).compareTo((String) m2.getObjectProperty(PROPIEDAD_clsPERSONA_NOMBRE)));
	}
	}


}
