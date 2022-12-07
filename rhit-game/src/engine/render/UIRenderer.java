package com.cleotroph.oldroads.engine.render;

import com.cleotroph.oldroads.engine.ui.UIContainer;
import com.cleotroph.oldroads.engine.ui.UIElement;
import com.cleotroph.oldroads.init.Window;
import processing.core.PGraphics;

import java.util.ArrayList;

public abstract class UIRenderer implements Renderer {
    ArrayList<UIElement> elements;
    public UIRenderer(){
        elements = new ArrayList<>();
    }
    public abstract void onActivate();
    public void render(PGraphics g){
        renderBefore(g);
        for(UIElement uie : elements){
            uie.render(g);
        }
        renderAfter(g);
    }
    public void putElement(UIElement uie){
        elements.add(uie);
    }
    protected abstract void renderBefore(PGraphics g);
    protected abstract void renderAfter(PGraphics g);
}
