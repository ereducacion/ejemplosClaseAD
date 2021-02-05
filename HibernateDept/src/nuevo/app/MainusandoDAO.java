package nuevo.app;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import modelo.Departamento;
import modelo.Empleado;
import nuevo.controlador.DepartamentoControler;
import nuevo.controlador.EmpleadoControler;

public class MainusandoDAO {
	public static void main(String[] args) {

		try {
			DepartamentoControler departamentoCtl = new DepartamentoControler();			
			EmpleadoControler empleadoCtl = new EmpleadoControler();
	
			// recupero un departamento
			Departamento dep = departamentoCtl.getDepartamento((byte)2);
			
			// lo asigno al nuevo empleado
			SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
	        Date fecha = (Date) objSDF.parse("04-02-2021"); 
	        Empleado e = new Empleado((short)22, dep, "Pinilla", "analista", fecha, 3000, 32);
			
			empleadoCtl.guardar(e);
			
			List<Empleado> losEmpl = empleadoCtl.listaTodos();
			
			for (Empleado empleado : losEmpl) {
				System.out.println(empleado.getApellido());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
