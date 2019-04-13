package LP;

import java.sql.Date;
import java.time.LocalDate;

import COMUN.clsExcepcionEquipacionRepetida;
import COMUN.clsExcepcionEquipoRepetido;
import COMUN.clsExcepcionEscudoRepetido;
import COMUN.clsExcepcionIntercambioRepetido;
import LN.clsGestorLN;

public class clsMenu {

	/**
	 * Crear un Menu para que pueda crearse su equipo, hacer un intercambio, cambiar
	 * cosas del equipo o salir
	 * 
	 * @throws Exception
	 */
	public static void MenuPrincipal() throws Exception {
		int op = 0;
		System.out.println("Bienvenido a nuestra comunidad esperemos que te guste");
		System.out.println();
		System.out.println("A continuacion te mostraremos un men? para apuntarte");
		Ventana v = new Ventana();
		v.setVisible(true);
		do {
			System.out.println("1-Empezar creando tu equipo ");
			System.out.println("2-Hacer un intercambio");
			System.out.println("3-Cambiar atributos del equipo");
			System.out.println("4-Salir");
			op = UtilidadesLP.leerEntero();
			switch (op) {
			case 1:
				Crearequipo();
				Crearequipacion();
				CrearEscudo();

				break;
			case 2:
				CrearIntercambio();
				break;
			case 3:
				/**
				 * Lo dejamos en blanco porque aun no hemos creado eliminar o buscar
				 */
				break;
			case 4:
				System.out.println("Ha sido un placer adios y que tengas un buen d?a");
				break;

			}

		} while (op != 4);
	}

	/**
	 * Crear un gln para acceder al gestor y guardar la correspondiente iformaci?n
	 */
	public static clsGestorLN gln = new clsGestorLN();

	/**
	 * Crear los m?todos para la creaci?n del equipo con sus atributos y finalmente
	 * lo guardaremos en el gestor
	 */

	public static void Crearequipo() {
		String nombreEquipo;
		Date fundacionEquipo;

		System.out.println("Escribe un nombre para tu equipo");
		nombreEquipo = UtilidadesLP.leerCadena();
		String date = null;
		fundacionEquipo = Date.valueOf(date);
		/**
		 * Aqui es donde lanzamos la excepcion que hemos propagado
		 */
		try {
			gln.añadirEquipo(nombreEquipo, fundacionEquipo);
		} catch (clsExcepcionEquipoRepetido e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Crear los m?todos para la creaci?n del equipacion con sus atributos y
	 * finalmente lo guardaremos en el gestor
	 */

	public static void Crearequipacion() {
		String color1;
		String color2;
		String publicidad;
		String serigrafiado = "";
		String oppublicidad;
		String opserigrafiado;

		System.out.println("Elige el color primario para tu equipacion");
		color1 = UtilidadesLP.leerCadena();

		System.out.println("Elige el color secundario para tu equipacion");
		color2 = UtilidadesLP.leerCadena();

		System.out.println("?Quieres poner publicidad?");
		oppublicidad = UtilidadesLP.leerCadena();

		if (oppublicidad.equalsIgnoreCase("si")) {
			System.out.println("?Qu? publicidad quieres poner?");
			publicidad = UtilidadesLP.leerCadena();

		}

		System.out.println("?Quieres poner serigrafiado?");
		opserigrafiado = UtilidadesLP.leerCadena();

		if (opserigrafiado.equalsIgnoreCase("si")) {
			System.out.println("?Que publicidad quieres poner?");
			serigrafiado = UtilidadesLP.leerCadena();

		}
		/**
		 * Aqui es donde lanzamos la excepcion que hemos propagado
		 */
		try {

			gln.anadirclsEquipacion(color1, color2, oppublicidad, opserigrafiado, 0);
		} catch (clsExcepcionEquipacionRepetida e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * Crear los m?todos para la creaci?n del escudo con sus atributos y finalmente
	 * lo guardaremos en el gestor
	 * 
	 * @throws Exception
	 */

	public static void CrearEscudo() throws Exception {
		String formaEscudo;
		String colorEscudo;

		System.out.println("Define de tu escudo");
		formaEscudo = UtilidadesLP.leerCadena();

		System.out.println("Di un color para tu escudo");
		colorEscudo = UtilidadesLP.leerCadena();
		/**
		 * Aqui es donde lanzamos la excepcion que hemos propagado
		 */

		try {
			gln.añadirEscudo(formaEscudo, colorEscudo);

		} catch (clsExcepcionEscudoRepetido e) {
			e.getMessage();
		}

	}

	/**
	 * Crear los m?todos para el intercambio del equipo con sus atributos y
	 * finalmente lo guardaremos en el gestor
	 */

	public static void CrearIntercambio() {
		String equipoOrigen;
		String equipoDestino;

		System.out.println("Escribe el nombre de tu equipo para poder intercambiar un jugador");
		equipoOrigen = UtilidadesLP.leerCadena();
		System.out.println("Escribe el equipo con el que quieres intercambiar");
		equipoDestino = UtilidadesLP.leerCadena();
		/**
		 * Aqui es donde lanzamos la excepcion que hemos propagado
		 */
		try {
			gln.addIntercambio(equipoOrigen, equipoDestino);
		} catch (clsExcepcionIntercambioRepetido e) {
			e.getMessage();
		}

	}

}


