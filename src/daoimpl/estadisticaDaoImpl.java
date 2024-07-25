package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import entidad.Cuenta;
import entidad.Estadistica;

public class estadisticaDaoImpl {
	
	private static final String select = "select ? (importeMovimiento) as resultado, idcuenta from ? \r\n" + 
			"where fechaMovimiento between ? and ? \r\n" + 
			"group by idcuenta";
	
	private static final String count = "select count(idcliente) as resultado from cliente where SexoCliente = '?'";
	
	
	 public estadisticaDaoImpl(){}
	
	
	public Estadistica obtenerDatos(String tipo, String tabla, LocalDate fechaInicio, LocalDate fechaFinal) {
		
		PreparedStatement statement;
						
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Estadistica estadistica = new Estadistica();
		
		try {
			statement = conexion.prepareStatement(select);
			statement.setString(1, tipo);
			statement.setString(2, tabla);
			statement.setDate(3, java.sql.Date.valueOf(fechaInicio));
			statement.setDate(4, java.sql.Date.valueOf(fechaFinal));
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				estadistica.setIdResultado(resultSet.getInt("idcuenta"));
				estadistica.setMontoResultado(resultSet.getDouble("total"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estadistica;
	}
	
	public int obtenerConteo(char tipo) {
		
		PreparedStatement statement;
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int conteo = 0;
		
		try {
			statement = conexion.prepareStatement(count);
			statement.setString(1, String.valueOf(tipo));
			
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				conteo = resultSet.getInt("resultado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conteo;
	}
	
}
