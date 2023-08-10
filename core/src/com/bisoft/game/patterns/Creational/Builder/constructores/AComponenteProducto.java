package com.bisoft.game.patterns.Creational.Builder.constructores;

import com.bisoft.game.patterns.Creational.Builder.objetos.*;


import java.util.ArrayList;

public abstract class AComponenteProducto {

    protected ArrayList<IComponenteProducto>  _Componente;
    private int indice;

    public int getIndice() {
        return indice;
    }

    protected void setIndice(int pIndice) {
        this.indice = pIndice;
    }




    public void inicializarArreglos(){
        _Componente = new ArrayList<IComponenteProducto>();
        _Componente.add(null); //Arma
        _Componente.add(null); //Posion
        _Componente.add(null); //Moneda
        _Componente.add(null); //Llave
        _Componente.add(null); //Habitacion
        _Componente.add(null); //Contenedor
        _Componente.add(null); //Item


    }

    public abstract void construirComponente(int pId, int pNivel, String pDescripcion) throws Exception;  //Armas

    public abstract void construirComponente(int pId, String pNombre, int pNivel, String pDescripcion) throws Exception;  //Posiones

    public abstract void construirComponente(int pPiezas) throws Exception;  //Contenedor de Vida - Cenfomonedas (valor int)

    public abstract void construirComponente(int pId, boolean pEspecial) throws Exception;  //Llave

    public abstract void construirComponente(String pEnemigo, String pRompecabezas, String pCofre, int pAreasRec, int pCheckpoint,
                                             String pPuerta,  boolean pEstadoJefe) throws Exception;  //Habitacion
    public abstract void construirComponente(int pId, int pPrecio, Items pItems, Habitacion pHabitacion, ContenedorVida pContenedor,
                                             int pArma, int pMoneda, int pPosion, int pLlave) throws Exception; //Producto
    public abstract void construirComponente(int pId, String pDescripcion, ArrayList<Cenfomonedas> pCenfomonedas, ArrayList<Posiones> pPosiones,
                                             ArrayList<Armas> pArmas, ArrayList<Llave> pLlaves) throws Exception; // Items

    public abstract void set_Componente(IComponenteProducto pComponente);
    public abstract IComponenteProducto getSet_Componente();






}
