package aleatorios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Aqu� se van a almacenar los contactos y los guardaremos en un fichero
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
	 * Escribir una persona en mi agenda en la posici�n indicada
	 * @param registro
	 * @param pos
	 * @throws IOException
	 */
	public void escribir (Persona registro, int pos) throws IOException {
		if (fichero != null) {
			
			// posiciono el puntero en el sitio que quiero ...
			fichero.seek(calculaposicion(pos));
			
			this.escribir(registro);
		}
	}
	
	/**
	 * Escribir una persona en la posici�n en la que actualmente est� el cursor 
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
			// el nombre de una persona tendr� hasta 32 car�cteres
			int dimensionNombre = 32;
			buffer.setLength(dimensionNombre);
			
			fichero.writeChars(buffer.toString());
			fichero.writeInt(registro.getEdad());
		}
		
	}
	
	/**
	 * Leer del fichero la persona que se encuentra en la posici�n actual del cursor
	 * y devuelve null cuando ha llegado al final
	 * @return
	 */
	public Persona leer() {
		
		Persona registro = null;
		// HE DECIDIDO que el nombre de una persona tendr� hasta 32 car�cteres
		int dimensionNombre = 32;
		
		if (fichero != null) {
			try {
				registro = new Persona();
				
				// leo car�cter a car�cter el nombre
				char campo[] = new char[dimensionNombre];
				for (int i = 0; i < dimensionNombre; i++) {
					campo[i] = fichero.readChar();
				}			
				registro.setNombre(new String(campo).replace('\0', ' '));
				
				registro.setEdad(fichero.readInt());		
			} catch (Exception e) {
				// entrar� aqu� cuando haya llegado al final del fichero
				registro = null;
			}
		}
		
		return registro;
	}
	
	/**
	 * Leer del fichero un registro cualquiera, el par�metro indica la posici�n
	 * del registro
	 * @param pos
	 * @return
	 * @throws IOException
	 */
	public Persona leer (int pos) throws IOException {
		
		if (fichero != null) {
			fichero.seek(calculaposicion(pos));
		}
		
		return this.leer();
	}

	/**
	 * @param pos
	 * @return
	 */
	private int calculaposicion(int pos) {
		return (pos-1)* TAMAGNOREGISTRO;
	}
	
	/**
	 * Posiciona el cursor al inico de los contactos
	 * @throws IOException
	 */
	public void iniciar() throws IOException  {			
			fichero.seek(0);	
	}
	
	
}
