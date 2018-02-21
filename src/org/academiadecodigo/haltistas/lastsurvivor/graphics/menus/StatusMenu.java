package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class StatusMenu extends Menu {

    public StatusMenu() {

        Rectangle rightMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
        rightMenu.fill();
        rightMenu.setColor(new Color(70, 130, 180));
    }

    public int menuX() {
        return Canvas.BACKGROUND_WIDTH / 2;
    }
}
