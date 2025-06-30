package modelo;

public class Propietario {
    private String codigoCasa;
    private String nombre;
    private String cedula;
    private String telefono;

    public Propietario(String codigoCasa, String nombre, String cedula, String telefono) {
        this.codigoCasa = codigoCasa;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public String getCodigoCasa() { return codigoCasa; }
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getTelefono() { return telefono; }

    @Override
    public String toString() {
        return nombre + " (Casa: " + codigoCasa + ", Cédula: " + cedula + ")";
    }
}
