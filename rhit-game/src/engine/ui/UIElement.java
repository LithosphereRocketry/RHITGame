package com.cleotroph.oldroads.engine.ui;

import processing.core.PGraphics;

public abstract class UIElement {
    public float x, y;
    public abstract void render(PGraphics g);
    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
    }
}
