package modelo;

public class ReservaEspacio {
    private String codigoCasa;
    private String espacio;
    private String fecha;
    private String hora;

    public ReservaEspacio(String codigoCasa, String espacio, String fecha, String hora) {
        this.codigoCasa = codigoCasa;
        this.espacio = espacio;
        this.fecha = fecha;
        this.hora = hora;
    }
    public String getCodigoCasa() { return codigoCasa; }
    public String getEspacio() { return espacio; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }

}
