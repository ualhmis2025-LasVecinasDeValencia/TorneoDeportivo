package org.ualhmis.torneos;

import java.time.LocalDateTime;

public class Reserva {

	private Partido partido;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFin;
	
	
	public Reserva(Partido partido, LocalDateTime horarioInicio,LocalDateTime horarioFin) {
		this.partido=partido;
		this.horarioInicio=horarioInicio;
		this.horarioFin=horarioFin;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public LocalDateTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalDateTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalDateTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalDateTime horarioFin) {
		this.horarioFin = horarioFin;
	}

	
}