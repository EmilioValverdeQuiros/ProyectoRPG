package com.bisoft.game.patterns.Structural.Decorator.gestor;

import com.bisoft.game.patterns.Structural.Adapter.objetos.MyRectangle;
import com.bisoft.game.patterns.Structural.Decorator.componente.Colision;
import com.bisoft.game.patterns.Structural.Decorator.componente_concreto.NoColision;
import com.bisoft.game.patterns.Structural.Decorator.decorador_concreto.ColisionAbajo;
import com.bisoft.game.patterns.Structural.Decorator.decorador_concreto.ColisionArriba;
import com.bisoft.game.patterns.Structural.Decorator.decorador_concreto.ColisionDerecha;
import com.bisoft.game.patterns.Structural.Decorator.decorador_concreto.ColisionIzquierda;

public class GestorDecorador {

    public Colision getColision(MyRectangle rectanguloDinamico, MyRectangle rectanguloEstatico) {

        float paredX1 = rectanguloEstatico.getX1();
        float paredX2 = rectanguloEstatico.getX2();
        float paredY1 = rectanguloEstatico.getY1();
        float paredY2 = rectanguloEstatico.getY2();

        float playerX1 = rectanguloDinamico.getX1();
        float playerX2 = rectanguloDinamico.getX2();
        float playerY1 = rectanguloDinamico.getY1();
        float playerY2 = rectanguloDinamico.getY2();

        Colision colision = new NoColision();
        if (playerY2 >= paredY1 && playerY1 < paredY1 &&
            (
                (playerX1 - paredX1 > 2 && playerX1 - paredX2 < 2) ||
                (playerX2 - paredX1 > 2 && playerX2 - paredX2 < 2)
            )
        )
        {
            return new ColisionArriba(colision);
        }

        if (playerY1 <= paredY2 && playerY2 > paredY2 &&
            (
                (playerX1 - paredX1 > 2 && playerX1 - paredX2 < 2) ||
                (playerX2 - paredX1 > 2 && playerX2 - paredX2 < 2)
            )
        ){
            return new ColisionAbajo(colision);
        }

        if (playerX2 >= paredX1 && playerX1 < paredX1 &&
            (
                (
                    (playerY1 - paredY1 > 2 && playerY1 - paredY2 < 2) ||
                    (playerY2 - paredY1 > 2 && playerY2 - paredY2 < 2)
                )
            )
        ){
            return new ColisionDerecha(colision);
        }

        if (playerX1 <= paredX2 && playerX2 > paredX1 &&
            (
                (
                    (playerY1 - paredY1 > 2 && playerY1 - paredY2 < 2) ||
                    (playerY2 - paredY1 > 2 && playerY2 - paredY2 < 2)
                )
            )
        ){
            return new ColisionIzquierda(colision);
        }

        return colision;
    }
}
