package ro.sci.services;

import ro.sci.dao.ProdusComandatDAO;
import ro.sci.meniu.ProdusComandat;

import java.util.Collection;

/**
 * Created by Skipy on 5/8/2017.
 */
public class ProdusComandatService {
    private ProdusComandatDAO produsComandatDAO;

    public Collection<ProdusComandat> listAll(){
        return produsComandatDAO.getAll();
    }
    public ProdusComandatDAO getProdusComandatDAO() {
        return produsComandatDAO;
    }

    public void setProdusComandatDAO(ProdusComandatDAO produsComandatDAO) {
        this.produsComandatDAO = produsComandatDAO;
    }
}
