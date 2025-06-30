package main;

import sistema.SistemaControl;
import modelo.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaControl sistema = new SistemaControl();
        int opcion;

        do {
            System.out.println("\n====== SISTEMA DE CONTROL Y SEGURIDAD ======");
            System.out.println("1. Registrar propietario");
            System.out.println("2. Registrar invitado");
            System.out.println("3. Registrar acceso");
            System.out.println("4. Reservar espacio común");
            System.out.println("5. Ver registros de acceso");
            System.out.println("6. Ver reservas");
            System.out.println("7. Ver propietarios");
            System.out.println("8. Ver invitados");
            System.out.println("9. Buscar persona por cédula");
            System.out.println("10. Guardar reporte");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Por favor ingresa un número: ");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Código de casa: ");
                    String codCasa = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = sc.nextLine();

                    if (codCasa.isEmpty() || nombre.isEmpty() || cedula.isEmpty() || tel.isEmpty()) {
                        System.out.println("Todos los campos son obligatorios.");
                        break;
                    }
                    sistema.registrarPropietario(new Propietario(codCasa, nombre, cedula, tel));
                    break;
                case 2:
                    System.out.print("Nombre invitado: ");
                    String nomInv = sc.nextLine();
                    System.out.print("Cédula invitado: ");
                    String cedInv = sc.nextLine();
                    System.out.print("Relación con propietario: ");
                    String rel = sc.nextLine();

                    if (nomInv.isEmpty() || cedInv.isEmpty() || rel.isEmpty()) {
                        System.out.println("Todos los campos son obligatorios.");
                        break;
                    }

                    sistema.registrarInvitado(new Invitado(nomInv, cedInv, rel));
                    break;
                case 3:
                    System.out.print("Cédula: ");
                    String cedu = sc.nextLine();
                    System.out.print("Tipo (Propietario/Invitado): ");
                    String tipo = sc.nextLine();
                    System.out.print("Acción (Entrada/Salida): ");
                    String accion = sc.nextLine();

                    if (cedu.isEmpty() || tipo.isEmpty() || accion.isEmpty()) {
                        System.out.println("Todos los campos son obligatorios.");
                        break;
                    }

                    String hora = new Date().toString();
                    sistema.registrarAcceso(new RegistroAcceso(cedu, tipo, accion, hora));
                    break;
