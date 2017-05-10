package ro.sci.services;

import ro.sci.dao.GamaDAO;
import ro.sci.meniu.Gama;

/**
 * Created by Skipy on 5/8/2017.
 */
public class GamaService {
    private GamaDAO gamaDAO;


    public Gama getGama (int idGama){
     return gamaDAO.getGama(idGama);

    }




    public GamaDAO getGamaDAO() {
        return gamaDAO;
    }

    public void setGamaDAO(GamaDAO gamaDAO) {
        this.gamaDAO = gamaDAO;
    }
}
