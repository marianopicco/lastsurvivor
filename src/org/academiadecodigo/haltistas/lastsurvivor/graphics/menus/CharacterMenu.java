package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class CharacterMenu extends Menu {

    private int INITIAL_POSITION_X = Canvas.PADDING + 10;
    private int initialPositionY = 580;

    public CharacterMenu() {

        Rectangle leftMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
        leftMenu.fill();
        leftMenu.setColor(Color.RED);

        textCharacter();
    }

    @Override
    public int menuX() {
        return Canvas.PADDING;
    }

    public void textCharacter() {

        Text name = new Text(INITIAL_POSITION_X, initialPositionY, "WARRIOR");

        name.draw();
    }

}
