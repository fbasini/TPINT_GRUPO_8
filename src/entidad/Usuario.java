package entidad;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String contrase�aUsuario;
    private boolean tipoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrase�aUsuario, boolean tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrase�aUsuario = contrase�aUsuario;
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

    public String getContrase�aUsuario() {
        return contrase�aUsuario;
    }

    public void setContrase�aUsuario(String contrase�aUsuario) {
        this.contrase�aUsuario = contrase�aUsuario;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
