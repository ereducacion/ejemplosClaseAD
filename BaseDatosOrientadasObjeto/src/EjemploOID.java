import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

public class EjemploOID {

	public static void main(String[] args) {

	ODB odb = null;
	try {
		// abrir la BD
		odb = ODBFactory.open("bdDeportesND.test");
		
		// obtener el objeto con Identificador de objeto (OID) 3
		OID identificador = OIDFactory.buildObjectOID(3);
		Jugador objeto = (Jugador)odb.getObjectFromId(identificador);
		System.out.println("Es el jugador " + objeto.getNombre());
		
	} finally {
		if (odb != null) {
			// cerrar la BD
			odb.close();
		}
	}
		
	}

}
