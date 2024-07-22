package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Prestamos;
import entidad.Usuario;

public class prestamoDaoImpl {
	private static final String selectAll="SELECT * FROM prestamos";
	private static final String update= "UPDATE prestamos SET autorizado = ? WHERE idprestamo = ?";
	
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
		System.out.println("dao");
	    PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    ArrayList<Prestamos> prestamos=new ArrayList<Prestamos>();
	    try {
	        statement = conexion.prepareStatement(selectAll);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	System.out.println("qlq");
	        	Prestamos prestamo=new Prestamos();
	        	prestamo.setIdPrestamo(resultSet.getInt("idprestamo"));
	        	prestamo.setIdcliente(resultSet.getInt("idcliente"));
	        	prestamo.setIdcuenta(resultSet.getInt("idcuenta"));
	        	prestamo.setFechaPrestamo(resultSet.getDate("fechaPrestamo").toLocalDate());
	        	prestamo.setImporteAPagar(resultSet.getBigDecimal("importeAPagar"));
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
}
