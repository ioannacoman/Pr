package ro.sci.meniu;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Skipy on 5/13/2017.
 */
public class Suma extends AbstractModel{


    @NotEmpty
    private String suma;

    public String getSuma() {
        return suma;
    }

    public void setSuma(String suma) {
        this.suma = suma;
    }


    @Override
    public String toString() {
        return "Valoare [suma= "+ suma +" ]";
    }
}
