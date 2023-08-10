package com.bisoft.game.patterns.Creational.Builder.objetos;

import java.util.ArrayList;

public class Items implements IComponenteProducto {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return "Articulos disponibles para sus compras.";
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Cenfomonedas> get_Cenfomonedas() {
        return _Cenfomonedas;
    }

    public void set_Cenfomonedas(ArrayList<Cenfomonedas> _Cenfomonedas) {
        this._Cenfomonedas = _Cenfomonedas;
    }

    public ArrayList<Posiones> get_Posiones() {
        return _Posiones;
    }

    public void set_Posiones(ArrayList<Posiones> _Posiones) {
        this._Posiones = _Posiones;
    }

    public ArrayList<com.bisoft.game.patterns.Creational.Builder.objetos.Armas> get_Armas() {
        return _Armas;
    }

    public void set_Armas(ArrayList<com.bisoft.game.patterns.Creational.Builder.objetos.Armas> _Armas) {
        this._Armas = _Armas;
    }

    public ArrayList<Llave> get_Llaves() {
        return _Llaves;
    }

    public void set_Llaves(ArrayList<Llave> _Llaves) {
        this._Llaves = _Llaves;
    }

    private int id;
    private String descripcion;

    private ArrayList<Cenfomonedas> _Cenfomonedas;
    private ArrayList<Posiones> _Posiones;
    private ArrayList<com.bisoft.game.patterns.Creational.Builder.objetos.Armas> _Armas;
    private ArrayList<Llave> _Llaves;

    //CENFOMONEDAS

    public void agregarCenfomonedas(Cenfomonedas pMon){
        this.get_Cenfomonedas().add(pMon);

    }

    public void nuevaCenfomoneda(int pValor, String pMon){
        agregarCenfomonedas(new Cenfomonedas(pValor, pMon));

    }

    public Cenfomonedas obtenerCenfomonedas(int pValor){
        for(Cenfomonedas obj : this.get_Cenfomonedas()){
            if(obj.getValor() == pValor)
                return obj;
        }
        return null;
    }

    public String infoCenfomonedas(){
        String data= "";
        for(Cenfomonedas obj : this.get_Cenfomonedas())
            data += obj.mostrarInformacion() + "/n";

        return data;



    }

    //POSIONES

    public void agregarPosion(Posiones pPos){
        this.get_Posiones().add(pPos);

    }

    public void nuevaPosion(int pId, String pPos){
        agregarPosion(new Posiones(pId,"",0, pPos));

    }

    public Posiones obtenerPosion(int pId){
        for(Posiones obj : this.get_Posiones()){
            if(obj.getId() == pId)
                return obj;
        }
        return null;
    }

    public String infoPosiones(){
        String data= "";
        for(Posiones obj : this.get_Posiones())
            data += obj.mostrarInformacion() + "/n";

        return data;



    }

    public boolean existenPosiones(String pNombre){
        for (Posiones obj : this.get_Posiones())
        {
            if(obj.getDescripcion() == pNombre)
                return true;
        }
        return false;
    }

    //ARMAS

    public void agregarArma(com.bisoft.game.patterns.Creational.Builder.objetos.Armas pArma){
        this.get_Armas().add(pArma);

    }

    public void nuevaArma(int pId, String pArma){
        agregarArma(new com.bisoft.game.patterns.Creational.Builder.objetos.Armas(pId,0, pArma));

    }

    public com.bisoft.game.patterns.Creational.Builder.objetos.Armas obtenerArma(int pId){
        for(com.bisoft.game.patterns.Creational.Builder.objetos.Armas obj : this.get_Armas()){
            if(obj.getId() == pId)
                return obj;
        }
        return null;
    }

    public String infoArmas(){
        String data= "";
        for(com.bisoft.game.patterns.Creational.Builder.objetos.Armas obj : this.get_Armas())
            data += obj.mostrarInformacion() + "/n";

        return data;



    }

    public boolean existenArmas(String pNombre){
        for (com.bisoft.game.patterns.Creational.Builder.objetos.Armas obj : this.get_Armas())
        {
            if(obj.getDescripcion() == pNombre)
                return true;
        }
        return false;
    }


    //LLAVES

    public void agregarLlave(Llave pLlave){
        this.get_Llaves().add(pLlave);

    }

    public void nuevaLlave(int pId, boolean pLlave){
        agregarLlave(new Llave(pId, pLlave));

    }

    public Llave obtenerLlave(int pId){
        for(Llave obj : this.get_Llaves()){
            if(obj.getId() == pId)
                return obj;
        }
        return null;
    }

    public String infoLlaves() throws Exception {
        String data= "";
        for(Llave obj : this.get_Llaves())
            data += obj.mostrarInformacion() + "/n";

        return data;



    }





    public Items(int pId, String pDescripcion,
                 ArrayList<Cenfomonedas> pCenfomonedas,
                 ArrayList<Posiones> pPosiones,
                 ArrayList<com.bisoft.game.patterns.Creational.Builder.objetos.Armas> pArmas,
                 ArrayList<Llave> pLlaves){
        set_Armas(pArmas);
        setId(pId);
        set_Cenfomonedas(pCenfomonedas);
        set_Llaves(pLlaves);
        set_Posiones(pPosiones);
        setDescripcion(pDescripcion);



    }


    public Items(int pId, String pDescripcion){
        setDescripcion(pDescripcion);
        setId(pId);
        set_Armas(new ArrayList<com.bisoft.game.patterns.Creational.Builder.objetos.Armas>());
        set_Posiones(new ArrayList<Posiones>());
        set_Llaves(new ArrayList<Llave>());
        set_Cenfomonedas(new ArrayList<Cenfomonedas>());

    }



    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        this.agregarCenfomonedas((Cenfomonedas) pComponente);
        this.agregarPosion((Posiones) pComponente);
        this.agregarArma((Armas) pComponente);
        this.agregarLlave((Llave) pComponente);


    }
    @Override
    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {
        this.get_Cenfomonedas().remove(pComponente);
        this.get_Llaves().remove(pComponente);
        this.get_Armas().remove(pComponente);
        this.get_Posiones().remove(pComponente);
    }


    public String mostrarInformacion()  {


        return "Descripcion de los items: "+this.getDescripcion();
    }



}
