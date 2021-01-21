package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {

	/**
	 * Pregunta al usuario por algo y recoge lo que ha introducido en una línea interpretándolo como
	 * una cadena, si no introduce una cadena válida vuelve a preguntar al usuario.
	 * @param mensaje	El mensaje que se muestra al usuario
	 * @return	la cadena introducida
	 */
	public static String preguntaPorCadena(String mensaje) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println(mensaje);
		String cadena = null;
	
		while (!salir) {
			try {
				cadena = sc.nextLine();
				salir = true;
			} catch (Exception e) {
				System.err.println("Error al introducir la cadena, repita por favor");
			}
		}
		return cadena;
		
	}

	/**
	 * Pregunta al usuario por algo y recoge lo que ha introducido en una línea interpretándolo como
	 * una cadena, si no introduce una cadena válida vuelve a preguntar al usuario un número de veces.
	 * @param mensaje	El mensaje que se muestra al usuario
	 * @return	la cadena introducida, null en caso de que supere la cantidad de intentos
	 */
	public static String preguntaPorCadena(String mensaje, int intentos) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println(mensaje);
		String cadena = null;
	
		int contador=0;
		while (!salir && contador < intentos) {
			try {
				cadena = sc.nextLine();
				salir = true;
			} catch (Exception e) {
				System.err.println("Error al introducir la cadena, repita por favor");
			}
			contador++;
		}
		return cadena;
		
	}
	
	/**
	 * Pregunta al usuario por algo y recoge lo que ha introducido en una línea interpretándolo como
	 * un entero, si no introduce un entero vuelve a preguntar al usuario.
	 * @param mensaje	El mensaje que se muestra al usuario
	 * @return	el valor entero introducido
	 */
	public static int preguntaPorEntero(String mensaje) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println(mensaje);
		int entero = -1;
	
		while (!salir) {
			try {
				entero = Integer.parseInt(sc.nextLine());
				salir = true;
			} catch (Exception e) {
				System.err.println("Error al introducir el entero, repita por favor");
			}
		}
		return entero;
		
	}
	
	/**
	 * Pregunta al usuario por algo y recoge lo que ha introducido en una línea interpretándolo como
	 * un entero, si no introduce un entero vuelve a preguntar al usuario un número determinado de intentos.
	 * @param mensaje	El mensaje que se muestra al usuario
	 * @return	el valor entero introducido, -1 si supera el número de intentos
	 */
	public static int preguntaPorEntero(String mensaje, int intentos) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println(mensaje);
		int entero = -1;
	
		int contador = 0;
		while (!salir && contador < intentos) {
			try {
				entero = Integer.parseInt(sc.nextLine());
				salir = true;
			} catch (Exception e) {
				System.err.println("Error al introducir el entero, repita por favor");
			}
			contador++;
		}
		return entero;
		
	}
	
	/**
	 * Pregunta al usuario por algo y recoge lo que ha introducido en una línea interpretándolo como
	 * un número flotante (float), si no introduce un flotante vuelve a preguntar al usuario.
	 * @param mensaje	El mensaje que se muestra al usuario
	 * @return	el valor flotante introducido
	 */
	public static float preguntaPorFlotante(String mensaje) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println(mensaje);
		float real = -1;
	
		while (!salir) {
			try {
				real = Float.parseFloat(sc.nextLine());
				salir = true;
			} catch (Exception e) {
				System.err.println("Error al introducir el entero, repita por favor");
			}
		}
		return real;
		
	}

	/**
	 * Pregunta al usuario por algo y recoge lo que ha introducido en una línea interpretándolo como
	 * una fecha con el formato indicado, si no introduce un flotante vuelve a preguntar al usuario.
	 * @param mensaje	El mensaje que se muestra al usuario
	 * @param formato	Formato que tendrá la fecha equivalente a {@link} 
	 * @return	la fecha con formato Date
	 */
	public static Date preguntaPorFecha(String mensaje, String formato) {
		
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println(mensaje + ";Formato:" + formato);
	
		SimpleDateFormat creaFecha = new SimpleDateFormat(formato);
		Date fecha = null;
		while (!salir) {
			try {
				fecha = creaFecha.parse(sc.nextLine());
				salir = true;
			} catch (ParseException e) {
				System.out.println("Error al convertir la fecha, repita por favor");
			} catch (Exception e) {
				System.err.println("Error al introducir la fecha, repita por favor");
			}
		}
		return fecha;
		
	}

}
