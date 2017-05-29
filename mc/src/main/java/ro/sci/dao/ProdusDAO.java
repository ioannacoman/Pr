package ro.sci.dao;

import ro.sci.meniu.Produs;

import java.util.Collection;

/**
 * Created by Skipy on 5/12/2017.
 */

public interface ProdusDAO extends BaseDAO<Produs>{
	Collection<Produs> getProduse(String gama);
	Collection<Produs> getProduseById(int idProdus);
	void addProdusCom (String idComenzi, int idProdus);
	void startComanda (String idComenzi, int idTable);
	void remProdusCom (String idComenzi, int idProdus, int aOrB);
}
