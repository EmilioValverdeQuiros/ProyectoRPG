package com.bisoft.game.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.bisoft.game.elements.Images;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

public class LoadScreen implements Screen {

    private int contador;
    private Images companyLogo;
    private float sum, alpha;

    private boolean loaded, ready, pause;

    public static AssetManager manager;

    public LoadScreen() {
        this.companyLogo = new Images(Resources.COMPANY_LOGO);
        this.sum = 0.008F;
        this.alpha = 0;
        this.loaded = false;
        this.ready = false;
        this.pause = false;
        this.contador = 0;
        manager = new AssetManager();
        manager.load(Resources.MUSIC, Music.class);
        manager.finishLoading();
    }

    @Override
    public void show() {
        this.companyLogo.setsize(300, 400);
        this.companyLogo.setCoordinates(200, 180);
    }

    @Override
    public void render(float delta) {


        Render.clearScreen();
        Render.Batch.begin();
        this.companyLogo.draw();
        Render.Batch.end();
        if (this.loaded) {
            if (!this.pause) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.pause = true;
            }
            if (!this.ready)
                fadeOut();
            else {
                Resources.MAIN.setScreen(new LoreScreen());
                this.dispose();
            }
        } else
            fadeIn();



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
    public void dispose() { // hace una limpia en memoria
        this.companyLogo.dispose();
    }

    //Private Function

    private void fadeIn() {
        if (!this.loaded) {
            if (this.alpha >= 1) {
                this.loaded = true;
            } else {
                this.alpha += this.sum;
                this.companyLogo.setAlpha(this.alpha);
            }
        }

    }

    private void fadeOut() {
        if (!this.ready) {
            if (this.alpha < 0) {
                this.ready = true;
            } else {
                this.alpha -= this.sum;
                this.companyLogo.setAlpha(this.alpha);
            }
        }

    }



}
