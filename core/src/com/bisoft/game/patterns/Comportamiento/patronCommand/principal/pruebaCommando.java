package com.bisoft.game.patterns.Comportamiento.patronCommand.principal;

import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Concreto.AtacarAventurero;
import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Concreto.AtacarJefe;
import com.bisoft.game.patterns.Comportamiento.patronEstado.concreto.Berserk;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoConcreto.Guerrero;
import com.bisoft.game.patterns.Creational.MetodoFabrica.ProductoConcreto.EnemigoJefe;


import java.util.Scanner;

public class pruebaCommando {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero();
        EnemigoJefe enemigoJefe = new EnemigoJefe("Jefe");
        Invoker ivk = new Invoker();
        Berserk berserk = new Berserk();

        int opcion;

        do {
            opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    if (guerrero.getDefense() == 0){
                        System.out.println("El aventurero ha muerto");
                    } else if(guerrero.getDefense() == 3){
                        AtacarAventurero atacarAventurero = new AtacarAventurero(guerrero,1);
                        guerrero.setEstado(berserk);
                        guerrero.ejecutarAccion(guerrero);
                        ivk.recibirTarea(atacarAventurero);
                        ivk.realizarAtaque();
                        System.out.println("Ataque despues de entrar en modo Berserk: " + guerrero.getAttack());
                    } else {
                        AtacarAventurero atacarAventurero = new AtacarAventurero(guerrero,1);
                        ivk.recibirTarea(atacarAventurero);
                        ivk.realizarAtaque();
                    }

                    break;
                case 2:
                    AtacarJefe atacarJefe = new AtacarJefe(enemigoJefe,1);
                    ivk.recibirTarea(atacarJefe);
                    ivk.realizarAtaque();
                    break;
            }


        }while (opcion != 4);
    }

    private static int mostrarMenu(){
        System.out.println("Bienvenido a la batalla");
        System.out.println("1. Atacar al aventurero");
        System.out.println("2. Atacar al monstruo");
        System.out.println("4. Salir");

        return sc.nextInt();
    }
}
