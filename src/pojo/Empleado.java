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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCifraVentas() {
		return cifraVentas;
	}

	public void setCifraVentas(int cifraVentas) {
		this.cifraVentas = cifraVentas;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	
	
}
