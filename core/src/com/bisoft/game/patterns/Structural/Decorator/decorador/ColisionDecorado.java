package com.bisoft.game.patterns.Structural.Decorator.decorador;

import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;

public abstract class ColisionDecorado extends Colision {

    protected Colision colision;

    public ColisionDecorado(Colision colision){
        this.colision = colision;
    }

}
