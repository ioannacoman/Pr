package ro.sci.meniu;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Skipy on 5/8/2017.
 */
public class Gama extends AbstractModel {
    @NotEmpty
    private int idGama;

    @NotEmpty
    private String gama;

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }
}
