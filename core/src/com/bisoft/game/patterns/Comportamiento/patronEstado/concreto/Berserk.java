package com.bisoft.game.patterns.Comportamiento.patronEstado.concreto;

import com.bisoft.game.patterns.Comportamiento.patronEstado.abstracto.Estado;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;


public class Berserk implements Estado {

    @Override
    public void ejecutarAccion(Character character) {
        System.out.println("El aventurero ha entrado en modo Berserk");

        int subirAttack = character.getAttack() + 1;
        character.setAttack(subirAttack);
    }
}
