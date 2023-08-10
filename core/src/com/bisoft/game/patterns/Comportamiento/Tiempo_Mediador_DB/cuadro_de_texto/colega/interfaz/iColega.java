package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.interfaz;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.mediador.interfaces.iMediador;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.objetos.text_box;

public interface iColega {
	public String obtenerTipo();
	public String obtenerMensaje();
	public void agregar_mensaje(text_box obj);
	public void setMediador(iMediador pOM);
}
