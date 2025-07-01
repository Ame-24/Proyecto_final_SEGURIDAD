package interfaz;

import sistema.SistemaControl;
import modelo.*;

import javax.swing.*;
import java.util.Date;

public class InterfazGrafica implements Interfaz {
    private final SistemaControl sistema = new SistemaControl();

    @Override
    public void iniciar() {
        String[] opciones = {
                "Registrar propietario",
                "Registrar invitado",
                "Registrar acceso",
                "Reservar espacio común",
                "Ver registros de acceso",
                "Ver reservas",
                "Ver propietarios",
                "Ver invitados",
                "Buscar persona por cédula",
                "Guardar reporte",
                "Salir"
        };

        int opcion;

        do {
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú principal",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (seleccion == null) {
                opcion = 10;
            } else {
                opcion = java.util.Arrays.asList(opciones).indexOf(seleccion);
            }

            try {
                switch (opcion) {
                    case 0 -> registrarPropietario();
                    case 1 -> registrarInvitado();
                    case 2 -> registrarAcceso();
                    case 3 -> reservarEspacio();
                    case 4 -> mostrarLista("Registros de Acceso", sistema.getRegistros());
                    case 5 -> mostrarLista("Reservas", sistema.getReservas());
                    case 6 -> mostrarLista("Propietarios", sistema.getPropietarios());
                    case 7 -> mostrarLista("Invitados", sistema.getInvitados());
                    case 8 -> buscarPersona();
                    case 9 -> sistema.guardarDatos();
                    case 10 -> JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcion != 10);
    }

    private void registrarPropietario() {
        String cod = JOptionPane.showInputDialog("Código de casa:");
        String nom = JOptionPane.showInputDialog("Nombre:");
        String ced = JOptionPane.showInputDialog("Cédula:");
        String tel = JOptionPane.showInputDialog("Teléfono:");

        if (cod != null && nom != null && ced != null && tel != null &&
                !cod.isEmpty() && !nom.isEmpty() && !ced.isEmpty() && !tel.isEmpty()) {

            if (!esTextoValido(nom)) {
                mostrarError("Nombre inválido. Solo letras y espacios.");
                return;
            }

            if (!esNumeroValido(ced)) {
                mostrarError("Cédula inválida. Solo números.");
                return;
            }

            if (!esTelefonoValido(tel)) {
                mostrarError("Teléfono inválido. Debe tener entre 7 y 10 dígitos.");
                return;
            }

            sistema.registrarPropietario(new Propietario(cod, nom, ced, tel));
        } else {
            mostrarError("Todos los campos son obligatorios.");
        }
    }

    private void registrarInvitado() {
        String nom = JOptionPane.showInputDialog("Nombre del invitado:");
        String ced = JOptionPane.showInputDialog("Cédula:");
        String rel = JOptionPane.showInputDialog("Relación con propietario:");

        if (nom != null && ced != null && rel != null &&
                !nom.isEmpty() && !ced.isEmpty() && !rel.isEmpty()) {

            if (!esTextoValido(nom) || !esTextoValido(rel)) {
                mostrarError("Nombre o relación inválidos. Solo letras y espacios.");
                return;
            }

            if (!esNumeroValido(ced)) {
                mostrarError("Cédula inválida. Solo números.");
                return;
            }

            sistema.registrarInvitado(new Invitado(nom, ced, rel));
        } else {
            mostrarError("Todos los campos son obligatorios.");
        }
    }