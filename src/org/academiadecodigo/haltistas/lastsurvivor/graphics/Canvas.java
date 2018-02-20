package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.*;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas implements Drawable {

    public final static int PADDING = 10;
    public final static int BACKGROUND_WIDTH = 1000;
    public final static int BACKGROUND_HEIGHT = 700;

    private Movable currentMenu;
    private Movable actionMenu;
    private Menu statusMenu;
    private Menu characterMenu;


    public Canvas() {
        draw();
        currentMenu = actionMenu;
    }


    @Override
    public void draw() {

        createAreaOfGame();
        createBackground();
        createMenu();
        drawCharacters();

    }

    private void createAreaOfGame() {

        Rectangle areaOfGame = new Rectangle(PADDING, PADDING, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

        areaOfGame.draw();
    }

    private void createBackground() {

        Picture pic = new Picture(PADDING, PADDING, "assets/background_test.jpg");

        pic.draw();
    }

    private void createMenu() {

        statusMenu = new StatusMenu();
        characterMenu = new CharacterMenu();
        actionMenu = new ActionMenu();

        statusMenu.draw();
        characterMenu.draw();
        actionMenu.draw();
    }

    public void receivedAction(KeyPress keyPress) {

        switch (keyPress) {

            case UP:
                currentMenu.moveUp();
                break;
            case DOWN:
                currentMenu.moveDown();
                break;
            case SPACE:
                currentMenu.actionSelection();
                break;
            default:
                System.out.println("JVM fucked up");
        }

    }

    public void drawCharacters() {

        Ellipse evilGuy = new Ellipse(100, 100, 100, 100);
        evilGuy.fill();

        Ellipse evilGuy2 = new Ellipse(100, 250, 100, 100);
        evilGuy2.fill();

        Ellipse evilGuy3 = new Ellipse(100, 400, 100, 100);
        evilGuy3.fill();

        Ellipse goodGuy = new Ellipse(800, 250, 100, 100);
        goodGuy.draw();

        Picture pointer = new Picture(70, 70, "assets/bluediamond.png");
        pointer.draw();

        Picture pointer2 = new Picture(70, 220, "assets/bluediamond.png");
        pointer2.draw();

        Picture pointer3 = new Picture(70, 370, "assets/bluediamond.png");
        pointer3.draw();

    }

}
