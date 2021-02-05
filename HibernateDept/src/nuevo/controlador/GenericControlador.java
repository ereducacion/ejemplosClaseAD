package nuevo.controlador;

import java.io.Serializable;
import java.util.List;

public interface GenericControlador<T, ID extends Serializable> {

	void guardar(T entity) throws RuntimeException;

	T crear() throws RuntimeException;

	T getDepartamento(ID id) throws RuntimeException;

	List<T> listaTodos() throws RuntimeException;

}