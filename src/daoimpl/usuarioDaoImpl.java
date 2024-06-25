package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.usuarioDao;
import daoimpl.Conexion;
import entidad.Usuario;

public class usuarioDaoImpl implements usuarioDao{
	
	private static final String select = "SELECT * FROM usuarios WHERE nombreUsuario = ? AND contrase�aUsuario = ?";

	@Override
	public Usuario obtenerUsuario(String nombreUsuario, String contrase�aUsuario) {
		Usuario usuario = null;
        PreparedStatement statement;
        Connection conexion = Conexion.getConexion().getSQLConexion();

        try {
        	statement = conexion.prepareStatement(select);
            statement.setString(2, contrase�aUsuario);
            statement.setString(1, nombreUsuario);
            ResultSet rs = statement.executeQuery();
            rs.next();

            if (rs.next()) {
                usuario = getUsuarioFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

	private Usuario getUsuarioFromResultSet(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombreUsuario(rs.getString("nombreUsuario"));
        usuario.setContrase�aUsuario(rs.getString("contrase�aUsuario"));
        usuario.setTipoUsuario(rs.getBoolean("tipoUsuario"));
        return usuario;
    }
		
	
}
