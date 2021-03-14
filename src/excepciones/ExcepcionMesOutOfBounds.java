package excepciones;

public class ExcepcionMesOutOfBounds extends Exception{
	public String toString() {
		return "El mes introducido debe estar entre 1-12";
	}
}
