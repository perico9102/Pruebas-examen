package excepciones;

public class ExcepcionCifraVentasNegativo extends Exception{
	public String toString() {
		return "La cifra de ventas no puede ser un numero negativo";
	}
}
