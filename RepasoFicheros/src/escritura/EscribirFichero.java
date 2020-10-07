package escritura;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFichero {

	public static void main(String[] args) {
		
		
		File mifichero = new File ("nuevo.txt");
		
		try {
			//mifichero.createNewFile();
			FileWriter escritor = new FileWriter(mifichero, true);
			
			System.out.println("que quieres escribir?");
			Scanner sc = new Scanner(System.in);
			String linea= sc.nextLine();
			
			escritor.append(linea);
			escritor.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
