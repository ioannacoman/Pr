package ro.sci.dao;

import ro.sci.meniu.ProdusComandat;

import java.util.Collection;

/**
 * Created by Skipy on 5/12/2017.
 */

public interface ProdusComandatDAO extends BaseDAO<ProdusComandat>{
	Collection<ProdusComandat> listAll(String idComenzi);
	Collection<ProdusComandat> getProduse(String gama);
	void insertProdus (int idProdus);
}
