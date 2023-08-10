package com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Concreto;

import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Abstracto.Comandos;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;



public class AtacarAventurero implements Comandos {
    private FabricaCharacter gestorCharacte = new FabricaCharacter();
    Character personaje = gestorCharacte.getCharacter();

    private int danio;

    public AtacarAventurero(Character personaje, int danio) {
        this.personaje = personaje;
        this.danio = danio;
    }

    @Override
    public void ejecutar() {
        this.personaje.recibirDanio(this.danio);
    }


}
