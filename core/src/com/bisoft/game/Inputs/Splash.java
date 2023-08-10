package com.bisoft.game.Inputs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class Splash extends Game {

    private Stage stage;

    @Override
    public void create() {

        ExtendViewport extendViewport = new ExtendViewport(700, 1200, new OrthographicCamera());
        stage = new Stage(extendViewport);

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skin.get("font-label", BitmapFont.class).getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Table table = new Table();
        table.defaults().pad(10);
        table.setFillParent(true);

        Label userName = new Label("USER ID : ", skin);
        TextField userNameField = new TextField("", skin);

        Label name = new Label("NAME : ", skin);
        TextField nameField = new TextField("", skin);

        Label email = new Label("EMAIL : ", skin);
        TextField emailField = new TextField("", skin);

        table.add(userName);
        table.add(userNameField).width(300);
        table.row();
        table.add(name).left();
        table.add(nameField).width(300);
        table.row();
        table.add(email).left();
        table.add(emailField).width(300);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

//
//
//package com.bisoft.game;
//
//        import com.badlogic.gdx.ApplicationAdapter;
//        import com.badlogic.gdx.Game;
//        import com.badlogic.gdx.Gdx;
//        import com.badlogic.gdx.Input;
//        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//        import com.bisoft.game.Inputs.Splash;
//        import com.bisoft.game.screen.MenuScreen;
//        import com.bisoft.game.utils.Render;
//        import com.bisoft.game.utils.Resources;
//        import com.bisoft.game.screen.*;
//
//public class StarGame extends Game implements Input.TextInputListener {
//
//    String text;
//    @Override
//    public void create() {
//
//    }
//
//    public void render() {
//        if (Gdx.input.justTouched())
//            Gdx.input.getTextInput(this,"Titulo","texto default","texto");
//        Gdx.app.log("Text", text);
//    }
//
//    @Override
//    public void input(String text) {
//        this.text  = text;
//    }
//
//    @Override
//    public void canceled() {
//        text = "cancelled";
//    }

//}
//
