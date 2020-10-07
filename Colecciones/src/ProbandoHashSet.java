import java.util.HashSet;

public class ProbandoHashSet {

	
	
	public static void main(String[] args) {
		
		HashSet<Persona> cjtoClase = new HashSet<Persona>();

		cjtoClase.add(new Persona(21, "Juan")); //0
		cjtoClase.add(new Persona(22, "María")); //1
		cjtoClase.add(new Persona(21, "Pili")); //2
		cjtoClase.add(new Persona(23, "Pedro")); //3
		cjtoClase.add(new Persona(23, "Yahir")); //4
		cjtoClase.add(new Persona(21, "Pili")); //5
		cjtoClase.add(new Persona(21, "Pili")); //6
		cjtoClase.add(new Persona(21, "Pili")); //7
		cjtoClase.add(new Persona(21, "Pili")); //8
		cjtoClase.add(new Persona(21, "Pili")); //9
		cjtoClase.add(new Persona(21, "Juan")); //10
		cjtoClase.add(new Persona(21, "Juan")); //11
		cjtoClase.add(new Persona(21, "Juan")); //12
		cjtoClase.add(new Persona(21, "Juan")); //13

		// Es diferente si se ha implementado en Persona hashcode y equals
		System.out.println(cjtoClase.size());
		
		// saber si está en la lista de clase una persona:
		if (cjtoClase.contains(new Persona(21, "Pili"))) System.out.println("está");
	}
}
