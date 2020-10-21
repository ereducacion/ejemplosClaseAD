package aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		Registro contacto1 = new Registro(21, "Pili");
		Registro contacto2 = new Registro(23, "Juan");
		Registro contacto3 = new Registro(20, "Yahir");
		Contactos agenda;
		
		agenda = new Contactos();
		
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
