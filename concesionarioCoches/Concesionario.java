package concesionarioCoches;

import java.util.ArrayList;

public class Concesionario {
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	private final String nombre = "Cochazos Perico";
	
	void annadir(String matricula, Color color, Modelo modelo) throws Exception {
		Coche coche = new Coche(matricula, color, modelo);
		if (!almacen.contains(coche))
			almacen.add(coche);
		else
			throw new CocheYaExisteException(
					"El coche ya existe en el concesionario. ");
	}
	
	boolean eliminar(String matricula) throws MatriculaNoValidaException {
		return almacen.remove(new Coche(matricula));
	}
		
	int size() {
		return almacen.size();
	}
		
	Coche get(String matricula) throws MatriculaNoValidaException,
			CocheNoExisteException {
			try {
			return almacen.get(almacen.indexOf(new Coche(matricula)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CocheNoExisteException(
					"El coche no está en el concesionario.");
		}
	}
		
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}
		public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
		}
}
