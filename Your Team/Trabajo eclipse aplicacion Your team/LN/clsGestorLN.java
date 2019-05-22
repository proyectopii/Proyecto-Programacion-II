package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import LD.clsDatos;
import LD.clsDatosBD;
import COMUN.Constantes;
import COMUN.clsExcepcionEquipacionRepetida;
import COMUN.clsExcepcionEquipoRepetido;
import COMUN.clsExcepcionEscudoRepetido;
import COMUN.clsExcepcionIntercambioRepetido;
import COMUN.clsExcepcionManagerRepetido;
import COMUN.itfProperty;

public class clsGestorLN {
	private clsDatos clsDatos = new clsDatos();
	private clsDatosBD clsDatosBD = new clsDatosBD();

	/**
	 * Aqu? creamos el Arraylist privado donde guardaremos los equipos
	 */
	private ArrayList<clsEquipo> tuequipo;
	private ArrayList<clsEquipacion> tuequipacion;
	private ArrayList<clsEscudo> tuescudo;
	private ArrayList<clsJugador> tujugador;
	private ArrayList<clsPartidos> tupartido;
	private ArrayList<clsTemporada> tutemporada;
	private ArrayList<clsIntercambio> tuintercambio;
	private ArrayList<clsJugador> listadoJugadores;
	private ArrayList<clsEquipo> listadoEquipos;
	private ArrayList<clsEscudo> listadoEscudos;
	private ArrayList<clsManager> listadoManagers;
	private ArrayList<clsManager> tumanager;

	/**
	 * Crearemos el constructor del arraylist
	 */
	public clsGestorLN() {
		tuequipo = new ArrayList<clsEquipo>();
		tuequipacion = new ArrayList<clsEquipacion>();
		tuescudo = new ArrayList<clsEscudo>();
		tujugador = new ArrayList<clsJugador>();
		tupartido = new ArrayList<clsPartidos>();
		tutemporada = new ArrayList<clsTemporada>();
		tuintercambio = new ArrayList<clsIntercambio>();
		listadoJugadores = new ArrayList<clsJugador>();
		listadoEquipos = new ArrayList<clsEquipo>();
		listadoEscudos = new ArrayList<clsEscudo>();
		listadoManagers = new ArrayList<clsManager>();
		tumanager = new ArrayList<clsManager>();
	}

	/**
	 * Con este metodo añadiremos equipaciones
	 * 
	 * @param color1
	 * @param color2
	 * @param publicidadP
	 * @param publicidadS
	 * @param serigrafiadoP
	 * @param serigrafiadoS
	 * @param dorsal
	 * @return
	 */
	public boolean anadirclsEquipacion(String color1P, String color2P, String color1S, String color2S, String publicidadP,
			String publicidadS, String serigrafiadoP, String serigrafiadoS, int dorsal)
			throws clsExcepcionEquipacionRepetida { // Aquí estoy propagando la excepcion

		clsEquipacion eq = new clsEquipacion(color1P, color2P, color1S, color2S, publicidadP, publicidadS,
				serigrafiadoP, serigrafiadoS, dorsal);// Aqui creamos una nueva equipacion
			clsDatosBD.Connect();																					 
		clsComparadorPorNombreEquipo comp = new clsComparadorPorNombreEquipo();
		/**
		 * Aquí ya tenemos los jugadores ordenados
		 */

		Collections.sort(listadoEquipos, comp); // diferentes atributos
		/**
		 * Este metodo nos sirve para saber si hay repetidos para que no lo añada
		 */
		if ((tuequipacion.contains(eq) == true)) {
			throw new clsExcepcionEquipacionRepetida("Equipación Repetida");

			/**
			 * Si no es repetido lo añadimos a la base de datos con sus atributos y nos lo
			 * retorna
			 */
		} else {
			tuequipacion.add(eq);

			clsDatosBD.InsertarEquipaciones(color1P, color2P, color1S, color2S, publicidadP, publicidadS,
					serigrafiadoP, serigrafiadoS, dorsal);
           clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Este metodo lo utilizaremos si queremos cambiar una equipacion
	 * 
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param serigrafiado
	 * @return
	 */

	public boolean cambioclsEquipacion(String color1P, String color2P, String color1S, String color2S, String publicidadP, 
			String publicidadS, String serigrafiadoP, String serigrafiadoS, int dorsal)
	/**
	 * Con la propiedad itfproperty sacamos la equipacion que tenemos con sus
	 * atributos
	 */
	{
		itfProperty datoABuscar = new clsEquipacion(color1P, color2P, color1S, color2S, publicidadP, publicidadS, serigrafiadoP,
				serigrafiadoS, 0);

		int p = tuequipo.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuequipo.get(p); // Aqui cambiamos la equipacion
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1P,
					Constantes.PROPIEDAD_clsEQUIPACION_COLOR2P);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Con este metodo buscamos equipaciones
	 * 
	 * @param color1
	 * @return
	 */

	public String buscarclsequipacion(String color1P, String color2P, String color1S, String color2S, String publicidadP,
			String publicidadS,	String serigrafiadoP, String serigrafiadoS, int dorsal) {
		/**
		 * Utilizaremos itfproperty para buscar y utilizaremos como clave el color 1
		 */

		itfProperty datoABuscar = new clsEquipacion(color1P, color2P, color1S, color2S, publicidadP, publicidadS, serigrafiadoP,
				serigrafiadoS, 0);

		int p = tuequipacion.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuequipacion.get(p); // Aqui obtenemos el dato

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1P);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Este metodo lo utilizaremos si queremos borrar alguna equipacion
	 * 
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param serigrafiado
	 * @return
	 */
	public boolean borrarclsEquipacion(String color1P, String color2P, String color1S, String color2S, String publicidadP,
			String publicidadS, String serigrafiadoP, String serigrafiadoS, int dorsal) {
		clsEquipacion equipacion = new clsEquipacion(color1P, color2P, color1S, color2S, publicidadP, publicidadS, serigrafiadoP,
				serigrafiadoS, 0);

		return tuequipacion.remove(equipacion);// aqui es cuando borramos la equipacion creada
	}

	/**
	 * Con este metodo recuperaremos la equipacion perdida
	 * 
	 * @return
	 */

	public ArrayList<clsEquipacion> recuperarEquipaciones() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsEquipacion> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarEquipacion();// Nos ayudaremos de la base de datos para poder para poder
															// recuperarlo

			while (rs.next()) {
				/**
				 * Con el getString recuperamos todos sus atributos
				 */

				clsEquipacion nuevoCoche = new clsEquipacion(rs.getString("color1P"), rs.getString("color2P"),
						rs.getString("color1S"), rs.getString("color2S"),rs.getString("serigrafiadoP"), 
						rs.getString("serigrafiadoS"), rs.getString("publicidadP"),
						rs.getString("publicidadS"), rs.getInt(0));

				temp.add(nuevoCoche);
				clsDatosBD.Disconnect();
			}

			return temp;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Con este metodo guardaremos todas las equipaciones
	 */
	public void guardarEquipaciones() {
		/**
		 * Con el getobjectproperty sacamos todos sus atributos y las guardamos en la
		 * base de datos
		 */
               clsDatosBD.Connect();
		for (clsEquipacion c : tuequipacion) {
			String color1P = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1P);
			String color1S = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1S);
			String color2P = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR2P);
			String color2S = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR2S);
			String publicidadP = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDADP);
			String publicidadS = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDADS);
			String serigrafiadoP = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADOP);
			String serigrafiadoS = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADOS);
			int DORSAL = (int) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_DORSAL);

			clsDatosBD.InsertarEquipaciones(color1P, color2P, color1S, color2S, publicidadP, publicidadS, serigrafiadoP,
					serigrafiadoS, DORSAL);// Aqui es cuando lo
			clsDatosBD.Disconnect();																				
		}
	}

	// ----------------------------------------------------------------------------------------
	/**
	 * En este metodo añadiremos equipo junto con la base de datos
	 * 
	 * @param nombreEquipo
	 * @param fundacionEquipo
	 * @return
	 */
	public boolean anadirEquipo(String nombreEquipo, java.util.Date fundacionEquipo) throws clsExcepcionEquipoRepetido {
		
		clsEquipo e = new clsEquipo(nombreEquipo, fundacionEquipo);
		clsDatosBD.Connect();
		clsComparadorPorNombreEquipo comp = new clsComparadorPorNombreEquipo();
		/**
		 * Aquí ya tenemos los jugadores ordenados
		 */

		Collections.sort(listadoEquipos, comp);

		if (tuequipo.contains(e) == true) {
			throw new clsExcepcionEquipoRepetido("Equipo repetido");// Aquí no nos admitira el equipo si esta repetido
		} else {
			tuequipo.add(e);

			clsDatosBD.InsertarEquipo(nombreEquipo, fundacionEquipo);
			clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Con este metodo cambiaremos de equipo
	 * 
	 * @param nombreEquipo
	 * @return
	 */

	public boolean cambioDeEquipo(String nombreEquipo) {
		itfProperty datoABuscar = new clsEquipo(nombreEquipo, null);// utilizaremos la clase itfProperty

		int p = tuequipo.indexOf(datoABuscar);// Aqui lo buscamos

		if (p != -1) {
			datoABuscar = tuequipo.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsEQUIPO_NOMBREEQUIPO,
					Constantes.PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Aqui buscamos el equipo a traves del nombre del equipo
	 * 
	 * @param nombreEquipo
	 * @return
	 */
	public String buscarEquipo(String nombreEquipo) {

		itfProperty datoABuscar = new clsEquipo(nombreEquipo, null);

		int p = tuequipo.indexOf(datoABuscar);// Utilizaremos también el index

		if (p != -1) {
			datoABuscar = tuequipo.get(p);

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPO_NOMBREEQUIPO);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Aqui borraremos el equipo
	 * 
	 * @param nombreEquipo
	 * @return
	 */

	public boolean borrarEquipo(String nombreEquipo) {
		clsEquipo equipo = new clsEquipo(nombreEquipo, null); // despues de crearlo con el remove lo borramos

		return tuequipo.remove(equipo);
	}

	/**
	 * Por si queremos recuperarlo lo hacemos aqui
	 * 
	 * @return
	 */

	public ArrayList<clsEquipo> recuperarequipo() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsEquipo> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarEquipo();

			while (rs.next()) {

				clsEquipo nuevoequipo = new clsEquipo(rs.getString("nombreEquipo"), rs.getDate(0));

				temp.add(nuevoequipo);
			}
             clsDatosBD.Disconnect();
			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Aqui guardaremos los datos
	 */

	public void guardarDatosEquipo() {
     clsDatosBD.Connect();
		for (clsEquipo e : tuequipo) {
			String nombreEquipo = (String) e.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPO_NOMBREEQUIPO); // Con la
																												// clase
																												// constantes
																												// las
																												// utilizamos
																												// todas
																												// las
																												// constantes
																												// de
																												// atributo
			Date fundacionEquipo = (Date) e.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPO_FUNDACIONEQUIPO);

			clsDatosBD.InsertarEquipo(nombreEquipo, fundacionEquipo);
			clsDatosBD.Disconnect();
		}

	}

	// ---------------------------------------------------------------------------------------------------
	/**
	 * Aqui añadiremos los escudos
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 * @return
	 * @throws Exception
	 */
	public boolean anadirEscudo(String formaEscudo, String colorEscudo) throws Exception {
		clsEscudo es = new clsEscudo(formaEscudo, colorEscudo);
		clsDatosBD.Connect();
		clsComparadorPorColores comp = new clsComparadorPorColores();
		/**
		 * Aquí ya tenemos los jugadores ordenados
		 */

		Collections.sort(listadoEscudos, comp);

		if (tuescudo.contains(es) == true)// Nos aseguramos que no hay ninguno repetido
		{
			throw new clsExcepcionEscudoRepetido("Escudo repetido");
		} else {
			tuescudo.add(es);

			clsDatosBD.InsertarEscudo(formaEscudo, colorEscudo);
            clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Con este metodo cambiaremos de escudo
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 * @return
	 */

	public boolean cambioEscudo(String formaEscudo, String colorEscudo) {
		itfProperty datoABuscar = new clsEscudo(formaEscudo, colorEscudo);

		int p = tuescudo.indexOf(datoABuscar);// Nos ayudamos del indexof para buscar

		if (p != -1) {
			datoABuscar = tuescudo.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO,
					Constantes.PROPIEDAD_clsESCUDO_FORMAESCUDO);// Utilizamos el setobject

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Aqui buscaremos los posibles escudos que haya
	 */

	public String buscarEscudo(String formaEscudo, String colorEscudo) {

		itfProperty datoABuscar = new clsEscudo(formaEscudo, colorEscudo);

		int p = tuescudo.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuescudo.get(p);

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Aqui borraremos los escudos que hay
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 * @return
	 */

	public boolean borrarEscudo(String formaEscudo, String colorEscudo) {
		clsEscudo escudo = new clsEscudo(formaEscudo, colorEscudo);

		return tuescudo.remove(escudo);
	}

	/**
	 * Aqui recuperaremos los escudos que haya
	 * 
	 * @return
	 */

	public ArrayList<clsEscudo> recuperarEscudo() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsEscudo> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarEscudo();

			while (rs.next()) {

				clsEscudo nuevoEscudo = new clsEscudo(rs.getString("color"), rs.getString("forma"));

				temp.add(nuevoEscudo);
				clsDatosBD.Disconnect();
			}

			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Aqui guardaremoslos posibles escudos
	 */

	public void guardarEscudos() {
         clsDatosBD.Connect();
		for (clsEscudo es : tuescudo) {
			String formaEscudo = (String) es.getObjectProperty(Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO);
			String colorEscudo = (String) es.getObjectProperty(Constantes.PROPIEDAD_clsESCUDO_FORMAESCUDO);

			clsDatosBD.InsertarEscudo(formaEscudo, colorEscudo);
			clsDatosBD.Disconnect();
		}

	}

//--------------------------------------------------------------------------
	/**
	 * Aqui añadiremos los intercambios que haya
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 * @throws clsExcepcionIntercambioRepetido
	 */
	public boolean anadirIntercambio(String equipoOrigen, String equipoDestino) throws clsExcepcionIntercambioRepetido {
		clsIntercambio i = new clsIntercambio(equipoOrigen, equipoDestino);
		/**
		 * Utilizaremos el contains para añadirlo
		 */
           clsDatosBD.Connect();
		if (tuintercambio.contains(i) == true) {
			throw new clsExcepcionIntercambioRepetido("Intercambio Repetido");
			/**
			 * Aqui sencillamente si hay repetido no lo añade
			 */
		} else {
			tuintercambio.add(i);

			clsDatosBD.InsertarIntercambio(equipoOrigen, equipoDestino);
            clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Esta funcion la creamos por si nos confundimos para cambiarlo
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 */

	public boolean cambioDeIntercambio(String equipoOrigen, String equipoDestino) {
		itfProperty datoABuscar = new clsIntercambio(equipoOrigen, equipoDestino);

		int p = tuintercambio.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuintercambio.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO,
					Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Si queremos consultar algun intercambio
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 */

	public String consultarPropietario(String equipoOrigen, String equipoDestino) {

		itfProperty datoABuscar = new clsIntercambio();

		int p = tuintercambio.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuintercambio.get(p);

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Por si queremos borrar un intercambio que lo haremos a traves del remove
	 * 
	 * @param equipoOrigen
	 * @param equipoDestino
	 * @return
	 */

	public boolean borrarIntercambio(String equipoOrigen, String equipoDestino) {
		clsIntercambio intercambio = new clsIntercambio(equipoOrigen, equipoDestino);

		return tuintercambio.remove(intercambio);
	}

	/**
	 * Si queremos recuperar el intercaambio
	 * 
	 * @return
	 */

	public ArrayList<clsIntercambio> recuperarIntercamvio() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsIntercambio> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarIntercambio();

			while (rs.next()) {

				clsIntercambio nuevointercambio = new clsIntercambio(rs.getString("equipoOrigen"),
						rs.getString("equipoDestino"));

				temp.add(nuevointercambio);
			}
           clsDatosBD.Disconnect();
			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Aqui guardamos todos los atributos de intercambio
	 */

	public void guardarIntercambios() {
     clsDatosBD.Connect();
		for (clsIntercambio i : tuintercambio) {
			String equipoDestino = (String) i.getObjectProperty(Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO);
			String equipoOrigen = (String) i.getObjectProperty(Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN);

			clsDatosBD.InsertarIntercambio(equipoOrigen, equipoDestino);
			clsDatosBD.Disconnect();
		}

	}

	// ----------------------------------------------------------------------------------------------------------------------
	/**
	 * Aqui añadiremos los jugadores
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param formaFisica
	 * @param skills
	 * @return
	 */
	public boolean anadirJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			int formaFisica, double skills) {
		clsDatosBD.Connect();
		clsJugador j = new clsJugador(formaFisica, skills);
		/**
		 * Hay que meter los nombres de los jugadores
		 */

		clsJugador p1 = new clsJugador("Jesus", "Baldomero", "Ruiz", "12345678A", "masculino", 2.5, 100);
		clsJugador p2 = new clsJugador("Hortensia", "Ramirez", "Lopez", "12345671B", "femenino", 1.0, 100);
		clsJugador p3 = new clsJugador("Xabier", "Tolano", "Herrero", "87654321C", "masculino", 2.0, 100);
		clsJugador p4 = new clsJugador("Rogelio", "Tolosa", "Chapero", "31264594R", "masculino", 1.5, 100);
		clsJugador p5 = new clsJugador("Raul", "Beltran", "Orobio", "90216538T", "masculino", 0.5, 100);
		clsJugador p6 = new clsJugador("Martin", " Rodriguez", "Zuñiga", "26492740L", "masculino", 1.5, 100);
		clsJugador p7 = new clsJugador("Ainhoa", " Serna", "Ruiz de viñaspe", "24759485O", "masculino", 3.0, 100);
		clsJugador p8 = new clsJugador("Oscar", "Areitio", "Sela", "32461554G", "masculino", 2.0, 100);
		clsJugador p9 = new clsJugador("Omar", "Estebanez", "Galdos", "76984329W", "masculino", 1.0, 100);
		clsJugador p10 = new clsJugador("Fran", " Alba", "Ortiz", "43015694F", "masculino", 2.5, 100);
		clsJugador p11 = new clsJugador("Julen", "Fuente", "Aguirre", "60439185I", "masculino", 1.5, 100);
		clsJugador p12 = new clsJugador("Jorge", "Martiarena", "Gibello", "54287419U2", "masculino", 2.0, 100);
		clsJugador p13 = new clsJugador("Amaia", "Saenz", "Lopez", "54327681O", "femenino", 2.0, 100);
		clsJugador p14 = new clsJugador("Isabel", " Campillo", "Lerena", "98430165T", "femenino", 1.5, 100);
		clsJugador p15 = new clsJugador("Fran", "Aizpurua", "Cerro", "95032715Y", "masculino", 1.5, 100);
		clsJugador p16 = new clsJugador("Maite", "Ibisate", "Guardiola", "32685489K", "femenino", 2.0, 100);
		clsJugador p17 = new clsJugador("Eugenio", " Frondoso", "Corral", "23517896H", "masculino", 2.5, 100);
		clsJugador p18 = new clsJugador("Fernando", " Goikoetxea", "Sarabia", "43615379V", "masculino", 2.0, 100);
		clsJugador p19 = new clsJugador("Olga", "Tolagua", "Nocedal", "76890321K", "femenino", 2.0, 100);
		clsJugador p20 = new clsJugador("Marina", "Sanchez", "Gutierrez", "21436579O", "femenino", 1.0, 100);
		clsJugador p21 = new clsJugador("Mikel", "Lerena", "Gomez", "54392016P", "masculino", 2.0, 100);
		listadoJugadores.add(p1);
		listadoJugadores.add(p2);
		listadoJugadores.add(p3);
		listadoJugadores.add(p4);
		listadoJugadores.add(p5);
		listadoJugadores.add(p6);
		listadoJugadores.add(p7);
		listadoJugadores.add(p8);
		listadoJugadores.add(p9);
		listadoJugadores.add(p10);
		listadoJugadores.add(p11);
		listadoJugadores.add(p12);
		listadoJugadores.add(p13);
		listadoJugadores.add(p14);
		listadoJugadores.add(p15);
		listadoJugadores.add(p16);
		listadoJugadores.add(p17);
		listadoJugadores.add(p18);
		listadoJugadores.add(p19);
		listadoJugadores.add(p20);
		listadoJugadores.add(p21);

		clsComparadorPorNombre comp = new clsComparadorPorNombre();
		/**
		 * Aquí ya tenemos los jugadores ordenados y utilizamos el collections sort
		 */

		Collections.sort(listadoJugadores, comp);

		if (tujugador.contains(j) == true) {
			return false;
		} else {
			tujugador.add(j);

			clsDatosBD.InsertarJugador(nombre, apellido1, apellido2, dni, sexo, skills, formaFisica);
          clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Por si quereis cambiar de jugador
	 * 
	 * @param formaFisica
	 * @param skills
	 * @return
	 */

	public boolean cambioJugador(int formaFisica, double skills) {
		itfProperty datoABuscar = new clsJugador(formaFisica, skills);
		/**
		 * Utilizaremos el index off para buscar los datos
		 */

		int p = tujugador.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tujugador.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA,
					Constantes.PROPIEDAD_clsJUGADOR_SKILLS);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Esto lo utilizaremos para consultar jugadores
	 * 
	 * @param skills
	 * @return
	 */

	public String consultarJugador(double skills) {

		itfProperty datoABuscar = new clsJugador(0, skills);

		int p = tujugador.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tujugador.get(p);

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsJUGADOR_SKILLS);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Aqui borraremos el jugador con el remove
	 * 
	 * @param formaFisica
	 * @param skills
	 * @return
	 */

	public boolean borrarJugador(int formaFisica, double skills) {
		clsJugador jugador = new clsJugador(formaFisica, skills);

		return tujugador.remove(jugador);
	}

	/**
	 * Aqui recuperaremos los jugadores
	 * 
	 * @return
	 */
	public ArrayList<clsJugador> recuperarjugador() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsJugador> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarJugador();

			while (rs.next()) {

				clsJugador jugador = new clsJugador(rs.getInt(100), rs.getDouble(null));

				temp.add(jugador);
			}
          clsDatosBD.Disconnect();
			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Aqui guardaremos los jugadores
	 */

	public void guardarJugadores() {
       clsDatosBD.Connect();
		for (clsJugador j : tujugador) {
			String nombre = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_NOMBRE);
			String apellido1 = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_APELLIDO1);
			String apellido2 = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_APELLIDO2);
			String dni = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_DNI);
			String sexo = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_SEXO);
			int formaFisica = (int) j.getObjectProperty(Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA);
			double skills = (Double) j.getObjectProperty(Constantes.PROPIEDAD_clsJUGADOR_SKILLS);

			clsDatosBD.InsertarJugador(nombre, apellido1, apellido2, dni, sexo, skills, formaFisica);
		clsDatosBD.Disconnect();
		}
		

	}

//-------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Aqui añadiremos los partidos
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 * @return
	 */
	public boolean anadirPartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		clsPartidos p = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);
		/**
		 * Con el contains nos ayudaremos para añadirlo si esta repetido no lo añade
		 */
		clsDatosBD.Connect();
		if (tupartido.contains(p) == true) {
			return false;
		} else {
			tupartido.add(p);

			clsDatosBD.InsertarPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);
            clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Para cambiar de partido utilizaremos este metodo
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 * @return
	 */

	public boolean cambioDePartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		itfProperty datoABuscar = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);
		/**
		 * Buscaremos a traves del indexoff
		 */
		int p = tupartido.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tupartido.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL,
					Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Consultaremos los partidos aqui y tambien utilizaremos el index off
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param fechaInicioPartido
	 * @return
	 */

	public String consultarPartido(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {

		itfProperty datoABuscar = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);

		int p = tupartido.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tupartido.get(p);

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL);

			return prop;
		} else {
			return null;
		}
	}

	public boolean borrarPartido(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		clsPartidos partidos = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);

		return tupartido.remove(partidos);
	}

	/**
	 * Aqui recuperaremos partidos
	 * 
	 * @return
	 */

	public ArrayList<clsPartidos> recuperarPartidos() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsPartidos> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarEscudo();

			while (rs.next()) {

				clsPartidos nuevopartido = new clsPartidos(rs.getString("equipoLocal"), rs.getString("equipoVisitante"),
						rs.getDate(0));

				temp.add(nuevopartido);
				clsDatosBD.Disconnect();
			}

			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Con todos los atributos guardaremos qui los partidos
	 */

	public void guardarPartidos() {
      clsDatosBD.Connect();
		for (clsPartidos p : tupartido) {
			String equipoLocal = (String) p.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL);
			String equipoVisitante = (String) p.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE);
			Date fechaInicioPartido = (Date) p.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO);

			clsDatosBD.InsertarPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);
		clsDatosBD.Disconnect();
		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Aqui añadiremos temporadas nos ayudaremos del contains
	 * 
	 * @param puestos
	 * @param trofeos
	 * @param anioTemporada
	 * @return
	 */
	public boolean anadirTemporada(int puestos, String trofeos, Date anioTemporada) {
		clsTemporada t = new clsTemporada(puestos, trofeos, anioTemporada);
         clsDatosBD.Connect();
		if (tutemporada.contains(t) == true) {
			return false;
		}
		/**
		 * Si hay una repetida no la añade
		 */
		else {
			tutemporada.add(t);

			clsDatosBD.InsertarTemporada(puestos, trofeos, anioTemporada);
             clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Aqui cambairemos de temporada nos ayudaremos del index of
	 * 
	 * @param puestos
	 * @param trofeos
	 * @param anioTemporada
	 * @return
	 */

	public boolean cambioDeTemporada(int puestos, String trofeos, Date anioTemporada) {
		itfProperty datoABuscar = new clsTemporada(puestos, trofeos, anioTemporada);

		int p = tutemporada.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tutemporada.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA,
					Constantes.PROPIEDAD_clsTEMPORADA_PUESTOS);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Aqui consultaremos la temporada y nos ayudaremos del index of
	 * 
	 * @param anioTemporada
	 * @return
	 */

	public String consultarTemporada(Date anioTemporada) {

		itfProperty datoABuscar = new clsTemporada(0, null, anioTemporada);

		int p = tutemporada.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tutemporada.get(p);
			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Si queremos borrar la temporada nos ayudaremos del remove
	 * 
	 * @param anioTemporada
	 * @return
	 */
	public boolean borrarTemporada(Date anioTemporada) {
		clsTemporada temporada = new clsTemporada(0, null, anioTemporada);

		return tutemporada.remove(temporada);
	}

	/**
	 * Si queremos recuperarla utilizaremos este metodo
	 * 
	 * @return
	 */

	public ArrayList<clsTemporada> recuperarTemporada() {

		try {
			clsDatosBD.Connect();
			ArrayList<clsTemporada> temp = new ArrayList<>();

			ResultSet rs = clsDatosBD.CargarTemporada();

			while (rs.next()) {

				clsTemporada temporada = new clsTemporada(rs.getInt(0), rs.getString("trofeos"), rs.getDate(0));

				temp.add(temporada);
				clsDatosBD.Disconnect();
			}

			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Y si queremos guardarla con sus atributos utilizaremos este metodo
	 */
	public void guardarTemporada() {
          clsDatosBD.Connect();
		for (clsTemporada t : tutemporada) {
			int puestos = (int) t.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_PUESTOS);
			String trofeos = (String) t.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_TROFEOS);
			Date anioTemporada = (Date) t.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA);

			clsDatosBD.InsertarTemporada(puestos, trofeos, anioTemporada);
		}
		clsDatosBD.Disconnect();

	}

	// -------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Aqui añadiremos manager nos ayudaremos del contains
	 * @param  
	 */
	public boolean anadirManager(String nombre, String apellido1, String apellido2, String dni, String sexo,
			String calidad, int valoracion) throws clsExcepcionManagerRepetido {
		/**
		 * Primero creamos varios Managers con el nombre,apellidos,dni,sexo,calidad y
		 * valoracion
		 */
		
		/*
		clsManager m1 = new clsManager("Ruiz", "Lopez", "Meno", "12485678B", "masculino", "buena", 76);
		clsManager m2 = new clsManager("Rosa", "Bernarda", "Guereñu", "12332671O", "femenino", "media", 54);
		clsManager m3 = new clsManager("Miguel", "Ortiz", "Berneder", "87324321C", "masculino", "media", 52);
		clsManager m4 = new clsManager("Michael", "Sese", "Arder", "31324594T", "masculino", "mala", 20);
		clsManager m5 = new clsManager("Miren", "Subell", "Bies", "90215338B", "femenino", "buena", 80);
		clsManager m6 = new clsManager("Jone", " Campos", "Iparaguirre", "26471740P", "femenina", "muy buena", 96);
		clsManager m7 = new clsManager("Joseba", " Lopez", "Poter", "24753285I", "masculino", "mala", 26);
		
		En caso de descomentar crear comentario Javadoc
		
		listadoManagers.add(m1);
		listadoManagers.add(m2);
		istadoManagers.add(m3);
		listadoManagers.add(m4);
		listadoManagers.add(m5);
		listadoManagers.add(m6);
		listadoManagers.add(m7);
		*/
		
		clsDatosBD.Connect();
		
		/**
		 * Llamamos al comparadaor por nombre para compararlo
		 */
		clsComparadorPorNombreManagers comp = new clsComparadorPorNombreManagers();
		/**
		 * Aquí ya tenemos los managers ordenados
		 */

		Collections.sort(listadoManagers, comp);
		clsManager m =new clsManager(nombre, apellido1, apellido2, dni, sexo, calidad, valoracion);
		if (tumanager.contains(m) == true) {
			throw new clsExcepcionManagerRepetido("Manager Repetido");

		}
		/**
		 * Si hay una repetida no la añade
		 */
		else {
			tumanager.add(m);

			clsDatosBD.InsertarManager(nombre, apellido1, apellido2, dni, sexo, calidad, valoracion);
          clsDatosBD.Disconnect();
			return true;
		}
	}

	/**
	 * Aqui cambiaremos de manager nos ayudaremos del index off
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param calidad
	 * @param valoracion
	 * @return
	 */

	public boolean cambioDeManager(String nombre, String apellido1, String apellido2, String dni, String sexo,
			String calidad, int valoracion) {
		itfProperty datoABuscar = new clsManager(nombre, apellido1, apellido2, dni, sexo, calidad, valoracion);

		int p = tumanager.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tumanager.get(p);
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsMANAGER_VALORACION,
					Constantes.PROPIEDAD_clsMANAGER_CALIDAD);

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Aqui consultaremos el manager y nos ayudaremos del index off
	 * 
	 * @param dni
	 * @return
	 */

	public String consultarManager(String dni) {

		itfProperty datoABuscar = new clsManager(null, null, null, dni, null, null, 0);

		int p = tumanager.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tumanager.get(p);
			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_DNI);

			return prop;
		} else {
			return null;
		}
	}

	/**
	 * Si queremos borrar algun manager utilizaremos el remove
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param sexo
	 * @param calidad
	 * @param valoracion
	 * @return
	 */
	public boolean borrarManager(String nombre, String apellido1, String apellido2, String dni, String sexo,
			String calidad, int valoracion) {
		clsManager manager = new clsManager(nombre, apellido1, apellido2, dni, sexo, calidad, valoracion);

		return tumanager.remove(manager);
	}

	/**
	 * Si queremos recuperarlo utilizaremos este metodo
	 * 
	 * @return
	 */

	public ArrayList<clsManager> recuperarmanager() {

		try {
			ArrayList<clsManager> temp = new ArrayList<>();
			clsDatosBD.Connect();
			ResultSet rs = clsDatosBD.CargarManager();

			while (rs.next()) {

				clsManager manager = new clsManager(rs.getString("nombre"), rs.getString("apellido1"),
						rs.getString("apellido2"), rs.getString("dni"), rs.getString("sexo"), rs.getString("calidad"),
						rs.getInt(0));

				temp.add(manager);
			}
			clsDatosBD.Disconnect();
			return temp;
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}

	/**
	 * Si queremos guardarlo con sus atributos utilizaremos este metodo
	 */

	public void guardarManager() {
clsDatosBD.Connect();
		for (clsManager m : tumanager) {
			String nombre = (String) m.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_NOMBRE);
			String apellido1 = (String) m.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_APELLIDO1);
			String apellido2 = (String) m.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_APELLIDO2);
			String dni = (String) m.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_DNI);
			String sexo = (String) m.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_SEXO);
			String calidad = (String) m.getObjectProperty(Constantes.PROPIEDAD_clsMANAGER_CALIDAD);
			int valoracion = (int) m.getObjectProperty(Constantes.PROPIEDAD_clsMANAGER_VALORACION);

			clsDatosBD.InsertarManager(nombre, apellido1, apellido2, dni, sexo, calidad, valoracion);
		}
clsDatosBD.Disconnect();
	}

}
