package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StatusMenu  extends Menu {

    public StatusMenu() {

        Picture rightMenu = new Picture (menuX(), menuY(), "assets/statusframe.png");
        rightMenu.draw();


    }

    public int menuX() {
        return Canvas.BACKGROUND_WIDTH / 2 + 10;
    }
}
