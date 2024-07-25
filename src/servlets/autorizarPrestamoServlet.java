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
import entidad.Movimiento;
import entidad.Prestamos;
import entidad.pagoCuota;
import negocioImpl.clienteNegocioImpl;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.movimientoNegocioImpl;
import negocioImpl.pagoCuotaNegocioImpl;
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
		try{
			if(request.getParameter("btnEnviar")!=null) { 
				System.out.println("-------------------");
				System.out.println("servlet autorizar");
				
				char autorizado=request.getParameter("autorizar").charAt(0);
				int idPrestamo=Integer.parseInt(request.getParameter("idPrestamo"));
				int idCliente=Integer.parseInt(request.getParameter("idCliente"));
				int idCuenta=Integer.parseInt(request.getParameter("idCuenta"));
				double monto=Double.parseDouble(request.getParameter("montoSolicitado"));
				BigDecimal montoSolicitado=BigDecimal.valueOf(monto);
				double montoPorC=Double.parseDouble(request.getParameter("montoPorCuota"));
				BigDecimal montoPorCuota=BigDecimal.valueOf(montoPorC);
				int cuotas=Integer.parseInt(request.getParameter("cuotas"));
				
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
					int asignado=cuentaNeg.asignarPrestamo(cuenta);
					System.out.println("prestamos en la cuenta");
					System.out.println(asignado);
					
					pagoCuota pagoCuota= new pagoCuota();
					pagoCuota.setIdPrestamo(idPrestamo);
					pagoCuota.setIdCuenta(idCuenta);
					pagoCuota.setIdCliente(idCliente) ;
					pagoCuota.setMontoAPagar(montoPorCuota);
					pagoCuota.setCuotas(cuotas);
					pagoCuota.setFechaPago(LocalDate.now());
					pagoCuotaNegocioImpl pagoCuotaNeg=new pagoCuotaNegocioImpl();
					int filas= pagoCuotaNeg.insertarCuotas(pagoCuota);
					System.out.println("Filas insertadas en pagocuotas");
					System.out.println(montoPorCuota);
				}
				int filas=prestamoNeg.updatePrestamo(prestamo);
				System.out.println("Prestamo autorizado");
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
		
		
		/*
		 * Movimiento movimiento = new Movimiento();
		 *  movimiento.setIdcuenta(idCuentaDestino);
        movimiento.setTipoMovimiento("Alta de un préstamo");
        movimiento.setFechaMovimiento(LocalDate.now());
        movimiento.setDetalleMovimiento("-");
        movimiento.setImporteMovimiento(importeFinal);
        movimiento.setDestinatario((int)misesion.getAttribute("idcliente"));
        
         movimientoNegocioImpl negMovimientos = new movimientoNegocioImpl();
         
         
         
         int resultado2 = negMovimientos.agregarMovimiento(movimiento);
		 * 
		 * 
		 * 
		 */
		
		doGet(request, response);
	}
}
