package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import controlador.Utilidades;
import modelo.*;

public class ConsultaSaldoVariosEmpleados {

	public static void main(String[] args) {
		
		String oficio = Utilidades.preguntaPorCadena("¿Por qué oficio preguntas?");

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sesion = fabrica.openSession();	

		try {

			String pregunta = "select salario from Empleado where oficio = :oficio";
			Query<Float> query = sesion.createQuery(pregunta);
			
			query.setParameter("oficio", oficio);
			List<Float> saldos = query.getResultList();
			
			for (Iterator<Float> iterator = saldos.iterator(); iterator.hasNext();) {
				float elSaldo = (float)iterator.next();
				System.out.println(elSaldo);
			}
		} catch (IllegalStateException cve) {
            cve.printStackTrace();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
    		sesion.close();
    		fabrica.close();			
		}
		
		System.exit(0);
	}
}
