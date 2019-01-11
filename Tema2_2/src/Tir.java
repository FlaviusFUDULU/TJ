
public class Tir extends Vehicul{
	
	int incarcatura;
	
	public Tir(){}
	public Tir(int incarcatura)
	{
		this.incarcatura = incarcatura;
	}
	
	public int getIncarcatura()
	{
		return incarcatura;
	}
	
	public void setIncarcatura(int incarcatura)
	{
		this.incarcatura = incarcatura;
	}
	
	public String toString()
	{
		return "Tir ->Pret: "+this.pret+"; Viteza: "+this.vitezaMaxima+"; Incarcatura: "+this.incarcatura;
	}

}
