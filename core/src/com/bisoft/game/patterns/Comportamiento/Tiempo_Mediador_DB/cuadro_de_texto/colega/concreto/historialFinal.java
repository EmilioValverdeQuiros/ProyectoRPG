package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.concreto;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.interfaz.iColega;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.mediador.interfaces.iMediador;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.objetos.text_box;

public class historialFinal implements iColega {
	private String mensaje;
	private iMediador mediador;

	public historialFinal() {
		setMensaje("<----");
	}

	public historialFinal(iMediador poM, String pMes) {
		setMediador(poM);
		setMensaje(pMes);
	}

	public historialFinal(String pMes) {
		setMensaje(pMes);
	}

	@Override
	public String obtenerTipo() {
		return "Despedir";
	}

	@Override
	public String obtenerMensaje() {
		return mensaje;
	}

	@Override
	public void agregar_mensaje(text_box obj) {
		obj.setTexto(this.obtenerMensaje());
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setMediador(iMediador poM) {
		this.mediador = poM;
	}


}
