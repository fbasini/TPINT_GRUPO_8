package daoimpl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Prestamos;
import entidad.pagoCuota;

public class pagoCuotaDaoImpl {
	public static final String insert="INSERT INTO pagocuotas (idCuota, idPrestamo, idCliente, montoAPagar, Cuotas) VALUES (?,?,?,?,?)";
	public static final String select="SELECT * FROM pagocuotas WHERE (idPrestamo, idCuota) IN (SELECT idPrestamo, MIN(idCuota)FROM pagocuotas WHERE pagado = 'N' AND idCliente = ? GROUP BY idPrestamo) ";	
	public static final String selecta="SELECT * FROM pagocuotas";
	public static final String update="UPDATE pagocuotas SET fechaPago = ?, idCuenta = ?, pagado=? WHERE idPrestamo = ? AND idCuota = ?";
	
	public int insertarCuotas(pagoCuota pagoCuota) throws SQLException {
			System.out.println("dao insertar cuotas");
			PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			//conexion.setAutoCommit(false);
			int filas = 0;
			statement = conexion.prepareStatement(insert);
			int cuotas=pagoCuota.getCuotas();
			System.out.println(pagoCuota.getIdPrestamo());
			System.out.println(cuotas);
			try
			{
				for(int i=1; i<=cuotas; i++) {
					System.out.println(i);
					statement.setInt(1, i);
					statement.setInt(2, pagoCuota.getIdPrestamo());
			        statement.setInt(3, pagoCuota.getIdCliente());
			        statement.setBigDecimal(4,pagoCuota.getMontoAPagar());
			        statement.setInt(5, cuotas);
			        
				 filas+= statement.executeUpdate();
				}
				if (filas == cuotas) {
	                conexion.commit();
	            }
			} 
			catch (SQLException e) 
			
			{
				System.out.println("cathc");
				e.printStackTrace();
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return filas;
	}
	public ArrayList<pagoCuota> listarCuotas(pagoCuota pagoCuotas){
			System.out.println("daocUOTA");
			
		    PreparedStatement statement;
		    Connection conexion = Conexion.getConexion().getSQLConexion();
		    ArrayList<pagoCuota> listaCuotas=new ArrayList<pagoCuota>();
		   
		    try {
		    	System.out.println("try");
		        statement = conexion.prepareStatement(select);
		        statement.setInt(1, pagoCuotas.getIdCliente());
		        System.out.println(pagoCuotas.getIdCliente());
		        
		        ResultSet resultSet = statement.executeQuery();
		        while (resultSet.next()) {
		        	pagoCuota pagoCuota = new pagoCuota();
		        	System.out.println("entro a cargar datos rs dao");
		        	pagoCuota.setIdCuota(resultSet.getInt("idCuota"));
		        	pagoCuota.setIdPrestamo(resultSet.getInt("idPrestamo"));
		        	pagoCuota.setIdCliente(resultSet.getInt("idCliente"));
		        	pagoCuota.setMontoAPagar(resultSet.getBigDecimal("montoAPagar"));
		        	pagoCuota.setCuotas(resultSet.getInt("Cuotas"));
		        	listaCuotas.add(pagoCuota);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return listaCuotas;
		}
	public int updateCuota(pagoCuota pagoCuota) {
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    int filas = 0;
	    try {
	    	System.out.println("entra al try dao");
	        statement = conexion.prepareStatement(update);
	        statement.setDate(1,Date.valueOf(pagoCuota.getFechaPago()));
	        statement.setInt(2, pagoCuota.getIdCuenta());
	        statement.setString(3, "Y");
	        statement.setInt(4, pagoCuota.getIdPrestamo());
	        statement.setInt(5, pagoCuota.getIdCuota());
	        
	        
	        System.out.println("ID Cuenta: " + pagoCuota.getIdCuenta());
	        System.out.println("ID cuota: " + pagoCuota.getIdCuota());
	        System.out.println("ID prestamo: " + pagoCuota.getIdPrestamo());
	        System.out.println("ID fecha: " + pagoCuota.getFechaPago());

	        filas = statement.executeUpdate();
	        if (filas > 0) {
	        	System.out.println("entra al if");
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
