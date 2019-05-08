package COMUN;

import java.sql.Date;
import java.time.LocalDate;

public class Constantes {
	/**
	 * Aqu? definiremos cada una de las constantes de todos los atributos de las
	 * clases para luego ponerlas en los m?todos set y get
	 */
	/**
	 * Aqui ponemos todas las constantes finales de equipacion como color1, color2,
	 * dorsal, publicidad y serigrafiado
	 */
	public static final String PROPIEDAD_clsEQUIPACION_COLOR1P = "color1P";
	public static final String PROPIEDAD_clsEQUIPACION_COLOR2P = "color2P";
	public static final String PROPIEDAD_clsEQUIPACION_COLOR1S = "color1S";
	public static final String PROPIEDAD_clsEQUIPACION_COLOR2S = "color2S";
	public static final String PROPIEDAD_clsEQUIPACION_DORSAL = "dorsal";
	public static final String PROPIEDAD_clsEQUIPACION_PUBLICIDADP = "publicidadP";
	public static final String PROPIEDAD_clsEQUIPACION_PUBLICIDADS = "publicidadS";
	public static final String PROPIEDAD_clsEQUIPACION_SERIGRAFIADOP = "serigrafiadoP";
	public static final String PROPIEDAD_clsEQUIPACION_SERIGRAFIADOS = "serigrafiadoS";

	/**
	 * Aqui ponemos todas las constantes finales de equipo como fundacionEquipo y
	 * nombreEquipo
	 */

	public static final String PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO = "fundacionEquipo";
	public static final String PROPIEDAD_clsEQUIPO_NOMBREEQUIPO = "nombreEquipo";

	/**
	 * Aqui ponemos todas las constantes finales de escudo como colorEscudo y
	 * formaEscudo
	 */

	public static final String PROPIEDAD_clsESCUDO_COLORESCUDO = "colorEscudo";
	public static final String PROPIEDAD_clsESCUDO_FORMAESCUDO = "formaEscudo";

	/**
	 * Aqui ponemos todas las constantes finales de intercambio como equipoOrigen y
	 * equipoDestino
	 */

	public static final String PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN = "equipoOrigen";
	public static final String PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO = "equipoDestino";

	/**
	 * Aqui ponemos todas las constantes finales de jugador como formaFisica y
	 * skills
	 */

	public static final String PROPIEDAD_clsJUGADOR_FORMAFISICA = "formaFisica";
	public static final String PROPIEDAD_clsJUGADOR_SKILLS = "skills";

	/**
	 * Aqui ponemos todas las constantes finales de partidos como equipoLocal,
	 * equipoVisitante y fechaInicioPartido
	 */

	public static final String PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL = "equipoLocal";
	public static final String PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE = "equipoVisitante";
	public static final String PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO = "fechaInicioPartido";

	/**
	 * Aqui ponemos todas las constantes finales de temporada como puestos, trofeos
	 * y anioTemporada
	 */

	public static final String PROPIEDAD_clsTEMPORADA_PUESTOS = "puestos";
	public static final String PROPIEDAD_clsTEMPORADA_TROFEOS = "trofeos";
	public static final String PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA = "anioTemporada";

	/**
	 * Aqui ponemos todas las constantes finales de persona como nombre, apellido1,
	 * apellido2, dni y sexo
	 */

	public static final String PROPIEDAD_clsPERSONA_NOMBRE = "nombre";
	public static final String PROPIEDAD_clsPERSONA_APELLIDO1 = "apellido1";
	public static final String PROPIEDAD_clsPERSONA_APELLIDO2 = "apellido2";
	public static final String PROPIEDAD_clsPERSONA_DNI = "dni";
	public static final String PROPIEDAD_clsPERSONA_SEXO = "sexo";

	/**
	 * Aqui ponemos todas las constantes finales de manager como calidad y
	 * valoracion
	 */

	public static final String PROPIEDAD_clsMANAGER_CALIDAD = "calidad";
	public static final String PROPIEDAD_clsMANAGER_VALORACION = "valoracion";
	
	/**
	 * Aqui ponemos todas las constantes finales para enumerar
	 */
	
	public static enum colorprimario{
		Amarillo,
		Naranja,
		Rojo,
		Morado,
		Azul,
		Rosa,
		Negro,
		Blanco,
		Verde,
		Marron;
	}

	public static enum encolorsecundario{
		Amarillo,
		Naranja,
		Rojo,
		Morado,
		Azul,
		Rosa,
		Negro,
		Blanco,
		Verde,
		Marron;
	}
	
	public static enum ensexo{
		Masculino,
		Femenino,
		Otro;
	}
}
