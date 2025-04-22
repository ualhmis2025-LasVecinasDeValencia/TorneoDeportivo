package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class InstalacionTest {
	


	@Test
	void agregarReservaCorrectaNoLanzaExcepcion() {
		
		
	    Pista pista = new Pista("Campo1", "Futbol", "Baloncesto");
	    Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
    	Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
        Equipo e2 = new Equipo("A", "Juvenil", "Femenino", entrenador); 
	    Partido partido = new Partido(e1,e2);
	    partido.setDeporte("Futbol");
	    LocalDateTime inicio = LocalDateTime.of(2025, 5, 1, 10, 0);
	    LocalDateTime fin = LocalDateTime.of(2025, 5, 1, 11, 0);

	    assertDoesNotThrow(() -> {
	        pista.AgregarReserva(inicio, fin, partido);
	    });
	}
	
	
	
	
	@Test
	void agregarReservaConDeporteInvalidoLanzaExcepcion() {
	    Pista pista = new Pista("Campo1", "Futbol", "Baloncesto");
	    Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
	    Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
	    Equipo e2 = new Equipo("A", "Juvenil", "Femenino", entrenador);
	    Partido partido = new Partido(e1, e2);
	    partido.setDeporte("Rugby");  // Deporte no compatible con la pista

	    LocalDateTime inicio = LocalDateTime.of(2025, 5, 1, 12, 0);
	    LocalDateTime fin = LocalDateTime.of(2025, 5, 1, 13, 0);

	    assertThrows(ReservaException.class, () -> {
	        pista.AgregarReserva(inicio, fin, partido);
	    });
	}
	
	
	 @Test
	    void testAgregarDeporte() {
	        // Arrange: Creamos una pista con deportes iniciales
	        Pista pista = new Pista("Pista1", "Futbol");

	        // Act: Agregamos más deportes
	        pista.agregarDeporte("Baloncesto", "Tenis", "Futbol"); // "Futbol" ya estaba

	        // Assert: Comprobamos que contiene todos los deportes esperados
	        HashSet<String> deportesEsperados = new HashSet<>();
	        deportesEsperados.add("Futbol");
	        deportesEsperados.add("Baloncesto");
	        deportesEsperados.add("Tenis");

	        assertEquals(deportesEsperados, pista.getDeportes());
	    }
	 
	 @Test
	 void testGetNombre() {
	     Campo pista = new Campo("Pista GetNombre", "Futbol");
	     assertEquals("Pista GetNombre", pista.getNombre());
	 }
	 
	 @Test
	 void testSetNombre() {
	     Pista pista = new Pista("Inicial", "Futbol");
	     pista.setNombre("Nombre Cambiado");
	     assertEquals("Nombre Cambiado", pista.getNombre());
	 }
	 
	 @Test
	 void testSetDeportes() {
	     Pabellon pista = new Pabellon("Pista Deportes", "Futbol");

	     HashSet<String> nuevosDeportes = new HashSet<>();
	     nuevosDeportes.add("Balonmano");
	     nuevosDeportes.add("Tenis");

	     pista.setDeportes(nuevosDeportes);

	     assertEquals(nuevosDeportes, pista.getDeportes());
	 }
	 
	
	     // ⚙️ Datos: solo casos que deben provocar una excepción de solapamiento
	     static Stream<Arguments> provideReservasSolapadas() {
	         return Stream.of(
	             // Caso 1: la nueva empieza durante la reserva existente
	             Arguments.of(
	                 LocalDateTime.of(2025, 5, 1, 10, 0),
	                 LocalDateTime.of(2025, 5, 1, 11, 0),
	                 LocalDateTime.of(2025, 5, 1, 10, 30),
	                 LocalDateTime.of(2025, 5, 1, 11, 30)
	             ),

	             // Caso 2: la nueva termina durante la reserva existente
	             Arguments.of(
	                 LocalDateTime.of(2025, 5, 1, 10, 0),
	                 LocalDateTime.of(2025, 5, 1, 11, 0),
	                 LocalDateTime.of(2025, 5, 1, 9, 30),
	                 LocalDateTime.of(2025, 5, 1, 10, 30)
	             ),

	             // Caso 3: la nueva engloba completamente a la reserva existente
	             Arguments.of(
	                 LocalDateTime.of(2025, 5, 1, 10, 0),
	                 LocalDateTime.of(2025, 5, 1, 11, 0),
	                 LocalDateTime.of(2025, 5, 1, 9, 30),
	                 LocalDateTime.of(2025, 5, 1, 11, 30)
	             ),

	             // Caso 4: la nueva es exactamente igual a la existente
	             Arguments.of(
	                 LocalDateTime.of(2025, 5, 1, 10, 0),
	                 LocalDateTime.of(2025, 5, 1, 11, 0),
	                 LocalDateTime.of(2025, 5, 1, 10, 0),
	                 LocalDateTime.of(2025, 5, 1, 11, 0)
	             )
	         );
	     }

	     @ParameterizedTest(name = "Caso {index}: se espera ReservaException")
	     @MethodSource("provideReservasSolapadas")
	     void testSolapamientosQueLanzanExcepcion(
	         LocalDateTime reservaInicio,
	         LocalDateTime reservaFin,
	         LocalDateTime nuevaInicio,
	         LocalDateTime nuevaFin) {

	         // Arrange
	         Pista pista = new Pista("Campo1", "Futbol");
	         Entrenador entrenador = new Entrenador("Luis", "hombre", LocalDate.of(1990, 4, 5));
	         Equipo e1 = new Equipo("x", "Juvenil", "Femenino", entrenador);
	         Equipo e2 = new Equipo("y", "Juvenil", "Femenino", entrenador);

	         Partido partido1 = new Partido(e1, e2);
	         partido1.setDeporte("Futbol");

	         Partido partido2 = new Partido(e1, e2);
	         partido2.setDeporte("Futbol");

	         // Hacemos la reserva inicial correctamente
	         assertDoesNotThrow(() -> pista.AgregarReserva(reservaInicio, reservaFin, partido1));

	         // Act + Assert: la nueva debe lanzar excepción por solapamiento
	         assertThrows(ReservaException.class, () -> pista.AgregarReserva(nuevaInicio, nuevaFin, partido2));
	     }
	     

	
	     static Stream<Arguments> provideCasosEquals() {
	         return Stream.of(
	             // Mismo tipo y nombre → true
	             Arguments.of(new Pista("Pista1", "Futbol"), new Pista("Pista1", "Baloncesto"), true),

	             // Mismo tipo, mismo nombre con mayúsculas → true
	             Arguments.of(new Campo("campoX", "Tenis"), new Campo("CAMPOX", "Tenis"), true),

	             // Mismo tipo, distinto nombre → false
	             Arguments.of(new Pabellon("Pabellon1", "Gimnasia"), new Pabellon("Pabellon2", "Gimnasia"), false),

	             // Distinto tipo, mismo nombre → false
	             Arguments.of(new Pista("Multiuso", "Futbol"), new Campo("Multiuso", "Futbol"), false),

	             // Comparar con null → false
	             Arguments.of(new Pista("Pista1", "Futbol"), null, false),

	             // Comparar con objeto de otra clase → false
	             Arguments.of(new Pista("Pista1", "Futbol"), "Pista1", false)
	         );
	     }

	     @ParameterizedTest(name = "Test {index}: {0} == {1} → {2}")
	     @MethodSource("provideCasosEquals")
	     void testEqualsInstalacion(Object i1, Object i2, boolean esperado) {
	         assertEquals(esperado, i1.equals(i2));
	     }
	    
	 }









