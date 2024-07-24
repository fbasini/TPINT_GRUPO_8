package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoimpl.usuarioDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Usuario;
import negocio.usuarioNegocio;
import negocioImpl.clienteNegocioImpl;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.usuarioNegocioImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreUsuario = request.getParameter("usuario");
        String passwordUsuario = request.getParameter("contraseña");
       
        usuarioNegocioImpl usuarioNeg= new usuarioNegocioImpl();
        Usuario usuario= usuarioNeg.obtenerUsuario(nombreUsuario,passwordUsuario);
        
        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", nombreUsuario);
        	
            if (usuario.isTipoUsuario()=='A') {
            	clienteNegocioImpl clienteNeg = new clienteNegocioImpl();
            	cuentaNegocioImpl cuentaNeg = new cuentaNegocioImpl();
            	
            	ArrayList<Cuenta> allCuentas = cuentaNeg.listarCuentas();
            	ArrayList<Cuenta> cuentasDisp = cuentaNeg.obtenerCuentasDisponibles();
            	ArrayList<Cliente> allClientes = clienteNeg.listarAllClientes();
            	
            	session.setAttribute("allCuentas", allCuentas);
            	session.setAttribute("cuentasDisp", cuentasDisp);
            	session.setAttribute("allClientes", allClientes);
            	
                response.sendRedirect("Admin/AdminHome.jsp");

            } else {
            	clienteNegocioImpl clienteNeg = new clienteNegocioImpl();
            	int idcliente = clienteNeg.obtenerIDUsuario(nombreUsuario);
            	
            	cuentaNegocioImpl cuentaNeg = new cuentaNegocioImpl();
            	ArrayList<Cuenta> cuentasCliente =cuentaNeg.listarCuentasDeCliente(idcliente);
            	
            	session.setAttribute("idcliente", idcliente);
            	session.setAttribute("cuentasCliente", cuentasCliente);
            	
            	
                response.sendRedirect("Cliente/UsuarioHome.jsp");
            }
        } else {
            response.sendRedirect("Login.jsp?error=true");
        }
	}

}
