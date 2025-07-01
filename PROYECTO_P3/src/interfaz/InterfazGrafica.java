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

    private void registrarAcceso() {
        String ced = JOptionPane.showInputDialog("Cédula:");
        String tipo = JOptionPane.showInputDialog("Tipo (Propietario/Invitado):");
        String accion = JOptionPane.showInputDialog("Acción (Entrada/Salida):");

        if (ced != null && tipo != null && accion != null &&
                !ced.isEmpty() && !tipo.isEmpty() && !accion.isEmpty()) {

            if (!esNumeroValido(ced)) {
                mostrarError("Cédula inválida.");
                return;
            }

            if (!tipo.equalsIgnoreCase("Propietario") && !tipo.equalsIgnoreCase("Invitado")) {
                mostrarError("Tipo inválido. Solo 'Propietario' o 'Invitado'.");
                return;
            }

            if (!accion.equalsIgnoreCase("Entrada") && !accion.equalsIgnoreCase("Salida")) {
                mostrarError("Acción inválida. Solo 'Entrada' o 'Salida'.");
                return;
            }

            String hora = new Date().toString();
            sistema.registrarAcceso(new RegistroAcceso(ced, tipo, accion, hora));
        } else {
            mostrarError("Todos los campos son obligatorios.");
        }
    }

    private void reservarEspacio() {
        String casa = JOptionPane.showInputDialog("Código de casa:");
        String espacio = JOptionPane.showInputDialog("Espacio:");
        String fecha = JOptionPane.showInputDialog("Fecha (DD/MM/AAAA):");
        String hora = JOptionPane.showInputDialog("Hora:");

        if (casa != null && espacio != null && fecha != null && hora != null &&
                !casa.isEmpty() && !espacio.isEmpty() && !fecha.isEmpty() && !hora.isEmpty()) {

            if (!esTextoValido(espacio)) {
                mostrarError("Nombre del espacio inválido.");
                return;
            }

            sistema.hacerReserva(new ReservaEspacio(casa, espacio, fecha, hora));
        } else {
            mostrarError("Todos los campos son obligatorios.");
        }
    }

    private void buscarPersona() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula a buscar:");
        if (cedula != null && !cedula.isEmpty()) {
            if (!esNumeroValido(cedula)) {
                mostrarError("Cédula inválida.");
            } else {
                sistema.buscarPersonaPorCedula(cedula);
            }
        } else {
            mostrarError("Debe ingresar una cédula.");
        }
    }

    private void mostrarLista(String titulo, java.util.List<?> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para mostrar.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Object obj : lista) {
            sb.append(obj).append("\n");
        }

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scroll, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // --- VALIDACIONES ---
    private boolean esTextoValido(String input) {
        return input.matches("[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+") && !input.trim().isEmpty();
    }

    private boolean esNumeroValido(String input) {
        return input.matches("\\d+") && !input.trim().isEmpty();
    }

    private boolean esTelefonoValido(String input) {
        return input.matches("\\d{7,10}");
    }
}
