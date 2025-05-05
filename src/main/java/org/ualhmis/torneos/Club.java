package org.ualhmis.torneos;

import java.util.ArrayList;

public class Club {
	
	//Atributos: 
	
   private String nombre; 
   private ArrayList<Equipo>  listaEquipos; 
   
   public Club (String nombre, ArrayList<Equipo> listaEquipos) {
	   
	   this.nombre = nombre; 
	   this.listaEquipos = new ArrayList<Equipo>(); 
	   
	   for (Equipo equipo : listaEquipos) {
		   
		   this.listaEquipos.add(equipo); 
		   }
	   
   }
   
   
   public ArrayList<Equipo> getListaEquipos() {
	return listaEquipos;
}



public Club (String nombre) {
	   
	   this.nombre = nombre; 
	   this.listaEquipos = new ArrayList<Equipo>(); 
	   
   }
   
   

public boolean AñadirEquipoClub(Equipo equipo) {
	
	//Precondición: 
	if(listaEquipos.contains(equipo)) return false; 
	listaEquipos.add(equipo); 
	return true; 
	
}
   
   
   
   
   
   

}
