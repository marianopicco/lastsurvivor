package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.ActionMenu;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.CharacterMenu;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.Menu;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.StatusMenu;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas implements Drawable {

    public final static int PADDING = 10;
    public final static int BACKGROUND_WIDTH = 1000;
    public final static int BACKGROUND_HEIGHT = 700;
    private ActionMenu currentMenu;
    private Menu statusMenu;
    private Menu actionMenu;
    private Menu characterMenu;
    private Ellipse goodGuy;
    private Ellipse evilGuy;



    public Canvas() {
        draw();
        currentMenu = (ActionMenu) actionMenu;
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
//TODO clear translate tests in receivedAction method
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

        evilGuy = new Ellipse(100, 250, 100, 100);
        evilGuy.fill();

        goodGuy = new Ellipse(800, 250, 100, 100);
        goodGuy.draw();

        Picture pointer2 = new Picture(70, 220, "assets/bluediamond.png");
        pointer2.draw();

    }


    public void translateGoodGuyToE(){
        goodGuy.translate(-200,0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goodGuy.translate(-200,0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goodGuy.translate(-200,0); //Atack possition
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goodGuy.translate(300,0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goodGuy.translate(300,0);
    }


    public void translateEToGoodGuy(){
        evilGuy.translate(200,0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evilGuy.translate(200,0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evilGuy.translate(200,0); //Atack possition
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evilGuy.translate(-300,0);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evilGuy.translate(-300,0);
    }
}
