package servlets;

import java.io.IOException;
import java.time.LocalDate;
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

@WebServlet("/primerIngresoServlet")
public class primerIngresoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public primerIngresoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clienteNegocioImpl negCliente = new clienteNegocioImpl();
		HttpSession session = request.getSession();
						
		ArrayList<Provincias> listaProvincias = negCliente.obtenerProvincias();
		session.setAttribute("listaProvincias", listaProvincias);
		
		response.sendRedirect("Cliente/MiPrimerIngreso.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Cliente cliente = new Cliente();
		HttpSession session = request.getSession();
		
		clienteNegocioImpl negCliente = new clienteNegocioImpl();
		
		int DNIingresado = Integer.parseInt(request.getParameter("txtDNI"));
		int CUILingresado = Integer.parseInt(request.getParameter("txtCUIL"));
		
		String mensajeResultado = "";
		int errores = 0;
		
		if (negCliente.comprobarExistenciaDNI(DNIingresado)){
			//System.out.println("DNI EXISTE");
			
			mensajeResultado += "Los siguientes campos no han sido validos: DNI";
			errores++;
			
		}
		//else {System.out.println("DNI VALIDO");}
		
		if (negCliente.comprobarExistenciaCUIL(CUILingresado)){
			//System.out.println("CUIL EXISTE");
			
			if (mensajeResultado == "") {
				mensajeResultado += "Los siguientes campos no han sido validos: CUIL";	
			}
			else{mensajeResultado += " CUIL";}
			errores++;
		}
		//else {System.out.println("CUIL VALIDO");}
		
		if (errores > 0) {
			request.setAttribute("mensaje", mensajeResultado);
	        request.getRequestDispatcher("Cliente/PaginaError.jsp").forward(request, response);
		}  
		
		cliente.setNombreUsuario((String)session.getAttribute("usuario"));
		cliente.setDNIcliente(Integer.parseInt(request.getParameter("txtDNI")));
		cliente.setCUILcliente(Integer.parseInt(request.getParameter("txtCUIL")));
		cliente.setNombreCliente(request.getParameter("txtNombre"));
		cliente.setApellidoCliente(request.getParameter("txtApellido"));
		cliente.setSexoCliente(request.getParameter("txtSexo").charAt(0));
		cliente.setNacionalidadCliente(request.getParameter("txtNacionalidad"));
		cliente.setFechaNacimientoCliente(LocalDate.parse(request.getParameter("txtFechaNacimiento")));
		cliente.setDireccionCliente(request.getParameter("txtDireccion"));
		cliente.setLocalidadCliente(request.getParameter("txtLocalidad"));
		cliente.setIdProvincias(Integer.parseInt(request.getParameter("ddlProvincia")));
		cliente.setEmailCliente(request.getParameter("txtEmail"));
		cliente.setTelefonoCliente(Integer.parseInt(request.getParameter("txtTelefono")));
		cliente.setClienteActivo('Y');
		
		negCliente.agregarCliente(cliente);
		
		
		session.setAttribute("clienteActual",cliente);
		
		
		System.out.println("Ciente agregado");
		
		response.sendRedirect("Cliente/primeraCuenta.jsp");
	}

}
