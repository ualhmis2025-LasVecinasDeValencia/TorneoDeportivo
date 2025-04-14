package org.ualhmis.torneos;

import java.util.ArrayList;
import java.util.List;

class GestorTorneos {
    private List<Torneo> torneos;

    public GestorTorneos() {
        this.torneos = new ArrayList<>();
    }

    public Torneo crearTorneo(String nombre, String deporte, String categoria, String modalidad, String tipo) {
    	
    	Torneo Nuevotorneo = new Torneo(nombre, deporte, categoria, modalidad, tipo); 
        torneos.add(Nuevotorneo);
        
        return Nuevotorneo; 
    }
    
    public boolean RegistrarEquipoTorneo(Equipo equipo, Torneo torneo) {
    	
    	
    	for(Torneo torneo1 : this.torneos) {
    		
    		for(Equipo equipos : torneo1.getEquipos()) {
    			
    			if(equipos.equals(equipo)) {
    				return false; 
    			}
	
    		}
    	}
    	
    	torneo.registrarEquipo(equipo);
    	return true; 
    	
    
    }
    
    
    
    public List<Torneo> getTorneos(){
    	
    	return torneos; 
    }
    
    
    
}