package com.bisoft.game.patterns.Structural.Decorator.decorador_concreto;

import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;
import com.bisoft.game.patterns.Structural.Decorator.decorador.ColisionDecorado;

public class ColisionDerecha extends ColisionDecorado {

    public ColisionDerecha(Colision colision) {
        super(colision);
    }
    @Override
    public boolean colisionDerecha() {
        return true;
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
        return colision.colisionAbajo();
    }
}
