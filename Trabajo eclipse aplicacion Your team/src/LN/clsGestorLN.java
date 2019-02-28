package LN;

import java.util.ArrayList;

public class clsGestorLN {
	/**
	 * Aqu� creamos el Arraylist privado donde guardaremos los equipos
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
	 * Aqu� crearemos el m�todo donde guardaremos todo cuando querramos a�adir buscar o eliminar
	 * Por ejemplo con el .add ir�amos a�adiendo los datos de cada uno
	 * Crear�amos los de eliminar por si querr�amos eliminar al
	 * @param e
	 */
	public void a�adirEquipo(clsEquipo e) {
		tuequipo.add(e);
	}
	public void a�adirEquipacion(clsEquipacion eq) {
		tuequipacion.add(eq);
	}
	public void a�adirEscudo(clsEscudo es) {
		tuescudo.add(es);
	}
	public void a�adirIntercambio(clsIntercambio i) {
		tuintercambio.add(i);
	}
	public void a�adirJugador(clsJugador j) {
		tujugador.add(j);
	}
	public void a�adirPartido(clsPartidos p) {
		tupartido.add(p);
	}
	public void a�adirTemporada(clsTemporada t) {
		tutemporada.add(t);
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
