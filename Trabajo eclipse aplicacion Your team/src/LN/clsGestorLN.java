package LN;

import java.time.LocalDate;
import java.util.ArrayList;

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

	public ArrayList<clsEquipacion>MostrarEquipacion(){
		return tuequipacion;
	}
	
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
	public void eliminarEquipacion(clsEquipacion e) {
		//tuequipacion.remove(e);
	}
	public void eliminarEquipo(clsEquipo eq) {
		
	}
	public void eliminarEscudo(clsEscudo es) {
	
	}
	public void eliminarIntercambio(clsIntercambio i) {
		
	}
	public void eliminarJugador(clsJugador j) {
		
	}
	public void eliminarPartido(clsPartidos p) {
		
	}
	public void eliminarTemporada(clsTemporada t) {
		
	}
	/**
	 * Por si quieres buscar una equipacion, un equipo, un escudo, un intercambio, un jugador, un partido o una temporada.
	 * 
	 */
	public boolean buscarEquipacion(clsEquipacion e) {
		return tuequipacion.indexOf(e)!=-1;
	}
	public boolean buscarEquipo(clsEquipo eq) {
		return tuequipo.indexOf(eq)!=-1;
	}
	public boolean buscarEscudo(clsEscudo es) {
		return tuescudo.indexOf(es)!=-1;
	}
	public boolean buscarIntercambio(clsIntercambio i) {
		return tuintercambio.indexOf(i)!=-1;
	}
	public boolean buscarJugador(clsJugador j) {
		return tujugador.indexOf(j)!=-1;
	}
	public boolean buscarPartido(clsPartidos p) {
		return tupartido.indexOf(p)!=-1;
	}
	public boolean buscarTemporada(clsTemporada t) {
		return tutemporada.indexOf(t)!=-1;
	}
	

}
