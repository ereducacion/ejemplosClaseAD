package conhashmap.escribir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import datos.Persona;

/**
 * Escribir objetos Persona en un fichero
 * ES IMPORTANTE QUE EL OBJETO QUE VAYAMOS A METER EN EL FICHERO EXTIENDA DE LA INTERFAZ {@link Serializable}
 * 
 * @author Eva Royo
 *
 */
public class EscribirFicheroBinarioObjetos {

	public static void main(String[] args) {
		
		// las personas la tengo en un hasmap, cuya clave es el nombre de la persona
		HashMap<String, Persona> listaPersonas = new HashMap<String, Persona>();
		
		File ficheroPersonas = new File("Personas.dat");
		
		FileOutputStream streamFichero;
		try {
			//abro el fichero para escribir en él (se borrará el contenido anterior)
			streamFichero = new FileOutputStream(ficheroPersonas);
			ObjectOutputStream escritorDeObjetosFichero = new ObjectOutputStream(streamFichero);
			
			listaPersonas = creaPersonas(10);
			
			for (Entry<String, Persona> laPareja : listaPersonas.entrySet() ) {
				escritorDeObjetosFichero.writeObject((Persona)laPareja.getValue());
			}
			escritorDeObjetosFichero.close();
			streamFichero.close();

		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada salida");
			e.printStackTrace();
		}
		
	}

	private static HashMap<String, Persona> creaPersonas(int cantidad) {
		
		HashMap<String, Persona> lalista = new HashMap<String, Persona>();
		
		for (int j = 0; j < cantidad; j++) {
			Persona p = new Persona(21+j, "Persona" + j);
			lalista.put(p.getNombre(), p);
		}
		return lalista;
	}
	
}
