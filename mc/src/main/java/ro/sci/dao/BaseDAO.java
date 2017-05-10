package ro.sci.dao;

import ro.sci.meniu.AbstractModel;

import java.util.Collection;

public interface BaseDAO<T extends AbstractModel> {

	Collection<T> getAll();
	
	T findById(int idProdus);
	
	T update(T model);
	
	boolean delete(T model);
}
