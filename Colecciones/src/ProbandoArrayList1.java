import java.util.ArrayList;
import java.util.Collections;

public class ProbandoArrayList1 {
	
	public static void main(String[] args) {
		
		ArrayList<String> listaClase = new ArrayList<String>();
		
		listaClase.add("Juan"); //0
		listaClase.add("Pedro"); //1
		listaClase.add("Pili"); //2
		listaClase.add("María"); //3
		listaClase.add("Pili");//4
		listaClase.add("Yahir"); //5
		
		System.out.println(listaClase.indexOf("Pili"));
		
		listaClase.set (1, "Pedrito");
		System.out.println(listaClase);
		
		
		for (String nombre : listaClase) {
			System.out.println("El nombre es:" + nombre);
		}
		

		// ORDENAR LA LISTA DE CLASE
		listaClase.sort(null);
		System.out.println(listaClase);
		
		listaClase.sort(Collections.reverseOrder());
		System.out.println(listaClase);
			
	}

}
