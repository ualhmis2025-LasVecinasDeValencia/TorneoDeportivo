package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ClubTest {

	
	 @Test
	 
	 void creacionClubConListaDeEquipos() {
		
		 
		 Entrenador entrenadorPrueba = new Entrenador("Luis", "hombre", LocalDate.of(1990, 04, 05)); 
		 Equipo equipoPrueba = new Equipo("GallardoMartinez", "Juvenil", "Futbol", entrenadorPrueba);
		 Equipo equipoPrueb2 = new Equipo("GallardoMartinez2", "Juvenil", "Futbol", entrenadorPrueba);

		  
		 ArrayList<Equipo> listaDeEquipos = new ArrayList<Equipo>();
		 
		 
		 listaDeEquipos.add(equipoPrueba); 
		 listaDeEquipos.add(equipoPrueb2); 
		 
		 Club clubPrueba = new Club("ClubPrueba", listaDeEquipos); 
		 
		 assertEquals(listaDeEquipos, clubPrueba.getListaEquipos()); 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
}
