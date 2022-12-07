package com.cleotroph.oldroads.init;

import com.cleotroph.oldroads.engine.input.INPUT;
import com.cleotroph.oldroads.engine.input.listeners.*;
import com.cleotroph.oldroads.engine.render.Renderer;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.event.MouseEvent;

public class Window extends PApplet {
    public static final Window INSTANCE = new Window();
    static Renderer activeRenderer;
    static PGraphics canvas;
    static int pw, ph;
    static WINDOW_MODE wm;
    static float W_RATIO = 16.0f;
    static float H_RATIO = 9.0f;

    enum WINDOW_MODE {
        FULLSCREEN,
        FULLSCREEN_CLIPPED,
        WINDOWED
    }

    public static void setRatio(float wr, float hr){
        W_RATIO = wr;
        H_RATIO = hr;
    }

    private void genCanvas(){
        if(wm == WINDOW_MODE.FULLSCREEN) {
            pw = width;
            ph = height;
        }else if(wm == WINDOW_MODE.FULLSCREEN_CLIPPED){
            if (pw == 0 || ph == 0) {
                float scale = min(width / W_RATIO, height / H_RATIO);
                pw = (int) (W_RATIO * scale);
                ph = (int) (H_RATIO * scale);
            }
        }
        canvas = createGraphics(pw, ph);
    }

    public static void Configure(Renderer defaultRenderer, WINDOW_MODE wm){
        activeRenderer = defaultRenderer;
        Window.wm = wm;
        if(wm == WINDOW_MODE.WINDOWED){
            pw = 500;
            ph = 500;
        }
    }

    public static void Configure(Renderer defaultRenderer, WINDOW_MODE wm, int pwidth, int pheight){
        activeRenderer = defaultRenderer;
        Window.wm = wm;
        pw = pwidth;
        ph = pheight;
    }

    @Override
    public void settings() {
        super.settings();
        if(wm == WINDOW_MODE.FULLSCREEN || wm == WINDOW_MODE.FULLSCREEN_CLIPPED){
            fullScreen();
        }else{
            size(pw, ph);
        }
    }

    @Override
    public void setup() {
        super.setup();
        frameRate(60);
        genCanvas();
    }

    @Override
    public void draw() {
        background(0);
        canvas.beginDraw();
        activeRenderer.render(canvas);
        canvas.endDraw();
        translate((width - pw) / 2.0f, (height - ph) / 2.0f);
        image(canvas, 0, 0);
        super.draw();
    }

    public void mouseClicked() {
        for (MouseClickedListener listener : INPUT.ActiveInputManager.mouseClickedListeners) {
            listener.onMouseClicked();
        }
    }

    public void mousePressed() {
        for (MousePressedListener listener : INPUT.ActiveInputManager.mousePressedListeners) {
            listener.onMousePressed();
        }
    }

    public void mouseReleased() {
        for (MouseReleasedListener listener : INPUT.ActiveInputManager.mouseReleasedListeners) {
            listener.onMouseReleased();
        }
    }

    public void keyPressed() {
        for (KeyPressedListener listener : INPUT.ActiveInputManager.keyPressedListeners) {
            listener.onKeyPressed();
        }
    }

    public void keyReleased() {
        for (KeyReleasedListener listener : INPUT.ActiveInputManager.keyReleasedListeners) {
            listener.onKeyReleased();
        }
    }

    public void mouseWheel(MouseEvent event) {
        for (MouseScrollListener listener : INPUT.ActiveInputManager.mouseScrollListeners) {
            listener.onMouseScroll(event.getCount());
        }
    }

    public static void setActiveRenderer(Renderer activeRenderer) {
        Window.activeRenderer = activeRenderer;
        activeRenderer.onActivate();
    }

    public static float getMouseX(){
        return INSTANCE.mouseX;
    }

    public static float getMouseY(){

        return INSTANCE.mouseY;
    }
}
