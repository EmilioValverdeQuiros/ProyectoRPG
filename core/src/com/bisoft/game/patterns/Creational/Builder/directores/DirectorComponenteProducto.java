package com.bisoft.game.patterns.Creational.Builder.directores;

import com.bisoft.game.patterns.Creational.Builder.constructores.*;
import com.bisoft.game.patterns.Creational.Builder.objetos.*;
import com.bisoft.game.patterns.Creational.Builder.objetos.IComponenteProducto;


import java.util.ArrayList;

public class DirectorComponenteProducto {
    private AComponenteProducto builder;

    private ArrayList<AComponenteProducto> builders = new ArrayList<AComponenteProducto>();


    public DirectorComponenteProducto(){
        builders.add(new BuilderArmas());
        builders.add(new BuilderPosiones());
        builders.add(new BuilderProductoFinal());
        builders.add(new BuilderCenfomonedas());
        builders.add(new BuilderLlave());
        builders.add(new BuilderHabitacion());


        builders.add(new BuilderContenedorVida());

        builders.add(new BuilderItems());




        for(int i=0; i < builders.size();i++){
            switchBuilder(i);
            this.getBuilder().inicializarArreglos();
        }
    }

    public AComponenteProducto getBuilder() {
        return builder;
    }

    private void setBuilder(AComponenteProducto builder) {
        this.builder = builder;
    }

    private void switchBuilder(int pIdx){
        this.setBuilder(builders.get(pIdx));
    }

    //Funciones para la construccion de objetos



    public IComponenteProducto construirArma(int pId, int pNivel, String pDescripcion) throws Exception {
        switchBuilder(0);
        this.getBuilder().construirComponente(pId, pNivel, pDescripcion);
        return this.getBuilder().getSet_Componente();
    }
    public IComponenteProducto construirPosiones(int pId, String pNombre, int pNivel, String pDescripcion) throws Exception {
        switchBuilder(1);
        this.getBuilder().construirComponente( pId,  pNombre,  pNivel,  pDescripcion);
        return this.getBuilder().getSet_Componente();
    }


    public IComponenteProducto construirCenfomonedas(int pValor) throws Exception {
        switchBuilder(2);
        this.getBuilder().construirComponente(pValor);
        return this.getBuilder().getSet_Componente();
    }

    public IComponenteProducto construirLlave(int pId, boolean pEspecial) throws Exception {
        switchBuilder(3);
        this.getBuilder().construirComponente(pId, pEspecial);
        return this.getBuilder().getSet_Componente();
    }

    public IComponenteProducto construirHabitacion(String pEnemigo, String pRompecabezas, String pCofre, int pAreasRec, int pCheckpoint,
                                                   String pPuerta, boolean pEstadoJefe) throws Exception {
        switchBuilder(4);
        this.getBuilder().construirComponente( pEnemigo,  pRompecabezas,  pCofre,  pAreasRec,  pCheckpoint,
                pPuerta,   pEstadoJefe);
        return this.getBuilder().getSet_Componente();
    }

    public IComponenteProducto construirContenedorVida(int pPieza) throws Exception {
        switchBuilder(5);
        this.getBuilder().construirComponente(pPieza);
        return this.getBuilder().getSet_Componente();
    }



    public IComponenteProducto construirItem(int pId, String pDescripcion, ArrayList<Cenfomonedas> pCenfomonedas, ArrayList<Posiones> pPosiones,
                                                     ArrayList<Armas> pArmas, ArrayList<Llave> pLlaves) throws Exception {
        switchBuilder(6);
        this.getBuilder().construirComponente( pId,  pDescripcion,  pCenfomonedas,  pPosiones, pArmas,  pLlaves);
        return this.getBuilder().getSet_Componente();
    }

    public ProductoFinal construirProductoFinal(int pId, int pPrecio, Items pItems, Habitacion pHabitacion, ContenedorVida pContenedor,
                                                int pArma, int pMoneda, int pPosion, int pLlave, /***/int pIdArma, int pNivelArma, String pDescripcionArma, /***/int pValor, /***/
                                                int pPieza, /***/String pEnemigo, String pRompecabezas, String pCofre, int pAreasRec, int pCheckpoint,
                                                String pPuerta, boolean pEstadoJefe, /***/int pIdItem, String pDescripcionItem, ArrayList<Cenfomonedas> pCenfomonedas, ArrayList<Posiones> pPosiones,
                                                ArrayList<Armas> pArmas, ArrayList<Llave> pLlaves, /***/int pIdLlave, boolean pEspecial,/***/int pIdPosion, String pNombre, int pNivelPosion, String pDescripcionPosion) throws Exception {

        IComponenteProducto arma = construirArma( pIdArma,  pNivelArma,  pDescripcionArma);
        IComponenteProducto cenfomoneda = construirCenfomonedas( pValor);
        IComponenteProducto contenedorVida = construirContenedorVida(pPieza);
        IComponenteProducto habitacion = construirHabitacion( pEnemigo,  pRompecabezas,  pCofre,  pAreasRec,  pCheckpoint,
                pPuerta,   pEstadoJefe);
        IComponenteProducto item = construirItem( pIdItem,  pDescripcionItem,  pCenfomonedas,  pPosiones,
                pArmas,  pLlaves);
        IComponenteProducto llave = construirLlave( pIdLlave,  pEspecial);
        IComponenteProducto posion = construirPosiones(pIdPosion,  pNombre,  pNivelPosion,  pDescripcionPosion);


        switchBuilder(7);
        this.getBuilder().construirComponente( pId,  pPrecio,  null,  null,  null,
                pArma,  pMoneda,  pPosion,  pLlave);
        IComponenteProducto producto = this.getBuilder().getSet_Componente();

        item.agregarComponente(llave);
        item.agregarComponente(arma);
        item.agregarComponente(cenfomoneda);
        item.agregarComponente(posion);

        producto.agregarComponente(llave);
        producto.agregarComponente(arma);
        producto.agregarComponente(cenfomoneda);
        producto.agregarComponente(posion);
        producto.agregarComponente(habitacion);
        producto.agregarComponente(contenedorVida);




        return (ProductoFinal) this.getBuilder().getSet_Componente();
    }











}
