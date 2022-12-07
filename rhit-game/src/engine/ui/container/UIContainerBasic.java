package com.cleotroph.oldroads.engine.ui.container;

import com.cleotroph.oldroads.engine.ui.UIContainer;
import processing.core.PGraphics;

public class UIContainerBasic extends UIContainer {
    public float x, y;

    public UIContainerBasic(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void pushTransform(PGraphics g) {
        g.translate(x, y);
    }

    @Override
    protected void popTransform(PGraphics g) {
        g.translate(-x, -y);
    }
}
