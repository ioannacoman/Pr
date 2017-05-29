package ro.sci.meniu;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Skipy on 5/8/2017.
 */
public class ProdusComandat extends Produs {

    @NotEmpty
    private int buc;

    @NotEmpty
    private float pretTotal;
    @NotEmpty
    private int idGama;

    public int getBuc() { return buc; }

    public void setBuc(int buc) {
        this.buc = buc;
    }

    public float getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(float pretTotal) {
        this.pretTotal = pretTotal;
    }

    public int getIdGama() { return idGama; }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }
}
