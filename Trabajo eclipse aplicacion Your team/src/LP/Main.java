package LP;

public class Main {

	public static void main(String[] args) {
		int op=0;
		System.out.println("Bienvenido a nuestra comunidad esperemos que te guste");
		System.out.println();
		System.out.println("A continuacion te mostraremos un men� para apuntarte");
		do {
			System.out.println("1-Empezar creando tu equipo");
			System.out.println("2-Salir");
			op=UtilidadesLP.leerEntero();
			switch(op) {
			case 1: 
				break;
			case 2:
				System.out.println("Ha sido un placer adios y que tengas un buen d�a");
				break;

	}

         }while(op!=7);
	}
}
	
