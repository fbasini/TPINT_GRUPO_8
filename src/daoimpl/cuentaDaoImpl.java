package daoimpl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	private static final String update = "UPDATE cuenta SET tipoCuenta = ?, CBUCuenta = ?, saldoCuenta = ?  WHERE idcuenta = ?";
	private static final String LISTA_CUENTAS_DISPONIBLES_QUERY = "SELECT idCuenta FROM Cuentas WHERE idCliente IS = 1";
	private static final String CHECK_COUNT_QUERY = "SELECT COUNT(*) AS cuentaCount FROM Cuentas WHERE idCliente = ?";
	private static final String ASIGNAR_CUENTA_QUERY = "UPDATE Cuentas SET idCliente = ? WHERE idCuenta = ?";
	private static final String obtenerCuentaDeCliente = "SELECT * FROM cuenta WHERE idcliente = ?";
	
	
	public int agregarCuenta(Cuenta cuenta) {
		
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int filas = 0;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cuenta.getIdcliente());
			statement.setString(2, cuenta.getTipoCuenta());
			statement.setDate(3, java.sql.Date.valueOf(cuenta.getFechaCreacion()));
			statement.setInt(4, cuenta.getCBUCuenta());
			statement.setBigDecimal(5, cuenta.getSaldoCuenta());
			statement.setString(6, String.valueOf(cuenta.getCuentaActiva()));
			filas = statement.executeUpdate();
			if (filas > 0) {
				conexion.commit();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas;
	}

	
	public int eliminarCuenta(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int filas = 0;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, cuenta.getIdcuenta());
			filas = statement.executeUpdate();
			if (filas > 0) {
				conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas;
	}


	public int modificarCuenta(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int filas = 0;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, cuenta.getTipoCuenta());
			
			statement.setInt(2, cuenta.getCBUCuenta());
			statement.setBigDecimal(3, cuenta.getSaldoCuenta());
			statement.setInt(4, cuenta.getIdcuenta());
			filas = statement.executeUpdate();
			if (filas > 0) {
				conexion.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas;
	}

	
	public ArrayList<Cuenta> listarCuentas() {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Cuenta> cuentas = new ArrayList<>();
		try {
			statement = conexion.prepareStatement(selectAll);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdcuenta(resultSet.getInt("idcuenta"));
				cuenta.setIdcliente(resultSet.getInt("idcliente"));
				cuenta.setTipoCuenta(resultSet.getString("tipoCuenta"));
				cuenta.setFechaCreacion(resultSet.getDate("fechaCreacion").toLocalDate());
				cuenta.setCBUCuenta(resultSet.getInt("CBUCuenta"));
				cuenta.setSaldoCuenta(resultSet.getBigDecimal("saldoCuenta"));
				cuenta.setCuentaActiva(resultSet.getString("CuentaActiva").charAt(0));
				cuentas.add(cuenta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuentas;
	}

	public ArrayList<Cuenta> obtenerCuentasCliente(int idcliente) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Cuenta> cuentas = new ArrayList<>();
		try {
			statement = conexion.prepareStatement(obtenerCuentaDeCliente);
			statement.setInt(1, idcliente);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdcuenta(resultSet.getInt("idcuenta"));
				cuenta.setIdcliente(resultSet.getInt("idcliente"));
				cuenta.setTipoCuenta(resultSet.getString("tipoCuenta"));
				cuenta.setFechaCreacion(resultSet.getDate("fechaCreacion").toLocalDate());
				cuenta.setCBUCuenta(resultSet.getInt("CBUCuenta"));
				cuenta.setSaldoCuenta(resultSet.getBigDecimal("saldoCuenta"));
				cuenta.setCuentaActiva(resultSet.getString("CuentaActiva").charAt(0));
				cuentas.add(cuenta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cuentas;
		
	}
	


	@Override
	public boolean asignarCuenta(int idCliente, int idCuenta)throws SQLException {
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
	             PreparedStatement statement = conexion.prepareStatement(ASIGNAR_CUENTA_QUERY)) {
	            statement.setInt(1, idCliente);
	            statement.setInt(2, idCuenta);
	            int filasAfectadas = statement.executeUpdate();
	            if (filasAfectadas > 0) {
	                conexion.commit();
	                return true;
	            }
	        }
	        return false;
	}


	@Override
	public List<Cuenta> obtenerCuentasDisponibles() throws SQLException{
		List<Cuenta> cuentas = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             PreparedStatement statement = conexion.prepareStatement(LISTA_CUENTAS_DISPONIBLES_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setIdcuenta(rs.getInt("idCuenta"));
                cuenta.setIdcliente(0); // Indica que está disponible
                cuentas.add(cuenta);
            }
        }
        return cuentas;
	}


	@Override
	public boolean puedeAsignarCuenta(int idCliente)  throws SQLException {
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
	             PreparedStatement statement = conexion.prepareStatement(CHECK_COUNT_QUERY)) {
	            statement.setInt(1, idCliente);
	            ResultSet rs = statement.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("cuentaCount") < 3;
	            }
	        }
	        return false;
	}
	
	
	
}
