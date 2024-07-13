package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
import negocioImpl.usuarioNegocioImpl;

@WebServlet("/ModificarClientesServlet")
public class ModificarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificarClientesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("j");
	if(request.getParameter("btnModificar")!=null) {
			String password=request.getParameter("txtPassword");
			Usuario usuario=new Usuario();
			
			usuario.setContraseñaUsuario(password);
			usuarioNegocioImpl usuarioNeg= new usuarioNegocioImpl();
			int fila=usuarioNeg.updatePassword(usuario);
			System.out.println(fila);
			 
		}
	}

}
