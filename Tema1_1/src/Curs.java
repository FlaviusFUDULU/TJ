import java.util.Date;

public class Curs {

	String id_angajat;
	String denumire;
	int numar_ore;
	float valoare;
	String diploma_de_absolvire;
	int anul;
	
	public Curs() {}
	
	public Curs(String id_angajat, String denumire, int numar_ore, float valoare, String diploma_de_absolvire,
			int anul) {
		super();
		this.id_angajat = id_angajat;
		this.denumire = denumire;
		this.numar_ore = numar_ore;
		this.valoare = valoare;
		this.diploma_de_absolvire = diploma_de_absolvire;
		this.anul = anul;
	}

	public String getId_angajat() {
		return id_angajat;
	}

	public void setId_angajat(String id_angajat) {
		this.id_angajat = id_angajat;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getNumar_ore() {
		return numar_ore;
	}

	public void setNumar_ore(int numar_ore) {
		this.numar_ore = numar_ore;
	}

	public float getValoare() {
		return valoare;
	}

	public void setValoare(float valoare) {
		this.valoare = valoare;
	}

	public String getDiploma_de_absolvire() {
		return diploma_de_absolvire;
	}

	public void setDiploma_de_absolvire(String diploma_de_absolvire) {
		this.diploma_de_absolvire = diploma_de_absolvire;
	}

	public int getAnul() {
		return anul;
	}

	public void setAnul(int anul) {
		this.anul = anul;
	}

	@Override
	public String toString() {
		return "Curs [id_angajat=" + id_angajat + ", denumire=" + denumire + ", numar_ore=" + numar_ore + ", valoare="
				+ valoare + ", diploma_de_absolvire=" + diploma_de_absolvire + ", anul=" + anul + "]";
	}

}
