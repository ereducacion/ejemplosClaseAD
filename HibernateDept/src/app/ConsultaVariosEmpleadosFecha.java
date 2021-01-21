package app;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import controlador.Utilidades;
import modelo.*;

public class ConsultaVariosEmpleadosFecha {

	public static void main(String[] args) {
		
		String formatoFecha = "yyyy-MM-dd";
		Date fecha = Utilidades.preguntaPorFecha("Listado de empleados dados de alta "
				+ "a partir de ¿Qué fecha?", formatoFecha);

		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sesion = fabrica.openSession();	

		try {

			String pregunta = "from Empleado where fechaAlta > :fecha";
			Query query = sesion.createQuery(pregunta);
			
			query.setParameter("fecha", fecha);
			List<Empleado> emps = query.getResultList();
			
			for (Empleado emp : emps) {
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
