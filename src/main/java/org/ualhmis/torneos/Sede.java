package org.ualhmis.torneos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sede {
	
	
   private String nombre; 
   private ArrayList<Instalacion> instalaciones; 
   private ArrayList<Reserva> reservas;
   
   public Sede(String nombre, Instalacion... instalaciones) {
	   this.nombre=nombre;
	   for(Instalacion instalacion : instalaciones) {
		   this.instalaciones.add(instalacion);
	   }
   }
   
   public void AgregarInstalacion(Instalacion instalacion) {
	   instalaciones.add(instalacion);
   }
   
   public void AgregarReserva(Instalacion instalacion,LocalDateTime horaInicio,LocalDateTime horaFin,Partido partido) throws ReservaException {
	   if(!instalacion.comprobarDeporte(partido.getDeporte())) throw new ReservaException("No se puede realizar un partido de " +partido.getDeporte() + " en esta instalación.");
	   for(Reserva reserva : reservas) {
		   if((reserva.getHorarioInicio().isBefore(horaInicio) && horaInicio.isBefore(reserva.getHorarioFin())) || (reserva.getHorarioInicio().isAfter(horaInicio) && horaFin.isAfter(reserva.getHorarioInicio()))) {
			   if(reserva.getInstalacion().equals(instalacion)) {
				   throw new ReservaException("Ya existe una reserva en ese lugar y hora.");
			   }
		   }
		   
	   }
	   Reserva reserva = new Reserva(partido,horaInicio,horaFin,instalacion);
	   reservas.add(reserva);
	   
   }
   
 

public Sede(String nombre) {
	  
	  this.nombre = nombre; 
	  this.instalaciones = new ArrayList<Instalacion>();
	  
  }
  
  
   public boolean AñadirInstalacion(Instalacion instalacion) {
	   
	   return this.instalaciones.add(instalacion); 
	   
   }
   

   public ArrayList<Instalacion> getInstalaciones() {
 	return instalaciones;
 }


 public void setInstalaciones(ArrayList<Instalacion> instalaciones) {
 	this.instalaciones = instalaciones;
 }
	
	

}
