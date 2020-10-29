package aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		Persona contacto1 = new Persona(21, "Pili");
		Persona contacto2 = new Persona(23, "Juan");
		Persona contacto3 = new Persona(20, "Yahir");
		Contactos agenda = new Contactos("MiAgenda.dat");
		
		try {
			agenda.abrir();
			agenda.escribir(contacto1,1);
			agenda.escribir(contacto2,2);
			agenda.escribir(contacto3,3);
		} catch (FileNotFoundException e) {
			System.out.println("Error, fichero no econtrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error, de escritura");
			e.printStackTrace();
		}
		
		try {
			System.out.println("Leo los registros a mano");
			System.out.println(agenda.leer(3));
			System.out.println(agenda.leer(1));
			System.out.println(agenda.leer(2));
		} catch (IOException e) {
			System.out.println("Error, de lectura");
			e.printStackTrace();
		}
		
		// ahora leo toda la agenda
		Principal tmp = new Principal();
		tmp.leerTodo(agenda);
		
	}
	
	/**
	 * leer todos los registros dentro del fichero.
	 *  Necesitarás implementar un método en la clase contactos que lo que haga
	 *   sea posicionar al pricipio de la agenda el cursor.
	 *   
	 * @param fichero
	 */
	public void leerTodo(Contactos agenda) {
		
		System.out.println("Leer todos los registros");
		try {
			agenda.iniciar();
			
			Persona p = agenda.leer();
			while (p != null) {
				System.out.println(p);
				p = agenda.leer();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
