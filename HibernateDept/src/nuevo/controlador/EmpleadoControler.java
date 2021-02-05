package nuevo.controlador;

import java.util.Date;
import java.util.List;

import modelo.Departamento;
import modelo.Empleado;
import nuevo.dao.persistencia.EmpleadoDAO;
import nuevo.dao.persistencia.hibernate.EmpleadoDAOImplHibernate;

public class EmpleadoControler implements GenericControlador<Empleado, Short>{
	   EmpleadoDAO empleadoDAO;

	    public EmpleadoControler() {
	    	empleadoDAO= new EmpleadoDAOImplHibernate();
	    }

	    public void guardar(Empleado empleado) throws RuntimeException {
	          empleadoDAO.saveOrUpdate(empleado);
	    }

		public Empleado crear(String apellido, float comision, Departamento departamento, Date fechaAlta, short idEmp, String oficio, float salario) throws RuntimeException {
			Empleado emp = empleadoDAO.create();
			emp.setApellido(apellido);
			emp.setComision(comision);
			emp.setDepartamento(departamento);
			emp.setFechaAlta(fechaAlta);
			emp.setIdEmp(idEmp);
			emp.setOficio(oficio);
			emp.setSalario(salario);
			return emp;
		}

		@Override
		public Empleado crear() throws RuntimeException {
			return empleadoDAO.create();
		}

		@Override
		public Empleado getDepartamento(Short id) throws RuntimeException {
			return empleadoDAO.get(id);
		}

		@Override
		public List<Empleado> listaTodos() throws RuntimeException {
			return empleadoDAO.findAll();
		}

}
