package pojo;

public class Empleado {

	private String dni;
	private String nombre;
	private int cifraVentas;
	private int mes;
	
	public Empleado(String dni, String nombre, int cifraVentas, int mes) {
		this.dni = dni;
		this.nombre = nombre;
		this.cifraVentas = cifraVentas;
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", cifraVentas=" + cifraVentas + ", mes=" + mes + "]";
	}
	
	
	
}
