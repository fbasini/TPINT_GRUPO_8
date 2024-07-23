package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Movimiento;

public class movimientoDaoImpl {

	private static final String insertarMovimiento = "INSERT INTO movimientos (idcuenta, tipoMovimiento, fechaMovimiento, detalleMovimiento, importeMovimiento, destinatario) VALUES (?,?,?,?,?,?)"; 
	
	
	public int agregarMovimiento(Movimiento movimiento) {
		
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    int filas = 0;
	    try {
	        statement = conexion.prepareStatement(insertarMovimiento);
	        statement.setInt(1, movimiento.getIdcuenta());
	        statement.setString(2, movimiento.getTipoMovimiento());
	        statement.setDate(3, java.sql.Date.valueOf(movimiento.getFechaMovimiento()));
	        statement.setString(4, movimiento.getDetalleMovimiento());
	        statement.setBigDecimal(5, movimiento.getImporteMovimiento());
	        statement.setInt(6, movimiento.getDestinatario());
	 
	        
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
		
	}
	
	

