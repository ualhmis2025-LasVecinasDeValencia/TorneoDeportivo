package org.ualhmis.torneos;

import java.util.ArrayList;
import java.util.List;

class Torneo {
    private String nombre;
    private String deporte;
    private String categoria;
    private String modalidad;
    private List<Equipo> equipos;
    private String tipo;
    private ArrayList<Partido> partidos; 
    private Equipo GanadorTorneo; 
    private Sede sede; 

    public Torneo(String nombre, String deporte, String categoria, String modalidad, String tipo) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.categoria = categoria;
        this.modalidad = modalidad;
        
        //En el main se podría poner .toLowerCase. (Además de avisar cuales son los tipos correctos)
        if(tipo != "copa" && tipo != "liga") {
            throw new IllegalArgumentException("El tipo de torneo no es válido"); 
        }
        else {
        	
            this.tipo = tipo;

        }
        this.equipos = new ArrayList<>();
        
        
        
        
    }

    public void registrarEquipo(Equipo equipo) {
        if (!equipo.getCategoria().equals(this.categoria) || !equipo.getModalidad().equals(this.modalidad)) {
            throw new IllegalArgumentException("El equipo no cumple con la categoría y modalidad del torneo");
        }
        if (!equipos.contains(equipo)) {
            equipos.add(equipo);
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
		
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	@Override
	public String toString() {
	    return "Torneo [nombre=" + nombre +
	           ", deporte=" + deporte +
	           ", categoria=" + categoria +
	           ", modalidad=" + modalidad +
	           ", tipo=" + tipo +
	           ", equipos=" + equipos + "]";
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (!(o instanceof Torneo)) 
        	return false;

        Torneo torneo = (Torneo) o;

        return (this.nombre==torneo.nombre && this.deporte==torneo.deporte && this.categoria==torneo.categoria && this.modalidad==torneo.modalidad && this.tipo==torneo.tipo);
        
    }
	
	
	public Partido registrarPartidos(Partido partido){
		
		//Precondición: 

		if(this.equipos.contains(partido.getEquipo1()) == false || this.equipos.contains(partido.getEquipo2()) == false) {
			
			return null; 
		}
		this.partidos.add(partido); 
	    
		
		return partido; 
		
		
	}
	
	public boolean registrarGanador(Equipo equipo) {
		
		
		if (this.equipos.contains(equipo) == false) return false; 
		
		this.GanadorTorneo = equipo; 
		return true; 
		
		
	}
	
	
	//El usuario debe elegir la instalacion que es adecuada según el deporte del torneo. 
	
	public boolean vincularSede(Sede sede, Instalacion instalacion) {
		
	     //Precondicion: 
		
		if(sede.getInstalaciones().contains(instalacion) == false) return false; 
		
		this.sede = sede; 
		
		return true; 

	}
	
	

    
    
}
