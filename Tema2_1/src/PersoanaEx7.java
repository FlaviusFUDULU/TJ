
public class PersoanaEx7 {

	private String nume;
	private int varsta;
	private AdresaEx7 adresa;
	
	public String getNume() { return nume; }
	public void setNume(String nume) { this.nume = nume;}
	
	public int getVarsta() {return varsta;}
	public void setVarsta(int varsta) {this.varsta = varsta;}
	
	public AdresaEx7 getAdresa() {return adresa;}
	public void setAdresa(AdresaEx7 adresa) {this.adresa = adresa;}
	

	public String toString() {
	return nume + ", " + varsta + ", "+adresa.toString();
	}
}
