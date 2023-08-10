package com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta;

import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto.Guerrero;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto.Mercenario;

public class FabricaMercenario implements GameCharacter {


    public FabricaMercenario() {
    }


    @Override
    public Character createCharacter() {
        Mercenario myCharacter=new Mercenario();
        myCharacter.info_Character();
        return myCharacter;
    }
}
