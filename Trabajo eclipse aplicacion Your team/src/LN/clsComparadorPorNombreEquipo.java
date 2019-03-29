package LN;


import static COMUN.Constantes.PROPIEDAD_clsEQUIPO_NOMBREEQUIPO;

import java.util.Comparator;


	public class  clsComparadorPorNombreEquipo implements Comparator<clsEquipo>  {

		@Override
		public int compare(clsEquipo e1, clsEquipo e2) {
			if (((String) e1.getObjectProperty(PROPIEDAD_clsEQUIPO_NOMBREEQUIPO)).compareTo((String) e2.getObjectProperty(PROPIEDAD_clsEQUIPO_NOMBREEQUIPO)) == 0) {
			return 0;
		}else { 
			return (((String) e1.getObjectProperty(PROPIEDAD_clsEQUIPO_NOMBREEQUIPO)).compareTo((String) e2.getObjectProperty(PROPIEDAD_clsEQUIPO_NOMBREEQUIPO)));
		}
		}

}
