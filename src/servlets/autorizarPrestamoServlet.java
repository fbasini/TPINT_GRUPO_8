package servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cuenta;
import entidad.Prestamos;
import negocioImpl.clienteNegocioImpl;
import negocioImpl.cuentaNegocioImpl;
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
				System.out.println("-------------------");
				System.out.println("servlet autorizar");
				
				char autorizado=request.getParameter("autorizar").charAt(0);
				int idPrestamo=Integer.parseInt(request.getParameter("idPrestamo"));
				int idCuenta=Integer.parseInt(request.getParameter("idCuenta"));
				double monto=Double.parseDouble(request.getParameter("montoSolicitado"));
				BigDecimal montoSolicitado=BigDecimal.valueOf(monto);
				
				Prestamos prestamo= new Prestamos();
				prestamo.setAutorizado(autorizado);
				prestamo.setIdPrestamo(idPrestamo);
				prestamoNegocioImpl prestamoNeg=new prestamoNegocioImpl();
				System.out.println(autorizado);
				if(autorizado=='Y') {
					System.out.println("cuenta");
					Cuenta cuenta=new Cuenta();
					cuenta.setIdcuenta(idCuenta);
					cuenta.setSaldoCuenta(montoSolicitado);
					cuentaNegocioImpl cuentaNeg= new cuentaNegocioImpl();
					cuentaNeg.asignarPrestamo(cuenta);
				}
				int filas=prestamoNeg.updatePrestamo(prestamo);
				System.out.println(filas);
				 RequestDispatcher rd = request.getRequestDispatcher("listarPrestamosServlet");
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
