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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import LD.clsDatos;
import COMUN.Constantes;
import COMUN.clsExcepcionEquipacionRepetida;
import COMUN.itfProperty;

public class clsGestorLN {
	private clsDatos clsDatos = new clsDatos();
	
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
	}

	/**
	 * Aqu? crearemos el m?todo donde guardaremos todo cuando querramos a?adir
	 * buscar o eliminar Por ejemplo con el .add ir?amos a?adiendo los datos de cada
	 * uno Crear?amos los de eliminar por si querr?amos eliminar al
	 * 
	 * @param
	 */
	public void anadirEquipo(String nombreEquipo, Date fundacionEquipo) {
		clsEquipo objtuequipo = new clsEquipo(nombreEquipo, fundacionEquipo);

		tuequipo.add(objtuequipo);
		clsComparadorPorNombreEquipo comp = new clsComparadorPorNombreEquipo();
		/**
		 * Aquí ya tenemos los jugadores ordenados
		 */
		Collections.sort(listadoEquipos, comp);

	}

	public void anadirEquipacion(String nombreEquipo, Date fundacionEquipo, String color1, String color2,
			String publicidad, String seriagrafiado, int dorsal) 
	{
		clsEquipacion objtuequipacion = new clsEquipacion(color1, color2, publicidad, seriagrafiado, dorsal);
		tuequipacion.add(objtuequipacion);
	}

	public void anadirEscudo(String nombreEquipo, Date fundacionEquipo, String formaEscudo, String colorEscudo) {
		clsEscudo objtuescudo = new clsEscudo(formaEscudo, colorEscudo);
		tuescudo.add(objtuescudo);
		clsComparadorPorColores comp = new clsComparadorPorColores();
		/**
		 * Aquí ya tenemos los jugadores ordenados
		 */
		Collections.sort(listadoEscudos, comp);
	}

	public void anadirIntercambio(String equipoOrigen, String equipoDestino) {
		clsIntercambio objtuintercambio = new clsIntercambio(equipoOrigen, equipoDestino);
		tuintercambio.add(objtuintercambio);
	}

	public void anadirJugador(String nombre, String apellido1, String apellido2, String dni, String sexo,
			int formaFisica, double skills) {
		clsJugador objtujugador = new clsJugador(nombre, apellido1, apellido2, dni, sexo, skills, formaFisica);
		tujugador.add(objtujugador);
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
		 * Aquí ya tenemos los jugadores ordenados
		 */
		Collections.sort(listadoJugadores, comp);
	}

	public void anadirPartido(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		clsPartidos objtupartido = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);
		tupartido.add(objtupartido);
	}

	public void anadirTemporada(int puestos, String trofeos, Date anioTemporada) {
		clsTemporada objtutemporada = new clsTemporada(puestos, trofeos, anioTemporada);
		tutemporada.add(objtutemporada);
	}

	public ArrayList<itfProperty> MostrarEquipacion() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsEquipacion eq : tuequipacion) {
			guardatodo.add((itfProperty) eq);
		}
		return guardatodo;
	}

	public ArrayList<itfProperty> MostrarEquipo() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsEquipo e : tuequipo) {
			guardatodo.add((itfProperty) e);
		}
		return guardatodo;

	}

	public ArrayList<itfProperty> MostrarIntercambio() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsIntercambio i : tuintercambio) {
			guardatodo.add((itfProperty) i);
		}
		return guardatodo;

	}

	public ArrayList<itfProperty> MostrarEscudo() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsEscudo es : tuescudo) {
			guardatodo.add((itfProperty) es);
		}
		return guardatodo;

	}

	public ArrayList<itfProperty> MostrarJugador() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsJugador j : tujugador) {
			guardatodo.add((itfProperty) j);
		}
		return guardatodo;

	}

	public ArrayList<itfProperty> MostrarPartidos() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsPartidos p : tupartido) {
			guardatodo.add((itfProperty) p);
		}
		return guardatodo;

	}

	public ArrayList<itfProperty> MostrarTemporada() {
		ArrayList<itfProperty> guardatodo = new ArrayList<>();

		for (clsTemporada t : tutemporada) {
			guardatodo.add((itfProperty) t);
		}
		return guardatodo;

	}
	

	
	

	/**
	 * Con este metodo añadiremos equipaciones
	 * 
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param serigrafiado
	 * @param dorsal
	 * @return
	 */
	public boolean anadirclsEquipacion(String color1, String color2, String publicidad, String serigrafiado,
			int dorsal)throws clsExcepcionEquipacionRepetida { //Aquí estoy propagando la excepcion

		clsEquipacion eq = new clsEquipacion(color1, color2, publicidad, serigrafiado, dorsal);// Aqui creamos una nueva
																								// equipacion con sus
																								// diferentes atributos
		/**
		 * Este metodo nos sirve para saber si hay repetidos para que no lo añada
		 */
		if (tuequipacion.contains(eq) == true) {
			throw new clsExcepcionEquipacionRepetida();
		
		
		/**
		 * Si no es repetido lo añadimos a la base de datos con sus atributos y nos lo
		 * retorna
		 */
		}else {
			tuequipacion.add(eq);

			clsDatos.insertarEquipaciones(color1, color2, publicidad, serigrafiado, dorsal);

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

	public boolean cambioclsEquipacion(String color1, String color2, String publicidad, String serigrafiado)
	/**
	 * Con la propiedad itfproperty sacamos la equipacion que tenemos con sus
	 * atributos
	 */
	{
		itfProperty datoABuscar = new clsEquipacion(color1, color2, publicidad, serigrafiado, 0);

		int p = tuequipo.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuequipo.get(p); // Aqui cambiamos la equipacion
			datoABuscar.setObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1,
					Constantes.PROPIEDAD_clsEQUIPACION_COLOR2);

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

	public String buscarclsequipacion(String color1) {
		/**
		 * Utilizaremos itfproperty para buscar y utilizaremos como clave el color 1
		 */

		itfProperty datoABuscar = new clsEquipacion(color1, "", "", "", 0);

		int p = tuequipacion.indexOf(datoABuscar);

		if (p != -1) {
			datoABuscar = tuequipacion.get(p); // Aqui obtenemos el dato

			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1);

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
	public boolean borrarclsEquipacion(String color1, String color2, String publicidad, String serigrafiado) {
		clsEquipacion equipacion = new clsEquipacion(color1, color2, publicidad, serigrafiado, 0);

		return tuequipacion.remove(equipacion);// aqui es cuando borramos la equipacion creada
	}

	/**
	 * Con este metodo recuperaremos la equipacion perdida
	 * 
	 * @return
	 */

	public ArrayList<clsEquipacion> recuperarEquipaciones() {

		try {
			ArrayList<clsEquipacion> temp = new ArrayList<>();

			ResultSet rs = clsDatos.cargarEquipaciones();// Nos ayudaremos de la base de datos para poder para poder
															// recuperarlo

			while (rs.next()) {
				/**
				 * Con el getString recuperamos todos sus atributos
				 */

				clsEquipacion nuevoCoche = new clsEquipacion(rs.getString("color1"), rs.getString("color2"),
						rs.getString("serigrafiado"), rs.getString("publicidad"), rs.getInt(0));

				temp.add(nuevoCoche);
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

		for (clsEquipacion c : tuequipacion) {
			String color1 = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR1);
			String color2 = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_COLOR2);
			String publicidad = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_PUBLICIDAD);
			String serigrafiado = (String) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_SERIGRAFIADO);
			int DORSAL = (int) c.getObjectProperty(Constantes.PROPIEDAD_clsEQUIPACION_DORSAL);

			clsDatos.insertarEquipaciones(color1, color2, publicidad, serigrafiado, DORSAL);// Aqui es cuando lo
																							// guardamps
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
	public boolean añadirEquipo(String nombreEquipo, Date fundacionEquipo) {
		clsEquipo e = new clsEquipo(nombreEquipo, fundacionEquipo);

		if (tuequipo.contains(e) == true) {
			return false; // Aquí no nos admitira el equipo si esta repetido
		} else {
			tuequipo.add(e);

			clsDatos.insertarEquipo(nombreEquipo, fundacionEquipo);
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
	public String BuscarEquipo(String nombreEquipo) {

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
			ArrayList<clsEquipo> temp = new ArrayList<>();

			ResultSet rs = clsDatos.cargarEquipo();

			while (rs.next()) {

				clsEquipo nuevoequipo = new clsEquipo(rs.getString("nombreEquipo"), rs.getDate(0));

				temp.add(nuevoequipo);
			}

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

			clsDatos.insertarEquipo(nombreEquipo, fundacionEquipo);
		}

	}

	// ---------------------------------------------------------------------------------------------------
	/**
	 * Aqui añadiremos los escudos
	 * 
	 * @param formaEscudo
	 * @param colorEscudo
	 * @return
	 */
	public boolean añadirEscudo(String formaEscudo, String colorEscudo) {
		clsEscudo es = new clsEscudo(formaEscudo, colorEscudo);

		if (tuescudo.contains(es) == true)// Nos aseguramos que no hay ninguno repetido
		{
			return false;
		} else {
			tuescudo.add(es);

			clsDatos.insertarEscudo(formaEscudo, colorEscudo);

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
	/*
	 * Aqui buscaremos los posibles escudos que haya
	 */

	public String BuscarEscudo(String formaEscudo, String colorEscudo) {

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
			ArrayList<clsEscudo> temp = new ArrayList<>();

			ResultSet rs = clsDatos.cargarEscudo();

			while (rs.next()) {

				clsEscudo nuevoEscudo = new clsEscudo(rs.getString("color"), rs.getString("forma"));

				temp.add(nuevoEscudo);
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

		for (clsEscudo es : tuescudo) {
			String formaEscudo = (String) es.getObjectProperty(Constantes.PROPIEDAD_clsESCUDO_COLORESCUDO);
			String colorEscudo = (String) es.getObjectProperty(Constantes.PROPIEDAD_clsESCUDO_FORMAESCUDO);

			clsDatos.insertarEscudo(formaEscudo, colorEscudo);
		}

	}

//--------------------------------------------------------------------------
	public boolean addIntercambio(String equipoOrigen, String equipoDestino) {
		clsIntercambio i = new clsIntercambio(equipoOrigen, equipoDestino);

		if (tuintercambio.contains(i) == true) {
			return false;
		} else {
			tuintercambio.add(i);

			clsDatos.insertarIntercambio(equipoOrigen, equipoDestino);

			return true;
		}
	}

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

	public boolean borrarIntercambio(String equipoOrigen, String equipoDestino) {
		clsIntercambio intercambio = new clsIntercambio(equipoOrigen, equipoDestino);

		return tuintercambio.remove(intercambio);
	}

	public ArrayList<clsIntercambio> recuperarIntercamvio() {

		try {
			ArrayList<clsIntercambio> temp = new ArrayList<>();

			ResultSet rs = clsDatos.cargarIntercambio();

			while (rs.next()) {

				clsIntercambio nuevointercambio = new clsIntercambio(rs.getString("equipoOrigen"),
						rs.getString("equipoDestino"));

				temp.add(nuevointercambio);
			}

			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void guardarIntercambios() {

		for (clsIntercambio i : tuintercambio) {
			String equipoDestino = (String) i.getObjectProperty(Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPODESTINO);
			String equipoOrigen = (String) i.getObjectProperty(Constantes.PROPIEDAD_clsINTERCAMBIO_EQUIPOORIGEN);

			clsDatos.insertarIntercambio(equipoOrigen, equipoDestino);
		}

	}

	// ----------------------------------------------------------------------------------------------------------------------
	public boolean addJugador(String nombre, String apellido1, String apellido2,String dni, String sexo,int formaFisica, double skills) {
		clsJugador j = new clsJugador(formaFisica, skills);

		if (tujugador.contains(j) == true) {
			return false;
		} else {
			tujugador.add(j);

			clsDatos.insertarJugador(nombre, apellido1, apellido2, dni, sexo, skills, formaFisica);

			return true;
		}
	}

	public boolean cambioJugador(int formaFisica, double skills) {
		itfProperty datoABuscar = new clsJugador(formaFisica, skills);

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

	public boolean borrarJugador(int formaFisica, double skills) {
		clsJugador jugador = new clsJugador(formaFisica, skills);

		return tujugador.remove(jugador);
	}

	public ArrayList<clsJugador> recuperarjugador() {

		try {
			ArrayList<clsJugador> temp = new ArrayList<>();

			ResultSet rs = clsDatos.cargarJugador();

			while (rs.next()) {

				clsJugador jugador = new clsJugador(rs.getInt(100), rs.getDouble(null));

				temp.add(jugador);
			}

			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void guardarJugadores() {

		for (clsJugador j : tujugador) {
			String nombre = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_NOMBRE);
			String apellido1 = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_APELLIDO1);
			String apellido2 = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_APELLIDO2);
			String dni = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_DNI);
			String sexo = (String) j.getObjectProperty(Constantes.PROPIEDAD_clsPERSONA_SEXO);
			int formaFisica = (int) j.getObjectProperty(Constantes.PROPIEDAD_clsJUGADOR_FORMAFISICA);
			double skills = (Double) j.getObjectProperty(Constantes.PROPIEDAD_clsJUGADOR_SKILLS);

			clsDatos.insertarJugador(nombre, apellido1, apellido2, dni, sexo, skills, formaFisica);
		}

	}
//-------------------------------------------------------------------------------------------------------------------------------------------

	public boolean addPartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		clsPartidos p = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);

		if (tupartido.contains(p) == true) {
			return false;
		} else {
			tupartido.add(p);

			clsDatos.insertarpartido(equipoLocal, equipoVisitante, fechaInicioPartido);

			return true;
		}
	}

	public boolean cambioDePartidos(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		itfProperty datoABuscar = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);

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

	public ArrayList<clsPartidos> recuperarPartidos() {

		try {
			ArrayList<clsPartidos> temp = new ArrayList<>();

			ResultSet rs = clsDatos.cargarPartido();

			while (rs.next()) {

				clsPartidos nuevopartido = new clsPartidos(rs.getString("equipoLocal"), rs.getString("equipoVisitante"),
						rs.getDate(0));

				temp.add(nuevopartido);
			}

			return temp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void guardarPartidos() {

		for (clsPartidos p : tupartido) {
			String equipoLocal = (String) p.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOLOCAL);
			String equipoVisitante = (String) p.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_EQUIPOVISITANTE);
			Date fechaInicioPartido = (Date) p.getObjectProperty(Constantes.PROPIEDAD_clsPARTIDOS_FECHAINICIOPARTIDO);

			clsDatos.insertarpartido(equipoLocal, equipoVisitante, fechaInicioPartido);
		}

	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	
	public boolean addTemporada( int puestos, String trofeos, Date anioTemporada  )
	{
		clsTemporada t = new clsTemporada( puestos , trofeos , anioTemporada );
		
		if( tutemporada.contains( t ) == true  )
		{
			return false;
		}
		else
		{
			tutemporada.add( t );
			
			clsDatos.insertarTemporada(puestos, trofeos, anioTemporada);
			
			return true;
		}
	}
	
	public boolean cambioDeTemporada(  int puestos, String trofeos, Date anioTemporada )
	{		
		itfProperty datoABuscar = new clsTemporada( puestos,trofeos,anioTemporada);
		
		int p = tutemporada.indexOf( datoABuscar );
		
		if( p != -1 )
		{
			datoABuscar = tutemporada.get(p); 
			datoABuscar.setObjectProperty( Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA,Constantes.PROPIEDAD_clsTEMPORADA_PUESTOS);
			
			return true;
		}
		else
		{
			return false;
		}
	}	

	public String consultarPropietario( Date anioTemporada  )
	{
		
		itfProperty datoABuscar = new clsTemporada(0, null, anioTemporada );
		
		int p = tutemporada.indexOf( datoABuscar );
		
		if( p != -1 )
		{
			datoABuscar = tutemporada.get(p); 
			String prop = (String) datoABuscar.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA);
					
			return prop;
		}
		else
		{
			return null;
		}
	}
	public boolean borrarTemporada( Date anioTemporada)
	{
		clsTemporada temporada = new clsTemporada(0,null,anioTemporada);
		
		return tutemporada.remove( temporada );
	}
	
	public ArrayList<clsTemporada> recuperarTemporada() {
		
		try
		{
			ArrayList<clsTemporada> temp = new ArrayList<>();
			
			ResultSet rs = clsDatos.cargarTemporada();
			
			while (rs.next()) {			
	
				clsTemporada temporada = new clsTemporada(rs.getInt(0), rs.getString("trofeos"), rs.getDate(0));
				
				temp.add(temporada);
			}
					
			return temp;
		}
		catch( SQLException ex )
		{
			ex.printStackTrace();
			return null;
		}		
	}
	
public void guardarTemporada() {
		
		for( clsTemporada t : tutemporada )
		{
			int puestos = (int) t.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_PUESTOS );
			String trofeos = (String) t.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_TROFEOS );
			Date anioTemporada = (Date) t.getObjectProperty(Constantes.PROPIEDAD_clsTEMPORADA_ANIOTEMPORADA );
			
			clsDatos.insertarTemporada(puestos, trofeos, anioTemporada);
		}
		
	}
	

}
