
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploNeoDatis {

	public static void main(String[] args) {
		
		
		ODB odb = null;
		try {
			// creamos las instancias
			Jugador j1 = new Jugador("María", "voleybol", "Zaragoza", 14, null);
			Jugador j2 = new Jugador("Mario", "baloncesto", "Cuarte", 14, null);
			Jugador j3 = new Jugador("Alicia", "voleybol", "Zaragoza", 14, null);
			Jugador j4 = new Jugador("Pedro", "voleybol", "Zaragoza", 15, null);
			Jugador j5 = new Jugador("David", "voleybol", "Zaragoza", 13, null);
			Jugador j6 = new Jugador("Carlos", "baloncesto", "Gallur", 13, null);
			Jugador j7 = new Jugador("Jesús", "baloncesto", "Gallur", 13, null);
			Jugador j8 = new Jugador("Miguel", "tenis", "Gallur", 14, null);

			// abrimos la BD
			odb = ODBFactory.open("bdDeportesND.test");
			
			//almacenar los jugadores en la base de datos
			odb.store(j1);
			odb.store(j2);
			odb.store(j3);
			odb.store(j4);
			odb.store(j5);
			odb.store(j6);
			odb.store(j7);
			odb.store(j8);

			// creo los equipos
			Equipo voley = new Equipo("Estrella", "voleybol");
			Equipo baloncesto = new Equipo("Estadium Venecia", "baloncesto");
			odb.store(voley);
			odb.store(baloncesto);
			
			//recupear todos los jugadores de la BD
			Objects<Jugador> jugadores = odb.getObjects(Jugador.class);
			
			// Visualizar los resultados
			System.out.println("Hay " + jugadores.size() + " jugadores");
			for (Jugador jugador : jugadores) {
				System.out.println(jugador.getNombre());
			}
			
			// recupear los jugadores que tienen el deporte voleybol y meterlos en el objeto voley
			// despues ¿es necesario guardar los datos?
		} finally {
			if (odb != null) {
				// cerrar la BD
				odb.close();
			}
		}
	}


}
