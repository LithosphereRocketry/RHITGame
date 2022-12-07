package com.cleotroph.oldroads.engine.render;

import com.cleotroph.oldroads.init.Window;
import processing.core.PGraphics;
import processing.opengl.PShader;

public abstract class ShaderLayer implements Renderer {
    protected PShader shader;
    public ShaderLayer(PShader s){
        shader = s;
    }
    public void render(PGraphics g){
        g.shader(shader);
    }
}
