package negocioImpl;
import java.util.ArrayList;

import entidad.Movimiento;
import entidad.Prestamos;
import daoimpl.movimientoDaoImpl;
import daoimpl.prestamoDaoImpl;

public class movimientoNegocioImpl {
   private movimientoDaoImpl movDao;
   
   public movimientoNegocioImpl() {
		this.movDao= new movimientoDaoImpl();
	}
   
   
   
	public int agregarMovimiento(Movimiento movimiento) {
		int filas= movDao.agregarMovimiento(movimiento);
		return  filas;
		
		
	}
	
	
}
