package com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor;

import com.bisoft.game.menucharacter.CreateCharacterScreen;

import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.principal.main_mediadior;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaAbstractaCharacter.GameCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.FabricaConcreta.FabricaMago;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.screen.*;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;
import com.bisoft.game.patterns.Comportamiento.Tiempo_Mediador_DB.principal.main_mediadior;
import com.bisoft.game.patterns.Structural.Proxy.*;
import java.io.IOException;


public class FabricaTipoJuego {

    //arreglo de personajes

    private static Character arCharacter;
    private static LoreScreen loreScreen = new LoreScreen();
    private static FabricaCharacter gestorCharacter;
    private static String[] args;
    public static main_mediadior mediadiorRecords = new main_mediadior();

    // constructor
    public FabricaTipoJuego() {

    }


    //crear personajes

    public static String CreateFabricaCharacter(GameCharacter pFabrica) {
        Character objCharacter = pFabrica.createCharacter();
        arCharacter = objCharacter;

        return objCharacter.info_Character();
    }


    public static String get_information_Character() {
        String msDatos = "";

        msDatos = msDatos + arCharacter.info_Character() + "\n";

        return msDatos;
    }

    public Character getCharacter() {
        return arCharacter;
    }

    public void setCharacter(Character arCharacter) {
        FabricaTipoJuego.arCharacter = arCharacter;
    }

    //Opciones para los 3 tipos de personajes

    public static String processFunction(int pOpc) throws IOException {
        String sMessage = "";
        Stopwatch stopwatch  = new Stopwatch();
        main_mediadior mediadiorRecords = new main_mediadior();

        switch (pOpc) {
            case 1:

                System.out.println("Estoy por elegir calabozo");
//                Resources.MAIN.setScreen(new PlayerScreen());
//                gestorCharacter = new FabricaCharacter();
//                gestorCharacter.getCharacter().info_Character();
//                System.out.println(gestorCharacter.getCharacter().info_Character());
                main_mediadior.main(args);
                stopwatch.main(args);
                Resources.MAIN.setScreen(new RoomArcade());
                break;
            case 2:
                System.out.println("Estoy por elegir calabozo");
                main_mediadior.main(args);
                stopwatch.main(args);
                Resources.MAIN.setScreen(new RoomAlcantarilla());
                break;
            case 3:
                System.out.println("Atras");
//                GameCharacter tiChara2 = new FabricaMago();
//                sMessage = CreateFabricaCharacter(tiChara2);
//                Render.close();
                Resources.MAIN.setScreen(new CreateCharacterScreen());
                break;
            case 4:
                Resources.MAIN.setScreen(new CreateCharacterScreen());
//                Resources.MAIN.setScreen(new TimerScreen());
//                sMessage = get_information_Character();
                break;
            case 5:
                sMessage = "Thank you for using the software";
                break;
            default:
                sMessage = "Invalid option";
        }

        return sMessage;
    }



}
