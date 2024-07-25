package dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cuenta;
import entidad.Cliente;

public interface cuentaDao {

	public int agregarCuenta(Cuenta cuenta);
	public int eliminarCuenta(int idcuenta);
	public int modificarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> listarCuentas();
	public boolean asignarCuenta(int idCliente, int idCuenta) throws SQLException;
	public List<Cuenta> obtenerCuentasDisponibles() throws SQLException;
	public boolean puedeAsignarCuenta(int idCliente) throws SQLException;
	BigDecimal obtenerSaldo(int idCuentaOrigen);
	
}
