package com.bisoft.game.patterns.Creational.Builder.objetos;

public class Armas implements IComponenteProducto {
    private int id;

    public int getId() {
        return 246 ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return 2;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return "Esta arma contiene una potencia duplicada y un alcance de mayor nivel.";
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private int nivel;
    private String descripcion;

    public Armas(int pId, int pNivel, String pDescripcion){
        setDescripcion(pDescripcion);
        setId(pId);
        setNivel(pNivel);

    }



    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion agregar componente no esta disponible");

    }


    public String mostrarInformacion() {
        return "El arma contiene un identificador de numero: " + this.getId()+ ", De nivel: " + this.getNivel() + ", Descripcion: " + this.getDescripcion() ;

    }


    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion eliminar componente no esta disponible");
    }
}
