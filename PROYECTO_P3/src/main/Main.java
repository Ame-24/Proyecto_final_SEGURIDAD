package main;

import interfaz.Interfaz;
import interfaz.InterfazGrafica;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new InterfazGrafica();
        interfaz.iniciar();
    }
}