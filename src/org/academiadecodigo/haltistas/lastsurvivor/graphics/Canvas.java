package org.academiadecodigo.haltistas.lastsurvivor.graphics;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
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

    private StatusMenu statusMenu;

    private Position leftPosition;
    private Position rightPosition;

    private Picture evilGuy;
    private Picture goodGuy;
    private Picture magicAttack;

    private Text damage;

    public Canvas() {

        leftPosition = new Position(100, 250);
        rightPosition = new Position(800, 250);
        magicAttack = new Picture(rightPosition.getPosX(), rightPosition.getPosY(), "assets/magic.png");

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

        Picture pic = new Picture(PADDING, PADDING, "assets/background.jpg");
        pic.draw();

    }

    private void createMenu() {

        statusMenu = new StatusMenu();
        Menu characterMenu = new CharacterMenu();
        actionMenu = new ActionMenu();

        statusMenu.draw();
        characterMenu.draw();

        actionMenu.instantiateStuff();

        damage = new Text(20, 20, "");
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

    public void drawMagicAttack() {
        magicAttack.draw();
    }

    public void translateMagic(Picture target) throws InterruptedException {
        while (magicAttack.getX() > target.getX() + 100) {
            magicAttack.translate(-3, 0);
            Thread.sleep(1);
        }
        magicAttack.delete();

        while (magicAttack.getX() < 800) {
            magicAttack.translate(3, 0);
            Thread.sleep(1);
        }

    }

    private void drawCharacters() {

        evilGuy = new Picture(leftPosition.getPosX(), leftPosition.getPosY(), "assets/buzzilisk.png");
        evilGuy.draw();

        goodGuy = new Picture(rightPosition.getPosX(), rightPosition.getPosY(), "assets/supergranny.png");
        goodGuy.draw();

        /* Pointer should be added when there is more than one enemy in the game
        Picture pointer = new Picture(evilGuy.getX(), evilGuy.getY(), "assets/littlearrow.png");
        pointer.draw();
        */
    }

    // The argument may change

    public void translateCharacter(Picture attacker, Picture target) throws InterruptedException {

        if (attacker.getX() > 500) {

            while (attacker.getX() > target.getX() + 100) {
                attacker.translate(-3, 0);
                Thread.sleep(1);
            }

            while (attacker.getX() < 800) {
                attacker.translate(3, 0);
                Thread.sleep(1);
            }

        } else {

            while (attacker.getX() < target.getX() - 100) {
                attacker.translate(3, 0);
                Thread.sleep(1);
            }

            while (attacker.getX() > 100) {
                attacker.translate(-3, 0);
                Thread.sleep(1);
            }
        }
    }

    public void resetCurrentAction() {
        currentAction = null;

    }

    public void showHitPoints(int hp, int maxHp) {
        statusMenu.showHitPoints(hp, maxHp);
    }

    public void showDamage(int damage) {

        this.damage.setText(" " + damage);
        this.damage.draw();
    }

    public void clearDamageDealt() {
        this.damage.delete();
    }

    public Picture getEvilGuy() {
        return evilGuy;
    }

    public Picture getGoodGuy() {
        return goodGuy;
    }

    public class ActionMenu extends Menu {


        private final static int TEXT_PADDING_LEFT = 50;
        private final static int TEXT_PADDING = 23;

        private Position menuPos;
        private int actionPointer = 0;

        private Picture selectionPointer;
        private Picture actionMenu;

        private Picture attack;
        private Picture magic;
        private Picture defend;
        private Picture item;

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

            actionMenu.draw();
            selectionPointer.draw();

            attack.draw();
            magic.draw();
            defend.draw();
            item.draw();
        }

        void hide() {
            hideAction();
        }

        void instantiateStuff() {

            actionMenu = new Picture(this.menuPos.getPosX(), this.menuPos.getPosY(), "assets/actionframe.png");

            attack = new Picture(textPos1.getPosX(), textPos1.getPosY(), "assets/attackWord.png");
            magic = new Picture(textPos2.getPosX(), textPos2.getPosY(), "assets/magicWORD.png");
            defend = new Picture(textPos3.getPosX(), textPos3.getPosY(), "assets/defendWORD.png");
            item = new Picture(textPos4.getPosX(), textPos4.getPosY(), "assets/itemsWORD.png");

            selectionPointer = new Picture(textPos1.getPosX(), textPos1.getPosY(), "assets/littlearrow.png");

        }

        void hideAction() {

            actionMenu.delete();

            selectionPointer.delete();

            attack.delete();
            magic.delete();
            defend.delete();
            item.delete();
        }

        void moveDown() {

            actionPointer++;

            if (actionPointer == Action.values().length) {
                selectionPointer.translate(0, -(Action.values().length * TEXT_PADDING));
                actionPointer = 0;
            }

            selectionPointer.translate(0, TEXT_PADDING);

        }

        void moveUp() {

            if (actionPointer == 0) {
                selectionPointer.translate(0, (Action.values().length * TEXT_PADDING));
                actionPointer = Action.values().length;
            }

            actionPointer--;
            selectionPointer.translate(0, -TEXT_PADDING);
        }

        void actionSelection() {

            switch (actionPointer) {

                case 0:
                    currentAction = Action.ATTACK;
                    break;
                case 1:
                    currentAction = Action.MAGIC;
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
        private int initialPositionX = Canvas.PADDING;
        private int initialPositionY = 580;

        CharacterMenu() {

            charmMenuPos = new Position(initialPositionX, initialPositionY);
            Picture leftMenu = new Picture(menuX(), menuY(), "assets/characterframe.png");
            leftMenu.draw();
            textCharacter();

        }

        double menuX() {
            return charmMenuPos.getPosX();
        }

        void textCharacter() {

            Picture name = new Picture(initialPositionX, initialPositionY, "assets/supergrannyname.png");
            name.draw();
        }
    }

    public class StatusMenu extends Menu {

        private final static int INNER_PADDING = 80;

        private Position statusMenuPos;
        private int initialPositionX = BACKGROUND_WIDTH / 2 + 10;
        private int initialPositionY = 580;

        private Position hitPointsPos;

        private Text hitPoints;

        StatusMenu() {

            statusMenuPos = new Position(initialPositionX, initialPositionY);
            Picture rightMenu = new Picture(menuX(), menuY(), "assets/statusframe.png");
            rightMenu.draw();

            double innerPadding = statusMenuPos.getPosX() + INNER_PADDING;

            hitPointsPos = new Position(innerPadding, statusMenuPos.getPosY());

            hitPoints = new Text(hitPointsPos.getPosX(), hitPointsPos.getPosY(), "");
            hitPoints.grow(10, 5);
        }

        double menuX() {
            return statusMenuPos.getPosX();
        }

        @Override
        public void draw() {
        }

        private void showHitPoints(int hp, int maxHitPoints) {

            this.hitPoints.setText(hp + " / " + maxHitPoints);
            this.hitPoints.draw();
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

