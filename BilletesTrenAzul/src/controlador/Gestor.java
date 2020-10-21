/**
 * 
 */
package controlador;

import datos.*;


import java.util.ArrayList;
import java.util.Date;

/**
 * @author Eva Royo
 *
 */
public class Gestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// estructura de datos para el programa
		ArrayList<Billete> listaBilletes = new ArrayList<Billete>();
		ArrayList<Tren> listaTrenes = new ArrayList<Tren>();
		
		// generar los trenes necesarios
		for (int i = 0; i < 4; i++) {
			Tren mitren = new Tren(i, "Zaragoza Delicias", "Madrid Atocha", new Date(50, 10, i));
			mitren.agnadeVagon(elvagon)
			listaTrenes.add(mitren);
		}
		
		// mostrar el menú
		int opcion= 1;
		
		switch (opcion) {
		case 0: // salir
			System.out.println("SALGO DE LA APLICACION");
			return;
		case 1: // comprar billete
			listaBilletes.add(creaBillete());
			break;
		case 2: // anular billete
			
			break;

		case 3: // listar billetes por numero de billete
			
			break;

		case 4: // listar billetes por fecha
			
			break;

		case 5: // lisar billetes por tren con los vagones
			
			break;

		default:
			break;
		}

	}

}
