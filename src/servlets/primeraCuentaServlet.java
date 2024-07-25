package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cuenta;
import negocioImpl.clienteNegocioImpl;
import negocioImpl.cuentaNegocioImpl;

@WebServlet("/primeraCuentaServlet")
public class primeraCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public primeraCuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cuenta cuenta = new Cuenta();
		HttpSession session = request.getSession();
		String nombreUsuario = (String) session.getAttribute("usuario");
		clienteNegocioImpl clienteNeg1 = new clienteNegocioImpl();
    	int idcliente = clienteNeg1.obtenerIDUsuario(nombreUsuario);
    	
    	cuenta.setIdcliente(idcliente);
    	cuenta.setTipoCuenta(request.getParameter("ddlTipoCuenta"));
    	cuenta.setFechaCreacion(LocalDate.now());
    	cuenta.setCBUCuenta(1000);
    	cuenta.setSaldoCuenta((BigDecimal.valueOf(10000.0)));
    	cuenta.setCuentaActiva('Y');
		
    	cuentaNegocioImpl negCuenta = new cuentaNegocioImpl();
    	negCuenta.agregarCuenta(cuenta);
    	
    	System.out.println("cuenta agregada");
    	
    	cuentaNegocioImpl cuentaNeg1 = new cuentaNegocioImpl();
    	ArrayList<Cuenta> cuentasCliente =cuentaNeg1.listarCuentasDeCliente(idcliente);
    	
    	session.setAttribute("idcliente", idcliente);
    	session.setAttribute("cuentasCliente", cuentasCliente);
    	
    	response.sendRedirect("Cliente/UsuarioHome.jsp");
		
		
		
	}

}
