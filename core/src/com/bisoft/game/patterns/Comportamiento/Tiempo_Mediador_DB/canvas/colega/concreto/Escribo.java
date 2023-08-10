package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.colega.concreto;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.colega.interfaz.Componente;

import java.io.*;

public class Escribo extends Componente {

	public Escribo() {
		this.setTipo("Cronometro");
	}
	@Override
	public void ejecutarAccion() throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream("timeRecords.txt", true));

		this.getMediador().guardar("Guardando record de " + this.getTipo());
//		this.getMediador().mostrarHistorial();
		System.out.println("Guardando records en base de datos..");
		System.setOut(out);

	}


}
