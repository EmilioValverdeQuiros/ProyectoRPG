package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.characters.Player;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.utils.Pantalla;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;
import com.bisoft.game.utils.WorldContactListener;

import java.util.Objects;

public class RoomMountain implements Screen {

    private Render render = new Render();
    private Inputs input;
    private Pantalla screen;
     private Player player;
    private TextureAtlas atlas;
   // private Dialogs dialogs;
    //private StatusText statusText;
    private FabricaCharacter gestor = new FabricaCharacter();
    private int actual = 0;

    ShapeRenderer border;

    public RoomMountain() {
        input = new Inputs();
        screen = new Pantalla("rooms/city.tmx");
        ///this.statusText = new StatusText(true);
        Resources.CURRENT_LOCATION = "City";
        int[] layers = {1, 3};
        atlas = new TextureAtlas("makecharacter/Pack/playerAssets.pack");
        player = new Player(atlas, 417, 285, this.screen.getWorld());
        screen.getWorld().setContactListener(new WorldContactListener());
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.input);


    }

    @Override
    public void render(float delta) {
        render.clearScreen();

       screen.update(delta);
       player.update(delta);

        render.Batch.setProjectionMatrix(screen.getCAMERA().combined);
        render.Batch.begin();
        //this.statusText.draw();
        player.draw(render.Batch);
        if (!Objects.equals(Resources.dialog, "")) {
            //this.dialogs.setText(Resources.dialog);
            //this.dialogs.draw();
        }
        render.Batch.end();
        //---------------
        inputHandler();


    }

    @Override
    public void resize(int width, int height) {screen.resize(width, height);}

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {dispose();
    }

    @Override
    public void dispose() {
        screen.isDispose(true);

        atlas.dispose();

    }


    private void inputHandler() {
        if (input.isUp() || input.isDown() || input.isRight() || input.isLeft() || input.isEnter()) {
            if (input.isDown()) {
                player.move("down");
            }
            if (input.isLeft()) {
                player.move("left");
            }
            if (input.isRight()) {
                player.move("right");
            }
            if (input.isUp()) {
                player.move("up");
            }
            if (input.isEnter()) {
                Resources.dialog = "";
            }
        } else {
            player.move("none");
        }
    }

}// Termina RoomMountain
