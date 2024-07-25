package servlets;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cuenta;
import entidad.Prestamos;
import entidad.pagoCuota;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.pagoCuotaNegocioImpl;
import negocioImpl.prestamoNegocioImpl;

/**
 * Servlet implementation class pagarCuotaServlet
 */
@WebServlet("/pagarCuotaServlet")
public class pagarCuotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pagarCuotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(request.getParameter("btnEnviar")!=null) { 
				System.out.println("-------------------");
				System.out.println("servlet pagar cuota");
				
				int idPrestamo=Integer.parseInt(request.getParameter("idPrestamo"));
				int idCliente=Integer.parseInt(request.getParameter("idCliente"));
				int idCuenta=Integer.parseInt(request.getParameter("misCuentas"));
				int idCuota=Integer.parseInt(request.getParameter("cuota"));
				Double monto=Double.parseDouble(request.getParameter("cuota"));
				BigDecimal montoAPagar=BigDecimal.valueOf(monto);
				
				pagoCuota pagoCuota=new pagoCuota();
				pagoCuota.setIdCliente(idCliente);
				pagoCuota.setIdCuenta(idCuenta);
				pagoCuota.setFechaPago(LocalDate.now());
				pagoCuota.setIdCuota(idCuota);
				pagoCuota.setIdPrestamo(idPrestamo);
				
				System.out.println("cuenta");
				Cuenta cuenta=new Cuenta();
				cuenta.setIdcuenta(idCuenta);
				cuenta.setSaldoCuenta(montoAPagar);
				cuentaNegocioImpl cuentaNeg= new cuentaNegocioImpl();
				int asignado=cuentaNeg.pagarPrestamo(cuenta);
				System.out.println("prestamos en la cuenta");
				System.out.println(asignado);
				
					pagoCuotaNegocioImpl pagoCuotaNeg=new pagoCuotaNegocioImpl();
					int filas= pagoCuotaNeg.updateCuota(pagoCuota);
					System.out.println("Filas insertadas en pagocuotas");
					System.out.println(filas);
				 RequestDispatcher rd = request.getRequestDispatcher("listarPagarCuotaServlet");
		            rd.forward(request, response);

			}	}catch(Exception e) {
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
