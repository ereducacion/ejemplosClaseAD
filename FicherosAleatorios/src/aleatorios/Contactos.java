package aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Fichero de acceso aleatorio
 * @author Eva Royo
 *
 */
public class Contactos {

	private RandomAccessFile fichero;
	
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile("Clientes.dat", "rw");
	}
	
	public void cerrar () throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}
	
	public void escribir(Registro registro) throws IOException {
		if (fichero != null) {
			registro.write(fichero);
		}
	}
	
	/**
	 * 
	 * @param registro
	 * @param pos
	 * @throws IOException
	 */
	public void escribir (Registro registro, int pos) throws IOException {
		if (fichero != null) {
			// posiciono el puntero en el sitio que quiero ...
			fichero.seek((pos-1) * Registro.DIM);
			escribir(registro);
		}
	}
	
	/**
	 * Leer del fichero el registro que se encuentra en la posición
	 * actual del cursos
	 * @return
	 */
	public Registro leer() {
		
		Registro registro = null;
		
		if (fichero != null) {
			try {
				registro = new Registro();
				registro.read(fichero);
			} catch (Exception e) {
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
	public Registro leer (int pos) throws IOException {
		
		if (fichero != null) {
			fichero.seek((pos-1)*Registro.DIM);
		}
		
		return leer();
	}
	
	
}
