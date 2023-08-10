package com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto;

import com.bisoft.game.patterns.Comportamiento.patronEstado.abstracto.Estado;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;


public abstract class Personaje implements Character {
    private Estado estado;
    @Override
    public abstract int getLevel();

    @Override
    public abstract void setLevel(int pDif);

    @Override
    public abstract void setDefense(int defense);

    @Override
    public abstract int getDefense();

    @Override
    public abstract String getTipeCharacter();

    @Override
    public abstract String info_Character();

    @Override
    public abstract void setExperience(int experience);

    @Override
    public abstract int getExperience();

    @Override
    public abstract void setAttack(int attacK);

    @Override
    public abstract int getAttack();

    @Override
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    @Override
    public void ejecutarAccion(Character character){
        estado.ejecutarAccion(character);
    }

    @Override
    public void recibirDanio(int danio){
        System.out.println("Vida antes del ataque: " + this.getDefense());
        int danioRecibido = this.getDefense() - danio;
        setDefense(danioRecibido);
        System.out.println("El aventurero ha recibido danio");
        System.out.println("Vida despues del ataque: " + this.getDefense());
        System.out.println("Tipe of Character is: " + this.getTipeCharacter() + ", This Level is : " + this.getLevel() + ", This experience is : "+this.getExperience()
                + ", This defense is : " + this.getDefense() + ", This attack is : " + this.getAttack() );
    }
}
