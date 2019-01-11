import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tema2_3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException{

		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD)context.getBean("operatiiJDBC");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int opt;
		
		do
		{
			System.out.println("\n----------------------------------------------------------------");
			System.out.println(" 1. Adaugare Masina");
			System.out.println(" 2. Sterge Masina");		
			System.out.println(" 3. Cautare masina dupa numar inmatriculare");
			System.out.println(" 4. Afinare masini");
			System.out.println(" 5. Afisare unei marci");
			System.out.println(" 6. Afisati statistica masinilor sub 100.000 KM");
			System.out.println(" 7. Afisarea masinilor mai noi de 5 ani");
			System.out.println(" 0. Exit.");			
			opt = Integer.parseInt(in.readLine());
			
			switch(opt)
			{
			case 1:
				System.out.println("Introduceti detaliile masinii:");
				System.out.print("Numar inmatriculare: ");
				String nr =  in.readLine();
				System.out.print("Marca: ");
				String marca =  in.readLine();
				System.out.print("Anul: ");
				int anul = Integer.parseInt(in.readLine());
				System.out.print("Culoarea: ");
				String culoarea =  in.readLine();
				System.out.print("Numar kilometrii: ");
				int nr_km = Integer.parseInt(in.readLine());
				
				db.insertMasina(nr, marca, anul, culoarea, nr_km);
				break;
				
			case 2:
				System.out.println("Introduceti numarul de inmatriculare al masinii: ");
				String nrinm =  in.readLine();
				db.deleteMasina(nrinm);
				break;
				
			case 3:
				System.out.println("Introduceti numarul de inmatriculare al masinii:");
				String nrinm2 = in.readLine();
				System.out.println(db.getMasini(nrinm2).toString());
				break;
				
			case 4:
				List<Masini> masini = db.getListaMasini();
				System.out.println("\n");
				for(Masini m : masini)
				{
					System.out.println(m.toString());					
				}				
				break;
				
			case 5:
				List<Masini> listaMasini;
				System.out.println("Introduceti marca masinii:");
				String marca2 =  in.readLine();
				listaMasini = db.getMarcaMasini(marca2);
				System.out.println("\n");
				for(Masini m : listaMasini)
				{
					System.out.println(m.toString());
				}
				break;
				
			case 6:
				int nrDeMasini= db.getNrMasini();
				int nrTotal = db.getListaMasini().size();				
				System.out.println("\n Statistica: "+ (nrDeMasini*100)/nrTotal + " %.");				
				break;
				
			case 7:
				List<Masini> listaMasini2 = db.getMasini5ani();
				System.out.println("\n");
				for(Masini m : listaMasini2)
				{
					System.out.println(m.toString());
				}
				break;
				
			default:break;
			}
			
		}while(opt != 0);
	}

}
