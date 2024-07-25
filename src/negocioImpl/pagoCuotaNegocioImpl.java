package negocioImpl;


import java.sql.SQLException;
import java.util.ArrayList;

import daoimpl.cuentaDaoImpl;
import daoimpl.pagoCuotaDaoImpl;
import entidad.pagoCuota;

public class pagoCuotaNegocioImpl {
	private pagoCuotaDaoImpl pagoCuotaDao; 
	
	public pagoCuotaNegocioImpl() {
		this.pagoCuotaDao= new pagoCuotaDaoImpl();
		
	}
	public int insertarCuotas(pagoCuota pagoCuota) throws SQLException {
		return pagoCuotaDao.insertarCuotas(pagoCuota);
	}
	public ArrayList<pagoCuota> listaCuotas(pagoCuota pagoCuotas){
		return pagoCuotaDao.listarCuotas(pagoCuotas);
	}
	public int updateCuota(pagoCuota pagoCuota) {
		return pagoCuotaDao.updateCuota(pagoCuota);
	}
}
