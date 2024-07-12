package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.clienteDaoImpl;
import entidad.Cliente;

@WebServlet("/ListarClientesServlet")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarClientesServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando en el servlet ListarClientesServlet"); // debug
		try {
            String opc = request.getParameter("opc");
            if (opc != null && opc.equals("1")) {
				clienteDaoImpl clienteDAO = new clienteDaoImpl();
		        ArrayList<Cliente> clientes = clienteDAO.listarClientes();
		        System.out.println("Número de clientes en servlet: " + clientes.size()); // Debug
		        request.setAttribute("listaClientes", clientes);
		        request.getRequestDispatcher("Admin/AdministrarClientes.jsp").forward(request, response);
            }
		 } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocurrió un error en el servidor: " + e.getMessage());
	        }
	}

}
