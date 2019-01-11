
public class PersoanaEx11 {
	
	private String nume;
	private int varsta;
	
	public PersoanaEx11(){}
	public PersoanaEx11(String nume, int varsta) 
	{
	this.nume = nume;
	this.varsta = varsta;
	}
	@Override
	public String toString() 
	{
	return nume + ", " + varsta;
	}
}

