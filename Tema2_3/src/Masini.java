
public class Masini {

	String nr_inmatriculare;
	String marca;
	int anul_fabticatiei;
	String culoare;
	int nr_km;
	
	public Masini(){}
	public Masini(String nr_inmatriculare, String marca, int anul_fabricatiei, String culoare, int nr_km)
	{
		this.nr_inmatriculare = nr_inmatriculare;
		this.marca = marca;
		this.anul_fabticatiei = anul_fabricatiei;
		this.culoare = culoare;
		this.nr_km = nr_km;
	}
	
	public String getNrInmatriculare()
	{
		return nr_inmatriculare;
	}
	public void setNrInmatriculare(String nr_inmatriculare)
	{
		this.nr_inmatriculare = nr_inmatriculare;
	}
	
	public String getMarca()
	{
		return marca;
	}
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public int getAnulFabricatiei()
	{
		return anul_fabticatiei;
	}
	public void setAnulFabricatiei(int anul_fabricatiei)
	{
		this.anul_fabticatiei = anul_fabricatiei;
	}
	
	public String getCuloare()
	{
		return culoare;
	}
	public void setCuloare(String culoare)
	{
		this.culoare = culoare;
	}
	
	public int getNrKm()
	{
		return nr_km;
	}
	public void setNrKm(int nr_km)
	{
		this.nr_km = nr_km;
	}	
	
	public String toString()
	{
		return "Numar_Inmatriculare: "+this.nr_inmatriculare+"; Marca: "+this.marca+"; Anul_Fabricatie: "+this.anul_fabticatiei+"; Culoare: "+this.culoare+"; Nr_KM: "+this.nr_km+";";
	}
}
