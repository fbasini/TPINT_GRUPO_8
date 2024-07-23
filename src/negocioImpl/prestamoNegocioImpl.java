package negocioImpl;

import java.util.ArrayList;

import daoimpl.prestamoDaoImpl;
import daoimpl.usuarioDaoImpl;
import entidad.Prestamos;

public class prestamoNegocioImpl {
	private prestamoDaoImpl prestamoDAO;
	
	public prestamoNegocioImpl() {
		this.prestamoDAO= new prestamoDaoImpl();
	}
	public ArrayList<Prestamos> listaPrestamo(){
		ArrayList<Prestamos> listaPrestamo=prestamoDAO.listarPrestamos();
		return listaPrestamo;
	}
	public int updatePrestamo(Prestamos prestamo) {
		int filas=prestamoDAO.updatePrestamo(prestamo);
		return filas;
	}
	
	public int agregarPrestamo(Prestamos prestamo) {
		
		int filas = prestamoDAO.agregarPrestamo(prestamo);
				
		return filas;
		
	}
}
