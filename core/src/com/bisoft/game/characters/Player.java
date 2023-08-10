package com.bisoft.game.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Concreto.AtacarAventurero;
import com.bisoft.game.patterns.Comportamiento.patronCommand.Comando_Concreto.AtacarJefe;
import com.bisoft.game.patterns.Comportamiento.patronCommand.principal.Invoker;
import com.bisoft.game.patterns.Comportamiento.patronEstado.concreto.Berserk;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft.game.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;
import com.bisoft.game.patterns.Creational.MetodoFabrica.CreadorConcreto.FabricaDeEnemigos;
import com.bisoft.game.patterns.Creational.MetodoFabrica.Producto.Enemigo;

public class Player extends Sprite {

    private float X;
    private float Y;
    private static float XF;
    private static float YF;
    private int SPEED = 2;
    //private Texture texture;
    private World world;
    private Body b2Body;


    private enum State {STANDINGup, STANDINGdown, STANDINGleft, STANDINGright, RUNNINGup, RUNNINGdown, RUNNINGleft, RUNNINGright}

    ;

    private State currentState;
    private State previousState;

    //Animacion para el personaje
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunR; // Right
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunL; // Left
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunU; // Up
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> playerRunD; // Down

    private float stateTimer;

    private TextureRegion playerStand;
    private FabricaCharacter gestorCharacte = new FabricaCharacter();

    private FabricaDeEnemigos gestorEnemy = new FabricaDeEnemigos();

    public Player(TextureAtlas pAtlas, float pX, float pY, World pWorld) {

        super(pAtlas.findRegion("MagoSprites"));

        this.X = pX;
        this.Y = pY;
        this.world = pWorld;

        ///Inicia Animacion personaje
        currentState = State.STANDINGdown;
        previousState = State.STANDINGdown;
        stateTimer = 0;

        int y = 0;
        if (gestorCharacte.getCharacter().getTipeCharacter().equals("Guerrero"))
            y = 1;
        else if (gestorCharacte.getCharacter().getTipeCharacter().equals("Mercenario"))
            y = 69;
        else if (gestorCharacte.getCharacter().getTipeCharacter().equals("Mago"))
            y = 35;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        //Para la animacion del personaje
        //Derecha
        for (int i = 3; i < 6; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunR = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();
        //Abajo
        for (int i = 0; i < 3; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunD = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();
        //Arriba
        for (int i = 6; i < 9; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunU = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();
        //Izquierda
        for (int i = 9; i < 12; i++) {
            frames.add(new TextureRegion(getTexture(), i * 32, y, 32, 32));
        }
        playerRunL = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(0.1f, frames);
        frames.clear();

        //Fin de animacion

        definePlayer();

        setBounds(0, 0, 32, 32);
        playerStand = new TextureRegion(this.getTexture(), 0, y, 32, 32);

        setRegion(playerStand); //Esto lo que hace es ya asociar al body
    }

    public float getX() {
        return b2Body.getPosition().x;
    }

    @Override
    public float getY() {
        return b2Body.getPosition().y;
    }


    public float getYFight() {
        return this.YF;
    }

    public float getXFight() {
        return this.XF;
    }

    public void setYFight(float pY) {
        this.YF = pY;
    }

    public void setXFight(float pX) {
        this.XF = pX;
    }

    public void move(String pDirection) {
        if (pDirection.equals("up")) {
            b2Body.setLinearVelocity(0, 100);
            currentState = State.RUNNINGup;
        }
        if (pDirection.equals("down")) {
            b2Body.setLinearVelocity(0, -100);
            currentState = State.RUNNINGdown;
        }
        if (pDirection.equals("left")) {
            b2Body.setLinearVelocity(-100, 0);
            currentState = State.RUNNINGleft;
        }
        if (pDirection.equals("right")) {
            b2Body.setLinearVelocity(100, 0);
            currentState = State.RUNNINGright;
        }
        previousState = currentState;

        if (pDirection.equals("none")) {
            b2Body.setLinearVelocity(0, 0);
            currentState = getState();
        }
    }
    public void atacar(String tecla){
        if (tecla.equals("espacio")) {
            Character personaje = gestorCharacte.getCharacter();
            Enemigo enemigo = gestorEnemy.crearEnemigo("Normal");
            Invoker ivk = new Invoker();
            Berserk berserk = new Berserk();

            AtacarJefe atacarJefe = new AtacarJefe(enemigo,1);
            ivk.recibirTarea(atacarJefe);
            ivk.realizarAtaque();

            if (personaje.getDefense() == 0){
                System.out.println("El aventurero ha muerto");

            } else {
                AtacarAventurero atacarAventurero = new AtacarAventurero(personaje,1);
                ivk.recibirTarea(atacarAventurero);
                ivk.realizarAtaque();
                if (personaje.getDefense() == 3){
                    personaje.setEstado(berserk);
                    personaje.ejecutarAccion(personaje);
                    System.out.println("Ataque despues de entrar en modo Berserk: " + personaje.getAttack());
                }

            }
        }
    }


    public void update(float delta) {
        setPosition(getX() - getWidth() / 2, getY() - getHeight() / 2); //Para que se este en el mismo lugar que el cuerpo y la imagen
        setRegion(getFrame(delta));
        this.X = b2Body.getPosition().x;
        this.Y = b2Body.getPosition().y;
    }

    private void definePlayer() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(this.X, this.Y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2Body = world.createBody(bdef);

        CircleShape shape = new CircleShape();
        shape.setRadius(8f);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;

        b2Body.createFixture(fdef).setUserData("player");
        shape.dispose();

    }

    private TextureRegion getFrame(float delta) {

        TextureRegion region;
        switch (currentState) {
            case RUNNINGup:
                region = playerRunU.getKeyFrame(stateTimer, true);
                break;
            case RUNNINGdown:
                region = playerRunD.getKeyFrame(stateTimer, true);
                break;
            case RUNNINGleft:
                region = playerRunL.getKeyFrame(stateTimer, true);
                break;
            case RUNNINGright:
                region = playerRunR.getKeyFrame(stateTimer, true);
                break;
            default:
                region = playerStand;
                break;
        }
        stateTimer = currentState == previousState ? stateTimer + delta : 0;
        return region;

    }

    private State getState() {
        if (previousState.equals("RUNNINGup"))
            return State.STANDINGup;
        else if (previousState.equals("RUNNINGdown"))
            return State.STANDINGdown;
        else if (previousState.equals("RUNNINGleft"))
            return State.STANDINGleft;
        else
            return State.STANDINGright;
    }





}
