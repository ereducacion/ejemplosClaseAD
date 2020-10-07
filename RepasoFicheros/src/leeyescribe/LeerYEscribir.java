package leeyescribe;

import escritura.Escribir;
import lectura.Leer;

public class LeerYEscribir {

	public static void main(String[] args) {
		
		Leer l = new Leer();
		Escribir e = new Escribir();
		
		String texto = l.leeFichero("saludo.txt");
		e.escribre(texto, "ficheroSalida.txt");
	}
}
