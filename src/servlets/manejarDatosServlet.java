package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import entidad.Provincias;
import negocioImpl.clienteNegocioImpl;

@WebServlet("/manejarDatosServlet")
public class manejarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public manejarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteNegocioImpl negCliente = new clienteNegocioImpl();
		HttpSession session = request.getSession();
		
		Cliente cliente = negCliente.obtenerClienteActual((int)session.getAttribute("idcliente"));
		session.setAttribute("clienteActual", cliente);
		
		ArrayList<Provincias> listaProvincias = negCliente.obtenerProvincias();
		session.setAttribute("listaProvincias", listaProvincias);
		
		response.sendRedirect("Cliente/MisDatos.jsp");
		
		
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		cliente = (Cliente) request.getSession().getAttribute("clienteActual");
		/*
		cliente.setDNIcliente(Integer.parseInt(request.getParameter("txtDNI")));
		cliente.setCUILcliente(Integer.parseInt(request.getParameter("txtCUIL")));
		cliente.setNombreCliente(request.getParameter("txtNombre"));
		cliente.setApellidoCliente(request.getParameter("txtApellido"));
		cliente.setSexoCliente(request.getParameter("txtSexo").charAt(0));
		cliente.setNacionalidadCliente(request.getParameter("txtNacionalidad"));
		cliente.setFechaNacimientoCliente(request.getParameter("txtFechaNacimiento"));
		cliente.setDireccionCliente(request.getParameter("txtDireccion"));
		cliente.setLocalidadCliente(request.getParameter("txtLocalidad"));
		cliente.setIdProvincias(request.getParameter("txtProvincia"));
		cliente.setEmailCliente(request.getParameter("txtEmail"));
		cliente.setTelefonoCliente(Integer.parseInt(request.getParameter("txtTelefono")));
		*/
	}

}
