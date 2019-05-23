package LD;

public class clsConstantesBD {
	/**
	 * Aqui crearemos las constantes para la base de datos
	 */
	
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "mydb";
	public static final String TIME="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "bkn1959";
	
	
	/**
	 * Aqui haremos todas las select que necesitemos
	 */
	
	public static final String SELECT_SQL_MANAGER="SELECT * FROM Manager where  dni = ?";
	public static final String  SELECT_SQL_EQUIPACION="SELECT * FROM Equipacion where color1=?";
	public static final String SELECT_SQL_EQUIPO="SELECT * FROM  where Nombre equipo=?";
	public static final String SELECT_SQL_ESCUDO="SELECT * FROM  where forma escudo =?";
	public static final String SELECT_SQL_INTERCAMBIO="SELECT * FROM  where Equipo origen and Equipo destino =?";
	public static final String SELECT_SQL_JUGADOR="SELECT * FROM Jugador  where idJugador =?";
	public static final String SELECT_SQL_PARTIDOS="SELECT * FROM Jugador where Skills =?";
	public static final String SELECT_SQL_TEMPORADA="SELECT * FROM temporada where Puestos y Trofeos y Anio temporada  =?";
	
	
	
	public static final String INSERT_SQL_MANAGER=	"INSERT INTO `mydb`.`manager`"
													+ "(`Nombre`,`Apellido1`,`Apellido2`,`dni`,`Sexo`,"
													+ "`Calidad`,`Valoracion`)";
	public static final String INSERT_SQL_EQUIPACION="INSERT INTO `mydb`.`equipacion`"
													+"(`idEquipación`,`color1P`,`color2P`,`serigrafiadoP`,"
													+"`publicidadP`,`color1S`,`color2S`,`serigrafiadoS`,"
													+"`publicidadS`,`Dorsal`)";
	public static final String INSERT_SQL_EQUIPO="INSERT INTO `mydb`.`equipo`"
			                                        +"(`idEquipo`,`Nombre equipo`,`Fecha fundacion`,`Manager_dni`,"
			                                        + "`Escudo_idEscudo`,`Intercambio_idIntercambio`,`Equipacion_idEquipación`,"
			                                        +"`Partido_idPartidos`)";
	public static final String INSERT_SQL_ESCUDO="INSERT INTO `mydb`.`escudo`"
			                                        +"(`idEscudo`,`color escudo`,`forma escudo`)";
	public static final String INSERT_SQL_INTERCAMBIO="INSERT INTO `mydb`.`intercambio`"
			                                        +"(`idIntercambio`,	`Equipo origen`,`Equipo destino`)";
	public static final String INSERT_SQL_JUGADOR="INSERT INTO `mydb`.`jugador`"
			                                        +"(`Nombre`,`Apellido1`,`Apellido2`,`dni`,`Sexo`,`Forma fisica`,"
			                                        +"`Skills`,`Intercambio_idIntercambio`)";
	public static final String INSERT_SQL_PARTIDOS="INSERT INTO `mydb`.`partido`"
			                                        +"(`idPartidos`,`Fecha partido`,`Equipo local`,`Equipo visitante`,"
			                                        +"`Temporada_idTemporada`)";
	public static final String INSERT_SQL_TEMPORADA="INSERT INTO `mydb`.`temporada`"
			                                        +"(`Anio temporada`,`Trofeos`,`Puestos`,`idTemporada`)";


}
