package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidad.Prestamos;


public class prestamoDaoImpl {
	private static final String selectAll="SELECT * FROM prestamos";
	private static final String select="SELECT * FROM prestamos WHERE autorizado='-'";
	private static final String update= "UPDATE prestamos SET autorizado = ? WHERE idprestamo = ?";
	private static final String insert = "INSERT INTO prestamos (idcliente,idcuenta,fechaPrestamo,importeAPagar, importeSolicitado,plazoEnCoutas, montoPorCuota,autorizado) VALUES (?,?,?,?,?,?,?,?)";
			
	public int updatePrestamo(Prestamos prestamo) {
		
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    int filas = 0;
	    try {
	        statement = conexion.prepareStatement(update);
	        statement.setString(1, String.valueOf(prestamo.getAutorizado()));
	        statement.setInt(2, prestamo.getIdPrestamo());
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
	public ArrayList<Prestamos> listarPrestamos(){
	    PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    ArrayList<Prestamos> prestamos=new ArrayList<Prestamos>();
	    try {
	    	System.out.println("listar");
	        statement = conexion.prepareStatement(select);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	Prestamos prestamo=new Prestamos();
	        	prestamo.setIdPrestamo(resultSet.getInt("idprestamo"));
	        	prestamo.setIdcliente(resultSet.getInt("idcliente"));
	        	prestamo.setIdcuenta(resultSet.getInt("idcuenta"));
	        	prestamo.setFechaPrestamo(resultSet.getDate("fechaPrestamo").toLocalDate());
	        	prestamo.setImporteAPagar(resultSet.getBigDecimal("importeAPagar"));
	        	prestamo.setImporteSolicitado(resultSet.getBigDecimal("importeSolicitado"));
	        	prestamo.setPlazoEnCuotas(resultSet.getInt("plazoEnCoutas"));
	        	prestamo.setMontoPorCuota(resultSet.getBigDecimal("montoPorCuota"));
	        	prestamo.setAutorizado(resultSet.getString("autorizado").charAt(0));
	        	prestamos.add(prestamo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return prestamos;
	}
	
	public int agregarPrestamo(Prestamos prestamo) {
		
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    int filas = 0;
	    try {
	        statement = conexion.prepareStatement(insert);
	        statement.setInt(1, prestamo.getIdcliente());
	        statement.setInt(2, prestamo.getIdcuenta());
	        statement.setDate(3, java.sql.Date.valueOf(prestamo.getFechaPrestamo()));
	        statement.setBigDecimal(4, prestamo.getImporteAPagar());
	        statement.setBigDecimal(5, prestamo.getImporteSolicitado());
	        statement.setInt(6, prestamo.getPlazoEnCuotas());
	        statement.setBigDecimal(7, prestamo.getMontoPorCuota());
	        statement.setString(8, String.valueOf(prestamo.getAutorizado()));
	       
	        
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
