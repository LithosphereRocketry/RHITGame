package com.cleotroph.oldroads.engine.render;

import com.cleotroph.oldroads.init.Window;
import processing.core.PGraphics;

import java.util.ArrayList;

public class ShaderRenderer implements Renderer {
    public ArrayList<ShaderLayer> layers;

    public ShaderRenderer() {
    }

    @Override
    public void render(PGraphics g) {
        for(ShaderLayer sl : layers){
            sl.render(g);
        }
    }

    @Override
    public void onActivate() {

    }
}
