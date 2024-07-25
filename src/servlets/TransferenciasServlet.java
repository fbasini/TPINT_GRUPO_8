package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Movimiento;
import negocioImpl.cuentaNegocioImpl;
import negocioImpl.movimientoNegocioImpl;

@WebServlet("/TransferenciasServlet")
public class TransferenciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransferenciasServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cbuDestino = Integer.parseInt(request.getParameter("cbuDestino"));
        BigDecimal importe = new BigDecimal(request.getParameter("importeATransferir"));

        String idCuentaOrigenStr = (String) request.getSession().getAttribute("idCuentaSeleccionada");
        int idCuentaOrigen = Integer.parseInt(idCuentaOrigenStr);

        movimientoNegocioImpl movNeg = new movimientoNegocioImpl();
        cuentaNegocioImpl cuentaNeg = new cuentaNegocioImpl();

        BigDecimal saldoOrigen = cuentaNeg.obtenerSaldo(idCuentaOrigen);
        if (saldoOrigen.compareTo(importe) < 0) {
            request.setAttribute("mensaje", "Saldo insuficiente.");
            request.getRequestDispatcher("Cliente/TransferirFondos.jsp").forward(request, response);
            return;
        }

        int idCuentaDestino = cuentaNeg.obtenerIdCuentaPorCBU(cbuDestino);
        if (idCuentaDestino == -1) {
            request.setAttribute("mensaje", "CBU de destinatario inválido.");
            request.getRequestDispatcher("Cliente/TransferirFondos.jsp").forward(request, response);
            return;
        }
        
        BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(importe);
        BigDecimal saldoDestino = cuentaNeg.obtenerSaldo(idCuentaDestino);
        BigDecimal nuevoSaldoDestino = saldoDestino.add(importe);
        
        int cbuOrigen = cuentaNeg.obtenerCBUPorIdCuenta(idCuentaOrigen);

        Movimiento movimientoSalida = new Movimiento(0, idCuentaOrigen, "Transferencia", LocalDate.now(), "Transferencia a cuenta " + cbuDestino, importe.negate(), idCuentaDestino);
        Movimiento movimientoEntrada = new Movimiento(0, idCuentaDestino, "Transferencia", LocalDate.now(), "Transferencia recibida de cuenta " + cbuOrigen, importe, idCuentaOrigen);

        try {
        	cuentaNeg.actualizarSaldo(idCuentaOrigen, nuevoSaldoOrigen);
            cuentaNeg.actualizarSaldo(idCuentaDestino, nuevoSaldoDestino);
            
            movNeg.agregarMovimiento(movimientoSalida);
            movNeg.agregarMovimiento(movimientoEntrada);

            request.setAttribute("mensaje", "Transferencia realizada con éxito.");
        } catch (Exception e) {
            request.setAttribute("mensaje", "Error al realizar la transferencia.");
        }

        request.getRequestDispatcher("CuentasClienteServlet").forward(request, response);
    }
}

