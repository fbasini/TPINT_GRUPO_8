package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.clienteDaoImpl;
import daoimpl.cuentaDaoImpl;
import entidad.Cliente;
import entidad.Cuenta;
import negocioImpl.cuentaNegocioImpl;;
/**
 * Servlet implementation class EliminarCuentaServlet
 */
@WebServlet("/EliminarCuentaServlet")
public class EliminarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCuentaServlet() {
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
		String idCuentaParam = request.getParameter("numeroCuentaElim");
        String mensaje;

      
       

        try {
            int idCuenta = Integer.parseInt(idCuentaParam);
            Cuenta cuenta = new Cuenta();
            cuenta.setIdcuenta(idCuenta);

            cuentaNegocioImpl cuentaNeg = new cuentaNegocioImpl();
            
            int filas = cuentaNeg.eliminarCuenta(cuenta);

            if (filas > 0) {
                mensaje = "Cuenta eliminada con éxito.";
            } else {
                mensaje = "No se pudo eliminar la cuenta.";
            }
        } catch (NumberFormatException e) {
            mensaje = "Número de cuenta inválido.";
        }

        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("Admin/GestionCuentas.jsp");
	}

}
