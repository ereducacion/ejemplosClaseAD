package lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lee los datos de un fichero de texto y devuelve un string
 * 
 * @author Eva Royo
 *
 */
public class Leer {

	public Leer () {
		
	}
	
	public String leeFichero (String nombreFichero) {		

		File mifichero = new File (nombreFichero);
		String texto = "";
		try {
			FileReader lector = new FileReader(mifichero);
			
			// ahora voy a leer utilizando un buffer
			BufferedReader cestaTemporal = new BufferedReader(lector);
			
			String linea = cestaTemporal.readLine();
			while (linea != null) {
				texto = texto + linea;
				linea = cestaTemporal.readLine();
			}
			
			cestaTemporal.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return texto;		
	}
}
