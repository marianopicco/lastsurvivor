package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.ActionMenu;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.CharacterMenu;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.Menu;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.StatusMenu;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
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

        Menu statusMenu = new StatusMenu();
        Menu characterMenu = new CharacterMenu();
        Menu ss = new ActionMenu();

        statusMenu.draw();
        characterMenu.draw();
        ss.draw();
    }

    public void drawCharacters(){

        Ellipse evilGuy =new Ellipse(100,100,100,100);
        evilGuy.fill();

        Ellipse evilGuy2 =new Ellipse(100,250,100,100);
        evilGuy2.fill();

        Ellipse evilGuy3 =new Ellipse(100,400,100,100);
        evilGuy3.fill();

        Ellipse goodGuy = new Ellipse(800, 250, 100, 100);
        goodGuy.draw();

/*
        Picture evil1 = new Picture(100, 50, "assets/evil1.png");
        evil1.draw();

        Picture evil2 = new Picture(100, 225, "assets/evil2.png");
        evil2.draw();

        Picture evil3 = new Picture(100, 400, "assets/evil3.png");
        evil3.draw();

        Picture hero = new Picture(800, 250, "assets/hero.png");
        hero.draw();
*/

        Picture pointer = new Picture(70, 70, "assets/bluediamond.png");
        pointer.draw();

        Picture pointer2 = new Picture(70, 220, "assets/bluediamond.png");
        pointer2.draw();

        Picture pointer3 = new Picture(70, 370, "assets/bluediamond.png");
        pointer3.draw();




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
