package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import controlador.Utilidades;
import modelo.*;

public class ConsultaDatosEmpleado {

	public static void main(String[] args) {
		
		String apellido = Utilidades.preguntaPorCadena("¿Cual es el apellido del empleado que quieres consultar?");

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sesion = fabrica.openSession();	

		try {

			String pregunta = "from Empleado where apellido = :apell";
			Query query = sesion.createQuery(pregunta);
			
			query.setParameter("apell", apellido);
			Empleado emp = (Empleado) query.getSingleResult();
			
			if (emp != null) {
				System.out.println("-------");
				System.out.println(emp.getApellido() + ": \n" + 
				"cobra " + emp.getSalario() + "\n" +
				"oficio " + emp.getOficio() + "\n" +
				"comisión " + emp.getComision() + "\n" +
				"y trabaja en el departamento de " + emp.getDepartamento().getNombre());
			} else {
				System.out.println("No existe este empleado");
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
