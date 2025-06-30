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