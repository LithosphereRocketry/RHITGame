package com.cleotroph.oldroads.engine.render;

import com.cleotroph.oldroads.init.Window;
import processing.core.PGraphics;

public interface Renderer {
    void render(PGraphics g);
    void onActivate();
}