package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCalabozos;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaTipoJuego;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

import java.io.IOException;
import java.util.ArrayList;

public class MenuDiferentesCalabozosScreen implements Screen {
    private Render render;
    private Inputs input;
    //private Pantalla screen;

    private Texture guerrero, mago, mercenario, fondoJardin, fondoJardinEdit, tenebroso, trampas;

    private Text titulo;

    private ArrayList<Text> options;
    private Images image;
    private FabricaCharacter gestorCharacter;

    private FabricaTipoJuego gestorTipoJuego;

    //private GestorPrototipo gestorPrototipo;

    private int actual = 0;

    public MenuDiferentesCalabozosScreen() {

        input = new Inputs();
        guerrero = new Texture("assets/makecharacter/Guerrero/Guerro.png");
        mercenario = new Texture("assets/makecharacter/Mercenario/Mercenario.png");
        mago = new Texture("assets/makecharacter/Mago/Mago.png");
        fondoJardin = new Texture("assets/rooms/FondoJardinSmall.jpeg");
        fondoJardinEdit = new Texture("assets/rooms/FondoJardinEditSmall.jpg");
        tenebroso = new Texture("assets/rooms/city/caminoSmall.jpeg");
        trampas = new Texture("assets/rooms/city/Piedras2Small.jpeg");
        image = new Images(Resources.CREATE_CHARACTER_BACKGROUND);
        titulo = new Text(Resources.GAME_FONT, 160, 450, 40, "Seleccione Calabozo");
        options = new ArrayList<>();
        gestorCharacter = new FabricaCharacter();
        //gestorPrototipo = new GestorPrototipo(0, 0, 0, 0);
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
//        render.Batch.draw(guerrero, 150, 250);
//        render.Batch.draw(mercenario, 350, 250);
//        render.Batch.draw(mago, 550, 250);
//        render.Batch.draw(fondoJardin, 150, 250);
//        render.Batch.draw(fondoJardinEdit, 350, 250);
        render.Batch.draw(tenebroso, 200, 250);
        render.Batch.draw(trampas, 400, 250);
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
        dispose();
    }

    @Override
    public void dispose() {
    }
    private void validateKeys() {
        try {
            if (this.input.isRight()) {
                this.actual++;
                if (this.actual > 2) {
                    this.actual = 0;
                }
                Thread.sleep(200);
                changeOptionColor(actual);
            }
            if (this.input.isLeft()) {
                this.actual--;
                if (this.actual < 0) {
                    this.actual = 2;
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


    private void generateMenu() {
        int mFontSize = 25;

//        this.options.add(new Text("Guerrero", mFontSize, Resources.GAME_FONT));
//        this.options.add(new Text("Mercenario", mFontSize, Resources.GAME_FONT));
//        this.options.add(new Text("Mago", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Calabozo arcade", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Calabozo alcantarilla", mFontSize, Resources.GAME_FONT));
        this.options.add(new Text("Salir", mFontSize, Resources.GAME_FONT));


        for (int i = 0; i < options.size(); i++) {

            if (i == 0) {
                this.options.get(i).setX(10);
            }
            if (i == 1) {
                this.options.get(1).setX(300);
            }
            if (i == 2) {
                this.options.get(2).setX(650);
            }
            this.options.get(i).setY(200);

        }


        changeOptionColor(0);
    }

    private void changeOptionColor(int pId) {
        for (Text mTemp : this.options) {
            mTemp.setColor(Color.WHITE);
            if (pId >= 0) {
                this.options.get(pId).setColor(Color.FIREBRICK);
                this.actual = pId;
            }
        }
    }

    private void executeAction() {
        try {
            switch (this.actual) {
                case 0:
                    gestorTipoJuego.processFunction(1);

                    this.dispose();
                    break;

                case 1:
                    gestorTipoJuego.processFunction(2);

                    this.dispose();
                    break;

                case 2:
                    gestorTipoJuego.processFunction(3);

                    this.dispose();
                    break;
                default:
                    String sMessage = "";
                    sMessage = "Invalid option";
            }
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Render.print(e.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
