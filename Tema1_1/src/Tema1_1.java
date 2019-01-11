import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tema1_1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException{

		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD)context.getBean("operatiiJDBC");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int opt;
		int opt2;
		
		do{
			System.out.println("\n----------------------------------------------------------------");
			System.out.println(" 1. Angajat");
			System.out.println(" 2. Curs");		
			System.out.println(" 0. Iesire.");			
			opt = Integer.parseInt(in.readLine());
			
			switch(opt){
			case 1:
				do {
					System.out.println("\n--------------Angajat--------------------------------------------------");
					System.out.println(" 1. Adaugare");
					System.out.println(" 2. Cautare");		
					System.out.println(" 3. Stergere");
					System.out.println(" 4. Actualizare");
					System.out.println(" 5. Afisare toti angajatii dintr-o firma");
					System.out.println(" 6. Afisare toti angajatii dupa vechime");
					System.out.println(" 7. Afisare toti angajatii cu un anumit curs");
					System.out.println(" 0. Inapoi.");
					opt2 = Integer.parseInt(in.readLine());
					
					switch(opt2){
					case 1:
						System.out.println("Introduceti datele angajatulu.");
						System.out.print("Nume: ");
						String nume =  in.readLine();
						
						System.out.print("Firma: ");
						String firma =  in.readLine();
						
						System.out.print("Functia: ");
						String functia =  in.readLine();
						
						System.out.print("Data angajarii: ");
						SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
						Date data =  (Date) sd.parse(in.readLine());
						db.insertAngajat(nume,firma,functia,data);
						break;
					case 2:
						System.out.println("Introduceti numele angajatulu pentru cautare.");
						System.out.print("Nume: ");
						String numeDeCautat =  in.readLine();
						System.out.println(db.cautareAngajat(numeDeCautat).toString());
						break;
					case 3:
						System.out.println("Introduceti numele angajatulu pentru stergere.");
						System.out.print("Nume: ");
						String numeDeSters =  in.readLine();
						db.stergereAngajat(numeDeSters);
						break;
					case 4:
						System.out.println("Introduceti numele angajatulu pentru actualizare.");
						System.out.print("Nume: ");
						String numeDeActualizat =  in.readLine();
						Angajati angDeActual = db.cautareAngajat(numeDeActualizat);
						if (angDeActual!=null) {
							System.out.println("Veti actualiza urmatorul angajat");
							System.out.println(angDeActual.toString());
							System.out.println("Introduceti datele angajatulu.");
							System.out.print("Nume: ");
							String numeDeActualizat2 =  in.readLine();
							
							System.out.print("Firma: ");
							String firmaDeActualizat =  in.readLine();
							
							System.out.print("Functia: ");
							String functiaDeActualizat =  in.readLine();
							
							System.out.print("Data angajarii: ");
							SimpleDateFormat sdactualizare = new SimpleDateFormat("dd/MM/yyyy");
							Date dataDeActualizat =  (Date) sdactualizare.parse(in.readLine());
							db.actualizareAngajat(numeDeActualizat2,firmaDeActualizat,functiaDeActualizat,dataDeActualizat,numeDeActualizat);
						}
						else {
							System.out.print("Nu a fost gasit niciun angajat cu numele " + numeDeActualizat);
						}
						break;
					case 5:
						System.out.println("Introduceti numele firmei pentru afisarea angajatilor.");
						System.out.print("Nume firma: ");
						String numeFirma =  in.readLine();
						List<Angajati> listaAng = db.afisareAndDinFirma(numeFirma);
						for(Angajati ang : listaAng)
						{
							System.out.println(ang.toString());
						}
						break;
					case 6:
						System.out.println("Introduceti numarul de ani pentru afisarea angajatilor.");
						System.out.print("Numar de ani: ");
						int numarDeAni =  Integer.parseInt(in.readLine());
						List<Angajati> listaAngData = db.afisareVechimeMaiMareDe(numarDeAni);
						for(Angajati ang : listaAngData)
						{
							System.out.println(ang.toString());
						}
						break;
					case 7:
						System.out.println("Introduceti denumirea cursului pentru afisarea angajatilor care au participat.");
						System.out.print("Denumire curs: ");
						String denumireCurs =  in.readLine();
						List<Angajati> listaAngCurs = db.afisareDupaCurs(denumireCurs);
						for(Angajati ang : listaAngCurs)
						{
							System.out.println(ang.toString());
						}
						break;
					}
				}while(opt2!=0);
				break;
				
			case 2:
				do {
					System.out.println("\n--------------Curs--------------------------------------------------");
					System.out.println(" 1. Adaugare");
					System.out.println(" 2. Cautare");		
					System.out.println(" 3. Stergere");
					System.out.println(" 4. Editare");
					System.out.println(" 0. Inapoi.");
					opt2 = Integer.parseInt(in.readLine());
					
					switch(opt2){
					case 1:
						System.out.println("Introduceti datele cursului.");
						System.out.print("ID-ul angajatului: ");
						String id_angajat =  in.readLine();
						
						System.out.print("Denumire curs: ");
						String denumire =  in.readLine();
						
						System.out.print("Numar de ore: ");
						int numar_ore = Integer.parseInt(in.readLine());
						
						System.out.print("Valoare: ");
						float valoare = Integer.parseInt(in.readLine());
						
						System.out.print("Diploma de absolvire(d/n): ");
						String diploma_de_absolvire =  in.readLine();
						
						System.out.print("Anul: ");
						int anul = Integer.parseInt(in.readLine());	
						db.insertCurs(id_angajat,denumire,numar_ore,diploma_de_absolvire,anul,valoare);
						break;
					case 2:
						System.out.println("Introduceti denumirea cursului pentru cautare.");
						System.out.print("Denumire curs: ");
						String denumireDeCautatat =  in.readLine();
						System.out.println(db.cautareCurs(denumireDeCautatat).toString());
						break;
					case 3:
						System.out.println("Introduceti denumirea cursului pentru stergere.");
						System.out.print("Denumire curs: ");
						String denumireDeSters =  in.readLine();
						db.stergereCurs(denumireDeSters);
						break;
					case 4:
						System.out.println("Introduceti denumirea cursului pentru actualizare.");
						System.out.print("Denumire curs: ");
						String denumireDeActualizat =  in.readLine();
						Curs cursDeActual = db.cautareCurs(denumireDeActualizat);
						if (cursDeActual!=null) {
							System.out.println("Veti actualiza urmatorul curs");
							System.out.println(cursDeActual.toString());
							System.out.println("Introduceti datele cursului.");
							System.out.print("ID-ul angajatului: ");
							String id_angajat2 =  in.readLine();
							
							System.out.print("Denumire curs: ");
							String denumire2 =  in.readLine();
							
							System.out.print("Numar de ore: ");
							int numar_ore2 = Integer.parseInt(in.readLine());
							
							System.out.print("Valoare: ");
							float valoare2 = Integer.parseInt(in.readLine());
							
							System.out.print("Diploma de absolvire(d/n): ");
							String diploma_de_absolvire2 =  in.readLine();
							
							System.out.print("Anul: ");
							int anul2 = Integer.parseInt(in.readLine());	
							db.actualizareCurs(id_angajat2,denumire2,numar_ore2,valoare2,diploma_de_absolvire2,anul2,denumireDeActualizat);
						}
						else {
							System.out.print("Nu a fost gasit niciun angajat cu numele " + denumireDeActualizat);
						}
						break;
					}
				}while(opt2!=0);
				break;
				
			default:break;
			}
			
		}while(opt != 0);
	}

}
