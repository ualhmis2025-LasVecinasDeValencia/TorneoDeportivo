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
   
   public void AgregarReserva(Instalacion instalacion,LocalDateTime horaInicio,LocalDateTime horaFin,Partido partido) {
	   
	   for(Reserva reserva : reservas) {
		   if((reserva.getHorarioInicio().isBefore(horaInicio) && horaInicio.isBefore(reserva.getHorarioFin())) || (reserva.getHorarioInicio().isAfter(horaInicio) && horaFin.isAfter(reserva.getHorarioInicio()))) {
			   if(reserva.getInstalacion().equals(instalacion)) {
				   //Aquí habria que devolver error
			   }
		   }
		   
	   }
	   Reserva reserva = new Reserva(partido,horaInicio,horaFin,instalacion);
	   reservas.add(reserva);
	   
   }
   
	
	
	

}
