package daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClienteDao;
import dao.cuentaDao;
import daoimpl.Conexion;
import entidad.Cliente;
import entidad.Cuenta;
import dao.usuarioDao;
import daoimpl.usuarioDaoImpl;
import entidad.Usuario;



public class cuentaDaoImpl implements cuentaDao {

	private static final String insert = "INSERT INTO cuenta(idcliente, tipoCuenta, fechaCreacion, CBUCuenta, saldoCuenta, CuentaActiva) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE cuenta SET CuentaActiva = 'N' WHERE idcuenta = ?";
	private static final String selectAll = "SELECT * FROM cuenta";
	private static final String update = "UPDATE cuenta SET tipoCuenta = ?, fechaCreacion = ?, CBUCuenta = ?, saldoCuenta = ?  WHERE idcuenta = ?";
	
	
	
	
	public int agregarCuenta(Cuenta cuenta) {
		
		return 0;
	}

	
	public int eliminarCuenta(Cuenta cuenta) {
		
		return 0;
	}


	public int modificarCuenta(Cuenta cuenta) {
		
		return 0;
	}

	
	public ArrayList<Cuenta> listarCuentas() {
		
		return null;
	}

	
	public int asignarCuentaCliente(Cuenta cuenta, Cliente cliente) {
		
		return 0;
	}

}
