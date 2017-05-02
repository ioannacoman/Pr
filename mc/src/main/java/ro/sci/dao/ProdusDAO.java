package ro.sci.dao;

import ro.sci.meniu.Produs;

import java.util.Collection;

public interface ProdusDAO extends BaseDAO<Produs>{

	Collection<Produs> searchByName(String query);
}
