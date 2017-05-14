package ro.sci.services;

import ro.sci.dao.ProdusDAO;
import ro.sci.meniu.Produs;

import java.util.Collection;

/**
 * Created by Skipy on 4/30/2017.
 */
public class ProdusService {

    private ProdusDAO dao;

    public Collection<Produs> listAll() {
        return dao.getAll();
    }

    public Collection<Produs> listProduse(String gama) { return dao.getProduse(gama); }

    public Collection<Produs> getProduseById(int idProdus) { return dao.getProduseById(idProdus); }

    public void startComanda(String idComenzi, int idTable){dao.startComanda(idComenzi,idTable);};

    public void addProdusCom(String idComenzi, int idProdus) { dao.addProdusCom(idComenzi,idProdus); }

    public void remProdusCom(String idComenzi, int idProdus, int aOrB) {dao.remProdusCom(idComenzi,idProdus,aOrB);}

    public ProdusDAO getDao() {
        return dao;
    }

    public void setDao(ProdusDAO dao) {
        this.dao = dao;
    }
}