package com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto;

public class Mago extends Personaje{

    private static int level;
    private static int defense = 7;
    private static int attack = 2;
    private static final String tipeCharacter = "Mago";
    private static int experience;

    public Mago() {
    }

    public void setLevel(int dif) {
        this.level = dif;
        this.setAttack(55 * dif);
        this.setDefense(60 * dif);
    }

    public void setExperience(int experience) {
        this.experience += experience;
        int dif = this.experience / 100;
        if (dif > getLevel()) {
            setLevel(dif);
        }
    }


    ///GET

    public int getLevel() {return level;}

    public int getDefense() {return defense;}

    public int getAttack() {return attack;}
    public int getExperience() {
        return experience;
    }



    public void setDefense(int defense) {Mago.defense = defense;}

    public void setAttack(int attack) {Mago.attack = attack;}

    public String getTipeCharacter() {
        return "Mago";
    }

    //Obtener los datos del personaje
    public String info_Character() {
        return "Tipe of Character is: " + this.getTipeCharacter() + ", This Level is : " + this.getLevel() + ", This experience is : "+this.getExperience()
                + ", This defense is : " + this.getDefense() + ", This attack is : " + this.getAttack() ;

    }





}
