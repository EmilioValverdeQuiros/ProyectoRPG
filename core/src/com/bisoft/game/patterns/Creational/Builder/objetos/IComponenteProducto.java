package com.bisoft.game.patterns.Creational.Builder.objetos;

public interface IComponenteProducto {

    public void agregarComponente(IComponenteProducto pComponente) throws Exception;
    public String mostrarInformacion();

    public void eliminarComponente(IComponenteProducto pComponente) throws Exception;
}
