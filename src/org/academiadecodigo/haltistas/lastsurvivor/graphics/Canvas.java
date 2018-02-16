package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas implements Drawable {

    public final static int PADDING = 10;
    public final static int BACKGROUND_WIDTH = 1000;
    public final static int BACKGROUND_HEIGHT = 700;


    @Override
    public void draw() {

        createAreaOfGame();
        createBackground();
        createMenu();

    }

    private void createAreaOfGame() {

        Rectangle areaOfGame = new Rectangle(PADDING, PADDING, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

        areaOfGame.draw();
    }

    private void createBackground() {

        Picture pic = new Picture(-150, -180, "assets/background_test.jpg");

        pic.grow(-2000, -180);
        //pic.draw();
    }

    private void createMenu() {

        Menu statusMenu = new StatusMenu();
        Menu characterMenu = new CharacterMenu();

        statusMenu.draw();
        characterMenu.draw();
    }
}
