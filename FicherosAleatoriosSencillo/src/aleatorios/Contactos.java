package aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Aquí se van a almacenar los contactos y los guardaremos en un fichero
 * @author Eva Royo
 *
 */
public class Contactos {
	
	public final static int TAMAGNOREGISTRO = 68; // 64 bytes para almacenar el nombre y 4 para almacenar el entero de edad

	private RandomAccessFile fichero;
	private String nomFichero;
	
	
	/**
	 * @param fichero
	 */
	public Contactos(String nomfichero) {
		this.nomFichero = nomfichero;
	}

	/**
	 * Abrir el fichero con los contactos para leer y escribir
	 * @throws FileNotFoundException
	 */
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile(nomFichero, "rw");
	}
	
	/**
	 * Cerrar el fichero de los contactos
	 * @throws IOException
	 */
	public void cerrar() throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}
	
	/**
	 * Escribir una persona en mi agenda en la posición indicada
	 * @param registro
	 * @param pos
	 * @throws IOException
	 */
	public void escribir (Persona registro, int pos) throws IOException {
		if (fichero != null) {
			
			// posiciono el puntero en el sitio que quiero ...
			fichero.seek((pos-1) * TAMAGNOREGISTRO);
			
			this.escribir(registro);
		}
	}
	
	/**
	 * Escribir una persona en la posición en la que actualmente esté el cursor 
	 * @param registro
	 * @throws IOException
	 */
	public void escribir (Persona registro) throws IOException {
		if (fichero != null) {

			// PARA ESCRIBIR UNA CADENA
			// primero escribo las cosas en un buffer
			StringBuffer buffer= new StringBuffer();
			if (registro.getNombre() != null) {
				buffer.append(registro.getNombre());
			}
			// el buffer tiene 32 bytes porque he DECIDIDO que 
			// el nombre de una persona tendrá hasta 32 carácteres
			int dimensionNombre = 32;
			buffer.setLength(dimensionNombre);
			
			fichero.writeChars(buffer.toString());
			fichero.writeInt(registro.getEdad());
		}
		
	}
	
	/**
	 * Leer del fichero la persona que se encuentra en la posición actual del cursor
	 * actual del cursos
	 * @return
	 */
	public Persona leer() {
		
		Persona registro = null;
		// HE DECIDIDO que el nombre de una persona tendrá hasta 32 carácteres
		int dimensionNombre = 32;
		
		if (fichero != null) {
			try {
				registro = new Persona();
				
				// leo carácter a carácter el nombre
				char campo[] = new char[dimensionNombre];
				for (int i = 0; i < dimensionNombre; i++) {
					campo[i] = fichero.readChar();
				}
				
				registro.setNombre(new String(campo).replace('\0', ' '));
				registro.setEdad(fichero.readInt());		
			} catch (Exception e) {
				// entrará aquí cuando haya llegado al final del fichero
				registro = null;
			}
		}
		
		return registro;
	}
	
	/**
	 * Leer del fichero un registro cualquiera, el parámetro indica la posición
	 * del registro
	 * @param pos
	 * @return
	 * @throws IOException
	 */
	public Persona leer (int pos) throws IOException {
		
		if (fichero != null) {
			fichero.seek((pos-1)* TAMAGNOREGISTRO);
		}
		
		return this.leer();
	}
	
	
}
