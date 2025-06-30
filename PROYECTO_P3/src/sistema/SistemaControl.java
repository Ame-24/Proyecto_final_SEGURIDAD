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