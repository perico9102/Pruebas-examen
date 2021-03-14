package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import excepciones.ExcepcionCifraVentasNegativo;
import excepciones.ExcepcionDniRepetido;
import excepciones.ExcepcionMesOutOfBounds;
import excepciones.ExcepcionNumeroIntroducidoFueraDeValores;
import pojo.Empleado;

public class Empresa {
	static Empleado empleado;
	static Scanner sc;
	static ArrayList<Empleado> lista = new ArrayList<>();
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		boolean fin = false;
		
		while(!fin) {
			try {
			System.out.println("Introduce lo que quieras hacer (AÑADIR UN EMPLEADO = 1, MODIFICAR LA"
					+ " CIFRA DE VENTAS = 2, MOSTRAR LA LISTA = 3, CONSULTAR EMPLEADO DEL MES = 4, SALIR = 5)");
			int respuesta = Integer.parseInt(sc.nextLine());
				switch (respuesta) {
				case 1: {
					agregarEmpleado();
					break;
				}
				case 2: {
					modificarCifraVentas();
					break;
				}
				case 3: {
					mostrarListaEmpleados();
					break;
				}
				case 4: {
					mostrarEmpleadoDelMes();
					break;
				}
				case 5: {
					fin = true;
					System.out.println("Saliendo del programa....");
				}
			}
				if (respuesta < 1 || 5 < respuesta) {
					throw new ExcepcionNumeroIntroducidoFueraDeValores();
				}
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido debe ser numerico");
			} catch (ExcepcionNumeroIntroducidoFueraDeValores j) {
				System.out.println(j);
			}

		}

	}

	private static void modificarCifraVentas() {
		boolean datoOk = true;
		int mes = 0;
		if (lista.isEmpty()) {
			System.out.println("No hay ningun empleado en la lista");
		} else {
			System.out.println("Introduce el dni del empleado a modificar");
			String dni = sc.nextLine();
			Iterator<Empleado> it = lista.iterator();
			while(it.hasNext() && datoOk) {
			empleado = it.next();
				if (dni.equalsIgnoreCase(empleado.getDni())) {
					mes = solicitarMes("Introduce el mes del empleado");
					int cifraDeVenta = solivitarCifraVentas("Introduce la nueva cifra de ventas");;
					for (Empleado empleado : lista) {
						if (dni.equalsIgnoreCase(empleado.getDni())) {
							empleado.setMes(mes);
							empleado.setCifraVentas(cifraDeVenta);
						}
					}
					datoOk = false;
				} else if (!dni.equalsIgnoreCase(empleado.getDni()) && !it.hasNext()) {
					System.out.println("El dni introducido no esta en la lista");
					datoOk = false;
				}
			}
		}
		
	}

	private static void mostrarEmpleadoDelMes() {
		 Empleado empleadoDelMes = new Empleado("", "", 0, 0);
		if (lista.isEmpty()) {
			System.out.println("No se ha introducido ningun empleado");
		} else {
			System.out.println("Introduce el mes que quieras consultar");
			int mes = Integer.parseInt(sc.nextLine());
			for (Empleado empleado : lista) {
				if (empleado.getCifraVentas() > empleadoDelMes.getCifraVentas() && empleado.getMes() == mes) {
					empleadoDelMes = empleado;
				}
			}
			System.out.println(empleadoDelMes);
		}
		
	}

	private static void mostrarListaEmpleados() {
		System.out.println("** Lista de empleados ** ");
		if (lista.isEmpty()) {
			System.out.println("La lista esta vacia");
		} else {
			for (Empleado empleado : lista) {
				System.out.println(empleado);
			}
		}
		
	}

	private static void agregarEmpleado() {
		
		String dni = solicitarDni("Introduce el dni del empleado");
		String nombre = solicitarNombre("Introduce el nombre del empleado");
		int cifraVentas = solivitarCifraVentas("Introduce la cifra de ventas del empleado");
		int mes = solicitarMes("Introduce el mes del empleado");
		
		empleado = new Empleado(dni, nombre, cifraVentas, mes);
		lista.add(empleado);
	}

	private static int solicitarMes(String mensaje) {
		int mes = 0;
		boolean datoOk = false;
		while(!datoOk) {
			try {	
					System.out.println(mensaje);
					mes = Integer.parseInt(sc.nextLine());
						if (mes > 12 || 1 > mes) {
							throw new ExcepcionMesOutOfBounds();
						}
						datoOk = true;
				
			} catch (ExcepcionMesOutOfBounds e) {
				mes = 0;
				datoOk = false;
				System.out.println(e);
			} catch (NumberFormatException j) {
				mes = 0;
				datoOk = false;
				System.out.println("La cifra debe ser numerica");
				
			}
		}
		return mes;
	}

	private static int solivitarCifraVentas(String mensaje) {
		int cifraVentas = 0;
		boolean datoOk = false;
		while(!datoOk) {
			try {
					System.out.println(mensaje);
					cifraVentas = Integer.parseInt(sc.nextLine());
					if (cifraVentas < 0) {
						throw new ExcepcionCifraVentasNegativo();
					}
				
				datoOk = true;
			} catch (ExcepcionCifraVentasNegativo e) {
				cifraVentas = 0;
				datoOk = false;
				System.out.println(e);
			} catch (NumberFormatException j) {
				System.out.println("La cifra debe ser numerica");
				cifraVentas = 0;
				datoOk = false;
			}
		}
		return cifraVentas;
	}

	private static String solicitarNombre(String mensaje) {
		String nombre = "";
		System.out.println(mensaje);
		nombre = sc.nextLine();
		return nombre;
	}

	private static String solicitarDni(String mensaje) {
		String dni ="";	
		boolean datoOk = false;
		while(!datoOk) {
			try {
				System.out.println(mensaje);
				dni = sc.nextLine().trim();
					for (Empleado empleado : lista) {
						if (dni.equalsIgnoreCase(empleado.getDni())) {
							throw new ExcepcionDniRepetido();	
						}
					}
				datoOk = true;
			} catch (ExcepcionDniRepetido e) {
				dni = "";
				datoOk = false;
				System.out.println(e);
			}
		}
		return dni;
	}

}
