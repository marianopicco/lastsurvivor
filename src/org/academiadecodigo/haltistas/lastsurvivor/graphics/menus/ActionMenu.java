package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Action;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ActionMenu extends Menu {
    private final static int INITIAL_POSITION_X=260;
    private int initialPositionY=menuY()+10;



    public ActionMenu() {

        Rectangle actionMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
        actionMenu.fill();
        actionMenu.setColor(Color.CYAN);
    }

    @Override
    public void draw() {
        defineAction();
    }

    @Override
    public int menuX() {
        return super.menuWidth() / 2;
    }

    @Override
    public int menuY() {
        return super.menuY() + 10;
    }

    @Override
    public int menuHeight() {
        return super.menuHeight() - 20;
    }

    @Override
    public int menuWidth() {
        return super.menuWidth() / 2;
    }

    public void defineAction() {

        Text attack = new Text(INITIAL_POSITION_X, initialPositionY, Action.ATTACK.getAction());
        Text magic = new Text(INITIAL_POSITION_X, menuY() + 30, Action.MAGIC.getAction());
        Text defend = new Text(INITIAL_POSITION_X, menuY() + 50, Action.DEFEND.getAction());
        Text item = new Text(INITIAL_POSITION_X, menuY() + 70, Action.ITEMS.getAction());

        Rectangle selectionBox = new Rectangle(INITIAL_POSITION_X, initialPositionY,60,20 );
        selectionBox.draw();

        attack.draw();
        magic.draw();
        defend.draw();
        item.draw();

        selectionBox.translate(0,20);
    }

}
