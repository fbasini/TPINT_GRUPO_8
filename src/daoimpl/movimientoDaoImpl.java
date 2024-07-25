package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Movimiento;

public class movimientoDaoImpl {

	private static final String insertarMovimiento = "INSERT INTO movimientos (idcuenta, tipoMovimiento, fechaMovimiento, detalleMovimiento, importeMovimiento, destinatario) VALUES (?,?,?,?,?,?)"; 
	private static final String listarMovimientosPorIdCuenta = "SELECT * FROM movimientos WHERE idcuenta = ?";
	
	
	public ArrayList<Movimiento> obtenerMovimientosIdCuenta(int idcuenta) {
	
	
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Movimiento> movimientos = new ArrayList<>();
	
		try {
			statement = conexion.prepareStatement(listarMovimientosPorIdCuenta);
			statement.setInt(1, idcuenta);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Movimiento movimiento = new Movimiento();
				movimiento.setIdMovimiento(resultSet.getInt("idMovimientos"));
				movimiento.setIdcuenta(resultSet.getInt("idcuenta"));
				movimiento.setTipoMovimiento(resultSet.getString("tipoMovimiento"));
				movimiento.setDetalleMovimiento(resultSet.getString("detalleMovimiento"));
				movimiento.setImporteMovimiento(resultSet.getBigDecimal("importeMovimiento"));
				movimiento.setDestinatario(resultSet.getInt("destinatario"));
				movimiento.setFechaMovimiento(resultSet.getDate("fechaMovimiento").toLocalDate());
				movimientos.add(movimiento);
			} 
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return movimientos;
		}
	

	public int agregarMovimiento(Movimiento movimiento) {
		
		PreparedStatement statement = null;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    int filas = 0;
	    try {
	    	 conexion.setAutoCommit(false);
	    	 // Preparar la declaración
	        statement = conexion.prepareStatement(insertarMovimiento);
	        statement.setInt(1, movimiento.getIdcuenta());
	        statement.setString(2, movimiento.getTipoMovimiento());
	        statement.setDate(3, java.sql.Date.valueOf(movimiento.getFechaMovimiento()));
	        statement.setString(4, movimiento.getDetalleMovimiento());
	        statement.setBigDecimal(5, movimiento.getImporteMovimiento());
	        statement.setInt(6, movimiento.getDestinatario());
	 
	        // Ejecutar la actualización
	        filas = statement.executeUpdate();
	        if (filas > 0) {
	            conexion.commit();
	        } else {
	            conexion.rollback();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            if (conexion != null) {
	                conexion.rollback(); // Hacer rollback en caso de error
	            }
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (conexion != null) {
	                // Rehabilitar autocommit y cerrar conexión
	                conexion.setAutoCommit(true);
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return filas;
		
		
	    }
		
	}
	
	

