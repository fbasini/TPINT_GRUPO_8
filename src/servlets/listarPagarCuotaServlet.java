package servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Prestamos;
import entidad.pagoCuota;
import negocioImpl.pagoCuotaNegocioImpl;
import negocioImpl.prestamoNegocioImpl;

/**
 * Servlet implementation class pagarCuotaServlet
 */
@WebServlet("/listarPagarCuotaServlet")
public class listarPagarCuotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listarPagarCuotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession misesion = request.getSession();
			pagoCuota pagoCuota=new pagoCuota();
			
			pagoCuota.setIdCliente((int)misesion.getAttribute("idcliente"));
			
			//pagoCuota.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
			
			pagoCuotaNegocioImpl pagoCuotaNeg= new pagoCuotaNegocioImpl();
	        ArrayList<pagoCuota> listaCuotas = pagoCuotaNeg.listaCuotas(pagoCuota);
	        System.out.println("Número de cuotas en servlet: " + listaCuotas.size()); 
	       // ArrayList<pagoCuota> listaCuentas=((ArrayList<pagoCuota>)misesion.getAttribute("cuentasCliente"));
		     //HttpSession sesion = request.getSession();
	        misesion.setAttribute("listaCuotas", listaCuotas);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	  request.getRequestDispatcher("Cliente/Deudas.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
