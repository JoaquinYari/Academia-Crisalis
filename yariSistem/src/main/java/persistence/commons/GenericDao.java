package persistence.commons;

import java.util.List;

public interface GenericDao<T> {

	public T findById(Integer id);
	public List<T> findAll();
	public Integer insert(T t);
	public Integer update(T t);
	public Integer delete(T t);
	
}
