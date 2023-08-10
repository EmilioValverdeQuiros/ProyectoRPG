package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.principal;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.objetos.Canvas;
import com.bisoft.game.patterns.Structural.Proxy.*;

import com.bisoft.game.characters.Player;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.colega.concreto.Escribo;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.colega.interfaz.Componente;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.mediador.concreto.MediadorCanvas;


import java.io.IOException;

public class gestor_mediadores {

	public String[] args;
	public void print(String pTxt) {
		System.out.println(pTxt);
	}

	public void record_Tiempo() throws IOException {
		// Creamos nuestro Mediador
		MediadorCanvas oMed1 = new MediadorCanvas();
		
		//Creamos los objetos canvas que seran nuestros lienzos
		Canvas olienzo1 = new Canvas();
		
		// Creamos los colegas
		Componente tiempo = new Escribo();

		
		// Le asignamos a cada colega un mediador
		tiempo.setMediador(oMed1);
		
		//Agreguemos el lienzo donde vamos a trabajar
		oMed1.setLienzo(olienzo1);


		//Ejecutemos acciones
		tiempo.ejecutarAccion();
		
		print("Reporte del historial/records Jugador HEROE");
		Stopwatch stopwatch = new Stopwatch();
		stopwatch.main(args);
		print(oMed1.mostrarHistorial());


	}

}
