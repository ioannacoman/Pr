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

    public Collection<Produs> listProduse(String gama) {
        return dao.getProduse(gama);
    }

    public void addProdusCom(int idProdus) {
        dao.insertProdus(idProdus);
    }

    ;


    public ProdusDAO getDao() {
        return dao;
    }

    public void setDao(ProdusDAO dao) {
        this.dao = dao;
    }
}