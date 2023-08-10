package com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto;

import com.bisoft.game.patterns.Comportamiento.patronEstado.abstracto.Estado;

public interface Character {

    //Metodos para utilizar en la fabrica

    int getLevel();

    void setLevel(int pDif);

    void setDefense(int defense);
    int getDefense();

    String getTipeCharacter();
    String info_Character();

    void setExperience(int experience);
    int getExperience();


    void setAttack(int attacK);
    int getAttack();


    void recibirDanio(int danio);

    void setEstado(Estado estado);

    void ejecutarAccion(Character character);
}





