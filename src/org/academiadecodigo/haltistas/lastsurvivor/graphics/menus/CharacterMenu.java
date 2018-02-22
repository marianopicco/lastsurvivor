package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CharacterMenu extends Menu {

    private int INITIAL_POSITION_X = Canvas.PADDING + 20;
    private int initialPositionY = 595;

    public CharacterMenu() {

        Picture leftMenu = new Picture (menuX(), menuY(), "assets/characterframe.png");
        leftMenu.draw();
        textCharacter();

    }


    public int menuX() {
        return Canvas.PADDING;
    }


    public void textCharacter() {

        Picture name = new Picture(INITIAL_POSITION_X, initialPositionY, "assets/supergrannyname.png");
        name.draw();
    }

}
