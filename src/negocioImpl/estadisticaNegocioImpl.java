package negocioImpl;

import java.time.LocalDate;

import daoimpl.estadisticaDaoImpl;
import entidad.Estadistica;

public class estadisticaNegocioImpl {

	private estadisticaDaoImpl estadisticadao;

    public estadisticaNegocioImpl() {
        this.estadisticadao = new estadisticaDaoImpl();  // Inicialización del objeto
    }
	
	public Estadistica obtenerDatos(String tipo, String tabla, LocalDate fechaInicio, LocalDate fechaFinal) {
		return estadisticadao.obtenerDatos(tipo, tabla, fechaInicio, fechaFinal);
	}
	
	
	public int obtenerConteo(char tipo) {
		return estadisticadao.obtenerConteo(tipo);
	}
}

