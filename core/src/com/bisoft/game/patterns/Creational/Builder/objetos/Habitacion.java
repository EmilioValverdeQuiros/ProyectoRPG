package com.bisoft.game.patterns.Creational.Builder.objetos;

public class Habitacion implements IComponenteProducto {
    public String getEnemigo() {
        return " Jefe";
    }

    public void setEnemigo(String enemigo) {
        this.enemigo = enemigo;
    }

    public String getRompecabezas() {
        return "Interno";
    }

    public void setRompecabezas(String rompecabezas) {
        this.rompecabezas = rompecabezas;
    }

    public String getCofre() {
        return "Item oculto";
    }



    public void setCofre(String cofre) {
        this.cofre = cofre;
    }

    public int getAreasRec() {
        return 3;
    }

    public void setAreasRec(int areasRec) {
        this.areasRec = areasRec;
    }

    public int getCheckpoint() {
        return 1;
    }

    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getPuerta() {
        return "puerta";
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public boolean isEstadoJefe() {
        return false;
    }

    public void setEstadoJefe(boolean estadoJefe) {
        this.estadoJefe = estadoJefe;
    }

    private String enemigo;
    private String rompecabezas;
    private String cofre;
    private int areasRec;
    private int checkpoint;
    private String puerta;
    private boolean estadoJefe;


    public Habitacion(String pEnemigo,
                      String pRompecabezas,
                      String pCofre,
                      int pAreasRec,
                      int pCheckpoint,
                      String pPuerta,
                      boolean pEstadoJefe){

        this.areasRec = pAreasRec;
        this.checkpoint = pCheckpoint;
        this.estadoJefe = pEstadoJefe;
        this.cofre = pCofre;
        this.rompecabezas = pRompecabezas;
        this.puerta = pPuerta;
        this.enemigo = pEnemigo;


    }

    public Habitacion(){
        this.areasRec = 0;
        this.checkpoint = 0;
        this.estadoJefe = false;
        this.cofre = "cofre";
        this.rompecabezas = "rompecabezas";
        this.puerta = "puerta";
        this.enemigo = "Enemigo";
    }


    public void agregarComponente() throws Exception {

    }


    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        throw new Exception("La funcion eliminar componente no esta disponible");
    }


    public String mostrarInformacion()  {
        return "Habitacion con enemigo: " + this.getEnemigo() + ", contiene cofre con :" + this.getCofre() + ", con una cantidad de areas de recuperacion de: "+ this.getAreasRec() + ", un checkpoint de: " + this.getCheckpoint() ;
    }


    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {

    }


}
