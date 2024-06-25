package entidad;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String contraseñaUsuario;
    private boolean tipoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseñaUsuario, boolean tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
