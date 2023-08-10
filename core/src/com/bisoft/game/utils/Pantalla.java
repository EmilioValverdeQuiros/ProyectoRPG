package com.bisoft.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bisoft.game.utils.Box2Helper;
import com.bisoft.game.utils.Resources;

import java.util.ArrayList;

public class Pantalla {

    //Variables para la generacion del mapa
    private TmxMapLoader MAPLOADER;
    public TiledMap MAP;
    private OrthogonalTiledMapRenderer RENDERER;
    private MapProperties PROP;

    //Variables para la vista del mapa, la camara funcionará como lo que se ve, el viewport como la forma que se ve y el scale para que se vea más bonito en mapas pequeños
    private OrthographicCamera CAMERA;
    private Viewport GAMEVIEW;
    private float SCALE;
    //Para la creacion de 2D Boxes
    private ArrayList<Box2Helper> BH = new ArrayList<Box2Helper>();
    private Box2Helper box2Helper;
    private World world;
    private Box2DDebugRenderer renderBox2dHelper;
    boolean city;
    int cityLayer;
    boolean dispose = false;

    public Pantalla(String pMap) {

        this.CAMERA = new OrthographicCamera();
        this.GAMEVIEW = new StretchViewport(Resources.WIDTH, Resources.HEIGHT, this.CAMERA);

        SCALE = Gdx.graphics.getWidth() / 800f;

        this.MAPLOADER = new TmxMapLoader();
        this.MAP = MAPLOADER.load(pMap);
        this.RENDERER = new OrthogonalTiledMapRenderer(this.MAP, SCALE);


        this.world = new World(new Vector2(0, 0), true); //Vector 2 es para la gravedad dentro de los juegos de plataforma, en nuestro caso es 0,0 ya que sino se cae el personaje
        this.box2Helper = new Box2Helper(world);

        this.renderBox2dHelper = box2Helper.getB2DR();

        sizeMap();
    }

    public Pantalla(String pMap, int pX, int pY) {
        this.CAMERA = new OrthographicCamera();
        this.GAMEVIEW = new StretchViewport(Resources.WIDTH, Resources.HEIGHT, this.CAMERA);

        this.MAPLOADER = new TmxMapLoader();
        this.MAP = MAPLOADER.load(pMap);
        this.RENDERER = new OrthogonalTiledMapRenderer(this.MAP);


        this.world = new World(new Vector2(0, 0), true);
        this.box2Helper = new Box2Helper(world);

        this.renderBox2dHelper = box2Helper.getB2DR();

        this.CAMERA.position.set(pX, pY, 0);


    }


    public OrthographicCamera getCAMERA() {
        return CAMERA;
    }

    public World getWorld() {
        return world;
    }

    public Box2DDebugRenderer getRenderBox2dHelper() {
        return renderBox2dHelper;
    }

    public void isDispose(boolean valor) {
        this.dispose = valor;
    }
    public void setCity(boolean city) {
        this.city = city;
    }
    public void setCityLayer(int cityLayer) {
        this.cityLayer = cityLayer;
    }

    public void update(float pDelta) {


        world.step(pDelta, 8, 6);
        if (dispose) {
            this.box2Helper.dispose();
            dispose();
        } else {
            this.CAMERA.update();
            this.RENDERER.setView(CAMERA);
            this.RENDERER.render();

            this.renderBox2dHelper.render(world, CAMERA.combined);
            renderBox2D();
        }


    }




    public void dispose() {
        //Limpiamos cuando se salga de la pantalla
        this.MAP.dispose();
        this.RENDERER.dispose();
    }
    public void resize(int width, int height) {
        this.GAMEVIEW.update(width, height);
    }



    public void Box2DMaplayers(int[] pLayers) {
        try {

            for (int layer : pLayers) {
                Box2Helper box = new Box2Helper(world);
                box.create2DBoxes(this.MAP, layer);
                BH.add(box);
            }

            if (city) {
                Box2Helper box = new Box2Helper(world);
                box.MapaArcadeMejoraObject(this.MAP, cityLayer);
                BH.add(box);
            }


        } catch (Exception e) {
            throw e;
        }
    }


    private void sizeMap() {
        this.PROP = MAP.getProperties();

        int mapWidth = PROP.get("width", Integer.class);
        int mapHeight = PROP.get("height", Integer.class);
        int tilePixelWidth = PROP.get("tilewidth", Integer.class);
        int tilePixelHeight = PROP.get("tileheight", Integer.class);

        int mapPixelWidth = mapWidth * tilePixelWidth;
        int mapPixelHeight = mapHeight * tilePixelHeight;

        //Por si se quiere saber el tamano del mapa
        System.out.println(mapPixelWidth);
        System.out.println(mapPixelHeight);

        this.CAMERA.position.set(mapPixelWidth / 2, mapPixelHeight / 2, 0);
    }

    private void renderBox2D() {
        for (Box2Helper box2D : this.BH) {
            box2D.getB2DR().render(this.world, CAMERA.combined);
        }

    }










}//Fin de la clase Pantalla
