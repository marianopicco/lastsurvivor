package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;

public abstract class Menu implements Drawable {

    @Override
    public void draw() {

    }

    public abstract int menuX();

    public int menuY() {
        return Canvas.BACKGROUND_HEIGHT - 150;
    }

    public int menuHeight() {
        return Canvas.BACKGROUND_HEIGHT - 550;
    }

    public int menuWidth() {
        return Canvas.BACKGROUND_WIDTH / 2;
    }

}
