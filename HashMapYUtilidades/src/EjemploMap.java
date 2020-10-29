import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class EjemploMap {

	public static void main(String[] args) {
		
		Map<String, Integer> mapaDeNombres  = new TreeMap<String, Integer>();
		
		String nombre;
		Integer nota;
		
		nombre = Leer.pedirCadena("Nombre");
		while(!nombre.equals("fin")){ 
			nota=Leer.pedirEntero("Nota:");
			mapaDeNombres.put(nombre, nota);
			nombre = Leer.pedirCadena("Nombre");
		}
		
		
		// escribir el mapa de los nombres y sus notas
		Leer.mostrarEnPantalla("Map de alumnos y notas");
		for (Entry<String, Integer> e : mapaDeNombres.entrySet()) {
			Leer.mostrarEnPantalla("Alumno : " + e.getKey() + " nota " + e.getValue());
		}

	}
}
