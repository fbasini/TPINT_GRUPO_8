package entidad;

public class Usuario {
    private String nombreUsuario;
    private String contraseñaUsuario;
    private char tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseñaUsuario, char tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public char isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
