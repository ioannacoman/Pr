package ro.sci.dao;

import ro.sci.meniu.Suma;

/**
 * Created by Skipy on 5/13/2017.
 */

public interface SumaDAO extends BaseDAO<Suma>{
    Suma getSuma(String idComenzi);
}
