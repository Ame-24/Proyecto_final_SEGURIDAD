package modelo;

public class EspacioComun {
    private String nombre;
    private String horarioDisponible;

    public EspacioComun(String nombre, String horarioDisponible) {
        this.nombre = nombre;
        this.horarioDisponible = horarioDisponible;
    }

    public String getNombre() { return nombre; }
    public String getHorarioDisponible() { return horarioDisponible; }

    @Override
    public String toString() {
        return nombre + " (Horario: " + horarioDisponible + ")";
    }
}
