package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Menu implements Drawable {

    public Menu() {

    }

    @Override
    public void draw() {

        Rectangle rightMenu = new Rectangle(500,550, 560, 150);
        rightMenu.fill();
        rightMenu.setColor(new Color(70,130,180));//steelblue

        Rectangle leftMenu = new Rectangle(10,550, 500, 150);
        leftMenu.fill();
        leftMenu.setColor(Color.RED);

        Rectangle actionMenu = new Rectangle(250,560,200,120);
        actionMenu.fill();
        actionMenu.setColor(Color.CYAN);





    }
}
