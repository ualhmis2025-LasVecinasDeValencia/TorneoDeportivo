package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Registro de partidos y validación de resultados


class TorneoTest {

    @Test
    void testRegistrarEquipoCorrectamente() {
        Torneo torneo = new Torneo("liga Juvenil", "Fútbol", "Juvenil", "Masculino", "liga");

        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);

        torneo.registrarEquipo(equipo);

        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testNoRegistrarEquipoDeDiferenteCategoria() {
        Torneo torneo = new Torneo("liga Juvenil", "Fútbol", "Juvenil", "Masculino", "liga");

        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Cadete", "Masculino", entrenador);

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipo));
    }

    @Test
    void testNoRegistrarEquipoDeDiferenteModalidad() {
        Torneo torneo = new Torneo("liga Juvenil", "Fútbol", "Juvenil", "Masculino", "liga");

        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Leonas", "Juvenil", "Femenino", entrenador);

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipo));
    }
    
    
    
    
    Torneo torneo = new Torneo("liga Juvenil", "Fútbol", "Juvenil", "Masculino", "liga");

    @Test
    void testGetNombre() {
    	
       assertEquals("liga Juvenil", torneo.getNombre()); 
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
    	
    	assertEquals("liga", torneo.getTipo()); 
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
    	
    	torneo.setTipo("copa");
        assertEquals("copa", torneo.getTipo()); 
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
    
    @Test
    
    void testTorneoToString() {
    	
    	String expected = "Torneo [nombre=Futbolin humano, deporte=Futbol, categoria=Juvenil, modalidad=Femenino, tipo=liga, equipos="; 
         
    	Torneo torneo = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");
    	
    	assertEquals(expected+"[]]",torneo.toString());
    	
    	Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
    	Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
        Equipo e2 = new Equipo("A", "Juvenil", "Femenino", entrenador);
        List<Equipo> lista = new ArrayList<Equipo>();
        lista.add(e1);
        lista.add(e2);
        
    	torneo.registrarEquipo(e1);
    	torneo.registrarEquipo(e2);
    	
    	assertEquals(expected + lista.toString()+"]",torneo.toString());
    }
    
    @Test
    
    void testEquals() {
    	
    	Torneo torneo = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");
    	Torneo torneo2 = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");
    	Torneo torneo3 = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Masculino", "liga");
    	assertTrue(torneo.equals(torneo));
    	assertTrue(torneo.equals(torneo2));
    	assertFalse(torneo.equals(torneo3));
    	assertFalse(torneo.equals(4));
    }
    
    
    @Test
    
    void testTorneoConDistintaModalidad() {
    
    
    assertThrows(IllegalArgumentException.class, () -> new Torneo("nombre", "deporte", "categoria", "modalidad", "tipoInvalido"));

}
    
    
    @ParameterizedTest
    @CsvSource({
    	
    	// nombre, deporte, categoria, modalidad, tipo, resultadoEsperado
    	
    	
        "Copa Futsal, Futbol Sala, Juvenil, Masculino,copa, true",
        "Liga Escolar, Baloncesto, Infantil, Femenino,liga, true",
        "Copa Primavera, Gimnasia Rítmica, Cadete, Femenino,copa, false",
        "Torneo Rápido, Ajedrez, Senior, Mixto,liga, false",
        "Copa Verano, Rugby, Juvenil, Masculino,copa, false"    	
    	
    	
    	
    	
    })
    
    void testVinculacionDeTorneoConSede(String nombre, String deporte, String categoria, String modalidad, String tipo, Boolean resultadoEsperado) {
    	
    	
    	//Arrange
    	Torneo torneo = new Torneo(nombre, deporte, categoria, modalidad, tipo); 
     
    	Pista pistaSede = new Pista("Pista1", "Baloncesto", "Futbol Sala");
    	Pabellon pabellonSede = new Pabellon("Pabellon1", "Gimnasia", "VoleyComba"); 
    
    	Sede sede = new Sede("RafaelFlorido", pistaSede, pabellonSede ); 
    	
    	//Act
    	
    	boolean resultado0 = torneo.vincularSede(sede); 
    	
    	
    	//Assert 
    	
    	assertEquals(resultadoEsperado, resultado0); 
    	
    		
    }
    
    
    @Test 
    
    void testRegistrarPartidosTorneo() {
    	
    	
    	Torneo torneo = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");

    	Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
    	Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
        Equipo e2 = new Equipo("A", "Juvenil", "Femenino", entrenador);
        Partido partido1 = new Partido(e1, e2); 
        torneo.registrarEquipo(e1);
        torneo.registrarEquipo(e2);
        
        Partido resultado = torneo.registrarPartidos(partido1); 
        
        assertEquals(partido1, resultado); 

        
    }
    
    
 @Test 
    
    void testRegistrarTorneoFallido() {
    	
    	
    	Torneo torneo = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");

    	Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
    	Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
        Equipo e2 = new Equipo("A", "Juvenil", "Femenino", entrenador);
        Partido partido1 = new Partido(e1, e2); 
        torneo.registrarEquipo(e1);
     
        
        Partido resultado = torneo.registrarPartidos(partido1); 
        
        assertEquals(null, resultado); 

        
    }
 
 
 @Test
 
  void testRegistrarGanador() {
	 
	 Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
 	 Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
 	 Torneo torneo = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");
 	 torneo.registrarEquipo(e1);
 	 torneo.registrarGanador(e1); 
 	 
 	 assertEquals(e1, torneo.getGanadorTorneo()); 
 	 
	 
 }
 
 
 @Test
 void testRegistrarGanadorQueNoParticipaEnElTorneo() {
	 
	 Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
 	 Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
 	 Torneo torneo = new Torneo("Futbolin humano", "Futbol", "Juvenil", "Femenino", "liga");
 	 torneo.registrarGanador(e1); 
 	 
 	 assertNotEquals(e1, torneo.getGanadorTorneo()); 
	 
	 
	 
 }

 
 
 

 
    
    
    
    
    
    
    
    
    
    

    
}


