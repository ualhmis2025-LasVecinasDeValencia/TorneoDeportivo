package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SedeTest {
	
	 
	 
	 @Test
	 void testAñadirInstalacionNueva() {
	     Sede sede = new Sede("Sede1");
	     Instalacion instalacion = new Pista("Campo1", "Futbol", "Baloncesto");

	     boolean resultado = sede.AñadirInstalacion(instalacion);

	     assertTrue(resultado);
	 }
	 
	 @Test
	 void testNoAñadirInstalacionDuplicada() {
	     Sede sede = new Sede("Sede1");
	     Instalacion instalacion = new Pista("Campo1", "Futbol", "Baloncesto");

	     sede.AñadirInstalacion(instalacion); 
	     boolean resultado = sede.AñadirInstalacion(instalacion); 

	     assertFalse(resultado);
	 }
	 
	 @Test
	 void testSetInstalaciones() {
	     // Arrange
	     Sede sede = new Sede("Sede de prueba");

	     Instalacion pista1 = new Pista("Pista1", "Futbol");
	     Instalacion pista2 = new Pista("Pista2", "Baloncesto");

	     ArrayList<Instalacion> nuevasInstalaciones = new ArrayList<>();
	     nuevasInstalaciones.add(pista1);
	     nuevasInstalaciones.add(pista2);

	     // Act
	     sede.setInstalaciones(nuevasInstalaciones);

	     // Assert
	     assertEquals(nuevasInstalaciones, sede.getInstalaciones());
	 }
	
	
	
	

}
