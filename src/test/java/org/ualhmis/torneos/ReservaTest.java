package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ReservaTest {

	@Test
	 
	 void GetPartido() {
		
		 Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

	     Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

	     Partido partido = new Partido(equipo1, equipo2);
	     LocalDateTime hi =  LocalDateTime.of(2025, 6, 15,15,30,00);
	     LocalDateTime hf =  LocalDateTime.of(2025, 6, 15,16,30,00);
		 Reserva reserva = new Reserva(partido, hi, hf) ;
		 
		 assertEquals(partido, reserva.getPartido()); 
		 
	 }
	
	@Test
	 
	 void SetPartido() {
		
		 Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

	     Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);
	     

	     Partido partido = new Partido(equipo1, equipo2);
	     LocalDateTime hi =  LocalDateTime.of(2025, 6, 15,15,30,00);
	     LocalDateTime hf =  LocalDateTime.of(2025, 6, 15,16,30,00);
		 Reserva reserva = new Reserva(partido, hi, hf) ;
		 
		 Equipo equipo3 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador2);
		 Partido partido2 = new Partido(equipo1,equipo3);
		 reserva.setPartido(partido2);
		 
		 
		 assertEquals(partido2, reserva.getPartido()); 
		 
	 }
	
	@Test
	 
	 void GetHoraInicio() {
		
		 Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

	     Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

	     Partido partido = new Partido(equipo1, equipo2);
	     LocalDateTime hi =  LocalDateTime.of(2025, 6, 15,15,30,00);
	     LocalDateTime hf =  LocalDateTime.of(2025, 6, 15,16,30,00);
		 Reserva reserva = new Reserva(partido, hi, hf) ;
		 
		 assertEquals(hi, reserva.getHorarioInicio()); 
		 
	 }
	
	@Test
	 
	 void SetHoraInicio() {
		
		 Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

	     Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);
	     

	     Partido partido = new Partido(equipo1, equipo2);
	     LocalDateTime hi =  LocalDateTime.of(2025, 6, 15,15,30,00);
	     LocalDateTime hf =  LocalDateTime.of(2025, 6, 15,16,30,00);
		 Reserva reserva = new Reserva(partido, hi, hf) ;
		 
		 LocalDateTime hi2 =  LocalDateTime.of(2025, 6, 15,13,30,00);
		 
		 reserva.setHorarioInicio(hi2);
		 
		 
		 assertEquals(hi2, reserva.getHorarioInicio()); 
		 
	 }
	@Test
	 
	 void GetHoraFin() {
		
		 Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

	     Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);

	     Partido partido = new Partido(equipo1, equipo2);
	     LocalDateTime hi =  LocalDateTime.of(2025, 6, 15,15,30,00);
	     LocalDateTime hf =  LocalDateTime.of(2025, 6, 15,16,30,00);
		 Reserva reserva = new Reserva(partido, hi, hf) ;
		 
		 assertEquals(hf, reserva.getHorarioFin()); 
		 
	 }
	
	@Test
	 
	 void SetHoraFin() {
		
		 Entrenador entrenador1 = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Entrenador entrenador2 = new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20));

	     Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador1);
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador2);
	     

	     Partido partido = new Partido(equipo1, equipo2);
	     LocalDateTime hi =  LocalDateTime.of(2025, 6, 15,15,30,00);
	     LocalDateTime hf =  LocalDateTime.of(2025, 6, 15,16,30,00);
		 Reserva reserva = new Reserva(partido, hi, hf) ;
		 
		 LocalDateTime hf2 =  LocalDateTime.of(2025, 6, 15,17,30,00);
		 
		 reserva.setHorarioFin(hf2);
		 
		 
		 assertEquals(hf2, reserva.getHorarioFin()); 
		 
	 }
}
