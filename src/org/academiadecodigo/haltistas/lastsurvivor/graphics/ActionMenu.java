package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ActionMenu extends Menu{

    public ActionMenu() {

        Rectangle actionMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
        actionMenu.fill();
        actionMenu.setColor(Color.CYAN);
    }

    @Override
    public int menuX() {
        return super.menuWidth() / 2;
    }

    @Override
    public int menuY() {
        return super.menuY() + 10;
    }

    @Override
    public int menuHeight() {
        return super.menuHeight() - 20;
    }

    @Override
    public int menuWidth() {
        return super.menuWidth() / 2;
    }
}
