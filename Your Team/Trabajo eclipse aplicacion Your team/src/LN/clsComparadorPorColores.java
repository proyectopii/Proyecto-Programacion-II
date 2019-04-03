package LN;

import static COMUN.Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO;

import java.util.Comparator;

public class clsComparadorPorColores implements Comparator<clsEscudo>  {
	
	@Override
	public int compare(clsEscudo c1, clsEscudo c2) {
		if (((String) c1.getObjectProperty(PROPIEDAD_clsESCUDO_COLORESCUDO)).compareTo((String) c2.getObjectProperty(PROPIEDAD_clsESCUDO_COLORESCUDO)) == 0) {
		return 0;
	}else { 
		return (((String) c1.getObjectProperty(PROPIEDAD_clsESCUDO_COLORESCUDO)).compareTo((String) c2.getObjectProperty(PROPIEDAD_clsESCUDO_COLORESCUDO)));
	}
	}

}
