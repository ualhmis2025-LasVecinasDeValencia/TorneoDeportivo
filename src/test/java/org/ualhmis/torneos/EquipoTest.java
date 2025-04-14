package org.ualhmis.torneos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

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
 
 
}
 
    
    
   
   
   
   
    

