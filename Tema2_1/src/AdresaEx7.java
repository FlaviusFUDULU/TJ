
public class AdresaEx7 {
	private int nr;
	private String strada;
	private String localitatea;
	
	public AdresaEx7(int nr, String strada, String localitatea) 
	{
		this.nr = nr; this.strada = strada; this.localitatea = localitatea;
	}
	public String toString() 
	{
		return nr + ", " + strada + ", "+ localitatea;
	}

}
