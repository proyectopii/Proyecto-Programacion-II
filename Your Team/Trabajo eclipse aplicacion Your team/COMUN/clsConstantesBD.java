package COMUN;

public class clsConstantesBD {
	/**
	 * Aqui crearemos las constantes para la base de datos
	 */
	
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "mydb";
	public static final String TIME="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "root";
	
	
	/**
	 * Aqui haremos todas las select que necesitemos
	 */
	
	public static final String SELECT_SQL_MANAGER="SELECT * FROM mydb.Manager where  dni = ?";
	public static final String  SELECT_SQL_EQUIPACION="SELECT * FROM mydb.Equipacion where color1=?";
	public static final String SELECT_SQL_EQUIPO="SELECT * FROM mydb.Equipo  where Nombre equipo=?";
	public static final String SELECT_SQL_ESCUDO="SELECT * FROM mydb.Escudo  where forma escudo =?";
	public static final String SELECT_SQL_INTERCAMBIO="SELECT * FROM mydb.Intercambio  where Equipo origen and Equipo destino =?";
	public static final String SELECT_SQL_JUGADOR="SELECT * FROM mydb.Jugador  where idJugador =?";
	public static final String SELECT_SQL_PARTIDOS="SELECT * FROM mydb.Partidos where Skills =?";
	public static final String SELECT_SQL_TEMPORADA="SELECT * FROM mydb.Temporada where Puestos y Trofeos y Anio temporada  =?";
	
	
	public static final int SELECT_SQL_ESC=7;
	
	
	public static final String INSERT_SQL_MANAGER=	"INSERT INTO `mydb`.`manager`"
													+ "(`Nombre`,`Apellido1`,`Apellido2`,`dni`,`Sexo`,"
													+ "`Calidad`,`Valoracion`,`Contrasenia`) values(?,?,?,?,?,?,?,?)";

	public static final String INSERT_SQL_EQUIPACION="INSERT INTO `mydb`.`equipacion`"
													+"(`color1P`,`color2P`,`serigrafiadoP`,"
													+"`publicidadP`,`color1S`,`color2S`,`serigrafiadoS`,"
													+"`publicidadS`,`Dorsal`) values(?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_SQL_EQUIPO="INSERT INTO `mydb`.`equipo`"
			                                        +"(`Nombre equipo`,`Fecha fundacion`,`Manager_dni`,"
			                                        + "`Escudo_idEscudo`,`Intercambio_idIntercambio`,`Equipacion_idEquipación`,"
			                                        +"`Partido_idPartidos`) values(?,?,?,?,?,?,?)";
	public static final String INSERT_SQL_ESCUDO="INSERT INTO `mydb`.`escudo`"
			                                        +"(`color escudo`,`forma escudo`) values(?,?)";
	public static final String INSERT_SQL_INTERCAMBIO="INSERT INTO `mydb`.`intercambio`"
			                                        +"(`Equipo origen`,`Equipo destino`) values(?,?)";
	public static final String INSERT_SQL_JUGADOR="INSERT INTO `mydb`.`jugador`"
			                                        +"(`Nombre`,`Apellido1`,`Apellido2`,`dni`,`Sexo`,`Forma fisica`,"
			                                        +"`Skills`,`Intercambio_idIntercambio`) values(?,?,?,?,?,?,?,?)";
	public static final String INSERT_SQL_PARTIDOS="INSERT INTO `mydb`.`partido`"
			                                        +"(`idPartidos`,`Fecha partido`,`Equipo local`,`Equipo visitante`,"
			                                        +"`Temporada_idTemporada`) values(?,?,?,?,?)";
	public static final String INSERT_SQL_TEMPORADA="INSERT INTO `mydb`.`temporada`"
			                                        +"(`Anio temporada`,`Trofeos`,`Puestos`,`idTemporada`) values(?,?,?,?)";

	
	public static final String DELETE_SQL_MANAGER="DELETE FROM `mydb`.`manager`WHERE=?";
	public static final String DELETE_SQL_EQUIPACION="DELETE FROM `mydb`.`equipacion`WHERE=?";
    public static final String DELETE_SQL_EQUIPO="DELETE FROM `mydb`.`equipo`WHERE=?";
    public static final String DELETE_SQL_ESCUDO="DELETE FROM `mydb`.`escudo`WHERE=?";
    public static final String DELETE_SQL_INTERCAMBIO="DELETE FROM `mydb`.`intercambio`WHERE=?";
    public static final String DELETE_SQL_JUGADOR="DELETE FROM `mydb`.`jugador`WHERE=?";
    public static final String DELETE_SQL_PARTIDOS="DELETE FROM `mydb`.`partido`WHERE=?";
    public static final String DELETE_SQL_TEMPORADA="DELETE FROM `mydb`.`temporada`WHERE=?";

    public static final String UPDATE_SQL_MANAGER= "UPDATE `mydb`.`manager`"
    		                                        +"SET `Nombre` = ?,"
    		                                        +"`Apellido1` = ?,"
    		                                        +"`Apellido2` = ?,"
    		                                        +"`dni` = ?,"
    		                                        +"`Sexo` = ?,"
    		                                        +"`Calidad` = ?,"
    		                                        +"`Valoracion` =?,"
    		                                        +"`Contrasenia` = ?"
    		                                        +"WHERE `dni` = ?";
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static final String SELECT_SQL_INDNI="SELECT dni FROM mydb.Manager where dni=?";
	public static final String SELECT_SQL_INCONTRASENIA="SELECT Contrasenia FROM mydb.Manager where "
			+ "Contrasenia=?";
	
}