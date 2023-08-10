package com.bisoft.game.patterns.Creational.Builder.objetos;

public class ProductoFinal implements IComponenteProducto {

    private int id;
    private int precio;

    private Items items;
    private Habitacion habitacion;
    private ContenedorVida contenedor;
    private int arma;
    private int cmoneda;
    private int posion;
    private int llave;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public ContenedorVida getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorVida contenedor) {
        this.contenedor = contenedor;
    }

    public int getArma() {
        return arma;
    }

    public void setArma(int arma) {
        this.arma = arma;
    }

    public int getCmoneda() {
        return cmoneda;
    }

    public void setCmoneda(int cmoneda) {
        this.cmoneda = cmoneda;
    }

    public int getPosion() {
        return posion;
    }

    public void setPosion(int posion) {
        this.posion = posion;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }



    public ProductoFinal(int pId, int pPrecio, Items pItems, Habitacion pHabitacion, ContenedorVida pContenedor,
                         int pArma, int pMoneda, int pPosion, int pLlave){
        this.setId(pId);
        this.setPrecio(pPrecio);
        this.setItems(pItems);
        this.setHabitacion(pHabitacion);
        this.setContenedor(pContenedor);
        this.setArma(pArma);
        this.setLlave(pLlave);
        this.setCmoneda(pMoneda);
        this.setPosion(pPosion);


    }


    @Override
    public void agregarComponente(IComponenteProducto pComponente) throws Exception {
        if(pComponente.getClass() == Items.class)
            this.setItems((Items) pComponente);

        if(pComponente.getClass() == Habitacion.class)
            this.setHabitacion((Habitacion) pComponente);

        if(pComponente.getClass() == ContenedorVida.class)
            this.setContenedor((ContenedorVida) pComponente);


    }

    @Override
    public String mostrarInformacion()  {
        return null;
    }

    @Override
    public void eliminarComponente(IComponenteProducto pComponente) throws Exception {

        if(pComponente.getClass() == Items.class)
            this.setItems(null);

        if(pComponente.getClass() == Habitacion.class)
            this.setHabitacion(null);

        if(pComponente.getClass() == ContenedorVida.class)
            this.setContenedor(null);

    }
}
