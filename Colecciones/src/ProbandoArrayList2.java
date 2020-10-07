import java.util.ArrayList;
import java.util.Iterator;

public class ProbandoArrayList2 {

	
	
	public static void main(String[] args) {
		
		ArrayList<Persona> listaClase = new ArrayList<Persona>();

		Persona p1 =  new Persona(21, "Juan");
		listaClase.add(p1);
		listaClase.add(new Persona(22, "María"));
		listaClase.add(new Persona(21, "Pili"));
		listaClase.add(new Persona(23, "Pedro"));
		listaClase.add(new Persona(23, "Yahir"));

		System.out.println(listaClase);

		Iterator<Persona> iterarClase =  listaClase.iterator();
		while (iterarClase.hasNext()) {
			Persona personica = (Persona) iterarClase.next();
			System.out.println(personica.getNombre());
		}
		
	}
}
