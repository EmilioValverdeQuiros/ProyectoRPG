package com.bisoft.game.utils.InteractiveObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bisoft.game.screen.RoomMountain;
import com.bisoft.game.utils.InteractiveTileObject;
import com.bisoft.game.utils.Resources;

public class Mountain extends InteractiveTileObject {

    public Mountain(World pWorld, TiledMap pMap, Rectangle pBounds) {
        super(pWorld, pMap, pBounds);

        FIXTURE.setUserData(this);
    }

    @Override
    public void onHit() {
       Gdx.app.log("City", "Collision");
        Resources.MAIN.setScreen(new RoomMountain());


    }


}
