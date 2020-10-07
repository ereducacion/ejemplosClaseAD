import java.util.ArrayList;

public class ProbandoArrayList3 {

	
	
	public static void main(String[] args) {
		
		ArrayList<Persona> listaClase = new ArrayList<Persona>();

		Persona p1 =  new Persona(21, "Juan");
		listaClase.add(p1); //0
		listaClase.add(new Persona(22, "María")); //1
		listaClase.add(new Persona(21, "Pili")); //2
		listaClase.add(new Persona(23, "Pedro")); //3
		listaClase.add(new Persona(23, "Yahir")); //4
		listaClase.add(new Persona(21, "Pili")); //5

		int persona1 = 2;
		int persona2 = 5;
		
		if (listaClase.get(persona1).equals(listaClase.get(persona2))) {
			System.out.println("son iguales");
		} else {
			System.out.println("no son iguales " + listaClase.get(persona1) + " y " + listaClase.get(persona2));
		}
		
		
	}
}
