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