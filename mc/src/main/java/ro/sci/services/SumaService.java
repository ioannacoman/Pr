package ro.sci.services;

import ro.sci.dao.SumaDAO;
import ro.sci.meniu.Suma;

/**
 * Created by Skipy on 5/13/2017.
 */
public class SumaService {
    private SumaDAO sumaDAO;
    public Suma getSuma(String idComenzi){
        return sumaDAO.getSuma(idComenzi);
    }
    public SumaDAO getSumaDAO() {
        return sumaDAO;
    }
    public void setSumaDAO(SumaDAO sumaDAO) {
        this.sumaDAO = sumaDAO;
    }
}
