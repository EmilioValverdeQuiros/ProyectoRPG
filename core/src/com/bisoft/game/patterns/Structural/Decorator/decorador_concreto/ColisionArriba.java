package com.bisoft.game.patterns.Structural.Decorator.decorador_concreto;

import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;
import com.bisoft.game.patterns.Structural.Decorator.decorador.ColisionDecorado;

public class ColisionArriba extends ColisionDecorado {

    public ColisionArriba(Colision colision) {
        super(colision);
    }
    @Override
    public boolean colisionDerecha() {
        return colision.colisionDerecha();
    }

    @Override
    public boolean colisionIzquierda() {
        return colision.colisionIzquierda();
    }

    @Override
    public boolean colisionArriba() {
        return true;
    }

    @Override
    public boolean colisionAbajo() {
        return colision.colisionAbajo();
    }
}
