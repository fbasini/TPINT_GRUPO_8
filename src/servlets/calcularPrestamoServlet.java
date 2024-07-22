package servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calcularPrestamoServlet")
public class calcularPrestamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public calcularPrestamoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cuotas = Integer.parseInt(request.getParameter("ddlCuotas"));
		double importeSolicitado= Double.parseDouble(request.getParameter("txtImporte"));
		double importeFinal=0;
		switch(cuotas) {
		case 3:
			importeFinal = importeSolicitado + importeSolicitado * 0.2;
			break;
		case 6:
			importeFinal = importeSolicitado + importeSolicitado * 0.4;
			break;
		case 12:
			importeFinal = importeSolicitado + importeSolicitado * 0.6;
			break;
		default:
			break;
		}
		double montoCuota = importeFinal/cuotas;
		int redondear =  (int)montoCuota * 100;
		montoCuota = ((double)redondear)/100;
		
		HttpSession misesion= request.getSession();
		misesion.setAttribute("importeFinal", importeFinal);
		misesion.setAttribute("montoCuota", montoCuota);
		
		response.sendRedirect("Cliente/SolicitarPrestamo.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
	}

}
