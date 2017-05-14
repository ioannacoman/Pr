package ro.sci.services;

import ro.sci.dao.ComandaDAO;
import ro.sci.meniu.Comanda;

/**
 * Created by Skipy on 5/12/2017.
 */
public class ComandaService {
    private ComandaDAO comandaDAO;
    public Comanda getIdComanda(int aOrB, int idTable){ return comandaDAO.getIdComanda(aOrB,idTable);}
    public Comanda countComenziDeschise(int idTable) {return comandaDAO.countComenziDeschise(idTable);}
    public void setComandaDAO(ComandaDAO comandaDAO) {
        this.comandaDAO = comandaDAO;
    }
    public void anulComanda(String idComenzi,int idTable){comandaDAO.anulComanda(idComenzi,idTable);}
    public void finishComanda(String idComenzi,int idTable){comandaDAO.finshComanda(idComenzi,idTable);}
}
