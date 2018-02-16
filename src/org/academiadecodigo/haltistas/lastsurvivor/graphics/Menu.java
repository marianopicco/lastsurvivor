package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Menu implements Drawable {

    public Menu() {

    }

    @Override
    public void draw() {

        Rectangle rightMenu = new Rectangle(statusMenuX(), menuY(), menuWidth(), menuHeight());
        rightMenu.fill();
        rightMenu.setColor(new Color(70, 130, 180));//steelblue


        Rectangle leftMenu = new Rectangle(characterMenuX(), menuY(), menuWidth(), menuHeight());
        leftMenu.fill();
        leftMenu.setColor(Color.RED);

        Rectangle actionMenu = new Rectangle(menuWidth() / 2, menuY() + 10, menuWidth() / 2,
                menuHeight() - 20);
        actionMenu.fill();
        actionMenu.setColor(Color.CYAN);


    }

    private int characterMenuX() {
        return Canvas.PADDING;
    }

    private int statusMenuX() {
        return Canvas.BACKGROUND_WIDTH / 2;
    }

    private int menuY() {
        return Canvas.BACKGROUND_HEIGHT - 150;

    }

    private int menuHeight() {
        return Canvas.BACKGROUND_HEIGHT - 550;
    }

    private int menuWidth() {
        return Canvas.BACKGROUND_WIDTH / 2;
    }


}
