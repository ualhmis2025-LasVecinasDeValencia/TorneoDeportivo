package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Creación de jugadores y cálculo automático de categoría

class EquipoTest {

    @Test
    void testAgregarJugadorCorrectamente() {
        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);

        Jugador jugador = new Jugador("Luis", "Masculino", LocalDate.of(2006, 7, 15)); // Juvenil
        equipo.agregarJugador(jugador);

        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void testNoAgregarJugadorDeDiferenteCategoria() {
        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);

        Jugador jugador = new Jugador("Luis", "Masculino", LocalDate.of(2015, 5, 10)); // Infantil

        equipo.agregarJugador(jugador);

        assertEquals(0, equipo.getJugadores().size()); // No debe agregarse
    }

    @Test
    void testAsignarSegundoEntrenador() {
        Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
        equipo.asignarSegundoEntrenador(entrenador2);

        assertNotNull(equipo.getSegundoEntrenador());
        assertEquals("Ana", equipo.getSegundoEntrenador().getNombre());
    }
    
    

    @ParameterizedTest(name = "{index} => nombre={0}, categoria={1}, modalidad={2}, nuloEntrenador={3}")
    @CsvSource({
        " , Infantil, Futbol, true",       // nombre vacío
        "'   ', Infantil, Futbol, true",   // nombre con espacios
        "Equipo A, , Futbol, true",        // categoría nula
        "Equipo A, Infantil, , true",      // modalidad nula
        "Equipo A, Infantil, Futbol, true"  // entrenador nulo
    })
    
    
    void testConstructorConDatosInvalidos(String nombre, String categoria, String modalidad, boolean nuloEntrenador) {
        Entrenador entrenador = nuloEntrenador ? null : new Entrenador(modalidad, modalidad, null);

        assertThrows(IllegalArgumentException.class, () -> {
            new Equipo(nombre, categoria, modalidad, entrenador);
        });
    }
    
    
    
    Entrenador entrenadorPrueba = new Entrenador("Luis", "hombre", LocalDate.of(1990, 04, 05)); 
    Equipo equipoPrueba = new Equipo("GallardoMartinez", "Juvenil", "Futbol", entrenadorPrueba);

    
    
  @Test
    
    void getNombre() {
    	
    	assertEquals("GallardoMartinez", equipoPrueba.getNombre()); 	
    }

 @Test
  
  void getCategoria() {
  	
  	assertEquals("Juvenil", equipoPrueba.getCategoria()); 
  }
  
 @Test
 
 void getModalidad() {
 	
 	assertEquals("Futbol", equipoPrueba.getModalidad()); 
 }
 
 @Test
 
 void getEntrenador() {
 	
 Entrenador entrenadorPruebaAssert = entrenadorPrueba;   
 	
 
 assertEquals(entrenadorPrueba, equipoPrueba.getEntrenador()); 
 	
 }
 
 
 @Test
 void setNombre() {
	 
	 equipoPrueba.setNombre("Antonio");
	 assertEquals("Antonio", equipoPrueba.getNombre()); 
	 
 }
    
 @Test
 void setCategoria() {
	 
	 equipoPrueba.setCategoria("Junior");
	 assertEquals("Junior", equipoPrueba.getCategoria()); 
	 
 }   
 
 @Test
 void setModalidad() {
	 
	 equipoPrueba.setModalidad("Tenis");
	 assertEquals("Tenis", equipoPrueba.getModalidad()); 
	 
 }   
 
 //Pueden existir problemas en este ya que de momento no tenemos equals de entrenador
 //Se podría hacer con desigual
 @Test
 void setEntrenador() {
	 
	 equipoPrueba.setEntrenador(entrenadorPrueba); 
	 assertEquals(entrenadorPrueba, equipoPrueba.getEntrenador()); 
	 
 }   
 
 

 @Test
 void testToStringEquipo() {

	 String esperado = "Equipo [nombre=GallardoMartinez, categoria=Juvenil, modalidad=Futbol, entrenador=" +
                       entrenadorPrueba.toString() + ", segundoEntrenador=null, jugadores=[]]";

     assertEquals(esperado, equipoPrueba.toString());
 }
 
 
 
 @Test
 void testEqualsMismoObjeto() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo equipo = new Equipo("A", "Infantil", "Futbol", entrenador);
     assertTrue(equipo.equals(equipo));
 }

 

 @Test
 void testEqualsConNull() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo equipo = new Equipo("A", "Infantil", "Futbol", entrenador);
     assertFalse(equipo.equals(null));
 }

 @Test
 void testEqualsConOtraClase() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo equipo = new Equipo("A", "Infantil", "Futbol", entrenador);
     String otroObjeto = "No es un equipo";
     assertFalse(equipo.equals(otroObjeto));
 }

 @Test
 void testEqualsConMismosDatos() {
     Entrenador entrenador1 = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Entrenador entrenador2 = new Entrenador("Ana", "mujer", LocalDate.of(1985, 6, 10));

     Equipo equipo1 = new Equipo("A", "Infantil", "Futbol", entrenador1);
     Equipo equipo2 = new Equipo("A", "Infantil", "Futbol", entrenador2); // entrenadores distintos, pero equals no los compara

     assertTrue(equipo1.equals(equipo2));
 }

 @Test
 void testEqualsConDatosDistintos() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));

     Equipo equipo1 = new Equipo("A", "Infantil", "Futbol", entrenador);
     Equipo equipo2 = new Equipo("B", "Infantil", "Futbol", entrenador); // nombre distinto

     assertFalse(equipo1.equals(equipo2));
 }
 
 
 
 @Test
 void testEqualsConCategoriaDistinta() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));

     Equipo equipo1 = new Equipo("A", "Infantil", "Futbol", entrenador);
     Equipo equipo2 = new Equipo("A", "Juvenil", "Futbol", entrenador); // categoría distinta

     assertFalse(equipo1.equals(equipo2));
 }

 @Test
 void testEqualsConModalidadDistinta() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));

     Equipo equipo1 = new Equipo("A", "Infantil", "Futbol", entrenador);
     Equipo equipo2 = new Equipo("A", "Infantil", "Baloncesto", entrenador); // modalidad distinta

     assertFalse(equipo1.equals(equipo2));
 }
 
 // Ambos categoria = null
 @Test
 void testEqualsConAmbasCategoriasNull() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo e1 = new Equipo("A", "x", "Futbol", entrenador);
     Equipo e2 = new Equipo("A", "x", "Futbol", entrenador);
     e1.setCategoria(null);
     e2.setCategoria(null);

     assertTrue(e1.equals(e2));
 }

 // this.categoria = null, other.categoria != null
 @Test
 void testEqualsConCategoriaNullSoloEnUno() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo e1 = new Equipo("A", "x", "Futbol", entrenador);
     Equipo e2 = new Equipo("A", "Infantil", "Futbol", entrenador);
     e1.setCategoria(null);

     assertFalse(e1.equals(e2));
 }

 // Ambos modalidad = null
 @Test
 void testEqualsConAmbasModalidadesNull() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo e1 = new Equipo("A", "Infantil", "x", entrenador);
     Equipo e2 = new Equipo("A", "Infantil", "x", entrenador);
     e1.setModalidad(null);
     e2.setModalidad(null);

     assertTrue(e1.equals(e2));
 }

 // this.modalidad = null, other.modalidad != null
 @Test
 void testEqualsConModalidadNullSoloEnUno() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo e1 = new Equipo("A", "Infantil", "x", entrenador);
     Equipo e2 = new Equipo("A", "Infantil", "Futbol", entrenador);
     e1.setModalidad(null);

     assertFalse(e1.equals(e2));
 }

 // Ambos nombre = null
 @Test
 void testEqualsConAmbosNombresNull() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo e1 = new Equipo("x", "Infantil", "Futbol", entrenador);
     Equipo e2 = new Equipo("x", "Infantil", "Futbol", entrenador);
     e1.setNombre(null);
     e2.setNombre(null);

     assertTrue(e1.equals(e2));
 }

 // this.nombre = null, other.nombre != null
 @Test
 void testEqualsConNombreNullSoloEnUno() {
     Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
     Equipo e1 = new Equipo("x", "Infantil", "Futbol", entrenador);
     Equipo e2 = new Equipo("A", "Infantil", "Futbol", entrenador);
     e1.setNombre(null);

     assertFalse(e1.equals(e2));
 }
 
 
 @Test 
 
 void testSetSegundoEntrenador() {
	 
	 Entrenador segundoEntrenador = entrenadorPrueba; 
	 equipoPrueba.setSegundoEntrenador(segundoEntrenador);
	 
	 assertEquals(segundoEntrenador, equipoPrueba.getSegundoEntrenador()); 
	 
	 
 }
 
 
 @Test
 
 void testsetJugadores() {
	 
	 Jugador jugador1 = new Jugador("Antonio", "Hombre", LocalDate.of(2004, 4, 5));
	 Jugador jugador2 = new Jugador("Miguel", "Hombre", LocalDate.of(2004, 6, 30));
	 
	 ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>(); 
	 listaJugadores.add(jugador1); 
	 listaJugadores.add(jugador2); 
	 
	 equipoPrueba.setJugadores(listaJugadores);
	 
	 assertEquals(listaJugadores, equipoPrueba.getJugadores()); 
	 
 }
 
 
}
 
    
    
   
   
   
   
    

