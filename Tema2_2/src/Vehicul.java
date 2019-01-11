
public class Vehicul {

	int pret;
	int vitezaMaxima;
	
	public Vehicul(){}
	
	public Vehicul(int pret, int viteza_maxima)
	{
		this.pret = pret;
		this.vitezaMaxima = viteza_maxima;
	}
	
	public int getPret()
	{
		return pret;
	}
	
	public void setPret(int pret)
	{
		this.pret = pret;
	}
	
	public int getVitezaMaxima()
	{
		return vitezaMaxima;
	}
	
	public void setVitezaMaxima(int viteza_maxima)
	{
		this.vitezaMaxima = viteza_maxima;
	}
	
	public String toString()
	{
		return "";
	}
}
