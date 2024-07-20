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
        if (request.getParameter("btnModificar") != null) {
            String password = request.getParameter("txtPassword");
            String nombreUsuario = request.getParameter("nombreUsuario");

            // Depuración: imprimir los valores recibidos
            System.out.println("Nombre de usuario: " + nombreUsuario);
            System.out.println("Contraseña: " + password);

            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setContraseñaUsuario(password);

            usuarioNegocioImpl usuarioNeg = new usuarioNegocioImpl();
            int filas = usuarioNeg.updatePassword(usuario);

            String mensaje;
            if (filas > 0) {
                mensaje = "Cliente modificado con éxito";
            } else {
                mensaje = "No se pudo modificar al cliente";
            }
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("Admin/AdministrarClientes.jsp").forward(request, response);
        }
    }
}