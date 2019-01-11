import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//====================== Ex2 ================================
abstract class FiguraEx2
{
	public abstract void aria();
}

class CercEx2 extends FiguraEx2
{
	public void aria()
	{
		System.out.print("\n Aria cercului: ");
	}
}

class DreptunghiEx2 extends FiguraEx2
{
	public void aria()
	{
		System.out.println("\n Aria dreptunghiului: ");
	}
}

//====================== Ex5 ================================
class DreptunghiEx5
{
	private int lungime;
	private int latime;
	
	public void aria()
	{
		System.out.println("Aria dreptunghiului: "+(lungime*latime));
	}
	public int getLungime()
	{return lungime;}
	public void setLungime(int lungime)
	{
		this.lungime = lungime;
	}
	
	public int getLatime()
	{return latime;}
	public void setLatime(int latime)
	{
		this.latime = latime;
	}
}

public class Tema2_1 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int opt;
		
		
		do
		{
			System.out.println("\n----------------------------------------------------------------");
			System.out.println(" 1. Exemplu 2");
			System.out.println(" 2. Exemplu 5");
			System.out.println(" 3. Exemplu 7");
			System.out.println(" 4. Exemplu 9");
			System.out.println(" 5. Exemplu 11");
			System.out.println(" 0. Exit.");			
			opt = Integer.parseInt(in.readLine());
			
			switch(opt)
			{
			case 1:
				FiguraEx2 cex2 = new CercEx2();
				cex2.aria();
				
				FiguraEx2 dex2 = new DreptunghiEx2();
				dex2.aria();
				break;
				
			case 2:
				BeanFactory factory = new XmlBeanFactory(new FileSystemResource("BeansEx5.xml"));
				DreptunghiEx5 dex5 = (DreptunghiEx5) factory.getBean("dreptunghi");				
				dex5.aria();
				break;
				
			case 3:
				ApplicationContext contextEx7=new ClassPathXmlApplicationContext("BeansEx7.xml");
				PersoanaEx7 p=(PersoanaEx7)contextEx7.getBean("pers");
				System.out.print(p);
				break;
				
			case 4:
				ApplicationContext contextEx9=new ClassPathXmlApplicationContext("BeansEx9.xml");
				MesajEx9 m1=(MesajEx9)contextEx9.getBean("mesaj");
				System.out.println("Obiectul m1 dupa creare:"+m1);
				m1.setMesaj("Al doilea mesaj!");
				System.out.println("Obiectul m1 dupa setare:"+m1);
				MesajEx9 m2=(MesajEx9)contextEx9.getBean("mesaj");
				System.out.println("Obiectul m2 dupa creare:"+m2);
				break;
				
			case 5:
				ApplicationContext contextEx11t=new ClassPathXmlApplicationContext("BeansEx11.xml");
				PersoanaEx11 pEx11=(AngajatEx11)contextEx11t.getBean("angajat");
				System.out.print(pEx11);
				break;
			}
			
		}while(opt != 0);

	}

}
