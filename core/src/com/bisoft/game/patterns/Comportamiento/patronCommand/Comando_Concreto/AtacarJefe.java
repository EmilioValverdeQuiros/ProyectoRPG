package com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Concreto;

import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Abstracto.Comandos;
import com.bisoft.game.patterns.Creational.MetodoFabrica.Producto.Enemigo;


public class AtacarJefe implements Comandos {

    private Enemigo enemigo;

    private int danio;

    public AtacarJefe(Enemigo enemigo, int danio) {
        this.enemigo = enemigo;
        this.danio = danio;
    }

    @Override
    public void ejecutar() {
        this.enemigo.recibirDanio(this.danio);
    }
}
