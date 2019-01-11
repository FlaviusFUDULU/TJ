
public class Autoturism extends Vehicul{
	
	String marca;
	int anul_fabricatiei;
	
	public Autoturism(){}
	
	public Autoturism(String marca, int anul_fabricatiei)
	{
		this.marca = marca;
		this.anul_fabricatiei = anul_fabricatiei;
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
		return anul_fabricatiei;
	}
	
	public void setAnulFabricatiei(int anul)
	{
		this.anul_fabricatiei = anul;
	}
	
	public String toString()
	{
		return "Autoturism -> Pret: "+this.pret+"; Viteza: "+this.vitezaMaxima+"; Marca: "+this.marca+"; Anul: "+this.anul_fabricatiei;
	}

}
