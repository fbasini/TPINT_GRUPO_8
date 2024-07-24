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

        int idCuentaOrigen = (int) request.getSession().getAttribute("idCuentaSeleccionada");

        movimientoNegocioImpl movNeg = new movimientoNegocioImpl();
        cuentaNegocioImpl cuentaNeg = new cuentaNegocioImpl();

        BigDecimal saldoOrigen = cuentaNeg.obtenerSaldo(idCuentaOrigen);
        if (saldoOrigen.compareTo(importe) < 0) {
            request.setAttribute("mensaje", "Saldo insuficiente.");
            request.getRequestDispatcher("TransferirFondos.jsp").forward(request, response);
            return;
        }

        int idCuentaDestino = cuentaNeg.obtenerIdCuentaPorCBU(cbuDestino);
        if (idCuentaDestino == -1) {
            request.setAttribute("mensaje", "CBU de destinatario inv�lido.");
            request.getRequestDispatcher("TransferirFondos.jsp").forward(request, response);
            return;
        }

        Movimiento movimientoSalida = new Movimiento(0, idCuentaOrigen, "Extracci�n", LocalDate.now(), "Transferencia a cuenta " + cbuDestino, importe.negate(), idCuentaDestino);
        Movimiento movimientoEntrada = new Movimiento(0, idCuentaDestino, "Dep�sito", LocalDate.now(), "Transferencia recibida de cuenta " + idCuentaOrigen, importe, idCuentaOrigen);

        try {
            cuentaNeg.actualizarSaldo(idCuentaOrigen, saldoOrigen.subtract(importe));
            cuentaNeg.actualizarSaldo(idCuentaDestino, cuentaNeg.obtenerSaldo(idCuentaDestino).add(importe));
            
            movNeg.agregarMovimiento(movimientoSalida);
            movNeg.agregarMovimiento(movimientoEntrada);

            request.setAttribute("mensaje", "Transferencia realizada con �xito.");
        } catch (Exception e) {
            request.setAttribute("mensaje", "Error al realizar la transferencia.");
        }

        request.getRequestDispatcher("Cliente/TransferirFondos.jsp").forward(request, response);
    }
}

