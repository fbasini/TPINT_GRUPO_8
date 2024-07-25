package negocioImpl;
import java.math.BigDecimal;
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

	
	public int eliminarCuenta(int idcuenta) {
		
		return cuentadao.eliminarCuenta(idcuenta);
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
		return cuentadao.asignarCuentaSiEsPosible(idCliente, idCuenta);
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
	
	public String obtenerDescripcionTipoCuenta(String tipoCuentaId) {
		return cuentadao.obtenerDescripcionTipoCuenta(tipoCuentaId);
	}


	public BigDecimal obtenerSaldo(int idCuentaOrigen) {
		return cuentadao.obtenerSaldo(idCuentaOrigen);
	}


	public void actualizarSaldo(int idCuenta, BigDecimal monto) {
	    cuentadao.actualizarSaldo(idCuenta, monto);
	}
	
	public Cuenta obtenerCuentaPorID(int idcuenta) {
		return cuentadao.obtenerCuentaPorID(idcuenta);
		
	}
	
	public int obtenerCBUPorIdCuenta(int idCuenta) {
	    return cuentadao.obtenerCBUPorIdCuenta(idCuenta);
	}
	
}
