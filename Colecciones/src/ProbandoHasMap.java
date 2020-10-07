import java.util.HashMap;
import java.util.Map;

public class ProbandoHasMap {

	public static void main(String[] args) {
	    
		HashMap<String, String> mapa = new HashMap<String, String>();
	    mapa.put("AR2324", "Ana Rosa");
	    mapa.put("JM8788", "Jose Miguel");
	    
	    
	    // Utilizando el método entrySet
	    for (Map.Entry<String, String> entry : mapa.entrySet()) {
	        System.out.println(entry.getKey() + " = " + entry.getValue());
	    }
	    
	    //con expresiones lambda
        mapa.forEach((laClave,elValor) -> System.out.println(laClave + " = " + elValor));

	}

}
