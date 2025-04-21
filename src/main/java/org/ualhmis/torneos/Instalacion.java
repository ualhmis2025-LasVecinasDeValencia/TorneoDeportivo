package org.ualhmis.torneos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

abstract class  Instalacion {

    private TreeMap<String, Boolean> horario;
    private String nombre;
    private HashSet<String> deportes;
    private ArrayList<Reserva> reservas;
    

//    public Instalacion() {
//        this.horario = new TreeMap<>();
//        establecerFranjas(LocalTime.of(8, 0), LocalTime.of(22, 0)); 
//    }

   
    public void AgregarReserva(LocalDateTime horaInicio,LocalDateTime horaFin,Partido partido) throws ReservaException {
 	   if(!this.comprobarDeporte(partido.getDeporte())) throw new ReservaException("No se puede realizar un partido de " +partido.getDeporte() + " en esta instalación.");
 	   for(Reserva reserva : reservas) {
 		   if((reserva.getHorarioInicio().isBefore(horaInicio) && horaInicio.isBefore(reserva.getHorarioFin())) || (reserva.getHorarioInicio().isAfter(horaInicio) && horaFin.isAfter(reserva.getHorarioInicio()))) {
 			  throw new ReservaException("Ya existe una reserva en esta instalación a esa hora");
 		   }
 		   
 	   }
 	   Reserva reserva = new Reserva(partido,horaInicio,horaFin);
 	   reservas.add(reserva);
 	   
    }
    
    //
    //
    //
    //
  
    public Instalacion(String nombre, String... deportes) {
      this.nombre=nombre;
      this.deportes = new HashSet<String>(); 
      for(String deporte : deportes) {
  		this.deportes.add(deporte);
  	}
  }
    
    public void agregarDeporte(String... deportes) {
    	for(String deporte : deportes) {
    		if(comprobarDeporte(deporte)) continue; //Aquí he hecho que no devuelva error si algun deporte se repita, simplemente que siga.
    		this.deportes.add(deporte);
    	}
    }
    
    public boolean comprobarDeporte(String deporte) {
    	return deportes.contains(deporte);
    }
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<String> getDeportes() {
		return deportes;
	}

	public void setDeportes(HashSet<String> deportes) {
		this.deportes = deportes;
	}
    
}

    
    

