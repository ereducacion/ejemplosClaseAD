package nuevo.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T,ID extends Serializable> {
    T create() throws RuntimeException;
    void saveOrUpdate(T entity) throws RuntimeException;
    T get(ID id) throws RuntimeException;
    void delete(ID id) throws RuntimeException;
    List<T> findAll() throws RuntimeException;
}
