package org.ualhmis.torneos;

import java.time.LocalTime;
import java.util.TreeMap;

public class Instalacion {

    private TreeMap<String, Boolean> horario;

    public Instalacion() {
        this.horario = new TreeMap<>();
        establecerFranjas(LocalTime.of(8, 0), LocalTime.of(22, 0)); 
    }

    public void establecerFranjas(LocalTime inicio, LocalTime fin) {
        horario.clear();
        while (inicio.isBefore(fin)) {
            LocalTime siguiente = inicio.plusMinutes(30);
            String franja = inicio + "-" + siguiente;
            horario.put(franja, true);
            inicio = siguiente;
        }
    }

    public boolean asignarPartido(Partido partido, String franjaHoraria) {
        if (!horario.containsKey(franjaHoraria)) {
            System.out.println("Franja no válida: " + franjaHoraria);
            return false;
        }

        if (horario.get(franjaHoraria)) {
            horario.put(franjaHoraria, false); 
            System.out.println("Partido asignado en la franja: " + franjaHoraria);
            return true;
        } else {
            System.out.println("Franja ocupada: " + franjaHoraria);
            return false;
        }
    }

    public void mostrarHorario() {
        for (String franja : horario.keySet()) {
            System.out.println(franja + " → " + (horario.get(franja) ? "Libre" : "Ocupada"));
        }
    }
}

    
    

