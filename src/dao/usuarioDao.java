package dao;

import entidad.Usuario;

public interface usuarioDao {
	Usuario obtenerUsuario(String nombreUsuario, String contraseņaUsuario);

	int agregarUsuario(Usuario usuario);
}
