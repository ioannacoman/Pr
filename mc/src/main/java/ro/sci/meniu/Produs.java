package ro.sci.meniu;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Skipy on 5/12/2017.
 */

public class Produs extends AbstractModel {

	@NotEmpty
	private int nrCrt;

	@NotEmpty
	private int idProdus;

	@NotEmpty
	private String numeProdus;

	@NotEmpty
	private String descriere;

	@NotEmpty
	private String gama;

	@NotEmpty
	private String unitateMasura;

	@NotEmpty
	private int cant;

	@NotEmpty
	private float pret;

	public int getNrCrt() {	return nrCrt; }

	public void setNrCrt(int nrCrt) {
		this.nrCrt = nrCrt;
	}

	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public String getNumeProdus() {
		return numeProdus;
	}

	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public String getGama() {
		return gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getUnitateMasura() { return unitateMasura; }

	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}

	public int getCant() { return cant; }

	public void setCant(int cant) { this.cant = cant; }

	public float getPret() { return pret; }

	public void setPret(float pret) { this.pret = pret; }

	@Override
	public String toString() {
	return "Produs [nrCrt="+ nrCrt +"idProdus="+ idProdus +", numeProdus=" + numeProdus + ", descriere=" + descriere + ", gama=" + gama + ", cant=" + cant + ", unitateMasura=" + unitateMasura + ", pret=" + pret + "]";
}
}
