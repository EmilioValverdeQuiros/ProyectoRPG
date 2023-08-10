package com.bisoft.game.patterns.Creational.MetodoFabrica.CreadorConcreto;

import com.bisoft.game.patterns.Creational.MetodoFabrica.Creador.MetodoFabrica;
import com.bisoft.game.patterns.Creational.MetodoFabrica.Producto.Enemigo;
import com.bisoft.game.patterns.Creational.MetodoFabrica.ProductoConcreto.EnemigoJefe;
import com.bisoft.game.patterns.Creational.MetodoFabrica.ProductoConcreto.EnemigoNormal;
import com.bisoft.game.patterns.Creational.MetodoFabrica.ProductoConcreto.EnemigoSubjefe;

public class FabricaDeEnemigos implements MetodoFabrica {

    public Enemigo crearEnemigo(String tipoEnemigo) {
        if((tipoEnemigo.equalsIgnoreCase("Normal")))
            return new EnemigoNormal(tipoEnemigo);
        else
        if((tipoEnemigo.equalsIgnoreCase("Jefe")))
            return new EnemigoJefe(tipoEnemigo);
        else
            return new EnemigoSubjefe(tipoEnemigo);
    }

}
