package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas implements Drawable {

    @Override
    public void draw(){

        Rectangle areaOfGame = new Rectangle(10, 10, 1000, 700);

        areaOfGame.draw();
    }

}
