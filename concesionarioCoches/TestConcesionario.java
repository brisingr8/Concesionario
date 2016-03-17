package concesionarioCoches;

import utiles.Menu;
import utiles.Teclado;

public class TestConcesionario{
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Salir" });
	
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.AZUL.generarOpcionesMenu());

	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.CORDOBA.generarOpcionesMenu());
	
	static Concesionario concesionario = new Concesionario();

	public static void main(String[] args) {
		do {
			switch (menu.gestionarMenu()) {
			case 1:
				annadirCoche();
				break;
			case 2:
				eliminarCoche();
				break;
			case 3:
				getCoche();
				break;
			case 4:
				System.out.println(concesionario);
				break;
			case 5:
				System.out.println("Número de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6:
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;

			default:
				System.out.println("Saliendo del programa...");
				return;
			}
		} while (true);
	}

	
	private static void getCoche() {
		try {
			System.out.println(concesionario.get(Teclado.leerCadena("Introduce la matrícula")));
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void eliminarCoche() {
		try {
			if (concesionario.eliminar(Teclado
					.leerCadena("Introduce la matrícula")))
				System.out.println("Coche eliminado");
			else
				System.out
						.println("El coche no se ha podido eliminar. No existe un coche con esa matrícula en el concesionario");
		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage()
					+ "No se ha podido eliminar el coche en el concesionario");
		}
	}

	private static void annadirCoche() {

		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matrícula"),
					pedirColor(), pedirModelo());
			System.out.println("Coche añadido con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage()
					+ "No se ha podido añadir el coche en el concesionario");
		}
	}

	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionarMenu();
		Modelo[] arrModelos = Modelo.CORDOBA.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	private static Color pedirColor() {
		int opcion = menuColores.gestionarMenu();
		Color[] arrColores = Color.AZUL.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}
}
