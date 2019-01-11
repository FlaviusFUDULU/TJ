import java.util.Date;

public class Angajati {

	String nume;
	String firma;
	String functie;
	Date data_angajarii;

	public Angajati() {}
	
	public Angajati(String nume, String firma, String functie, Date data_angajarii) {
		super();
		this.nume = nume;
		this.firma = firma;
		this.functie = functie;
		this.data_angajarii = data_angajarii;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}

	public Date getData_angajarii() {
		return data_angajarii;
	}

	public void setData_angajarii(Date data_angajarii) {
		this.data_angajarii = data_angajarii;
	}

	@Override
	public String toString() {
		return "Angajati [nume=" + nume + ", firma=" + firma + ", functie=" + functie + ", data_angajarii="
				+ data_angajarii + "]";
	}
}
