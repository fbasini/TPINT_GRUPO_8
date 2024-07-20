package dao;

import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Cliente;

public interface cuentaDao {

	public int agregarCuenta(Cuenta cuenta);
	public int eliminarCuenta(Cuenta cuenta);
	public int modificarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> listarCuentas();
	public int asignarCuentaCliente(Cuenta cuenta, Cliente cliente);
	
}
