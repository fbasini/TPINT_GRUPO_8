package negocioImpl;
import daoimpl.usuarioDaoImpl;
import entidad.Usuario;
import negocio.usuarioNegocio;

public class usuarioNegocioImpl implements usuarioNegocio {
	public Usuario obtenerUsuario(String nombreUsuario, String passwordUsuario) {
		 usuarioDaoImpl usuarioDAO = new usuarioDaoImpl();
	     Usuario usuario = usuarioDAO.obtenerUsuario(nombreUsuario, passwordUsuario);
	     return usuario;
	}
}
