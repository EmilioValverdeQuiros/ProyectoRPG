package com.bisoft.game.patterns.Structural.Decorator.decorador_concreto;

import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;
import com.bisoft.game.patterns.Structural.Decorator.decorador.ColisionDecorado;

public class ColisionAbajo extends ColisionDecorado {

    public ColisionAbajo(Colision colision) {
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
        return colision.colisionArriba();
    }

    @Override
    public boolean colisionAbajo() {
        return true;
    }
}
