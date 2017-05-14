package ro.sci.dao;

import ro.sci.meniu.Comanda;

/**
 * Created by Skipy on 5/12/2017.
 */
public interface ComandaDAO extends BaseDAO<Comanda>  {
    Comanda getIdComanda (int aOrB, int idTable);
    Comanda countComenziDeschise(int idTable);
    void anulComanda (String idComenzi, int idTable);
    void finshComanda (String idComenzi, int idTable);

}
