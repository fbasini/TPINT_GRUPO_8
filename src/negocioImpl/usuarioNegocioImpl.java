package negocioImpl;
import daoimpl.usuarioDaoImpl;
import entidad.Usuario;
import negocio.usuarioNegocio;

public class usuarioNegocioImpl implements usuarioNegocio {
	private usuarioDaoImpl usuarioDAO;
	
	public usuarioNegocioImpl() {
		this.usuarioDAO= new usuarioDaoImpl();
	}
	public Usuario obtenerUsuario(String nombreUsuario, String passwordUsuario) {
	     Usuario usuario = usuarioDAO.obtenerUsuario(nombreUsuario, passwordUsuario);
	     return usuario;
	}
	public int agregarUsuario(Usuario usuario) {
		return usuarioDAO.agregarUsuario(usuario);
	}
	public int updatePassword(Usuario usuario) {
		return usuarioDAO.updatePassword(usuario);
	
	}
}
