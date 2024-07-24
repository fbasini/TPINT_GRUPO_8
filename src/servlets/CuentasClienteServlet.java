package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.cuentaDaoImpl;
import entidad.Cuenta;


@WebServlet("/CuentasCliente")
public class CuentasClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CuentasClienteServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente = (int) request.getSession().getAttribute("idCliente");
        
        cuentaDaoImpl cuentaDao = new cuentaDaoImpl();
        ArrayList<Cuenta> cuentasCliente = cuentaDao.obtenerCuentasCliente(idCliente);
        
        for (Cuenta cuenta : cuentasCliente) {
            String tipoCuentaId = cuenta.getTipoCuenta();
            String descripcionTipoCuenta = cuentaDao.obtenerDescripcionTipoCuenta(tipoCuentaId); 
            cuenta.setTipoCuenta(descripcionTipoCuenta); 
            System.out.println("Tipo Cuenta ID: " + tipoCuentaId + ", Descripción: " + descripcionTipoCuenta);
        }
        
        request.getSession().setAttribute("cuentasCliente", cuentasCliente);

        request.getRequestDispatcher("UsuarioHome.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
