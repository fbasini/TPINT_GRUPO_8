package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Usuario;
import negocioImpl.usuarioNegocioImpl;

@WebServlet("/agregarClienteServlet")
public class agregarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public agregarClienteServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("btnAceptar") != null) {
	            String usuarioNombre = request.getParameter("txtUsuario");
	            String contrase�a = request.getParameter("txtContrase�a");
	            String repetirContrase�a = request.getParameter("txtRepetirContrase�a");

	            if (!contrase�a.equals(repetirContrase�a)) {
	                String mensajeError = "Las contrase�as no coinciden.";
	                request.setAttribute("mensaje", mensajeError);
	                RequestDispatcher rd = request.getRequestDispatcher("Admin/AgregarClientes.jsp");
	                rd.forward(request, response);
	                return;
	            }

	            Usuario usuario = new Usuario();
	            usuario.setNombreUsuario(usuarioNombre);
	            usuario.setContrase�aUsuario(contrase�a);
	            usuarioNegocioImpl usuarioNeg = new usuarioNegocioImpl();
	            Cliente cliente = new Cliente();
	            cliente.setNombreUsuario(usuarioNombre);

	            int filas = usuarioNeg.agregarUsuario(usuario);
	            String mensaje;
	            if (filas > 0) {
	                mensaje = "Cliente agregado con �xito";
	            } else {
	                mensaje = "No se pudo agregar al cliente"; // manejar excepci�n
	            }
	            request.setAttribute("mensaje", mensaje);
	            RequestDispatcher rd = request.getRequestDispatcher("Admin/AgregarClientes.jsp");
	            rd.forward(request, response);
		 }
	}
}
;