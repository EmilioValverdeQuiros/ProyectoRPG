package com.bisoft.game.patterns.Comportamiento.patronCommand.principal;

import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Abstracto.Comandos;


import java.util.ArrayList;

public class Invoker {
    private ArrayList<Comandos> ataques = new ArrayList<>();

    public void recibirTarea(Comandos comandos){
        this.ataques.add(comandos);
    }

    public void realizarAtaque(){
        for (Comandos comandos: ataques) {
            comandos.ejecutar();
        }
        this.ataques.clear();
    }
}
