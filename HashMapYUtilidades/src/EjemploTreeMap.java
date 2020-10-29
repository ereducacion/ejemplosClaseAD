import java.util.*;

public class EjemploTreeMap {

	
	public static void main(String[] args) {
		
		// mapa con clave: nota y valor: lista ordenada de apellidos que tienen esa nota
		TreeMap<Integer, TreeSet<String> > mapNotas = new TreeMap<Integer, TreeSet<String> > ();
		
		TreeSet<String> listaApellidos=null;
		boolean encontrado;

		String apellido;
		Integer nota = Leer.pedirEntero("Nota de 1 a 10:");
		
		while(nota!=0){
			
			apellido=Leer.pedirCadena("Apellido del alumno:");
			
			if(mapNotas.containsKey(nota)){
				encontrado=buscarApellido(mapNotas, apellido);

				if(!encontrado){ 
					//insertar el apellido
					mapNotas.get(nota).add(apellido);
				}else{
					System.out.println("El apellido ya existe");
				}
				
			}else{
				
				// crear la lista vacia
				listaApellidos = new TreeSet<String>();
				 //agregar el apellido
				listaApellidos.add(apellido);
				// insertar el nodo clave-valor
				mapNotas.put(nota, listaApellidos); 
					
			}
			nota = Leer.pedirEntero("Nota de 1 a 10:");
		}

		// recorrer el map
		Iterator<Integer> itr = mapNotas.keySet().iterator();
		while (itr.hasNext()) {
			nota = (int)itr.next();
			listaApellidos=mapNotas.get(nota);
			System.out.println(nota + ": " );
			for(String unApellido: listaApellidos){
				System.out.print(unApellido + ", ");
			}
		}
	} 
	
	public static boolean buscarApellido(TreeMap<Integer, TreeSet<String> > mapNotas, String apellido){
		
		Iterator< Map.Entry<Integer, TreeSet<String>>> it;
		it = mapNotas.entrySet().iterator();
		
		//Nodo del map (clave, valor)
		Map.Entry<Integer, TreeSet<String>> mEntry;	
		TreeSet<String> listaApellidosPorNota=null;
		
		boolean encontrado=false;
		while (it.hasNext() && !encontrado) {
			
			 // obtener el nodo clave-valor
			mEntry = it.next();
			listaApellidosPorNota = mEntry.getValue(); 

			if(listaApellidosPorNota.contains(apellido)){
				encontrado=true;
			}
		}
		return encontrado;
	}
}
