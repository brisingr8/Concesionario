package concesionarioCoches;

public enum Modelo {
	
	//LOS MODELOS CON LA MARCA CORRESPONDIENTE
	
	SERIE1(Marca.BMW),
	SERIE2(Marca.BMW),
	FIESTA(Marca.FORD),
	ORION(Marca.FORD),
	LEON(Marca.SEAT),
	CORDOBA(Marca.SEAT);
	//--------------------------------------------------------------------
	private Marca marca;
	
	private Modelo(Marca marca){
		this.marca=marca;
	}
	
	public Marca getMarca(){
		return marca;
	}
	
	public String toString() {
		return name() + ", " + getMarca();
	}
	//--------------------------------------------------------------------
	
	//ALMACENA TODOS LOS MODELOS POSIBLES
	private static final Modelo[] VALUES = values();
	
	//GENERA LAS OPCIONES DEL MENU INCLUYENDO SALIR
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	//DEVUELVE VALUES
	public Modelo[] getValues() {
		return VALUES;
	}
}
