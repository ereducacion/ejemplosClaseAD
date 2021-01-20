package app;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import controlador.HibernateUtil;

import modelo.*;

public class MainQuery {

	public static void main(String[] args) {

		// ------------------UTILIZAMOS LO DEFINIDO ANTES-------------
		//obtener la fábrica de la conexión actual para crear una sesión
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		//------------------------------------------------------------
		// creamos la sesión
		Session sesion = fabrica.openSession();	
		
		try {
			// empezamos la transacción de la sesión
			sesion.beginTransaction();
			System.out.println("Leo los departamentos");	
			Query<Departamento> q = sesion.createQuery("from Departamento");
			List<Departamento> lista = q.list();
			
			for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
				Departamento departamento = (Departamento) iterator.next();
				System.out.println("El departamento de " + departamento.getNombre() + " tiene a los empleados...");
				Set<Empleado> losempleados = departamento.getEmpleados();
				for (Iterator iterator2 = losempleados.iterator(); iterator2.hasNext();) {
					Empleado empleado = (Empleado) iterator2.next();
					System.out.println("trabaja " + empleado.getApellido());
				}
			}
			sesion.getTransaction().commit();	
			
		} catch (ConstraintViolationException cve) {
            try {
                if (sesion.getTransaction().isActive()) {
                    sesion.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	  System.out.println("Falló al hacer un rollback " +  exc.getMessage());
            }
        } catch (RuntimeException ex) {
            try {
                if (sesion.getTransaction().isActive()) {
                    sesion.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	  System.out.println("Falló al hacer un rollback " +  exc.getMessage());
            }
        } catch (Exception ex) {
            try {
                if (sesion.getTransaction().isActive()) {
                    sesion.getTransaction().rollback();
                }
            } catch (Exception exc) {
                System.out.println("Falló al hacer un rollback " +  exc.getMessage());
            }
        }		
		
		sesion.close();
		fabrica.close();
		System.exit(0);	

	}

}
