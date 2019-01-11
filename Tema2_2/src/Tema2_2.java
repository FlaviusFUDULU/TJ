import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tema2_2 {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Vehicul v1 = (Vehicul)context.getBean("Autoturism1");
		Vehicul v2 = (Vehicul)context.getBean("Autoturism2");
		Vehicul v3 = (Vehicul)context.getBean("Motocicleta1");
		Vehicul v4 = (Vehicul)context.getBean("Motocicleta2");
		Vehicul v5 = (Vehicul)context.getBean("Tir1");
		
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v3.toString());
		System.out.println(v4.toString());
		System.out.println(v5.toString());
	}

}
