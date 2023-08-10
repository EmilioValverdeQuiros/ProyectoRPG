package com.bisoft.game.patterns.Creational.Builder.objetos;

public class ContenedorVida implements IComponenteProducto {
    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    private int piezas;

    public ContenedorVida(int pPiezas){
        setPiezas(pPiezas);
    }





    public void agregarComponente(IComponenteProducto pComponente) throws Exception {

    }


    public String mostrarInformacion() {
        return "Ha adquirido una nueva pieza de un contenedor de vida.";
    }


    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {

    }
}
