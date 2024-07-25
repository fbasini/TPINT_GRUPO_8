package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cuenta;
import negocioImpl.cuentaNegocioImpl;

/**
 * Servlet implementation class ObtenerCuentasServlet
 */
@WebServlet("/ObtenerCuentasServlet")
public class ObtenerCuentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private cuentaNegocioImpl cuentaDAO = new cuentaNegocioImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerCuentasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        ArrayList<Cuenta> cuentasCliente = cuentaDAO.listarCuentasDeCliente(idCliente);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
