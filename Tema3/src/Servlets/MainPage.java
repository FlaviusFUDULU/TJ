package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Masina;
import Model.User;
import Persistance.OperatiiBD;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(request.getParameter("id"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD)context.getBean("operatiiJDBC");
		
		User userDB = null;
		try {
			userDB = db.getUserById(userId);
		}
		catch (Exception e){
			response.sendError(403,"Unauthorised");
		}

		//response.getWriter().append("Served at mainpage: ").append(user);
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("table {");
		out.print("font-family: arial, sans-serif;");
		out.print("border-collapse: collapse;");
		out.print("width: 100%;");
		out.print("}");

		out.print("td, th {");
		out.print("  border: 1px solid #dddddd;");
		out.print(" text-align: left;");
		out.print("padding: 8px;");
		out.print("}");

		out.print("tr:nth-child(even) {");
		out.print("background-color: #dddddd;");
		out.print("}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Bine ai venit, " + userDB.getUtilizator() + "</h1>");
		if (userDB.getNivel_de_acces() == 2) {
			out.print("<h1>Nivelul ultilizatorului este 2. Adauga panou AICI</h1>");
		}
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>Nr de inmatriculare</th>");
		out.print("<th>Marca</th>");
		out.print("<th>Modelul</th>");
		out.print("<th>Culoarea</th>");
		out.print("<th>Anul fabricatiei</th>");
		out.print("<th>Capacitatea cilindrica</th>");
		out.print("<th>Tipul de combustibil</th>");
		out.print("<th>Puterea</th>");
		out.print("<th>Cuplul</th>");
		out.print("<th>Volumul portbagajului</th>");
		out.print("<th>Pretul</th>");
		out.print("</tr>");
		
		
		List<Masina> masini = db.getAllCars();
		
		for (Masina masina : masini) {
			out.print("<tr>");
			//out.print("<td>Alfreds Futterkiste</td>");
			out.print("<td>" + masina.getNr_inmatriculare() + "</td>");
			out.print("<td>" + masina.getMarca() + "</td>");
			out.print("<td>" + masina.getModelul() + "</td>");
			out.print("<td>" + masina.getCuloarea() + "</td>");
			out.print("<td>" + masina.getAnul_fabricatiei() + "</td>");
			out.print("<td>" + masina.getCapacitatea_cilindrica() + "</td>");
			out.print("<td>" + masina.getTipul_de_combustibil() + "</td>");
			out.print("<td>" + masina.getPutere() + "</td>");
			out.print("<td>" + masina.getCuplu() + "</td>");
			out.print("<td>" + masina.getVolumul_portbagajului() + "</td>");
			out.print("<td>" + masina.getPretul() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
