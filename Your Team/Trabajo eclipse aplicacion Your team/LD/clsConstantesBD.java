package LD;

public class clsConstantesBD {
	/**
	 * Aqui crearemos las constantes para la base de datos
	 */
	
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "mybd";
	public static final String TIME="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "root";
	
	
	/**
	 * Aqui haremos todas las select que necesitemos
	 */
	
	public static final String SELECT_SQL_MANAGER="SELECT * FROM Manager where  dni = ?";
	public static final String  SELECT_SQL_EQUIPACION="SELECT * FROM Equipacion where color1=?";
	public static final String SELECT_SQL_EQUIPO="SELECT * FROM  where Nombre equipo=?";
	public static final String SELECT_SQL_ESCUDO="SELECT * FROM  where forma escudo =?";
	public static final String SELECT_SQLINTERCAMBIO="SELECT * FROM  where Equipo origen and Equipo destino =?";
	public static final String SELECT_SQL_JUGADOR="SELECT * FROM Jugador  where idJugador =?";
	public static final String SELECT_SQL_PARTIDOS="SELECT * FROM Jugador where Skills =?";
	public static final String SELECT_SQL_TEMPORADA="SELECT * FROM temporada where Puestos y Trofeos y Anio temporada  =?";
	
	
	
	public static final String INSERT_SQL_MANAGER=	"INSERT INTO `mydb`.`manager`"
													+ "(`Nombre`,`Apellido1`,`Apellido2`,`dni`,`Sexo`,"
													+ "`Calidad`,`Valoracion`)";

}
