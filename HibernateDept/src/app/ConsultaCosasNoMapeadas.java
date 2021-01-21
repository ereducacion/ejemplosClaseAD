package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import controlador.Utilidades;
import modelo.*;

public class ConsultaCosasNoMapeadas {

	public static void main(String[] args) {
		
		SessionFactory fabrica = HibernateUtil.getSessionFactory();
		Session sesion = fabrica.openSession();	

		try {

			String pregunta = "from Empleado e, Departamento d where d.idDep = e.departamento.idDep order by e.apellido";
			Query<Object> resultado = sesion.createQuery(pregunta);
			
			List<Object> lista = resultado.list();
			
			// es una lista de cosas, cada cosa es un array de 2 objetos, un empleado y un departamento
			// lo sé porque en la consulta he elegido todos los campos de uno y de otro
			for (Object cosas : lista) {
				Object[] losObjetos = (Object[])cosas;
				Empleado e = (Empleado) losObjetos[0];
				Departamento d = (Departamento) losObjetos[1];
				System.out.println("--------");
				System.out.println(e.getApellido() + " trabaja en " + d.getNombre());
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
