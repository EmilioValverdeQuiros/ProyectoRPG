package com.bisoft.game.patterns.Creational.Builder.objetos;

public class Posiones implements IComponenteProducto {
    public int getId() {
        return 185;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return "Magnatus";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return 1;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return "Concede al que la bebe poder tener una fuerza física sobrenatural";
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private int id;
    private String nombre;
    private int nivel;
    private String descripcion;

    public Posiones(int pId, String pNombre, int pNivel, String pDescripcion){
        setDescripcion(pDescripcion);
        setId(pId);
        setNivel(pNivel);
        setNombre(pNombre);


    }

    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion agregar componente no esta disponible");

    }


    public String mostrarInformacion()  {
        return "Posion: " + this.getId()+ " ,de nivel :" + this.getNivel() + " ,nombre: "+ this.getNombre() + " ,se describe como: " + this.getDescripcion() ;

    }

    @Override
    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion eliminar componente no esta disponible");
    }
}
