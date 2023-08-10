package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

public class LoreScreen implements Screen {

    private Text text;
    private ShapeRenderer border;
    private float alpha;
    private float sum;
    private Inputs input;
    private Images background;

    public static AssetManager manager;

    private Music music;

    public LoreScreen() {
        music = LoadScreen.manager.get(Resources.MUSIC, Music.class);
        music.setLooping(true);
        music.setVolume(1.0f);

        music.play();
        ///TEXTO DE LA PRIMERA PANTALLA
        this.text = new Text(Resources.GAME_FONT, 50, 400, 28,
                "En un mundo de fantasia, donde las personas tienen \nvidas normales con trabajos normales, existe una \nmanera de ganarse la vida luchando " +
                        "\ncontra monstruos y completando desafios " +
                        "dentro \ndel gran calabozo, a esas personas se les conoce \ncomo aventureros");


        this.border = new ShapeRenderer();
        this.background = new Images(Resources.LORE_BACKGROUND);
        this.input = new Inputs();
        this.sum = 0.0008F;
        this.alpha = 0;
    }

    @Override
    public void show() {
        this.background.setsize(600, 800);
        this.text.setColor(Color.WHITE);
        Gdx.input.setInputProcessor(this.input);


    }

    @Override
    public void render(float delta) {

        Render.Batch.begin();
        this.background.draw();
        this.text.draw();
        Render.Batch.end();
        loadMenuScreen();

        nextText();

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

    private void loadMenuScreen() {
        if (this.input.isUp() || this.input.isDown() || this.input.isEnter()) {
            Resources.MAIN.setScreen(new MenuScreen());
            music.stop();
        }
    }

    private void nextText() {
        this.alpha += this.sum;
        if (this.alpha >= 0.6) {
            this.text.setText("En este mundo de fantasia nace un heroe \nlegendario que tendra como objetivo ser el \nmejor aventurero del mundo, nuestro " +
                    "heroe se \nadentrara en las fosas del gran calabozo para \nsubir" +
                    " de nivel y conseguir equipamiento, \nhabilidades y accesorios dignos del mejor \naventurero del mundo");
            this.text.setCoordinates(80, 400);
        }
        if (this.alpha >= 1) {
            this.text.setText("PRESIONE ENTER");
            this.text.setCoordinates(80, 400);
        }

    }
}
