package dao;

import entidad.Usuario;

public interface usuarioDao {
	Usuario obtenerUsuario(String nombreUsuario, String contrase�aUsuario);
	
	int agregarUsuario(Usuario usuario);
}
