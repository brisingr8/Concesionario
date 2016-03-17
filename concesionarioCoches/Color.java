package concesionarioCoches;

public enum Color {
	AZUL, AMARILLO, ROJO;
	
	//ALMACENA TODOS LOS COLORES POSIBLES
	private static final Color[] VALUES = values();
		
	//GENERA LAS OPCIONES DEL MENU INCLUYENDO SALIR
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Color color : VALUES) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
		
	//DEVUELVE VALUES
	public Color[] getValues() {
		return VALUES;
	}
}
