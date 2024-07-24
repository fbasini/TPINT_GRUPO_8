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
import entidad.Prestamos;
import dao.usuarioDao;
import daoimpl.usuarioDaoImpl;
import entidad.Usuario;



public class cuentaDaoImpl implements cuentaDao {

	private static final String insert = "INSERT INTO cuenta(idcliente, tipoCuenta, fechaCreacion, CBUCuenta, saldoCuenta, CuentaActiva) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE cuenta SET CuentaActiva = 'N' WHERE idcuenta = ?";
	private static final String selectAll = "SELECT * FROM cuenta";
	private static final String update = "UPDATE cuenta SET tipoCuenta = ?, CBUCuenta = ?, saldoCuenta = ?  WHERE idcuenta = ?";
	private static final String LISTA_CUENTAS_DISPONIBLES_QUERY = "SELECT idcuenta FROM cuenta WHERE idcliente = 1";
	private static final String CHECK_COUNT_QUERY = "SELECT COUNT(*) AS cuentaCount FROM cuenta WHERE idcliente = ?";
	private static final String ASIGNAR_CUENTA_QUERY = "UPDATE cuenta SET idcliente = ? WHERE idcuenta = ?";
	private static final String obtenerCuentaDeCliente = "SELECT * FROM cuenta WHERE idcliente = ?";
	private static final String updateSaldo="UPDATE cuenta SET saldoCuenta = saldoCuenta + ? WHERE idcuenta = ?";
	private static final String obtenerIdPorCBU = "SELECT idcuenta FROM cuenta WHERE CBUCuenta = ?";
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
	public boolean asignarCuenta(int idCliente, int idCuenta) {
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
	             PreparedStatement statement = conexion.prepareStatement(ASIGNAR_CUENTA_QUERY)) {
	            statement.setInt(1, idCliente);
	            statement.setInt(2, idCuenta);
	            int filasAfectadas = statement.executeUpdate();
	            if (filasAfectadas > 0) {
	                conexion.commit();
	                return true;
	            }
	        }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return false;
	}


	@Override
	public ArrayList<Cuenta> obtenerCuentasDisponibles() {
		ArrayList<Cuenta> cuentas = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             PreparedStatement statement = conexion.prepareStatement(LISTA_CUENTAS_DISPONIBLES_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setIdcuenta(rs.getInt("idcuenta"));
                cuenta.setIdcuenta(rs.getInt("idcuenta"));
				cuenta.setIdcliente(rs.getInt("idcliente"));
				cuenta.setTipoCuenta(rs.getString("tipoCuenta"));
				cuenta.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
				cuenta.setCBUCuenta(rs.getInt("CBUCuenta"));
				cuenta.setSaldoCuenta(rs.getBigDecimal("saldoCuenta"));
				cuenta.setCuentaActiva(rs.getString("CuentaActiva").charAt(0));
				cuentas.add(cuenta);
            }
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return cuentas;
	}


	@Override
	public boolean puedeAsignarCuenta(int idCliente)   {
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
	             PreparedStatement statement = conexion.prepareStatement(CHECK_COUNT_QUERY)) {
	            statement.setInt(1, idCliente);
	            ResultSet rs = statement.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("cuentaCount") < 3;
	            }
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return false;
	}
	
public int asignarPrestamo(Cuenta cuenta) {
		
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    int filas = 0;
	    try {
	        statement = conexion.prepareStatement(updateSaldo);
	        statement.setBigDecimal(1, cuenta.getSaldoCuenta());
	        statement.setInt(2, cuenta.getIdcuenta());
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
	

public int obtenerIdCuentaPorCBU(int CBU) {
	 int idCuenta = -1;
   
    try {
       
        Connection conexion = Conexion.getConexion().getSQLConexion();
        PreparedStatement stmt = conexion.prepareStatement(obtenerIdPorCBU);
        
        stmt.setInt(1, CBU);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            idCuenta = rs.getInt("idcuenta");
        }
        
        rs.close();
        stmt.close();
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return idCuenta;
}



}
