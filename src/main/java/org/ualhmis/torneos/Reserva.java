package org.ualhmis.torneos;

import java.time.LocalDateTime;

public class Reserva {

	private Partido partido;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFin;
	private Instalacion instalacion;
	
	public Reserva(Partido partido, LocalDateTime horarioInicio,LocalDateTime horarioFin, Instalacion instalacion) {
		this.partido=partido;
		this.horarioInicio=horarioInicio;
		this.horarioFin=horarioFin;
		this.instalacion=instalacion;
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

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	
}