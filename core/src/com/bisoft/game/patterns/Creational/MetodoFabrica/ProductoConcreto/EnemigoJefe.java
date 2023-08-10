package com.bisoft.game.patterns.Creational.MetodoFabrica.ProductoConcreto;

import com.bisoft.game.patterns.Creational.MetodoFabrica.Producto.Enemigo;

public class EnemigoJefe extends Enemigo {
    /******************************** SECCION: CONSTRUCTORES *********************************/
    public EnemigoJefe(String tipoEnemigo) {
        setDificultad("Nivel 3");
        setMecanica("superior a 10 ataques para derribar");
        setTipoEnemigo("Jefe");
    }

    /****************** SECCION: Implementación de las funciones abstractas *******************/

    public String getDescripcion() {
        return "Enemigo de tipo  " + this.getTipoEnemigo() + " con tecnica " + this.getMecanica() + " y una dificultad de " + this.getDificultad();
    }



}
