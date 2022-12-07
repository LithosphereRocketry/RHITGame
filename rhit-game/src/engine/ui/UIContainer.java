package com.cleotroph.oldroads.engine.ui;

import processing.core.PGraphics;

import java.util.ArrayList;

public abstract class UIContainer extends UIElement {
    ArrayList<UIElement> elements;
    public UIContainer(){
        elements = new ArrayList<>();
    }
    public void putElement(UIElement uie){
        elements.add(uie);
    }
    public abstract void pushTransform(PGraphics g);
    public void render(PGraphics g){
        pushTransform(g);
        for (UIElement uie : elements) {
            uie.render(g);
        }
        popTransform(g);
    }
    protected abstract void popTransform(PGraphics g);
}
