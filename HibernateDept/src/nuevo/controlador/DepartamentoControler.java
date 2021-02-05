package nuevo.controlador;

import java.util.List;
import java.util.Set;

import modelo.Departamento;
import modelo.Empleado;
import nuevo.dao.persistencia.DepartamentoDAO;
import nuevo.dao.persistencia.hibernate.DepartamentoDAOImplHibernate;

public class DepartamentoControler implements GenericControlador<Departamento, Byte> {
	   DepartamentoDAO departamentoDAO;

	    public DepartamentoControler() {
	    	departamentoDAO= new DepartamentoDAOImplHibernate();
	    }

	    @Override
		public void guardar(Departamento departamento) throws RuntimeException {
	       departamentoDAO.saveOrUpdate(departamento);
	    }
	    
		public Departamento crear(byte idDep, Set<Empleado> empleados, String localidad, String nombre) throws RuntimeException {
	    	Departamento dep = departamentoDAO.create();
	    	dep.setLocalidad(localidad);
	    	dep.setNombre(nombre);
	    	dep.setEmpleados(empleados);
	    	dep.setIdDep(idDep);
	    	return(dep);
	    }
	    
	    @Override
		public Departamento getDepartamento (Byte idDep) throws RuntimeException {
	    	return departamentoDAO.get(idDep);
	    }
	    
	    @Override
		public List<Departamento> listaTodos() throws RuntimeException {
	    	return departamentoDAO.findAll();
	    }

		@Override
		public Departamento crear() throws RuntimeException {
			return departamentoDAO.create();
		}


}
