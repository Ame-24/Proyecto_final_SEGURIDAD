package modelo;

public class Invitado {
    private String nombre;
    private String cedula;
    private String relacion;

    public Invitado(String nombre, String cedula, String relacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.relacion = relacion;
    }
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getRelacion() { return relacion; }
}
