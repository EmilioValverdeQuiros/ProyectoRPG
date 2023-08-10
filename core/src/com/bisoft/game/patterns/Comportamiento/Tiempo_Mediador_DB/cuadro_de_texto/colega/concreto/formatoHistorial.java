package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.concreto;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.interfaz.iColega;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.mediador.interfaces.iMediador;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.objetos.text_box;

public class formatoHistorial implements iColega {
	private String mensaje;
	private iMediador mediador;

	public formatoHistorial() {
		setMensaje("<----","bold");
	}

	public formatoHistorial(iMediador poM, String pMes) {
		setMediador(poM);
		setMensaje(pMes,"bold");
	}

	public formatoHistorial(String pMes) {
		setMensaje(pMes, "bold");
	}

	private String get_italic(String pMes) {
		return "_" + pMes +"_" ;
	}
	private String get_bold(String pMes) {
		return "*" + pMes +"*" ;
	}

	public void setMensaje(String mensaje, String pFormat) {
		if(pFormat == "bold")
			this.mensaje = get_bold(mensaje);
		else
			this.mensaje = get_italic(mensaje);
	}

	@Override
	public String obtenerTipo() {
		return "Formato";
	}

	@Override
	public String obtenerMensaje() {
		return mensaje;
	}

	@Override
	public void agregar_mensaje(text_box obj) {
		obj.setTexto(this.obtenerMensaje());
	}

	@Override
	public void setMediador(iMediador poM) {
		this.mediador = poM;
	}


}
