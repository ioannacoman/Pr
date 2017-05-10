package ro.sci.dao;

import ro.sci.meniu.AbstractModel;
import ro.sci.meniu.Produs;

import java.util.Collection;

public interface BaseDAO<T extends AbstractModel> {

	Collection<T> getAll();

	boolean delete(Produs produs);
}
