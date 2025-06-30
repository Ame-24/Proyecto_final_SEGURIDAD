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

    public void registrarPropietario(Propietario p) {
        for (Propietario prop : propietarios) {
            if (prop.getCedula().equals(p.getCedula())) {
                System.out.println("Ya existe un propietario con esa cédula.");
                return;
            }
        }
        propietarios.add(p);
        System.out.println("Propietario registrado correctamente.");
    }

    public void registrarInvitado(Invitado i) {
        for (Invitado inv : invitados) {
            if (inv.getCedula().equals(i.getCedula())) {
                System.out.println("Ya existe un invitado con esa cédula.");
                return;
            }
        }
        invitados.add(i);
        System.out.println("Invitado registrado correctamente.");
    }

    public void registrarEspacio(EspacioComun e) {
        espacios.add(e);
    }

    public void hacerReserva(ReservaEspacio r) {
        for (ReservaEspacio res : reservas) {
            if (res.getEspacio().equalsIgnoreCase(r.getEspacio()) &&
                    res.getFecha().equals(r.getFecha()) &&
                    res.getHora().equals(r.getHora())) {
                System.out.println("Ese espacio ya está reservado en esa fecha y hora.");
                return;
            }
        }
        reservas.add(r);
        System.out.println("Reserva realizada correctamente.");
    }

    public void registrarAcceso(RegistroAcceso r) {
        registros.add(r);
        System.out.println("Acceso registrado correctamente.");
    }

    public void mostrarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("No hay registros de acceso aún.");
        } else {
            System.out.println("Registros de acceso:");
            for (RegistroAcceso r : registros) {
                System.out.println(" - " + r);
            }
        }
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas de espacios comunes.");
        } else {
            System.out.println("Reservas realizadas:");
            for (ReservaEspacio r : reservas) {
                System.out.println(" - " + r);
            }
        }
    }

    public void mostrarPropietarios() {
        if (propietarios.isEmpty()) {
            System.out.println("No hay propietarios registrados.");
        } else {
            System.out.println("Lista de propietarios:");
            for (Propietario p : propietarios) {
                System.out.println(" - " + p);
            }
        }
    }