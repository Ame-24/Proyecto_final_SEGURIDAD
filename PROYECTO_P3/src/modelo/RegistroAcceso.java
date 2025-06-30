package modelo;

public class RegistroAcceso {
    private String cedula;
    private String tipo;
    private String accion;
    private String fechaHora;

    public RegistroAcceso(String cedula, String tipo, String accion, String fechaHora) {
        this.cedula = cedula;
        this.tipo = tipo;
        this.accion = accion;
        this.fechaHora = fechaHora;
    }
}
