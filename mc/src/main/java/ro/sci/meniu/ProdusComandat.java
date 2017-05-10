package ro.sci.meniu;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Skipy on 5/8/2017.
 */
public class ProdusComandat extends Produs {

    @NotEmpty
    private int buc;

    public int getBuc() {
        return buc;
    }

    public void setBuc(int buc) {
        this.buc = buc;
    }
}
