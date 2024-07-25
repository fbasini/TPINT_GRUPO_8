package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Estadistica;
import negocioImpl.estadisticaNegocioImpl;


@WebServlet("/calcularEstadisticasServlet")
public class calcularEstadisticasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public calcularEstadisticasServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("btnMostrarDatos") != null) {
			estadisticaNegocioImpl negEstadistica = new estadisticaNegocioImpl();
			Estadistica estadistica = new Estadistica();
			
			
			estadistica = negEstadistica.obtenerDatos((String)request.getParameter("ddlTipo"), 
					(String)request.getParameter("ddlTabla"), 
					LocalDate.parse(request.getParameter("txtFechaInicio")), 
					LocalDate.parse(request.getParameter("txtFechaFinal")));
			
			
			request.setAttribute("estadistica", estadistica);
			request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);
		}
		
		if(request.getParameter("btnMostrarConteo") != null) {
			estadisticaNegocioImpl negEstadistica = new estadisticaNegocioImpl();
			
			char tipo =request.getParameter("ddlConteo").charAt(0);
			System.out.println(tipo);
			int conteo = negEstadistica.obtenerConteo(tipo); 
			System.out.println(conteo);
								
			request.setAttribute("conteo", conteo);
			request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
