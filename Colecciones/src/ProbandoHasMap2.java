import java.util.HashMap;
import java.util.Map;

public class ProbandoHasMap2 {

	public static void main(String[] args) {
	    
		HashMap<Integer, String> mapa = new HashMap<Integer, String>();
	    mapa.put(29147887, "Ana Rosa");
	    mapa.put(98665214, "Jose Miguel");
	    
	    String nombre = mapa.get(29147887);
	    
	    System.out.println(nombre);
	    // Utilizando el método entrySet
	    for (Map.Entry<Integer, String> elementoDelMapa : mapa.entrySet()) {
	        System.out.println(elementoDelMapa.getKey() + " = " + elementoDelMapa.getValue());
	    }
	    
	    //con expresiones lambda
        mapa.forEach((laClave,elValor) -> System.out.println(laClave + " = " + elValor));
 
	}
	
}
