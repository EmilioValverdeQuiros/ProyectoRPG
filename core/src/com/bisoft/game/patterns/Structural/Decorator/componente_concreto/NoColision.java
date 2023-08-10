package com.bisoft.game.patterns.Structural.Decorator.componente_concreto;

import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;

public class NoColision extends Colision {

    @Override
    public boolean colisionDerecha() {
        return false;
    }

    @Override
    public boolean colisionIzquierda() {
        return false;
    }

    @Override
    public boolean colisionArriba() {
        return false;
    }

    @Override
    public boolean colisionAbajo() {
        return false;
    }
}
