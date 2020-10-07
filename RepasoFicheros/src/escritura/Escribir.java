package escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir {
	
	public Escribir() {
		
	}
	
	public void escribre(String texto, String fichero) {

		File mifichero = new File(fichero);
		
		try {
			FileWriter escritor=new FileWriter(mifichero); 
			BufferedWriter br=new BufferedWriter(escritor);
			
			br.write(texto);
			//br.newLine();
			br.close();  


		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("No se encontro el archivo");
		}
	}

}
