package ro.sci.dao;

import ro.sci.meniu.ProdusComandat;

import java.util.Collection;

public interface ProdusComandatDAO extends BaseDAO<ProdusComandat>{
	Collection<ProdusComandat> getProduse(String gama);
	void insertProdus (int idProdus);

}
