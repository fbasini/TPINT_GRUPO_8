package servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entidad.Cuenta;
import entidad.Movimiento;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.movimientoNegocioImpl;

/**
 * Servlet implementation class agregarCuentaServlet
 */
@WebServlet("/agregarCuentaServlet")
public class agregarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarCuentaServlet() {
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
		
		cuentaNegocioImpl neo = new cuentaNegocioImpl();
		 movimientoNegocioImpl negMovimientos = new movimientoNegocioImpl();
		int CBU = Integer.parseInt(request.getParameter("txtCBU"));
        String tipoCuenta = request.getParameter("tipoCuenta");
        BigDecimal saldoFijo = BigDecimal.valueOf(10000.00);
        Movimiento movimiento = new Movimiento();
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setIdcliente(1);
        nuevaCuenta.setTipoCuenta(tipoCuenta);
       nuevaCuenta.setFechaCreacion(LocalDate.now());
       nuevaCuenta.setCBUCuenta(CBU);
       nuevaCuenta.setSaldoCuenta(saldoFijo);
       nuevaCuenta.setCuentaActiva('Y');
        	
        
       
       
       int filas = neo.agregarCuenta(nuevaCuenta);
       String mensaje;
       if (filas > 0) {
           mensaje = "Cliente agregado con éxito";
       } else {
           mensaje = "No se pudo agregar al cliente"; // manejar excepción
       }
       
       

       movimiento.setIdcuenta(nuevaCuenta.getIdcuenta());
       movimiento.setTipoMovimiento("Alta de cuenta");
       movimiento.setFechaMovimiento(LocalDate.now());
       movimiento.setDetalleMovimiento("-");
       movimiento.setImporteMovimiento(saldoFijo);
       movimiento.setDestinatario(CBU);
       
       int resultado2 = negMovimientos.agregarMovimiento(movimiento);
       
       if(resultado2 !=1) {
    	   
    	   System.out.println("Movimiento agregado");
    	   
       }else {
    	   
    	   System.out.println("Error en movimiento");
    	   
       }
       
       request.setAttribute("mensaje", mensaje);
       response.sendRedirect("Admin/GestionCuentas.jsp");
	}

	
	}


