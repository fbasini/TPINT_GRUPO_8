package negocio;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.Cuenta;


public interface cuentaNegocio {
	public int agregarCuenta(Cuenta cuenta);
	public int eliminarCuenta(int idcuenta);
	public int modificarCuenta(Cuenta cuenta);
	public ArrayList<Cuenta> listarCuentas();
	public boolean asignarCuenta(int idCliente, int idCuenta) throws SQLException;
	public List<Cuenta> obtenerCuentasDisponibles() throws SQLException;
	public boolean puedeAsignarCuenta(int idCliente) throws SQLException;
	
}
