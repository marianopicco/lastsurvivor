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
    private Action currentAction;
    private Ellipse goodGuy;
    private Ellipse evilGuy;


    private Position leftPosition;
    private Position rightPosition;

    public Canvas() {
        leftPosition = new Position(100, 250);
        rightPosition = new Position(800, 250);
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

        Menu statusMenu = new StatusMenu();
        Menu characterMenu = new CharacterMenu();
        actionMenu = new ActionMenu();

        statusMenu.draw();
        characterMenu.draw();

        actionMenu.instantiateStuff();

    }

    //TODO clear translate tests in receivedAction method
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

    public void showActionMenu() {
        actionMenu.draw();
    }

    public void hideActionMenu() {
        actionMenu.hide();
    }

    private void drawCharacters() {


        Ellipse evilGuy = new Ellipse(leftPosition.getPosX(), leftPosition.getPosY(), 100, 100);
        evilGuy.fill();

        Ellipse goodGuy = new Ellipse(rightPosition.getPosX(), rightPosition.getPosY(), 100, 100);
        goodGuy.draw();

        /* Pointer should be added when there is more than one enemy in the game
        Picture pointer = new Picture(evilGuy.getX(), evilGuy.getY(), "assets/bluediamond.png");
        pointer.draw();
        */

    }

    public void resetCurrentAction() {
        currentAction = null;

    }

    public class ActionMenu extends Menu {


        private final static int TEXT_PADDING_LEFT = 50;
        private final static int TEXT_PADDING = 23;

        private Position menuPos;
        private int actionPointer = 0;

        private Rectangle selectionBox;
        private Rectangle actionMenu;

        private Text attack;
        private Text magic;
        private Text defend;
        private Text item;

        private Position textPos1;
        private Position textPos2;
        private Position textPos3;
        private Position textPos4;


        ActionMenu() {
            currentAction = null;
            menuPos = new Position(super.menuWidth() / 2, super.menuY() + 10);

            double leftPadding = menuPos.getPosX() + TEXT_PADDING_LEFT;

            // Text starts at background position, then increases relating to the previous text
            textPos1 = new Position(leftPadding, this.menuPos.getPosY() + TEXT_PADDING);
            textPos2 = new Position(leftPadding, textPos1.getPosY() + TEXT_PADDING);
            textPos3 = new Position(leftPadding, textPos2.getPosY() + TEXT_PADDING);
            textPos4 = new Position(leftPadding, textPos3.getPosY() + TEXT_PADDING);
        }

        @Override
        public void draw() {

            actionMenu.fill();

            selectionBox.draw();

            attack.draw();
            magic.draw();
            defend.draw();
            item.draw();
        }

        void hide() {
            hideAction();
        }

        void instantiateStuff() {

            actionMenu = new Rectangle(this.menuPos.getPosX(), this.menuPos.getPosY(), 250, 130);
            actionMenu.setColor(Color.CYAN);

            attack = new Text(textPos1.getPosX(), textPos1.getPosY(), Action.ATTACK.getAction());
            defend = new Text(textPos3.getPosX(), textPos3.getPosY(), Action.DEFEND.getAction());
            magic = new Text(textPos2.getPosX(), textPos2.getPosY(), Action.MAGIC.getAction());
            item = new Text(textPos4.getPosX(), textPos4.getPosY(), Action.ITEMS.getAction());

            selectionBox = new Rectangle(textPos1.getPosX(), textPos1.getPosY(), 60, 20);

        }

        void hideAction() {

            actionMenu.delete();

            selectionBox.delete();

            attack.delete();
            magic.delete();
            defend.delete();
            item.delete();
        }

        void moveDown() {

            actionPointer++;

            if (actionPointer == Action.values().length) {
                selectionBox.translate(0, -(Action.values().length * TEXT_PADDING));
                actionPointer = 0;
            }

            selectionBox.translate(0, TEXT_PADDING);

        }

        void moveUp() {

            if (actionPointer == 0) {
                selectionBox.translate(0, (Action.values().length * TEXT_PADDING));
                actionPointer = Action.values().length;
            }

            actionPointer--;
            selectionBox.translate(0, -TEXT_PADDING);
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


    public class CharacterMenu extends Menu {

        private Position charmMenuPos;
        private int initialPositionX = Canvas.PADDING + 10;
        private int initialPositionY = 580;

        CharacterMenu() {

            charmMenuPos = new Position(initialPositionX, initialPositionY);
            Rectangle leftMenu = new Rectangle(menuX(), menuY(), menuWidth(), menuHeight());
            leftMenu.fill();
            leftMenu.setColor(Color.RED);

            textCharacter();
        }

        double menuX() {
            return charmMenuPos.getPosX();
        }

        void textCharacter() {
            Text name = new Text(initialPositionX, initialPositionY, "WARRIOR");
            name.draw();

        }

    }

    private class Position {

        private double posX;
        private double posY;

        Position(double x, double y) {
            posX = x;
            posY = y;

        }

        public double getPosX() {
            return posX;
        }

        public double getPosY() {
            return posY;
        }

    }

}

