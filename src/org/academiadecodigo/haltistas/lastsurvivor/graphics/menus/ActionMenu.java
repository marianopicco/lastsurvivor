package org.academiadecodigo.haltistas.lastsurvivor.graphics.menus;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.Action;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ActionMenu extends Menu implements Movement {

    private final static int INITIAL_POSITION_X = 260;
    private final static int SELECTION_MOVE_X = 0;
    private final static int SELECTION_MOVE_Y = 20;

    private int initialPositionY = menuY() + 10;
    private int actionPointer = 0;
    private Picture selectionPointer;
    private Action currentAction;



    public ActionMenu() {

        Picture actionMenu = new Picture(menuX(), menuY(), "assets/actionframe.png");
        actionMenu.draw();
        currentAction = Action.ATTACK;
    }

    @Override
    public void draw() {
        drawAction();
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

    public void drawAction() {

        Picture attack = new Picture(INITIAL_POSITION_X, initialPositionY, "assets/attackWORD.png");
        Picture magic = new Picture(INITIAL_POSITION_X, menuY() + 30, "assets/magicWORD.png");
        Picture defend = new Picture(INITIAL_POSITION_X, menuY() + 50, "assets/defendWORD.png");
        Picture item = new Picture(INITIAL_POSITION_X, menuY() + 70, "assets/itemsWORD.png");

        selectionPointer = new Picture(INITIAL_POSITION_X, initialPositionY, "assets/littlearrow.png");
        selectionPointer.draw();

        attack.draw();
        magic.draw();
        defend.draw();
        item.draw();

        actionSelection();
    }

    @Override
    public void moveDown() {

        actionPointer++;

        if (actionPointer == Action.values().length) {
            selectionPointer.translate(SELECTION_MOVE_X, -80);
            actionPointer = 0;
        }

        selectionPointer.translate(SELECTION_MOVE_X, SELECTION_MOVE_Y);

    }

    @Override
    public void moveUp() {

        if (actionPointer == 0) {
            selectionPointer.translate(SELECTION_MOVE_X, 80);
            actionPointer = Action.values().length;
        }

        actionPointer--;
        selectionPointer.translate(SELECTION_MOVE_X, -SELECTION_MOVE_Y);
    }

    @Override
    public void actionSelection() {

        switch (currentAction) {
            case ATTACK:
                //call class EnemySelection
                break;
            case MAGIC:
                //call class EnemySelection
                break;
            case DEFEND:
                break;
            case ITEMS:
                break;
            default:
                System.out.println("JVM fucked up");
        }
    }

    public Action getCurrentAction() {
        return currentAction;
    }

}
