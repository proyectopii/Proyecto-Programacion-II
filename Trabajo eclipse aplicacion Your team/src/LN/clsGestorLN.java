package LN;

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

import COMUN.itfProperty;

public class clsGestorLN {
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
	ArrayList<clsJugador> listadoJugadores;
	ArrayList<clsEquipo> listadoEquipos;

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

	}

	public void anadirEquipacion(String nombreEquipo, Date fundacionEquipo, String color1, String color2,
			String publicidad, String seriagrafiado, int dorsal) {
		clsEquipacion objtuequipacion = new clsEquipacion(nombreEquipo, fundacionEquipo, color1, color2, publicidad,
				seriagrafiado, dorsal);
		tuequipacion.add(objtuequipacion);
	}

	public void anadirEscudo(String nombreEquipo, Date fundacionEquipo, String formaEscudo, String colorEscudo) {
		clsEscudo objtuescudo = new clsEscudo(nombreEquipo, fundacionEquipo, formaEscudo, colorEscudo);
		tuescudo.add(objtuescudo);
	}

	public void anadirIntercambio(String equipoOrigen, String equipoDestino) {
		clsIntercambio objtuintercambio = new clsIntercambio(equipoOrigen, equipoDestino);
		tuintercambio.add(objtuintercambio);
	}

	public void anadirJugador(String nombreJugador, int formaFisica, int edad, double skills, String nombreEquipo,
			Date fundacionEquipo) {
		clsJugador objtujugador = new clsJugador(nombreJugador, formaFisica, edad, skills, nombreEquipo,
				fundacionEquipo);
		tujugador.add(objtujugador);
	}

	public void anadirPartido(String equipoLocal, String equipoVisitante, Date fechaInicioPartido) {
		clsPartidos objtupartido = new clsPartidos(equipoLocal, equipoVisitante, fechaInicioPartido);
		tupartido.add(objtupartido);
	}

	public void anadirTemporada(int puestos, String trofeos, LocalDate anioTemporada, String ganador) {
		clsTemporada objtutemporada = new clsTemporada(puestos, trofeos, anioTemporada, ganador);
		tutemporada.add(objtutemporada);
	}

	public void añadirJugadores() {
		/**
		 * Hay que meter los nombres de los jugadores
		 */
		clsJugador p1 = new clsJugador("Jesus Baldomero", 100, 22, 2.5, null, null);
		clsJugador p2 = new clsJugador("Hortensia Ramirez", 100, 25, 1.0, null, null);
		clsJugador p3 = new clsJugador("Xabier Tolano", 100, 32, 2.0, null, null);
		clsJugador p4 = new clsJugador("Rogelio Tolosa", 100, 23, 1.5, null, null);
		clsJugador p5 = new clsJugador("Raul Beltran", 100, 43, 0.5, null, null);
		clsJugador p6 = new clsJugador("Martin Rodriguez", 100, 44, 1.5, null, null);
		clsJugador p7 = new clsJugador("Ainhoa Serna", 100, 21, 3.0, null, null);
		clsJugador p8 = new clsJugador("Oscar Areitio", 100, 48, 2.0, null, null);
		clsJugador p9 = new clsJugador("OmarEstebanez", 100, 27, 1.0, null, null);
		clsJugador p10 = new clsJugador("Fran Alba", 100, 32, 2.5, null, null);
		clsJugador p11 = new clsJugador("Julen Fuente", 100, 21, 1.5, null, null);
		clsJugador p12 = new clsJugador("Jorge Martiarena", 100, 44, 2.0, null, null);
		clsJugador p13 = new clsJugador("Amaia Saenz", 100, 42, 0.5, null, null);
		clsJugador p14 = new clsJugador("Isabel Campillo", 100, 29, 1.0, null, null);
		clsJugador p15 = new clsJugador("Fran Aizpurua", 100, 53, 0.5, null, null);
		clsJugador p16 = new clsJugador("Maite Ibisate", 100, 43, 2.0, null, null);
		clsJugador p17 = new clsJugador("Eugenio Frondoso", 100, 24, 2.5, null, null);
		clsJugador p18 = new clsJugador("Fernando Goikoetxea", 100, 44, 2.0, null, null);
		clsJugador p19 = new clsJugador("Olga Tolagua", 100, 56, 2.0, null, null);
		clsJugador p20 = new clsJugador("Marina Sanchez", 100, 39, 1.00, null, null);
		clsJugador p21 = new clsJugador("Mikel Lerena", 100, 21, 2.00, null, null);
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
	 * Por si queremos eliminar alguna cosa dejamos lo metodos ahi
	 * 
	 * @param nombreEquipo
	 * @param fundacionEquipo
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param seriagrafiado
	 */
	public void eliminarEquipacion(String nombreEquipo, LocalDate fundacionEquipo, String color1, String color2,
			String publicidad, String seriagrafiado) {

	}

	public void eliminarEquipo(String nombreEquipo, LocalDate fundacionEquipo) {

	}

	public void eliminarEscudo(String nombreEquipo, LocalDate fundacionEquipo, String formaEscudo, String colorEscudo) {

	}

	public void eliminarIntercambio(String nombreEquipo, LocalDate fundacionEquipo, String equipoOrigen,
			String equipoDestino) {

	}

	public void eliminarJugador(String nombreEquipo, LocalDate fundacionEquipo, String nombreJugador, int formaFisica,
			int edad, double skills) {

	}

	/**
	 * Por si quieres buscar una equipacion, un equipo, un escudo, un intercambio,
	 * un jugador, un partido o una temporada.
	 * 
	 */
	public boolean buscarEquipacion(String color1) {
		return tuequipacion.indexOf(color1) != -1;
	}

	public boolean buscarEquipo(String nombreEquipo) {
		return tuequipo.indexOf(nombreEquipo) != -1;
	}

	public boolean buscarEscudo(String formaEscudo) {
		return tuescudo.indexOf(formaEscudo) != -1;
	}

	public boolean buscarIntercambio(String equipoDestino) {
		return tuintercambio.indexOf(equipoDestino) != -1;
	}

	public boolean buscarJugador(String NombreJugador) {
		return tujugador.indexOf(NombreJugador) != -1;
	}

	public boolean buscarPartido(String FechaIncioPartido) {
		return tupartido.indexOf(FechaIncioPartido) != -1;
	}

	public boolean buscarTemporada(String ganador) {
		return tutemporada.indexOf(ganador) != -1;
	}

	/**
	 * A continuaci?n pondremos varios m?todos
	 */
	private ArrayList<itfProperty> contenedor;

	// 7public clsGestorLN() {

	// contenedor = new ArrayList<>();
	// }
	public boolean anadir(itfProperty obj) {
		// no existe el dato en el array
		if (buscar(obj) == false) {
			contenedor.add(obj);

			return true;
		} else {
			return false;
		}
	}

	public boolean buscar(itfProperty obj) {
		int p = contenedor.indexOf(obj);

		if (p == -1)
			return false;
		else
			return true;
	}

	public boolean borrar(itfProperty obj) {
		if (buscar(obj) == true) {
			contenedor.remove(obj);

			return true;
		} else {
			return false;
		}
	}

	public boolean cargar(String nomFichero) {
		try {
			File f = new File(nomFichero);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream oos = new ObjectInputStream(fis);

			contenedor = (ArrayList<itfProperty>) oos.readObject();

			oos.close();// DEATH

			return true;
		} catch (FileNotFoundException ex) {
			System.out.println("Error nombre del fichero no se acepta!");
			return false;
		} catch (IOException ex) {
			System.out.println("Error no se encuentra la ruta!");
			return false;
		} catch (ClassCastException ex) {
			System.out.println("Error el tipo de dato no corresponde!");
			return false;
		} catch (ClassNotFoundException ex) {

			System.out.println("Error el tipo de dato no existe!");
			return false;
		}
	}

	public boolean grabar(String nomFichero) {
		// tratamiento de excepciones
		try {
			File f = new File(nomFichero);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(contenedor);

			oos.close();// DEATH

			return true;
		} catch (FileNotFoundException ex) {
			System.out.println("Error nombre del fichero no se acepta!");
			return false;
		} catch (IOException ex) {
			System.out.println("Error no se encuentra la ruta!");
			return false;
		}
	}

}
