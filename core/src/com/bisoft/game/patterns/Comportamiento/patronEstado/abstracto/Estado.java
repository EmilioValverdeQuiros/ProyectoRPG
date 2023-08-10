package com.bisoft.game.patterns.Comportamiento.patronEstado.abstracto;

import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

public interface Estado {
    void ejecutarAccion(Character character);

}
