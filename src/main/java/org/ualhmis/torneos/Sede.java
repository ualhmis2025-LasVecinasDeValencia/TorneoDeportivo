package org.ualhmis.torneos;

import java.util.ArrayList;

public class Sede {
	
	
   private String nombre; 
   private ArrayList<Instalacion> instalaciones; 
   
  public Sede(String nombre) {
	  
	  this.nombre = nombre; 
	  this.instalaciones = new ArrayList<Instalacion>();
	  
  }
  
  
   public boolean AñadirInstalacion(Instalacion instalacion) {
	   
	   return this.instalaciones.add(instalacion); 
	   
   }
   
	
	
	

}
