package ro.sci.dao;

import ro.sci.meniu.Gama;

/**
 * Created by Skipy on 5/8/2017.
 */

public interface GamaDAO extends BaseDAO<Gama> {
    Gama getGama(int idGama);
    Gama getIdGama(int idProdus);
}
