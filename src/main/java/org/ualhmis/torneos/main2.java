package org.ualhmis.torneos;

import java.time.LocalDate;

public class main2 {

	public static void main(String[] args) {

		
		 Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
	     Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);
	     
	     Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenador);

		
		Campo inst = new Campo("Campo"); 
	
		Partido p = new Partido(equipo, equipo2);
		
		/*
		inst.mostrarHorario();

		inst.asignarPartido(p, "10:00-10:30");

		inst.mostrarHorario();

		*/
		
		
		
	}

}
