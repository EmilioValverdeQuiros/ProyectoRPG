package com.bisoft.game.patterns.Creational.Builder.main;

import com.bisoft.game.menucharacter.CreateCharacterScreen;
import com.bisoft.game.patterns.Creational.Builder.constructores.AComponenteProducto;
import com.bisoft.game.patterns.Creational.Builder.directores.DirectorComponenteProducto;
import com.bisoft.game.patterns.Creational.Builder.objetos.IComponenteProducto;
import com.bisoft.game.utils.Resources;

public class GestorBuilder {


    public static String procesarFuncion(int pOpc) {

        DirectorComponenteProducto dr = new DirectorComponenteProducto();
        String sMensaje ="";
        AComponenteProducto AComp;
        int pOpcDos = 0;

        switch (pOpc) {

            case 1:
                System.out.println("Prueba1");
                try {
                    IComponenteProducto p = dr.construirArma(6, 8, "Arma");
                    imprimir(p.mostrarInformacion());
                } catch (Exception e) {
                    imprimir("Error: " + e.getMessage());
                }
                break;

            case 2:
                System.out.println("Prueba2");
                try {
                    IComponenteProducto p = dr.construirPosiones(6, "jos", 6, "u");
                    imprimir(p.mostrarInformacion());
                } catch (Exception e) {
                    imprimir("Error: " + e.getMessage());
                }
                break;

            case 3:
                System.out.println("Prueba3");
                try {
                    IComponenteProducto p = dr.construirCenfomonedas(4);
                    imprimir(p.mostrarInformacion());
                } catch (Exception e) {
                    imprimir("Error: " + e.getMessage());
                }
                break;

            case 4:
                System.out.println("Prueba4");
                try {
                    IComponenteProducto p = dr.construirLlave(4, true);
                    imprimir(p.mostrarInformacion());
                } catch (Exception e) {
                    imprimir("Error: " + e.getMessage());
                }
                break;

            case 5:
                System.out.println("Prueba5");
                try{
                    IComponenteProducto p  = dr.construirHabitacion("j","i","l",4,1,"j", false);
                    imprimir(p.mostrarInformacion());
                } catch (Exception e){
                    imprimir("Error: " + e.getMessage());
                }


                break;
            case 6:
                System.out.println("Prueba6");
                try {

                    IComponenteProducto p = dr.construirContenedorVida(1);
                    imprimir(p.mostrarInformacion());
                } catch (Exception e) {
                    imprimir("Error: " + e.getMessage());
                }
                break;

            case 7:
                System.out.println("Prueba7");
                Resources.MAIN.setScreen(new CreateCharacterScreen());


                break;



            default:
                sMensaje = "Opcion invalida";
                break;
        }

        return sMensaje ;

    }



    private static void imprimir(String mensaje){
        System.out.println(mensaje);
    }



}
