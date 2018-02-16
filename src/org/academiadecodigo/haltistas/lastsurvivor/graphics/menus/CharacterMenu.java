package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CharacterMenu extends Menu {

    public CharacterMenu() {

        Rectangle leftMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
        leftMenu.fill();
        leftMenu.setColor(Color.RED);
    }

    @Override
    public int menuX() {
        return Canvas.PADDING;
    }
}
