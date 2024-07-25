package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import entidad.Usuario;
import negocioImpl.usuarioNegocioImpl;


@WebServlet("/cambiarContraseniaServlet")
public class cambiarContraseniaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public cambiarContraseniaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String usuarioNombre = (String) session.getAttribute("usuario");
        String contrasenia = request.getParameter("pssNueva1");
        String repetirContrasenia = request.getParameter("pssNueva2");

        if (!contrasenia.equals(repetirContrasenia)) {
            String mensajeError = "Las contraseñas no coinciden.";
            request.setAttribute("mensaje", mensajeError);
            RequestDispatcher rd = request.getRequestDispatcher("Cliente/PaginaError.jsp");
            rd.forward(request, response);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioNombre);
        usuario.setContraseñaUsuario(contrasenia);
        usuarioNegocioImpl usuarioNeg = new usuarioNegocioImpl();       

        int filas = usuarioNeg.updatePassword(usuario);
        String mensaje="";
        if (filas > 0) {
            mensaje += "Contraseña cambiada con éxito";
        } else {
        	
            mensaje += "Error al cambiar la contraseña"; // manejar excepción
            RequestDispatcher rd = request.getRequestDispatcher("Cliente/PaginaError.jsp");
            rd.forward(request, response);
        }
        request.setAttribute("mensaje", mensaje);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("Cliente/PaginaExito.jsp");
        rd.forward(request, response);
		
	}

}
