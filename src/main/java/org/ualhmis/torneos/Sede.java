package org.ualhmis.torneos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sede {
	
	
   private String nombre; 
   private ArrayList<Instalacion> instalaciones; 
   
   public Sede(String nombre, Instalacion... instalaciones) {
	   this.nombre=nombre;
	   
	   this.instalaciones = new ArrayList<Instalacion>(); 
	   for(Instalacion instalacion : instalaciones) {
		   this.instalaciones.add(instalacion);
	   }
   }
   
   public void AgregarInstalacion(Instalacion instalacion) {
	   instalaciones.add(instalacion);
   }
   
 

//public Sede(String nombre) {
//	  
//	  this.nombre = nombre; 
//	  this.instalaciones = new ArrayList<Instalacion>();
//	  
//  }
  
   
   public boolean AñadirInstalacion(Instalacion instalacion) { //Si cambiamos instalaciones por un HashSet ya no acepta duplicados, pero si se hace antes hay que añadir metodo equals y metodo hashcode(o como se llame) a Instalacion
	   if(this.instalaciones.contains(instalacion)) return false;
	   return this.instalaciones.add(instalacion); 
	   
   }
   

   public ArrayList<Instalacion> getInstalaciones() {
 	return instalaciones;
 }


 public void setInstalaciones(ArrayList<Instalacion> instalaciones) {
 	this.instalaciones = instalaciones;
 }
	
	

}
