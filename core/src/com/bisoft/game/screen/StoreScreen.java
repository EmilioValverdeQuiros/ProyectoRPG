package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.menucharacter.CreateCharacterScreen;
import com.bisoft.game.patterns.Creational.Builder.main.GestorBuilder;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

import com.bisoft.game.patterns.Creational.MetodoFabrica.Gestor.Gestor;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

import java.util.ArrayList;

public class StoreScreen implements Screen {

    private Images back;
    private Render render;
    private Inputs input;

    private Texture pocion, arma, cenfomoneda, llave, item, habitacion, contenedorVida;

    private Text gameName;

    private GestorBuilder gestorBuilder;

    private static Text countDownLabel;

    private Images image;

    private Text titulo;
    private ArrayList<Text> options;

    private float alpha, sum;
    private int actual = 0;
    ShapeRenderer border;

    private static float timeCount;
    private static float worldTimer;


    public StoreScreen() {
        input = new Inputs();





        //habitacion = new Texture("assets/makecharacter/Habitacion/habitacion.png");
       //contenedorVida = new Texture("assets/makecharacter/ContenedorVida/contenedorVida.png");
        image = new Images(Resources.CREATE_CHARACTER_BACKGROUND);
        titulo = new Text(Resources.GAME_FONT, 60, 450, 40, "Seleccione el articulo que desea");
        countDownLabel = new Text(Resources.GAME_FONT, 160, 450, 40, "Seleccione el articulo que desea");
        options = new ArrayList<>();
        gestorBuilder = new GestorBuilder();



    }

    @Override
    public void show() {
        generateMenu();
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render(float delta) {
        render.clearScreen();
        render.Batch.begin();
        image.draw();
        titulo.draw();
        for (Text mText : this.options) {

            mText.draw();
        }


        render.Batch.end();
        validateKeys();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private void generateMenu() {
        int mFontSize = 25;
        float mNextY = 0;
        int mRest = 40;


        this.options.add(new Text("Arma  ", mFontSize, Resources.GAME_FONT));


        this.options.add(new Text("Pocion  ", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Cenfomoneda", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Llave", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Habitacion", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("ContenedorVida", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Atras", mFontSize, Resources.GAME_FONT));






        this.options.get(0).centerTextScreen();
        mNextY = this.options.get(0).getY();
        for (Text mTemp : this.options) {
            mTemp.centerTextScreen();
            mNextY -= mRest;
            mTemp.setY(mNextY);
        }


        for (int i = 0; i < options.size(); i++) {

            if (i == 0) {
                this.options.get(i).setY(100);
            }
            if (i == 1) {
                this.options.get(i).setY(150);
            }
            if (i == 2) {
                this.options.get(i).setY(200);
            }
            if (i == 3) {
                this.options.get(i).setY(250);
            }
            if (i == 4) {
                this.options.get(i).setY(300);

            }
            if (i == 5) {
                this.options.get(i).setY(350);

            }
            if (i == 6) {
                this.options.get(i).setY(400);

            }

            this.options.get(i).setX(100);

        }


        changeOptionColor(0);


    }

    private void changeOptionColor(int pId) {
        for (Text mTemp : this.options) {
            mTemp.setColor(Color.WHITE);
            if (pId >= 0) {
                this.options.get(pId).setColor(Color.GREEN);
                this.actual = pId;
            }
        }
    }


    private void validateKeys() {
        try {
            if (this.input.isUp()) {
                this.actual++;
                if (this.actual > 6) {
                    this.actual = 0;
                }
                Thread.sleep(200);
                changeOptionColor(actual);
            }
            if (this.input.isDown()) {
                this.actual--;
                if (this.actual < 0) {
                    this.actual = 6;
                }
                Thread.sleep(200);
                changeOptionColor(actual);
            }
            if (this.input.isEnter()) {
                executeAction();
            }
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }

    }


    private void executeAction() {
        try {
            switch (this.actual) {
                case 0:
                    gestorBuilder.procesarFuncion(1);

                    this.dispose();
                    break;

                case 1:
                    gestorBuilder.procesarFuncion(2);

                    this.dispose();
                    break;

                case 2:
                    gestorBuilder.procesarFuncion(3);

                    this.dispose();
                    break;

                case 3:
                    gestorBuilder.procesarFuncion(4);

                    this.dispose();
                    break;
                case 4:
                    gestorBuilder.procesarFuncion(5);

                    this.dispose();
                    break;

                case 5:
                    gestorBuilder.procesarFuncion(6);

                    this.dispose();
                    break;
                case 6:
                    gestorBuilder.procesarFuncion(7);

                    this.dispose();
                    break;

                default:
                    String sMessage = "";
                    sMessage = "Invalid option";
            }
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Render.print(e.toString());
        }

    }

    public static void update(float dt){
        timeCount += dt;
        if (timeCount >= 1 ) {
            worldTimer--;
            countDownLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }
}
