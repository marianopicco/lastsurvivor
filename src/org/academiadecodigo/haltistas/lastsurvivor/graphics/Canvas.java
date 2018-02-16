package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas implements Drawable {

    @Override
    public void draw(){

        createAreaOfGame();
createBackground();

    }

    private void createAreaOfGame() {
        Rectangle areaOfGame = new Rectangle(10, 10, 1000, 700);

        areaOfGame.draw();
    }

    private void createBackground() {
        
        Picture pic = new Picture(-150, -180, "assets/background_test.jpg");
        pic.grow(-2000, -180);
        pic.draw();
    }

}
