package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
	
import controlador.HibernateUtil;

import modelo.*;

public class MainGetDepartamento {

	public static void main(String[] args) {

		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la f�brica de la conexi�n actual para crear una sesi�n
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesi�n
		Session sesion = fabrica.openSession();	
		// creamos la transacci�n de la sesi�n
		Transaction tx = sesion.beginTransaction();
		
		Departamento dep = (Departamento) sesion.get(Departamento.class, (byte)12);
		System.out.println("El nombre del departamento es " + dep.getNombre());
		
		//dep.setLocalidad("Cuenca");
		sesion.delete(dep);
		
		sesion.getTransaction().commit();	
		
		sesion.close();
		fabrica.close();
		System.exit(0);	
		
	}

}
