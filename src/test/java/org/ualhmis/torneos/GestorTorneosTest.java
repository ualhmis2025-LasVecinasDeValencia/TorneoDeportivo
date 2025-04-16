package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GestorTorneosTest {

	@Test
	void testCrearTorneo() {
		GestorTorneos GT = new GestorTorneos();
		List<Torneo> torneos = new ArrayList<>();

		GT.crearTorneo("PádelExtreme", "Pádel", "Juvenil", "Masculino", "Liga");
		torneos.add(new Torneo("PádelExtreme", "Pádel", "Juvenil", "Masculino", "Liga"));
		assertEquals(GT.getTorneos(), torneos);
	}

	@Test
	void testRegistrarEquipoTorneo() {
		GestorTorneos GT = new GestorTorneos();

		GT.crearTorneo("PádelExtreme", "Pádel", "Juvenil", "Masculino", "Liga");
		GT.crearTorneo("King Pon", "Tenis de mesa", "Juvenil", "Masculino", "Liga");

		Entrenador entrenador = new Entrenador("Leopoldo","Masculino",LocalDate.of(1990, 04, 16));
		Equipo equipo= new Equipo("VdV","Juvenil","Masculino",entrenador);
		assertTrue(GT.RegistrarEquipoTorneo(equipo, GT.getTorneos().getFirst()));
		assertFalse(GT.RegistrarEquipoTorneo(equipo, GT.getTorneos().getLast()));
		
	}
}
