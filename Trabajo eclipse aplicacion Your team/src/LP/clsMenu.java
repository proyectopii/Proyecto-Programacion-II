package LP;

import java.time.LocalDate;

import LN.clsGestorLN;

public class clsMenu {
	public static void MenuPrincipal() {
		int op=0;
		System.out.println("Bienvenido a nuestra comunidad esperemos que te guste");
		System.out.println();
		System.out.println("A continuacion te mostraremos un menú para apuntarte");
		do {
			System.out.println("1-Empezar creando tu equipo ");
			System.out.println("2-Hacer un intercambio");
			System.out.println("3-Cambiar atributos del equipo");
			System.out.println("4-Salir");
			op=UtilidadesLP.leerEntero();
			switch(op) {
			case 1: 
				Crearequipo();
				Crearequipacion();
				CrearEscudo();
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("Ha sido un placer adios y que tengas un buen día");
				break;

	}

         }while(op!=4);
	}
	public static clsGestorLN gln = new clsGestorLN(); 
	
	public static void Crearequipo() {
		String nombreEquipo;
		LocalDate fundacionEquipo;
		
		System.out.println("Escribe un nombre para tu equipo");
		nombreEquipo=UtilidadesLP.leerCadena();
		fundacionEquipo=LocalDate.now();
		
		gln.añadirEquipo(nombreEquipo, fundacionEquipo);
	}
	
	public static void Crearequipacion () {
		String color1;
		String color2;
		String publicidad;
		String serigrafiado="";
		String oppublicidad;
		String opserigrafiado;
		
		System.out.println("Elige el color primario para tu equipacion");
		color1=UtilidadesLP.leerCadena();
		
		System.out.println("Elige el color secundario para tu equipacion");
		color2=UtilidadesLP.leerCadena();
		
		System.out.println("¿Quieres poner publicidad?");
		oppublicidad=UtilidadesLP.leerCadena();
		if (oppublicidad.equalsIgnoreCase("si")) {
			System.out.println("¿Qué publicidad quieres poner?");
			publicidad=UtilidadesLP.leerCadena();
			
		}
		
		System.out.println("¿Quieres poner serigrafiado?");
		opserigrafiado=UtilidadesLP.leerCadena();
		if (opserigrafiado.equalsIgnoreCase("si")) {
			System.out.println("¿Qué publicidad quieres poner?");
			serigrafiado=UtilidadesLP.leerCadena();
			
		}
		
		gln.añadirEquipacion(null, null, color1, color2, oppublicidad, serigrafiado);
	}
	public static void CrearEscudo() {
		String formaEscudo;
		String colorEscudo;
		
		System.out.println("Define de tu escudo");
		formaEscudo=UtilidadesLP.leerCadena();
		
		System.out.println("Di un color para tu escudo");
		colorEscudo=UtilidadesLP.leerCadena();
		
		gln.añadirEscudo(null, null, formaEscudo, colorEscudo);
		
	}
	
}


