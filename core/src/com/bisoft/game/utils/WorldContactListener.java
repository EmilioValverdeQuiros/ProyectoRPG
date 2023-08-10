package com.bisoft.game.utils;

import com.badlogic.gdx.physics.box2d.*;

public class WorldContactListener implements  ContactListener {

    public void beginContact(Contact contact) {

        Fixture FixA = contact.getFixtureA();
        Fixture FixB = contact.getFixtureB();

        if (FixA.getUserData() == "player" || FixB.getUserData() =="player"){
            Fixture player = FixA.getUserData() == "player" ? FixA : FixB;
            Fixture object = player == FixA ? FixB: FixA;

            //Comprobamos que sea de la clase InteractiveTileObject, devuelve true si es cierto
            if (object.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())){
                ((InteractiveTileObject) object.getUserData()).onHit();
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }


}
