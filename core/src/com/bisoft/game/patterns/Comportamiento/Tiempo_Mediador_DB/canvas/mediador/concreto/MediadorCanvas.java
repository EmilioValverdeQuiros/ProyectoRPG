package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.mediador.concreto;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.mediador.interfaces.IMediadorCanvas;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.objetos.Canvas;


public class MediadorCanvas implements IMediadorCanvas {
	private Canvas tiempoMediador;

	@Override
	public void guardar(String pM) {
		this.tiempoMediador.actualizar_el_record(pM.toLowerCase());
	}

	@Override
	public String mostrarHistorial() {
		return tiempoMediador.get_historial();
	}


	public void setLienzo(Canvas lienzo) {
		this.tiempoMediador = lienzo;
	}
	
}