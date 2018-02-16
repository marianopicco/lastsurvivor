package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Action;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ActionMenu extends Menu {


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

        Text attack = new Text(260, menuY() + 10, Action.ATTACK.getAction());
        Text magic = new Text(260, menuY() + 30, Action.MAGIC.getAction());
        Text defend = new Text(260, menuY() + 50, Action.DEFEND.getAction());
        Text item = new Text(260, menuY() + 70, Action.ITEMS.getAction());

        attack.draw();
        magic.draw();
        defend.draw();
        item.draw();


    }


}
