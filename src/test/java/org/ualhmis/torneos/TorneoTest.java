package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

// Registro de partidos y validación de resultados


class TorneoTest {

    @Test
    void testRegistrarEquipoCorrectamente() {
        Torneo torneo = new Torneo("Liga Juvenil", "Fútbol", "Juvenil", "Masculino", "Liga");

        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);

        torneo.registrarEquipo(equipo);

        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testNoRegistrarEquipoDeDiferenteCategoria() {
        Torneo torneo = new Torneo("Liga Juvenil", "Fútbol", "Juvenil", "Masculino", "Liga");

        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Cadete", "Masculino", entrenador);

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipo));
    }

    @Test
    void testNoRegistrarEquipoDeDiferenteModalidad() {
        Torneo torneo = new Torneo("Liga Juvenil", "Fútbol", "Juvenil", "Masculino", "Liga");

        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Leonas", "Juvenil", "Femenino", entrenador);

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipo));
    }
    
    
    
    
    Torneo torneo = new Torneo("Liga Juvenil", "Fútbol", "Juvenil", "Masculino", "Liga");

    @Test
    void testGetNombre() {
    	
       assertEquals("Liga Juvenil", torneo.getNombre()); 
    }
    
    @Test
    
    void testGetDeporte() {
    	
    	assertEquals("Fútbol", torneo.getDeporte()); 
    }
    
    @Test
    
    void testGetCategoria() {
    	
    	assertEquals("Juvenil", torneo.getCategoria());
    }
    
    @Test
    
    void testGetModalidad() {
    	
    	assertEquals("Masculino", torneo.getModalidad()); 
    }
    
    @Test
    
    void testGetTipo() {
    	
    	assertEquals("Liga", torneo.getTipo()); 
    }
    
    @Test
    
    void testSetNombre() {
    	
    	torneo.setNombre("Torneo de Antonio");
    	assertEquals("Torneo de Antonio", torneo.getNombre()); 
    }
    
    @Test
    
    void testSetDeporte() {
    	torneo.setDeporte("tenis");
    	assertEquals("tenis", torneo.getDeporte()); 
    }
    
    @Test
    
    void testSetCategoria() {
    	
    	torneo.setCategoria("Junior");
    	assertEquals("Junior", torneo.getCategoria()); 
    }
    
    @Test
    
    void testSetModalidad() {
    	
    	torneo.setModalidad("Femenino");
        assertEquals("Femenino", torneo.getModalidad()); 
    }
    
    @Test
    
    void testSetTipo() {
    	
    	torneo.setTipo("Copa");
        assertEquals("Copa", torneo.getTipo()); 
    }
    
    @Test
    
    void testSetEquipos() {
    	
    	
        Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));

    	
    	 Equipo e1 = new Equipo("x", "Infantil", "Futbol", entrenador);
         Equipo e2 = new Equipo("A", "Infantil", "Futbol", entrenador);
         
         ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>(); 
         listaEquipos.add(e1); 
         listaEquipos.add(e2);
         torneo.setEquipos(listaEquipos);
         assertEquals(listaEquipos, torneo.getEquipos()); 
         
         
    }
    
    
    
}
