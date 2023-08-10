package com.bisoft.game.patterns.Creational.MetodoFabrica.Creador;

import com.bisoft.game.patterns.Creational.MetodoFabrica.Producto.Enemigo;

public interface MetodoFabrica {
    public Enemigo crearEnemigo (String tipoEnemigo);
}
