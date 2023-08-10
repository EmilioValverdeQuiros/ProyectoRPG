package com.bisoft.game.patterns.Structural.Adapter.adaptador;

import com.badlogic.gdx.math.Rectangle;
import com.bisoft.game.patterns.Structural.Adapter.objetos.MyRectangle;

public class MyRectangleAdapter extends MyRectangle {

    final Rectangle rectangle;
    final String name;
    public MyRectangleAdapter(Rectangle rectangle, String name){
        this.rectangle = rectangle;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getX1() {
        return rectangle.getX();
    }

    @Override
    public float getX2() {
        return rectangle.getX() + rectangle.getWidth();
    }

    @Override
    public float getY1() {
        return rectangle.getY();
    }

    @Override
    public float getY2() {
        return rectangle.getY() + rectangle.getHeight();
    }
}