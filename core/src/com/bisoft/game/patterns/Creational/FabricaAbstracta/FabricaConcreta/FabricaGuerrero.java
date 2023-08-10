package com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta;

import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto.Guerrero;

public class FabricaGuerrero implements GameCharacter {

    public FabricaGuerrero() {
    }


    @Override
    public Character createCharacter() {
        Guerrero myCharacter=new Guerrero();
        myCharacter.info_Character();
        return myCharacter;
    }
}

