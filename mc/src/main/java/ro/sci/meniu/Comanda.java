package ro.sci.meniu;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Skipy on 5/12/2017.
 */
public class Comanda extends AbstractModel{
    @NotEmpty
    private int idComanda;

    private int countComenziDeschise;

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    @Override
    public String toString() {
        return String.valueOf(idComanda);
    }

    public int getCountComenziDeschise() {
        return countComenziDeschise;
    }

    public void setCountComenziDeschise(int countComenziDeschise) {
        this.countComenziDeschise = countComenziDeschise;
    }
}
