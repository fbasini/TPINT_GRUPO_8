package negocioImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.Cuenta;
import negocio.cuentaNegocio;
import daoimpl.cuentaDaoImpl;


public class cuentaNegocioImpl implements cuentaNegocio {
	private cuentaDaoImpl cuentadao; 
	
	public cuentaNegocioImpl() {
		
		
		this.cuentadao= new cuentaDaoImpl();
		
	}
	

	public int agregarCuenta(Cuenta cuenta) {
		
		return cuentadao.agregarCuenta(cuenta);
	}

	
	public int eliminarCuenta(Cuenta cuenta) {
		
		return cuentadao.eliminarCuenta(cuenta);
	}

	
	public int modificarCuenta(Cuenta cuenta) {
	
		return cuentadao.modificarCuenta(cuenta);
	}

	
	public ArrayList<Cuenta> listarCuentas() {
		
		return cuentadao.listarCuentas();
	}

	public ArrayList<Cuenta> listarCuentasDeCliente(int idcliente) {
		
		return cuentadao.obtenerCuentasCliente(idcliente);
	}

	
	public boolean asignarCuenta(int idCliente, int idCuenta)  {
		// TODO Auto-generated method stub
		return cuentadao.asignarCuenta(idCliente, idCuenta);
	}


	
	public ArrayList<Cuenta> obtenerCuentasDisponibles()  {
		// TODO Auto-generated method stub
		return cuentadao.obtenerCuentasDisponibles();
	}


	
	public boolean puedeAsignarCuenta(int idCliente)  {
		// TODO Auto-generated method stub
		return cuentadao.puedeAsignarCuenta(idCliente);
	}
	public int asignarPrestamo(Cuenta cuenta) {
		return cuentadao.asignarPrestamo(cuenta);
	}
	
	public int obtenerIdCuentaPorCBU(int CBU) {
		
		return cuentadao.obtenerIdCuentaPorCBU(CBU);
		
	}
	
}
