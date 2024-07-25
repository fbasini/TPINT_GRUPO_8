package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		try {
			HttpSession session = request.getSession();
            int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
            cuentaNegocioImpl cuentaDAO = new cuentaNegocioImpl();
            
            cuentaDAO.eliminarCuenta(idCuenta);
            ArrayList<Cuenta> allCuentas = cuentaDAO.listarCuentas();
            
			session.setAttribute("allCuentas", allCuentas);
            response.sendRedirect("Admin/AdministrarCuenta.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocurrió un error al eliminar la cuenta: " + e.getMessage());
        }
	}

}
