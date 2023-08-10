package com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta;

import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto.Guerrero;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto.Mago;

public class FabricaMago implements GameCharacter {

    public FabricaMago() {
    }


    @Override
    public Character createCharacter() {
         Mago myCharacter=new Mago();
        myCharacter.info_Character();
        return myCharacter;
    }
}
