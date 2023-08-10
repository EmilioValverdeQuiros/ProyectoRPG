package com.bisoft.game.patterns.Creational.MetodoFabrica.ProductoConcreto;

import com.bisoft.game.patterns.Creational.MetodoFabrica.Producto.Enemigo;

public class EnemigoSubjefe extends Enemigo {
    public EnemigoSubjefe(String tipoEnemigo) {
        setDificultad("Nivel 2");
        setMecanica("Necesario 6 ataques para derribar");
        setTipoEnemigo("Subjefe");
    }

    /****************** SECCION: Implementación de las funciones abstractas *******************/

    public String getDescripcion() {
        return "Enemigo de tipo  " + this.getTipoEnemigo() + "con tecnica " + this.getMecanica() + "de dificultad " + this.getDificultad();
    }

}
