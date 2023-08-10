package com.bisoft.game.patterns.Creational.Builder.constructores;

import com.bisoft.game.patterns.Creational.Builder.objetos.*;


import java.util.ArrayList;

public class BuilderHabitacion  extends AComponenteProducto {

    public BuilderHabitacion(){
        this.setIndice(4);
    }

    @Override
    public void construirComponente(int pId, int pPrecio, Items pItems, Habitacion pHabitacion, ContenedorVida pContenedor, int pArma, int pMoneda, int pPosion, int pLlave) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con nueve parametros no esta disponible");
    }

    @Override
    public void construirComponente(int pId, String pDescripcion, ArrayList<Cenfomonedas> pCenfomonedas, ArrayList<Posiones> pPosiones, ArrayList<Armas> pArmas, ArrayList<Llave> pLlaves) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con seis parametros no esta disponible");
    }

    @Override
    public void construirComponente(int pId, boolean pEspecial) throws Exception {

        throw new Exception("La funcion [consstruirComponente] con dos parametros no esta disponible");
    }

    @Override
    public void construirComponente(int pId, String pNombre, int pNivel, String pDescripcion) throws Exception {

        throw new Exception("La funcion [consstruirComponente] con cuatro parametros no esta disponibled");

    }

    @Override
    public void construirComponente(int pId, int pNivel, String pDescripcion) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con tres parametros no esta disponible");

    }

    @Override
    public void construirComponente(int pPiezas) throws Exception {
        throw new Exception("La funcion [consstruirComponente] con un parametros no esta disponible");

    }

    @Override
    public void construirComponente(String pEnemigo, String pRompecabezas, String pCofre, int pAreasRec, int pCheckpoint,
                                    String pPuerta,  boolean pEstadoJefe) throws Exception {

        this.set_Componente(new Habitacion( pEnemigo,  pRompecabezas,  pCofre,  pAreasRec,  pCheckpoint,
                pPuerta,   pEstadoJefe));
    }


    public void set_Componente(IComponenteProducto pComponente) {
        this._Componente.set(getIndice(), pComponente);


    }

    @Override
    public IComponenteProducto getSet_Componente() {
        return this._Componente.get(getIndice());
    }
}