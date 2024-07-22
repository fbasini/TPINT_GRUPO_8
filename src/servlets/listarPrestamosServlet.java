package servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoimpl.clienteDaoImpl;
import daoimpl.prestamoDaoImpl;
import entidad.Cliente;
import entidad.Prestamos;
import negocioImpl.prestamoNegocioImpl;

/**
 * Servlet implementation class AutorizarPrestamo
 */
@WebServlet("/listarPrestamosServlet")
public class listarPrestamosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarPrestamosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------------------");
		System.out.println("servlet");
		try{
			/*if(request.getParameter("btnEnviar")!=null) { *///ver q onda
			
				prestamoNegocioImpl prestamoNeg= new prestamoNegocioImpl();
		        ArrayList<Prestamos> listaPrestamos = prestamoNeg.listaPrestamo();
		        System.out.println("Número de prestamos en servlet: " + listaPrestamos.size()); 
		        HttpSession sesion = request.getSession();
		        sesion.setAttribute("listaPrestamos", listaPrestamos);
		      
			//}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		  request.getRequestDispatcher("Admin/AutorizarPrestamos.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
