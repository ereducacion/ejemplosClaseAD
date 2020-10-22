package aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		Persona contacto1 = new Persona(21, "Pili");
		Persona contacto2 = new Persona(23, "Juan");
		Persona contacto3 = new Persona(20, "Yahir");
		Contactos agenda;
		
		agenda = new Contactos("MiAgenda.dat");
		
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
			System.out.println(agenda.leer(3));
		} catch (IOException e) {
			System.out.println("Error, de lectura");
			e.printStackTrace();
		}
	}
}
