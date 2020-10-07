import java.util.ArrayList;

public class ProbandoArrayList0 {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
						
		ArrayList Lista = new ArrayList();
		Lista.add("Hola");
		Lista.add(3);
		Lista.add('a');
		Lista.add(23.5);

		for (Object object : Lista) {
			System.out.println(object.getClass());
		}
		for (int i = 0; i < Lista.size(); i++) {
			System.out.println((Lista.get(i)).getClass());
		}
		

		
	}

}
