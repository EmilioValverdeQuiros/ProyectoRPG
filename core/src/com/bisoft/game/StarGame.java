package com.bisoft.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bisoft.game.screen.MenuScreen;
import com.bisoft.game.utils.Render;
import com.bisoft.game.utils.Resources;
import com.bisoft.game.screen.*;

public class StarGame extends Game {
	@Override
	public void create() {
		Render.Batch = new SpriteBatch();
		//Resources.MAIN.setScreen(new LoreScreen());

		Resources.MAIN.setScreen(new LoadScreen());

//		Resources.MAIN.setScreen(new MenuScreen());
	}

}
