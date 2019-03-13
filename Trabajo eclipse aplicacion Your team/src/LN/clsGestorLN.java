package LN;

import java.time.LocalDate;
import java.util.ArrayList;

import Comun.itfProperty;

public class clsGestorLN {
	/**
	 * Aquí creamos el Arraylist privado donde guardaremos los equipos
	 */
	private ArrayList<clsEquipo> tuequipo;
	private ArrayList<clsEquipacion> tuequipacion;
	private ArrayList<clsEscudo> tuescudo;
	private ArrayList<clsJugador> tujugador;
	private ArrayList<clsPartidos> tupartido;
	private ArrayList<clsTemporada> tutemporada;
	private ArrayList<clsIntercambio> tuintercambio;
	
	
	/**
	 * Crearemos el constructor del arraylist
	 */
	public clsGestorLN() {
		tuequipo=new ArrayList<clsEquipo>();
		tuequipacion=new ArrayList<clsEquipacion>();
		tuescudo=new ArrayList<clsEscudo>();
		tujugador=new ArrayList<clsJugador>();
		tupartido=new ArrayList<clsPartidos>();
		tutemporada=new ArrayList<clsTemporada>();
		tuintercambio=new ArrayList<clsIntercambio>();
	}
	/**
	 * Aquí crearemos el método donde guardaremos todo cuando querramos añadir buscar o eliminar
	 * Por ejemplo con el .add iríamos añadiendo los datos de cada uno
	 * Crearíamos los de eliminar por si querríamos eliminar al
	 * @param e
	 */
	public void añadirEquipo(String nombreEquipo, LocalDate fundacionEquipo) {
		clsEquipo objtuequipo = new clsEquipo(nombreEquipo,fundacionEquipo);  
		
		tuequipo.add(objtuequipo);
		
	}
	public void añadirEquipacion(String nombreEquipo, LocalDate fundacionEquipo,String color1, String color2, String publicidad, String seriagrafiado) {
		clsEquipacion objtuequipacion = new clsEquipacion(nombreEquipo,fundacionEquipo,color1,color2,publicidad,seriagrafiado); 
		tuequipacion.add(objtuequipacion);
	}
	
	public void añadirEscudo(String nombreEquipo, LocalDate fundacionEquipo, String formaEscudo, String colorEscudo) {
		clsEscudo objtuescudo = new clsEscudo(nombreEquipo,fundacionEquipo,formaEscudo,colorEscudo); 
		tuescudo.add(objtuescudo);
	}
	public void añadirIntercambio(String nombreEquipo, LocalDate fundacionEquipo,String equipoOrigen, String equipoDestino) {
		clsIntercambio objtuintercambio = new clsIntercambio(nombreEquipo,fundacionEquipo,equipoOrigen,equipoDestino); 
		tuintercambio.add(objtuintercambio);
	}
	public void añadirJugador(String nombreEquipo, LocalDate fundacionEquipo, String nombreJugador, int formaFisica, int edad,
			double skills) {
		clsJugador objtujugador=new clsJugador(nombreEquipo,fundacionEquipo,nombreJugador,formaFisica,edad,skills);
		tujugador.add(objtujugador);
	}
	public void añadirPartido(String equipoLocal, String equipoVisitante, LocalDate fechaInicioPartido) {
		clsPartidos objtupartido=new clsPartidos(equipoLocal,equipoVisitante,fechaInicioPartido);
		tupartido.add(objtupartido);
	}
	
	public void añadirTemporada(String equipoLocal, String equipoVisitante, LocalDate fechaInicioPartido,int puestos, String trofeos, LocalDate anioTemporada, String ganador) {
		clsTemporada objtutemporada=new clsTemporada(equipoLocal,equipoVisitante,fechaInicioPartido,puestos,trofeos,anioTemporada,ganador);
		tutemporada.add(objtutemporada);
	}

	/**public ArrayList<itfProperty>MostrarEquipacion(){
		ArrayList<itfProperty> guardatodo=new ArrayList<>();
		for (clsEquipacion eq: tuequipacion) 
			{guardatodo.add(eq);
		}
		return guardatodo;
	}*/
	
	public ArrayList<clsEquipo>MostrarEquipo(){
		return tuequipo;
	}
	
	public ArrayList<clsEscudo>MostrarEscudo(){
		return tuescudo;
	}
	
	public ArrayList<clsIntercambio>MostrarIntercambio(){
		return tuintercambio;
	}
	
	public ArrayList<clsJugador>MostrarJugador(){
		return tujugador;
	}
	
	public ArrayList<clsPartidos>MostrarPartido(){
		return tupartido;
	}
	
	public ArrayList<clsTemporada>MostrarTemporada(){
		return tutemporada;
	}
	/**
	 * Por si queremos eliminar alguna cosa dejamos lo metodos ahi
	 * @param nombreEquipo
	 * @param fundacionEquipo
	 * @param color1
	 * @param color2
	 * @param publicidad
	 * @param seriagrafiado
	 */
	public void eliminarEquipacion(String nombreEquipo, LocalDate fundacionEquipo,String color1, String color2, String publicidad, String seriagrafiado) {
		
	}
	public void eliminarEquipo(String nombreEquipo, LocalDate fundacionEquipo) {
		
	}
	public void eliminarEscudo(String nombreEquipo, LocalDate fundacionEquipo, String formaEscudo, String colorEscudo) {
	
	}
	public void eliminarIntercambio(String nombreEquipo, LocalDate fundacionEquipo,String equipoOrigen, String equipoDestino) {
		
	}
	public void eliminarJugador(String nombreEquipo, LocalDate fundacionEquipo, String nombreJugador, int formaFisica, int edad,
			double skills) {
		
	}
	
	/**
	 * Por si quieres buscar una equipacion, un equipo, un escudo, un intercambio, un jugador, un partido o una temporada.
	 * 
	 */
	public boolean buscarEquipacion(String color1) {
		return tuequipacion.indexOf(color1)!=-1;
	}
	public boolean buscarEquipo(String nombreEquipo) {
		return tuequipo.indexOf(nombreEquipo)!=-1;
	}
	public boolean buscarEscudo(String formaEscudo) {
		return tuescudo.indexOf(formaEscudo)!=-1;
	}
	public boolean buscarIntercambio(String equipoDestino) {
		return tuintercambio.indexOf(equipoDestino)!=-1;
	}
	public boolean buscarJugador(String NombreJugador) {
		return tujugador.indexOf(NombreJugador)!=-1;
	}
	public boolean buscarPartido(String FechaIncioPartido) {
		return tupartido.indexOf(FechaIncioPartido)!=-1;
	}
	public boolean buscarTemporada(String ganador) {
		return tutemporada.indexOf(ganador)!=-1;
	}
	

}
