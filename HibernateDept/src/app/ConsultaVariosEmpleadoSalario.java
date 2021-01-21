package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import controlador.Utilidades;
import modelo.*;

public class ConsultaVariosEmpleadoSalario {

	public static void main(String[] args) {
		
		float salario = Utilidades.preguntaPorFlotante("¿Salario mínimo del empleado a mostrar?");

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sesion = fabrica.openSession();	

		try {

			String pregunta = "from Empleado where salario > :salario";
			Query query = sesion.createQuery(pregunta);
			
			query.setParameter("salario", salario);
			List<Empleado> emps = query.getResultList();
			
			for (Iterator iterator = emps.iterator(); iterator.hasNext();) {
				Empleado emp = (Empleado) iterator.next();
				System.out.println("-------");
				System.out.println(emp.getApellido() + ": \n" + 
				"cobra " + emp.getSalario() + "\n" +
				"oficio " + emp.getOficio() + "\n" +
				"comisión " + emp.getComision() + "\n" +
				"y trabaja en el departamento de " + emp.getDepartamento().getNombre());
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
