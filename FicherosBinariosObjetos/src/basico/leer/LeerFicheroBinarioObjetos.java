package basico.leer;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import datos.Persona;

public class LeerFicheroBinarioObjetos {

	public static void main(String[] args) {
		
		HashMap<String, Persona> listaPersonas = new HashMap<String, Persona>();
		File ficheroPersonas = new File("PersonasBasico.dat");
		
		try {
			//abro el fichero para escribir en él
			FileInputStream streamFichero = new FileInputStream(ficheroPersonas);
			ObjectInputStream lectorDeObjetosFichero = new ObjectInputStream(streamFichero);
			
			Persona p = (Persona)lectorDeObjetosFichero.readObject(); // leyendo una persona
			System.out.println(p);
			try {
				while (true) {
					p = (Persona)lectorDeObjetosFichero.readObject();
					System.out.println(p);
				}
			} catch (EOFException e) {
				System.out.println("llegue al final del fichero");
			}
			
			lectorDeObjetosFichero.close();
			streamFichero.close();
					
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada salida");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No hay este tipo de clase en el fichero");
			e.printStackTrace();
		}
		
	}

	
}
