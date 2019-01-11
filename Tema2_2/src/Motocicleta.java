
public class Motocicleta extends Vehicul{
	
	String tip;
	
	public Motocicleta(){}
	
	public Motocicleta(String tip)
	{
		this.tip = tip;
	}
	
	public String getTip()
	{
		return tip;
	}
	
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	
	public String toString()
	{
		return "Motocicleta -> Pret:"+this.pret+"; Viteza:"+this.vitezaMaxima+"; Tipul:"+this.tip;
	}
}
