package com.bisoft.game.patterns.Creational.Builder.objetos;

public class Cenfomonedas implements IComponenteProducto {


    public int getValor() {
        return 1;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    private int valor;

    public Cenfomonedas(int pValor){
        setValor(pValor);
    }

    public Cenfomonedas(int pValor, String pMon) {
        setValor(pValor);

    }


    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion agregar componente no esta disponible");

    }


    public String mostrarInformacion()  {
        return "Valor de moneda: " + this.getValor();

    }

    @Override
    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion eliminar componente no esta disponible");
    }


}
