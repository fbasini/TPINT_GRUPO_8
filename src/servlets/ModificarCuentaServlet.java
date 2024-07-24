package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import entidad.Cuenta;
import entidad.Usuario;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.usuarioNegocioImpl;

/**
 * Servlet implementation class ModificarCuentaServlet
 */
@WebServlet("/ModificarCuentaServlet")
public class ModificarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCuentaServlet() {
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
		 if (request.getParameter("btnModificar") != null) {
			 HttpSession session = request.getSession();
	            String tipocuenta = request.getParameter("tipoCuenta");
	            String cbucuentaStr = request.getParameter("cbuCuenta");
	            String saldocuentaStr = request.getParameter("saldoCuenta");
	            String idcuentaStr = request.getParameter("idCuenta");
	            String idclienteStr = request.getParameter("idCliente");
	            String fechacreacionStr = request.getParameter("fechaCreacion");

	            try {
	                // Validación y conversión de parámetros
	                if (tipocuenta != null && !tipocuenta.isEmpty() &&
	                    cbucuentaStr != null && !cbucuentaStr.isEmpty() &&
	                    saldocuentaStr != null && !saldocuentaStr.isEmpty() &&
	                    idcuentaStr != null && !idcuentaStr.isEmpty() &&
	                    idclienteStr != null && !idclienteStr.isEmpty()) {
	                    
	                    int idcuenta = Integer.parseInt(idcuentaStr);
	                    int idcliente = Integer.parseInt(idclienteStr);
	                    int cbucuenta = Integer.parseInt(cbucuentaStr);
	                    BigDecimal saldocuenta = new BigDecimal(saldocuentaStr);
	                    LocalDate fechacreacion = null;

	                    if (fechacreacionStr != null && !fechacreacionStr.isEmpty()) {
	                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	                        fechacreacion = LocalDate.parse(fechacreacionStr, formatter);
	                    }

	                    // Crear objeto Cuenta con los datos validados
	                    Cuenta cuenta = new Cuenta();
	                    cuenta.setIdcliente(idcliente);
	                    cuenta.setIdcuenta(idcuenta);
	                    cuenta.setCBUCuenta(cbucuenta);
	                    cuenta.setFechaCreacion(fechacreacion); // Ajustado para LocalDate
	                    cuenta.setTipoCuenta(tipocuenta);
	                    cuenta.setSaldoCuenta(saldocuenta);

	                    // Llamada al método del negocio para actualizar la cuenta
	                    cuentaNegocioImpl cuentaNeg = new cuentaNegocioImpl();
	                    int filas = cuentaNeg.modificarCuenta(cuenta);

	                    String mensaje;
	                    if (filas > 0) {
	                        mensaje = "Cuenta modificada con éxito";
	                        ArrayList<Cuenta> allCuentas = cuentaNeg.listarCuentas();
	                        
							session.setAttribute("allCuentas", allCuentas);
	                        
	                    } else {
	                        mensaje = "No se pudo modificar la cuenta";
	                    }
	                    request.setAttribute("mensaje", mensaje);
	                } else {
	                    request.setAttribute("mensaje", "Por favor, complete todos los campos");
	                }
	            } catch (NumberFormatException e) {
	                e.printStackTrace();
	                request.setAttribute("mensaje", "Error de formato numérico: " + e.getMessage());
	            }

	            // Redirigir de vuelta a la página de gestión de cuentas
	            request.getRequestDispatcher("Admin/AdministrarCuenta.jsp").forward(request, response);
	        }
        }
	}


