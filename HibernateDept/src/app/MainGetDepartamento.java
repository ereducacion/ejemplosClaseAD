package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
	
import controlador.HibernateUtil;

import modelo.*;

public class MainGetDepartamento {

	public static void main(String[] args) {

		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la fábrica de la conexión actual para crear una sesión
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesión
		Session sesion = fabrica.openSession();	
		// creamos la transacción de la sesión
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
