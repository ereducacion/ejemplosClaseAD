package nuevo.dao.implementacion;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import controlador.HibernateUtil;
import nuevo.dao.GenericDAO;

public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {


    SessionFactory sessionFactory;

     public GenericDAOImplHibernate() {
        sessionFactory=HibernateUtil.getSessionFactory();
    }


    @Override
    public T create() throws RuntimeException {
        try {
            return getEntityClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void saveOrUpdate(T entity) throws RuntimeException {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(ex);
        } finally {
			session.close();
		}
    }

    @Override
    public T get(ID id) throws RuntimeException {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            T entity = (T) session.get(getEntityClass(), id);
            session.getTransaction().commit();

            return entity;
        } catch (ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(ex);
        } finally {
			session.close();
		}
    }

    @Override
    public void delete(ID id) throws RuntimeException {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            T entity = (T) session.get(getEntityClass(), id);
            if (entity == null) {
                throw new RuntimeException("Los datos a borrar ya no existen");
            }
            session.delete(entity);
            session.getTransaction().commit();
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(ex);
        }finally {
			session.close();
		}
    }

    @Override
    public List<T> findAll() throws RuntimeException {
        Session session = sessionFactory.openSession();
        try {

            Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
            List<T> entities = query.list();
            return entities;
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
            	System.err.println("Fallo al hacer la recuperación de la BD " + exc.getMessage());
            }
            throw new RuntimeException(ex);
        } finally {
			session.close();
		}
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
