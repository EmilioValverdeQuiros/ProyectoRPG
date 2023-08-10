package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.menucharacter.CreateCharacterScreen;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;
import com.sun.org.apache.xml.internal.utils.res.XResources_zh_CN;

import java.util.ArrayList;

public class Room1Screen implements Screen {

    private Images back;
    private Inputs input;

    private Text gameName;

    private int actual = 0;

    ShapeRenderer border;

    public Room1Screen() {
        this.back = new Images(Resources.HABITACION_JARDIN);
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 200, 510, 80, "GE FORCE");
        resize(1000,1000);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);
    }

    @Override
    public void render(float delta) {
        Render.Batch.begin();
        this.back.draw();
        this.gameName.draw();
        Render.Batch.end();
        /*validateMouse();*/
      //showLoreScreen();
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



    private void executeAction() {
        switch (this.actual) {
            case 0:
               Resources.MAIN.setScreen(new CreateCharacterScreen());
                this.dispose();

                //Tu gestor y objetos
                //aqui
                //Fin de tu gestor y objetos
                //FabricaCharacter gestorCharacter = new FabricaCharacter();
               // Character player = gestorCharacter.getCharacter();

                break;
            case 1:
                Render.close();
                break;

        }
    }






}
