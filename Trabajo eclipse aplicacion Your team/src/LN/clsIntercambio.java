package LN;

public class clsIntercambio {
	/*
	 * Crearemos los atributos de clsIntercambio 
	 * Para hacer un intercambio tendrá que haber un equipo
	 */
	private String equipoOrigen;
	private String equipoDestino;
	/*
	 * Ahora crearemos un constructor vacío y otro con parámetros
	 */
	public clsIntercambio() {
		String equipoOrigen="";
		String equipoDestino="";
	}
	public clsIntercambio(String equipoOrigen, String equipoDestino) {
		super();
		this.equipoOrigen = equipoOrigen;
		this.equipoDestino = equipoDestino;
	}
	/*
	 * Ahora crearemos los getters y setters de los atributos
	 */
	public String getEquipoOrigen() {
		return equipoOrigen;
	}
	public void setEquipoOrigen(String equipoOrigen) {
		this.equipoOrigen = equipoOrigen;
	}
	public String getEquipoDestino() {
		return equipoDestino;
	}
	public void setEquipoDestino(String equipoDestino) {
		this.equipoDestino = equipoDestino;
	}
	
	
	
	

}
