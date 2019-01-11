package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.User;
import Persistance.OperatiiBD;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String user=request.getParameter("user");
		String password=request.getParameter("pass");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ConexiuneBD.xml");
		OperatiiBD db = (OperatiiBD)context.getBean("operatiiJDBC");
		
		User userDB = null;
		try {
			userDB = db.verificaUtilizator(user, password);
		}
		catch (Exception e){
			response.sendError(403,"Unauthorised");
			System.out.println("Usename sau parola incorecta");
		}
		
		if (userDB != null) {
			//response.setHeader("name", userDB.getUtilizator());
			response.sendRedirect("http://localhost:8080/Tema3/MainPage?id="+userDB.getId());
		}
		
	}

}
