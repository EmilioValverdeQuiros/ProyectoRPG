package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.mediador.concreto;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.concreto.formatoHistorial;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.colega.interfaz.iColega;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.mediador.interfaces.iMediador;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.cuadro_de_texto.objetos.text_box;

import java.util.ArrayList;


public class mediador implements iMediador {
	private  ArrayList<iColega> list_colegas_mediados;
	
	public mediador() {
		list_colegas_mediados = new ArrayList<iColega>();
	}

	@Override
	public void ejecutar_accion(String pId, text_box pObj) {
		pObj.setTexto(get_sepecific_colega(pId).obtenerMensaje());
	}
	
	public void ejecutar_accion(String pId, text_box pObj, String pFormato, String mensaje) {
		iColega temp = get_sepecific_colega(pId);
		((formatoHistorial) temp).setMensaje(mensaje,pFormato);
		pObj.setTexto(temp.obtenerMensaje());
	}
	
	private iColega get_sepecific_colega(String pType) {
		iColega temp = null;
		
		for( iColega colega : list_colegas_mediados )
            if( colega.obtenerTipo() == pType ) {
            	temp = colega;
                break;
            }
        
		return temp;
	}
}
