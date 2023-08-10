package com.bisoft.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bisoft.game.Inputs.Inputs;
import com.bisoft.game.Inputs.MyTextInputListener;
import com.bisoft.game.elements.Images;
import com.bisoft.game.elements.Text;
import com.bisoft.game.menucharacter.CreateCharacterScreen;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;

import java.awt.*;
import java.util.ArrayList;

public class PlayerScreen extends InputAdapter implements Screen {

    private Images back;
    private Images image;
    private Inputs input;

    private Text gameName;
    private ArrayList<Text> options;

    private float alpha, sum;

    private int actual = 0;

    ShapeRenderer border;

    // codigo para player
    Stage stage;
    SpriteBatch batch;
    Texture player;
    Texture brick;
    float speed = 150.0f;
    float playerx = 400;
    float playery = 400;
    com.badlogic.gdx.math.Rectangle player_rectangle;
    com.badlogic.gdx.math.Rectangle brick_rectangle;
    float prevx;
    float prevy;

    OrthographicCamera camera;
    //
    public PlayerScreen() {
        this.sum = 0.0008F;
        this.alpha = 0;
        this.back = new Images(Resources.MENU_BACKGROUND);
        this.options = new ArrayList<Text>();
        this.input = new Inputs();
        this.border = new ShapeRenderer();
        this.gameName = new Text(Resources.GAME_FONT, 200, 510, 80, "GE FORCE");
        image = new Images(Resources.CREATE_CHARACTER_BACKGROUND);

    }

    @Override
    public void show() {
        // player
        player = new Texture("makecharacter/Mago/hero6.png");
        brick = new Texture("makecharacter/Mago/brick.jpeg");

        stage = new Stage();
        player_rectangle = new Rectangle(playerx, playery, player.getWidth(), player.getHeight());
        brick_rectangle = new Rectangle(100, 100, brick.getWidth(), brick.getHeight());

        Gdx.input.setInputProcessor(stage);
        prevx = 0;
        prevy = 0;
        camera = new OrthographicCamera(playerx, playery);
        camera.setToOrtho(false);
        batch = new SpriteBatch();
        //

        //Text field below
        MyTextInputListener listener = new MyTextInputListener();
        Gdx.input.getTextInput(listener, "Dialog Title", "Initial Textfield Value", "Hint Value");

        MyTextInputListener inputListener = new MyTextInputListener();
        inputListener.input("textField");


    }

    @Override
    public void render(float delta) {

        // player
        Gdx.gl.glClearColor(1,1,1,0);
        ScreenUtils.clear(1,1,1,0);
        MyTextInputListener listener = new MyTextInputListener();
        Gdx.input.getTextInput(listener, "Dialog Title", "Initial Textfield Value", "Hint Value");

        batch.begin();
            camera.position.set(playerx,playery,0);
            camera.update();

            stage.draw();
            batch.draw(player,playerx,playery);
            batch.draw(brick, 100,100);

                if (brick_rectangle.overlaps(player_rectangle)){
                    System.out.println("colision");
                    playery = prevy;
                    playerx = prevx;
                }

                if (Gdx.input.isKeyPressed(Input.Keys.W) && playery<500){
                    System.out.println("W");
                    prevy = playery;
                    playery += Gdx.graphics.getDeltaTime()*speed;
                    player = new Texture("makecharacter/Mago/hero4.png");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.S)&&playery>0){
                    System.out.println("S");
                    prevy = playery;
                    playery -= Gdx.graphics.getDeltaTime()*speed;
                    player = new Texture("makecharacter/Mago/hero1.png");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.A) && playerx >0){
                    System.out.println("A");
                    prevx = playerx;
                    playerx -= Gdx.graphics.getDeltaTime()*speed;
                    player = new Texture("makecharacter/Mago/hero3.png");
                }
                if (Gdx.input.isKeyPressed(Input.Keys.D)&&playerx<700){
                    System.out.println("D");
                    prevx = playerx;
                    playerx += Gdx.graphics.getDeltaTime()*speed;
                    player = new Texture("makecharacter/Mago/hero8.png");
                }

                if (!Gdx.input.isKeyPressed((Input.Keys.ANY_KEY)))
                    player = new Texture("makecharacter/Mago/hero6.png");

            player_rectangle = new Rectangle(playerx, playery, player.getWidth(), player.getHeight());
            brick_rectangle = new Rectangle(100, 100, brick.getWidth(), brick.getHeight());

        //Text field below
        MyTextInputListener listener1 = new MyTextInputListener();
        Gdx.input.getTextInput(listener1, "Dialog Title", "Initial Textfield Value", "Hint Value");



        batch.setProjectionMatrix(camera.combined);
        batch.end();
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
}
