package com.bisoft.game.patterns.Creational.Builder.objetos;

public class Llave implements IComponenteProducto {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEspecial() {
        return false;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    private int id;
    private boolean especial;

    public Llave(int pId, boolean pEspecial){
        setEspecial(pEspecial);
        setId(pId);


    }


    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion agregar componente no esta disponible");

    }


    public String mostrarInformacion()  {
        return "Llave adquirida con exito" + ", Especialidad :" + especial;

    }

    @Override
    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion eliminar componente no esta disponible");
    }
}
