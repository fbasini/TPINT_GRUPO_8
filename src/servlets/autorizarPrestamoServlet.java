package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Prestamos;
import negocioImpl.prestamoNegocioImpl;

/**
 * Servlet implementation class autorizarPrestamoServlet
 */
@WebServlet("/autorizarPrestamoServlet")
public class autorizarPrestamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autorizarPrestamoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sAutorizar");
		try{
			if(request.getParameter("btnEnviar")!=null) { 
				System.out.println("sIf");
				Prestamos prestamo= new Prestamos();
				prestamo.setAutorizado(request.getParameter("autorizar").charAt(0));
				prestamo.setIdPrestamo(Integer.parseInt(request.getParameter("idPrestamo")));
				prestamoNegocioImpl prestamoNeg=new prestamoNegocioImpl();
				int filas=prestamoNeg.updatePrestamo(prestamo);
				System.out.println(filas);
				 RequestDispatcher rd = request.getRequestDispatcher("Admin/AutorizarPrestamos.jsp");
		            rd.forward(request, response);
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
