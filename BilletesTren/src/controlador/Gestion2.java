package controlador;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import datos.*;

/**
 * Clase para gestionar una empresa (tipo ADIF) que gestiona trenes y la
 * compra venta de billetes
 * @author Eva Royo
 *
 */
public class Gestion2 {

	private static final int PRECIOBILLETE = 50;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Gestion2 gestion = new Gestion2();
		
		// tengo dos listas duplicadas, puede ser redundante...más control...
		// OTRA OPCIÓN DE CODIFICACIÓN MÁS EFICAZ, SIN REPETIR ESTRUCTURAS?!
		HashMap<Integer, Billete> billetesPorNumero = new HashMap<Integer, Billete>();
		List<Billete> listaBilletes = new ArrayList<Billete>();
		
		int numBillete = 100;
			
		// genero los trenes
		ArrayList<Tren> trenes = new ArrayList<Tren>();
		gestion.generaTrenes(trenes);
		
		// comprar billete --> elegir día, tren, asiento (mostrar los libres)
		int menu = 0;
		boolean salir = false;
		while (!salir) {
			// muestro el menú al usuario
			gestion.muestraMenu();
			try {
				menu = sc.nextInt();
				sc.nextLine();
				if (menu ==0) {
					salir = true;
				} else {
					switch (menu) {
					case 1: // Comprar un billete
						
						numBillete = numBillete +1;
						
						// elijo el número de tren
						int numTren = gestion.muestraTrenesyFechas(trenes);
						if (numTren == 0) break;
						
						// elijo el número de vagon dentro del tren
						int numVagon = gestion.muestraAsientosLibresYEligeVagon(trenes.get(numTren-1));
						if (numVagon == 0) break;
						
						// elijo el asiento dentro del vagón
						int asiento = gestion.eligeAsientoLibreEnVagon(trenes.get(numTren-1).getVagones().get(numVagon-1));
						if (asiento == 0) break;
						
						// CREO el billete y lo añado
						Billete bil = gestion.comprarBillete(numBillete, trenes.get(numTren-1), numVagon-1, asiento);
						listaBilletes.add(bil);		
						billetesPorNumero.put(numBillete, bil);
						break;
					case 2: // Anular un billete
						
						// primero preguntar el número de billete que se quiere anular
						int numeroBilleteAnular = gestion.eligeBilleteAAnular(billetesPorNumero);
						if (numeroBilleteAnular == 0) break;
						
						// liberar el asiento correspondiente del vagón
						Billete billeteAnular = billetesPorNumero.get(numeroBilleteAnular);
						billeteAnular.getVagon().liberaBillete(billeteAnular.getAsiento());
						billetesPorNumero.remove(numeroBilleteAnular);
						
						// eliminarlo de las listas
						for (int i = 0; i < listaBilletes.size(); i++) {
							if (listaBilletes.get(i).getNumero() == numeroBilleteAnular) {
								listaBilletes.remove(i);
							}
						}
						billetesPorNumero.remove(numeroBilleteAnular);
						break;
					case 3: // mostar billetes por número de billete
						listaBilletes.sort(Billete::comparaPorNumBillete);
						listaBilletes.forEach(elbillete -> System.out.println(elbillete));
						break;
					case 4: // mostrar billetes por fecha
						listaBilletes.sort(Billete::comparaPorFecha);
						listaBilletes.forEach(elbillete -> System.out.println(elbillete));
						break;
					case 5: // mostrar billetes vendidos de un tren 
						for (Tren tren : trenes) {
							System.out.print("En el tren " + tren.getNumero() + ":\n");
							gestion.muestraBilletesTren(tren);
						}
						break;

					default:
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("No ha introducido un número, inténtelo de nuevo");
				sc.nextLine();
			}
		}
				
	}

	/**
	 * Genera los trenes de forma manual
	 * @param trenes
	 */
	private void generaTrenes(ArrayList<Tren> trenes) {
		
		Tren tren1 = new Tren(1,LocalDateTime.of(2020, 10, 5, 10, 30),"Zaragoza", "Atocha");
		Tren tren2 = new Tren(2,LocalDateTime.of(2020, 11, 8, 9, 35),"Zaragoza", "Barcelona Sants");
		Tren tren3 = new Tren(3,LocalDateTime.of(2020, 12, 20, 16, 40),"Zaragoza", "Sevilla");
		
		// añadimos inicialmente 1 vagón a cada tren
		tren1.agnadeVagon(new Vagon(1));
		tren2.agnadeVagon(new Vagon(1));
		tren3.agnadeVagon(new Vagon(1));

		trenes.add(tren1);
		trenes.add(tren2);
		trenes.add(tren3);
	}

	/**
	 * Muestra los billetes comprados del tren que se pasa como parámetro
	 * @param tren
	 * @return
	 */
	private void muestraBilletesTren(Tren tren) {
		
		tren.getVagones().forEach(vagon -> System.out.println("\t" + vagon.toString() + " billetes vendidos= " + vagon.billetesVendidos()));

	}

	/**
	 * Elige el número de billete que quiere anular
	 * @param losBilletes 
	 * @return el número de billete que va a anularse, 0 si quiere salir del menú
	 */
	private int eligeBilleteAAnular(HashMap<Integer, Billete> losBilletes) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println("Introduzca un número de billete para ANULAR: (0 para salir)");
	
		int numeroBillete = 0;
		while (!salir) {
			try {
				numeroBillete = sc.nextInt();
				sc.nextLine();
				if (numeroBillete == 0 || losBilletes.containsKey(numeroBillete)) {
					salir = true;
				} else {
					System.out.println("El número de billete introducido no existe, inténtelo de nuevo");
				}
				
			} catch (Exception e) {
				System.out.println("No ha introducido un número, inténtelo de nuevo");
				sc.nextLine();
			}
		}
		return numeroBillete;
		
	}

	/**
	 * Muestra los trenes y las fechas en las que salen, y se elige un tren
	 * @param trenes
	 * @return el número de tren elegido, o 0 en caso de que desee salir
	 */
	private int muestraTrenesyFechas(ArrayList<Tren> trenes) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int eleccionTren = 0;
		boolean salir = false;
		System.out.println("Elija uno de los trenes: (introduzca 0 para salir)");
		for (Tren tren : trenes) {
			System.out.println(tren);
		}
		while (!salir) {
			try {
				eleccionTren = sc.nextInt();
				sc.nextLine();
				if (eleccionTren > 0 && eleccionTren <= trenes.size()) {
					// la elección es correcta
					return eleccionTren;
				} else if (eleccionTren ==0) {
					salir = true;
				} else {
					System.out.println("La elección no es correcta");
				}
			} catch (Exception e) {
				System.out.println("No ha introducido un número");
				sc.nextLine();
			}
		}
		return eleccionTren;
	}

	/**
	 * Muestra el menú de la aplicación por pantalla
	 */
	private void muestraMenu() {
		System.out.println("===========================");
		System.out.println("COMPRA/VENTA BILLETES TREN");
		System.out.println("===========================");
		
		System.out.println("Elija una opción:");
		System.out.println("1: Comprar un billete de tren");
		System.out.println("2: Anular un billete de tren");
		System.out.println("3: Listar los billetes por número de billete");
		System.out.println("4: Listar los billetes por fecha");
		System.out.println("5: Listar los asientos vendidos de un tren");
		System.out.println("0: SALIR");
	}

	/**
	 * Comprar un billete dentro de un tren elegido, en un vagón elegido, en un asiento elegido.
	 * La fecha y hora del billete corresponde con la fecha y hora del tren
	 * @param numBillete
	 * @param tren
	 * @param numeroVagon
	 * @param asiento
	 * @return el billete creado
	 */
	private Billete comprarBillete(int numBillete, Tren tren, int numeroVagon, int asiento) {
		
		Billete bil = new Billete(numBillete, tren.getHoraSalida(), tren, tren.getVagones().get(numeroVagon), PRECIOBILLETE, asiento);
		// muestra los asientos libres del vagón del tren actual
		tren.getVagones().get(numeroVagon).asignaBillete(numBillete, asiento);
		return bil;
	}

	/**
	 * Muestra los vagones libres en pantalla y pide al usuario que elija uno. 
	 * Incluye el control para asegurar que lo que ha elegido es correcto, en otro caso devuelve 0
	 * @param elvagon
	 * @return 0 si quiere salir del menú o algo ha salido mal, sino devuelve el número de asiento libre
	 */
	private int eligeAsientoLibreEnVagon(Vagon elvagon) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
			
		int eleccionAsiento = 0;

		System.out.println("Elija un asiento dentro del vagón " + elvagon.getNumero()
		+ " por favor: (introduzca 0 para salir)");

		boolean salir = false;
		while (!salir) {
			try {
				eleccionAsiento = sc.nextInt();
				sc.nextLine();
				if (eleccionAsiento > 0 && elvagon.asientoLibre(eleccionAsiento)) {
					// la elección es correcta
					return eleccionAsiento;
				} else if (eleccionAsiento ==0) {
					salir = true;
				} else {
					System.out.println("La elección no es correcta");
				}
			} catch (Exception e) {
				System.out.println("No ha introducido un número, inténtelo de nuevo");
				sc.nextLine();
			}
		}
		return eleccionAsiento;
	}
	
	/**
	 * Muestra los vagones y sus asientos libres en pantalla y pide al usuario que elija un vagón. 
	 * Si un vagón está lleno, se añade otro vagón al tren.
	 * Incluye el control para asegurar que lo que ha elegido es correcto, en otro caso devuelve 0
	 * @param tren
	 * @return 0 si quiere salir del menú o algo ha salido mal, sino el índice para acceder al número del vagón elegido
	 */
	private int muestraAsientosLibresYEligeVagon(Tren tren) {
		// muestra los vagoles libres en pantalla
		// primero muestra los asientos que han sido cancelados
		ArrayList<Vagon> listVag = tren.getVagones();
		
		// comprobar si el vagón ya no tiene más asientos libres, si es así, añadir un vagón al tren.
		if (tren.lleno()) {
			Vagon elvagon = new Vagon(tren.getVagones().size()+1); // le damos el siguiente número de vagón dentro del tren 
			tren.agnadeVagon(elvagon);
		}
		
		// mostrar los asientos libres en los vagones
		for (Vagon vagon : listVag) {
			System.out.println("El vagón " + vagon.getNumero() + " tiene libres los asientos: " + vagon.asientosLibres());
		}
		
		Scanner sc = new Scanner(System.in);
		int eleccionVagon = 0;
		boolean salir = false;
		
		System.out.println("Seleccione el vagón, por favor: (0 para salir)");
		while (!salir) {
			try {
				eleccionVagon = sc.nextInt();
				sc.nextLine();
				if (eleccionVagon > 0 && eleccionVagon <= tren.getVagones().size()) {
					// el vagon elegido es el correcto y me voy 
					salir = true;
				} else if (eleccionVagon ==0) {
					return 0;
				} else {
					System.out.println("La elección no es correcta");
				}
			} catch (Exception e) {
				System.out.println("No ha introducido un número");
				sc.nextLine();
			}
		}
		
		return eleccionVagon; 
	}
}
