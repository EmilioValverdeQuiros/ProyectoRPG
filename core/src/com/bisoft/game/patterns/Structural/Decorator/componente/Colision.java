package com.bisoft.game.patterns.Structural.Decorator.componente;

public abstract class Colision {

    public abstract boolean colisionDerecha() ;
    public abstract boolean colisionIzquierda() ;
    public abstract boolean colisionArriba() ;
    public abstract boolean colisionAbajo() ;

    final public boolean colision(){
        return colisionDerecha() || colisionIzquierda() || colisionArriba() || colisionAbajo();
    }

    @Override
    public String toString() {
        return colisionDerecha() ? "Derecha" : colisionIzquierda() ? "Izquierda" : colisionArriba() ? "Arriba" : colisionAbajo() ? "Abajo" : "Sin Colision";
    }
}
