package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.graphics.menus.*;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas implements Drawable {

    public final static int PADDING = 10;
    public final static int BACKGROUND_WIDTH = 1000;
    public final static int BACKGROUND_HEIGHT = 700;

    private ActionMenu actionMenu;
    private Menu statusMenu;
    private Menu characterMenu;
    private Action currentAction;


    public Canvas() {
        draw();
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
                actionMenu.moveUp();
                break;
            case DOWN:
                actionMenu.moveDown();
                break;
            case SPACE:
                actionMenu.actionSelection();
                break;
            default:
                System.out.println("JVM fucked up");
        }

    }

    public Action getCurrentAction() {
        return currentAction;
    }

    //    public Action playerChoice() {
//
//        Action thisAction = actionMenu.getCurrentAction();
//
//        actionMenu.resetCurrentAction();
//
//        return thisAction;
//    }

    void drawCharacters() {

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

    public void resetCurrentAction() {
        currentAction = null;
    }

    public class ActionMenu extends Menu {

        private final static int INITIAL_POSITION_X = 260;
        private final static int SELECTION_MOVE_X = 0;
        private final static int SELECTION_MOVE_Y = 20;

        private int initialPositionY = menuY() + 10;
        private int actionPointer = 0;
        private Rectangle selectionBox;


        ActionMenu() {

            Rectangle actionMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
            actionMenu.fill();
            actionMenu.setColor(Color.CYAN);
            currentAction = null;
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

        void drawAction() {

            Text attack = new Text(INITIAL_POSITION_X, initialPositionY, Action.ATTACK.getAction());
            Text magic = new Text(INITIAL_POSITION_X, menuY() + 30, Action.MAGIC.getAction());
            Text defend = new Text(INITIAL_POSITION_X, menuY() + 50, Action.DEFEND.getAction());
            Text item = new Text(INITIAL_POSITION_X, menuY() + 70, Action.ITEMS.getAction());

            selectionBox = new Rectangle(INITIAL_POSITION_X, initialPositionY, 60, 20);
            selectionBox.draw();

            attack.draw();
            magic.draw();
            defend.draw();
            item.draw();
        }

        void moveDown() {

            actionPointer++;

            if (actionPointer == Action.values().length) {
                selectionBox.translate(SELECTION_MOVE_X, -80);
                actionPointer = 0;
            }

            selectionBox.translate(SELECTION_MOVE_X, SELECTION_MOVE_Y);

        }

        void moveUp() {

            if (actionPointer == 0) {
                selectionBox.translate(SELECTION_MOVE_X, 80);
                actionPointer = Action.values().length;
            }

            actionPointer--;
            selectionBox.translate(SELECTION_MOVE_X, -SELECTION_MOVE_Y);
        }

        void actionSelection() {

            switch (actionPointer) {

                case 0:
                    currentAction = Action.ATTACK;
                    break;
                case 1:
                    //call class EnemySelection
                    break;
                case 2:
                    currentAction = Action.DEFEND;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("JVM fucked up");
            }
        }


    }

}
