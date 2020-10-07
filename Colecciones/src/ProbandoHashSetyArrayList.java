import java.util.ArrayList;
import java.util.HashSet;

public class ProbandoHashSetyArrayList {

	
	
	public static void main(String[] args) {
		
		ArrayList<Persona> listaClase = new ArrayList<Persona>();

		Persona p0 = new Persona(21, "Juan"); //0
		Persona p1 = new Persona(22, "María"); //1
		Persona p2 = new Persona(21, "Pili"); //2
		Persona p3 = new Persona(23, "Pedro"); //3
		Persona p4 = new Persona(23, "Yahir"); //4
		Persona p5 = new Persona(21, "Pili"); //5
		Persona p6 = new Persona(21, "Pili"); //6
		Persona p7 = new Persona(21, "Pili"); //7
		Persona p8 = new Persona(21, "Pili"); //8
		Persona p9 = new Persona(21, "Pili"); //9
		Persona p10 = new Persona(21, "Juan"); //10
		Persona p11 = new Persona(21, "Juan"); //11
		Persona p12 = new Persona(21, "Juan"); //12
		Persona p13 = new Persona(21, "Juan"); //13
		
		listaClase.add(p0); //0
		listaClase.add(p1); //1
		listaClase.add(p2); //2
		listaClase.add(p3); //3
		listaClase.add(p4); //4
		listaClase.add(p5); //5
		listaClase.add(p6); //6
		listaClase.add(p7); //7
		listaClase.add(p8); //8
		listaClase.add(p9); //9
		listaClase.add(p10); //10
		listaClase.add(p11); //11
		listaClase.add(p12); //12
		listaClase.add(p13); //13
		
		//si no tiene implementado el overwrite de toString....
		System.out.println("Imprimer los punteros =" +  listaClase);
		
		// Es diferente si se ha implementado en Persona hashcode y equals
		// saber si está en la lista de clase una persona:
		if (listaClase.contains(p11)) System.out.println("está en la lista");
		
		
		//TRABAJANDO CON CONJUNTOS
		// Es diferente si se ha implementado en Persona hashcode y equals
		HashSet<Persona> conjuntoPersonas = new HashSet<Persona>();
		
		for (Persona persona : listaClase) {
			conjuntoPersonas.add(persona);
		}
		System.out.println("Imprimer los punteros =" + conjuntoPersonas);
		conjuntoPersonas.forEach(persona -> System.out.println("Recorrido lamda " + persona.getNombre()));
		
		if (conjuntoPersonas.contains(p11)) System.out.println("está en el conjunto");
	}
}
