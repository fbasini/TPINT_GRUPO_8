package entidad;

public class Usuario {
    private String nombreUsuario;
    private String contrase�aUsuario;
    private char tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrase�aUsuario, char tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrase�aUsuario = contrase�aUsuario;
        this.tipoUsuario = tipoUsuario;
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
}
