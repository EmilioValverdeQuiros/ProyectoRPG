package com.bisoft.game.patterns.Creational.MetodoFabrica.Producto;

public abstract class Enemigo {
    private String dificultad;
    private String mecanica;
    private String tipoEnemigo;


    public Enemigo(String dificultad, String mecanica, String tipoEnemigo) {
        setDificultad(dificultad);
        setMecanica(mecanica);
        setTipoEnemigo(tipoEnemigo);
    }

    public Enemigo(){
        setDificultad("");
        setMecanica("");
        setTipoEnemigo("Enemigo");
    }


    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getMecanica() {
        return mecanica;
    }

    public void setMecanica(String mecanica) {
        this.mecanica = mecanica;
    }

    public String getTipoEnemigo() {
        return tipoEnemigo;
    }

    public void setTipoEnemigo(String tipoEnemigo) {
        this.tipoEnemigo = tipoEnemigo;
    }


    public abstract String getDescripcion();

    public void recibirDanio(int danio){
        System.out.println("El enemigo ha recibido danio\n");
    }
}
