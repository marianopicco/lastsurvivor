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


    public Canvas() {
        draw();
        currentMenu = (ActionMenu)actionMenu;
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

        Picture pic = new Picture(PADDING, PADDING, "assets/background.jpg");

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

    public void receivedAction(KeyPress keyPress){
        switch(keyPress){
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

        //Ellipse evilGuy = new Ellipse(100, 100, 100, 100);
        //evilGuy.fill();

        //Ellipse evilGuy2 = new Ellipse(100, 250, 100, 100);
        //evilGuy2.fill();

        //Ellipse evilGuy3 = new Ellipse(100, 400, 100, 100);
        //evilGuy3.fill();

        //Ellipse goodGuy = new Ellipse(800, 250, 100, 100);
        //goodGuy.draw();


        Picture evil1 = new Picture(100, 100, "assets/blastercyst.png");
        evil1.draw();

        Picture evil2 = new Picture(100, 350, "assets/buzzilisk.png");
        evil2.draw();

        //Picture evil3 = new Picture(100, 225, "assets/.png");
        //evil3.draw();

        Picture hero = new Picture(700, 350, "assets/supergranny.png");
        hero.draw();


        Picture pointer1 = new Picture(50, 70, "assets/arrow.png");
        pointer1.draw();

        Picture pointer2 = new Picture(50, 320, "assets/arrow.png");
        pointer2.draw();

        //Picture pointer3 = new Picture(70, 370, "assets/arrow.png");
        //pointer3.draw();


        //goodGuy.translate(-600,0); //é a deslocação de ataque
        //goodGuy.translate(600,0);

    }
/*
    public void enemyPosition(){

        int numberOfEnemies;

        switch(numberOfEnemies) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            default:


        }

    }
    */
}
