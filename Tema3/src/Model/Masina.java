package Model;
import java.util.Date;

public class Masina {

	String nr_inmatriculare;
	String marca;
	String modelul;
	String culoarea;
	int anul_fabricatiei;
	int capacitatea_cilindrica;
	String tipul_de_combustibil;
	int putere;
	int cuplu;
	
	public Masina() {}
	
	public Masina(String nr_inmatriculare, String marca, String modelul, String culoarea,
			int anul_fabricatiei, int capacitatea_cilindrica, String tipul_de_combustibil, int putere, int cuplu) {
		super();
		this.nr_inmatriculare = nr_inmatriculare;
		this.marca = marca;
		this.modelul = modelul;
		this.culoarea = culoarea;
		this.anul_fabricatiei = anul_fabricatiei;
		this.capacitatea_cilindrica = capacitatea_cilindrica;
		this.tipul_de_combustibil = tipul_de_combustibil;
		this.putere = putere;
		this.cuplu = cuplu;
	}
	float volumul_portbagajului;
	int pretul;

	public String getNr_inmatriculare() {
		return nr_inmatriculare;
	}

	public void setNr_inmatriculare(String nr_inmatriculare) {
		this.nr_inmatriculare = nr_inmatriculare;
	}

//	public int getId_utilizator() {
//		return id_utilizator;
//	}
//
//	public void setId_utilizator(int id_utilizator) {
//		this.id_utilizator = id_utilizator;
//	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelul() {
		return modelul;
	}

	public void setModelul(String modelul) {
		this.modelul = modelul;
	}

	public String getCuloarea() {
		return culoarea;
	}

	public void setCuloarea(String culoarea) {
		this.culoarea = culoarea;
	}

	public int getAnul_fabricatiei() {
		return anul_fabricatiei;
	}

	public void setAnul_fabricatiei(int anul_fabricatiei) {
		this.anul_fabricatiei = anul_fabricatiei;
	}

	public int getCapacitatea_cilindrica() {
		return capacitatea_cilindrica;
	}

	public void setCapacitatea_cilindrica(int capacitatea_cilindrica) {
		this.capacitatea_cilindrica = capacitatea_cilindrica;
	}

	public String getTipul_de_combustibil() {
		return tipul_de_combustibil;
	}

	public void setTipul_de_combustibil(String tipul_de_combustibil) {
		this.tipul_de_combustibil = tipul_de_combustibil;
	}

	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	public int getCuplu() {
		return cuplu;
	}

	public void setCuplu(int cuplu) {
		this.cuplu = cuplu;
	}

	public float getVolumul_portbagajului() {
		return volumul_portbagajului;
	}

	public void setVolumul_portbagajului(float volumul_portbagajului) {
		this.volumul_portbagajului = volumul_portbagajului;
	}

	public int getPretul() {
		return pretul;
	}

	public void setPretul(int pretul) {
		this.pretul = pretul;
	}

}
