package Modelo;

public class usuario {
    private int id;
    private String nombre;
    private String rol;
    private boolean activo;

    public usuario(int id, String nombre, String rol, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.activo = activo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    public boolean isActivo() { return activo; }
}
