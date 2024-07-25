package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Movimiento;

public class movimientoDaoImpl {

	private static final String insertarMovimiento = "INSERT INTO movimientos (idcuenta, tipoMovimiento, fechaMovimiento, detalleMovimiento, importeMovimiento, destinatario) VALUES (?,?,?,?,?,?)"; 
	
	
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
	
	

