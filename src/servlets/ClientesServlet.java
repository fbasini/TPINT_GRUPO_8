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

@WebServlet("/Clientes")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClientesServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteDaoImpl clienteDAO = new clienteDaoImpl();
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();
        request.setAttribute("listaClientes", clientes);
        request.getRequestDispatcher("Admin/AdministrarClientes2.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
