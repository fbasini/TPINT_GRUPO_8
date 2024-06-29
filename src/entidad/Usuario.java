package entidad;

public class Usuario {
    private String nombreUsuario;
    private String contrase�aUsuario;
    private char tipoUsuario;
    private char usuarioActivo;

    public Usuario() {
    }

   

    public Usuario(String nombreUsuario, String contrase�aUsuario, char tipoUsuario, char usuarioActivo) {
	
		this.nombreUsuario = nombreUsuario;
		this.contrase�aUsuario = contrase�aUsuario;
		this.tipoUsuario = tipoUsuario;
		this.usuarioActivo = usuarioActivo;
	}



	// Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrase�aUsuario() {
        return contrase�aUsuario;
    }

    public void setContrase�aUsuario(String contrase�aUsuario) {
        this.contrase�aUsuario = contrase�aUsuario;
    }

    public char isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }



	public char getUsuarioActivo() {
		return usuarioActivo;
	}



	public void setUsuarioActivo(char usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}



	public char getTipoUsuario() {
		return tipoUsuario;
	}
    
    
}
