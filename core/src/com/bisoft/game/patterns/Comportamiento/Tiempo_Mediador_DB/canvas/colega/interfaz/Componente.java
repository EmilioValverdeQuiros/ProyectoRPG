package com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.colega.interfaz;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.canvas.mediador.concreto.MediadorCanvas;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Componente {
	protected MediadorCanvas m;
	private String tipo;
    
	
    public MediadorCanvas getMediador(){
        return this.m;
    }
    
	protected String getTipo() {
		 return this.tipo;
	}

    public void setMediador( MediadorCanvas m ){
        this.m = m;
    }
    
    protected void setTipo( String m ){
        this.tipo = m;
    }
    
    //------------------------------------
    
    public abstract void ejecutarAccion() throws IOException;
}
