package basico.escribir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.FieldPosition;
import java.util.HashMap;
import java.util.Map;
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
		
		File ficheroPersonas = new File("PersonasBasico.dat");
		
		FileOutputStream streamFichero;
		try {
			//abro el fichero para escribir en él
			streamFichero = new FileOutputStream(ficheroPersonas);
			ObjectOutputStream escritorDeObjetosFichero = new ObjectOutputStream(streamFichero);
			
			Persona p0 = new Persona(21, "Juan"); //0
			Persona p1 = new Persona(22, "María"); //1
			Persona p2 = new Persona(21, "Pili"); //2
			Persona p3 = new Persona(23, "Pedro"); //3
			Persona p4 = new Persona(23, "Yahir"); //4
			Persona p5 = new Persona(21, "Pili"); //5
			
			escritorDeObjetosFichero.writeObject((Persona)p0);
			escritorDeObjetosFichero.writeObject((Persona)p1);
			escritorDeObjetosFichero.writeObject((Persona)p2);
			escritorDeObjetosFichero.writeObject((Persona)p3);
			escritorDeObjetosFichero.writeObject((Persona)p4);
			escritorDeObjetosFichero.writeObject((Persona)p5);

		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada salida");
			e.printStackTrace();
		}
		
	}
	
}
