
public class AngajatEx11  extends PersoanaEx11
{
	private int vechime;
	
	public AngajatEx11(){}
	public AngajatEx11(String nume, int varsta, int vechime) 
	{
	super(nume, varsta);
	this.vechime = vechime;
	}
	
	public String toString() 
	{
	return super.toString()+", "+vechime;
	}
}
