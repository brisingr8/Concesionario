package concesionarioCoches;

import java.util.regex.Pattern;

public class Coche {
	private String matricula;
	private Color color;
	private Modelo modelo;
	
	//REGEX DE LA MATRICULA
	static final private Pattern patternMatricula = Pattern.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");
	
	public Coche(String matricula, Color color, Modelo modelo)throws Exception{
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}
	
	public Coche(String matricula) throws MatriculaNoValidaException{
		setMatricula(matricula);
	}
	
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}
	
	private void setMatricula(String matricula)
			throws MatriculaNoValidaException {
		if (esValida(matricula))
			this.matricula = estandarizarMatricula(matricula);
		else
			throw new MatriculaNoValidaException("La matr�cula no es v�lida. ");
	}
	
	private String estandarizarMatricula(String matricula) {
		assert esValida(matricula);
		return matricula.replaceAll("[ -]", "");
	}

	Color getColor() {
		return color;
	}

	private void setColor(Color color) throws ColorNoValidoException {
		if (color != null)
			this.color = color;
		else
			throw new ColorNoValidoException("El color no es v�lido. ");
	}

	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo != null)
			this.modelo = modelo;
		else
			throw new ModeloNoValidoException("El modelo no es v�lido. ");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}
}
