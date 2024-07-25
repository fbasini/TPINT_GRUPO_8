package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
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
import entidad.Movimiento;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.movimientoNegocioImpl;
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
        Movimiento movimiento = new Movimiento();
        movimientoNegocioImpl negMovimientos = new movimientoNegocioImpl();
        BigDecimal saldoFijo = BigDecimal.valueOf(10000.00);
        System.out.println(idCliente);
        System.out.println(idCuenta);
        System.out.println("Entro al servlet");

        if (cuentaDAO.asignarCuenta(idCliente, idCuenta)) {
            System.out.println("Asignado");
            
            Cuenta cuenta = new Cuenta();
            cuenta=cuentaDAO.obtenerCuentaPorID(idCuenta);
            
            movimiento.setIdcuenta(idCuenta);
            movimiento.setTipoMovimiento("Alta de cuenta");
            movimiento.setFechaMovimiento(LocalDate.now());
            movimiento.setDetalleMovimiento("Depósito inicial en la cuenta");
            movimiento.setImporteMovimiento(saldoFijo);
            movimiento.setDestinatario(cuenta.getCBUCuenta());
            
            int resultado2 = negMovimientos.agregarMovimiento(movimiento);
            
            if(resultado2 !=1) {
         	   
         	   System.out.println("Movimiento agregado");
         	   
            }else {
         	   
         	   System.out.println("Error en movimiento");
         	   
            }
            
            
            
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