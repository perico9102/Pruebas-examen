package main;

import java.util.Scanner;

public class Empresa {

	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		boolean fin = false;
		
		while(!false) {
			System.out.println("Introduce lo que quieras hacer (AÑADIR UN EMPLEADO = 1, MODIFICAR LA"
					+ " CIFRA DE VENTAS = 2, MOSTRAR LA LISTA = 3, INDICAR EMPLEADO DEL MES = 4, SALIR = 5	)");
			int respuesta = Integer.parseInt(sc.nextLine());
			switch (respuesta) {
				case 1: {
					
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
					
					break;
				}
				case 5: {
					fin = true;
					System.out.println("Saliendo del programa....");
				}
			}
			
			
		}

	}

}
