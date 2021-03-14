package excepciones;

public class ExcepcionDniRepetido extends Exception{
	public String toString() {
		return "El dni introducido ya esta en la lista";
	}
}
