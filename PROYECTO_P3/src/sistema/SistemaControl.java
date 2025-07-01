package sistema;

import modelo.*;
import java.io.*;
import java.util.*;

public class SistemaControl {
    private List<Propietario> propietarios = new ArrayList<>();
    private List<Invitado> invitados = new ArrayList<>();
    private List<EspacioComun> espacios = new ArrayList<>();
    private List<ReservaEspacio> reservas = new ArrayList<>();
    private List<RegistroAcceso> registros = new ArrayList<>();

    public String registrarPropietario(Propietario p) {
        for (Propietario prop : propietarios) {
            if (prop.getCedula().equals(p.getCedula())) {
                return "Ya existe un propietario con esa cédula.";
            }
        }
        propietarios.add(p);
        return "Propietario registrado correctamente.";
    }

    public String registrarInvitado(Invitado i) {
        for (Invitado inv : invitados) {
            if (inv.getCedula().equals(i.getCedula())) {
                return "Ya existe un invitado con esa cédula.";
            }
        }
        invitados.add(i);
        return "Invitado registrado correctamente.";
    }

    public void registrarEspacio(EspacioComun e) {
        espacios.add(e);
    }

    public String hacerReserva(ReservaEspacio r) {
        for (ReservaEspacio res : reservas) {
            if (res.getEspacio().equalsIgnoreCase(r.getEspacio()) &&
                    res.getFecha().equals(r.getFecha()) &&
                    res.getHora().equals(r.getHora())) {
                return "Ese espacio ya está reservado en esa fecha y hora.";
            }
        }
        reservas.add(r);
        return "Reserva realizada correctamente.";
    }

    public String registrarAcceso(RegistroAcceso r) {
        registros.add(r);
        return "Acceso registrado correctamente.";
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public List<ReservaEspacio> getReservas() {
        return reservas;
    }

    public List<RegistroAcceso> getRegistros() {
        return registros;
    }

    public String buscarPersonaPorCedula(String cedula) {
        for (Propietario p : propietarios) {
            if (p.getCedula().equals(cedula)) {
                return "Propietario encontrado:\n" + p;
            }
        }
        for (Invitado i : invitados) {
            if (i.getCedula().equals(cedula)) {
                return "Invitado encontrado:\n" + i;
            }
        }
        return "No se encontró ninguna persona con esa cédula.";
    }

    public String guardarDatos() {
        try (PrintWriter writer = new PrintWriter("reporte.txt")) {
            writer.println("REPORTE DEL SISTEMA");
            writer.println("Total propietarios: " + propietarios.size());
            writer.println("Total invitados: " + invitados.size());
            writer.println("Total registros de acceso: " + registros.size());
            writer.println("Total reservas: " + reservas.size());
            return "Datos guardados en 'reporte.txt'.";
        } catch (IOException e) {
            return "Error al guardar el reporte.";
        }
    }
}
