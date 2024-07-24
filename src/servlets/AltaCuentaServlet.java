package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import entidad.Cuenta;

import negocioImpl.cuentaNegocioImpl;
import negocioImpl.clienteNegocioImpl;

@WebServlet("/AltaCuentaServlet")
public class AltaCuentaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private clienteNegocioImpl clienteDAO = new clienteNegocioImpl();
    private cuentaNegocioImpl cuentaDAO = new cuentaNegocioImpl();

    public AltaCuentaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	/*List<Cliente> clientes = new ArrayList<>();
        List<Cuenta> cuentasDisponibles = new ArrayList<>();

        clientes = clienteDAO.listarClientes();
		cuentasDisponibles = cuentaDAO.obtenerCuentasDisponibles();
		request.setAttribute("clientes", clientes);
		request.setAttribute("cuentasDisponibles", cuentasDisponibles);
		request.getRequestDispatcher("/altaCliente.jsp").forward(request, response);
		*/
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int idCliente = Integer.parseInt(request.getParameter("usuarios"));
        int idCuenta = Integer.parseInt(request.getParameter("numeroCuentaAsig"));
        System.out.println(idCliente);
        System.out.println(idCuenta);
        System.out.println("Entro al servlet");

        if (cuentaDAO.asignarCuenta(idCliente, idCuenta)) {
            System.out.println("Asignado");
            
            ArrayList<Cuenta> cuentasDisp = cuentaDAO.obtenerCuentasDisponibles();
            session.setAttribute("cuentasDisp", cuentasDisp);
            response.sendRedirect("Admin/GestionCuentas.jsp");
        } else {
            System.out.println("No asignado");
            request.setAttribute("error", "No se pudo asignar la cuenta o el cliente ya tiene 3 cuentas asignadas.");
            doGet(request, response); // Redirige para recargar los datos en el formulario
        }
    }
}