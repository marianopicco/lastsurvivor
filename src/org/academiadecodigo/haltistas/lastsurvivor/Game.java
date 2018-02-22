package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.characters.Role;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.haltistas.lastsurvivor.input.InputHandler;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final int PLAYER_PARTY_SIZE = 3;
    private final int ENEMIES_PER_LEVEL = 3;

    private InputHandler inputHandler;
    private Character[] enemies;
    private Character[] playerParty;
    private Stage currentStage;
    private Canvas canvas;
    private boolean gameRunning;
    private KeyPress keyPressed;
    private boolean isPlayerTurn;

    private int playerTarget = 0;

    /**
     * Game Class
     * Game preparation and game logic should go here
     */
    public void init() {

        canvas = new Canvas();

        inputHandler = new InputHandler(this);

        enemies = new Character[ENEMIES_PER_LEVEL];
        playerParty = new Character[PLAYER_PARTY_SIZE];

        // Current party only has one character, expandable in the future

        playerParty[0] = CharacterFactory.createCharacter("Player", 3, 4, 1, Role.WARRIOR);
        //playerParty[0] = CharacterFactory.createCharacter("Player", 2, 1, 4, Role.WIZARD);
        
        characterStats();

        currentStage = new Stage(1);
    }

    public void start() {

        gameRunning = true;

        // Player is now targeting enemies sequentially until the menu is working

        //int playerTarget = 0;

        // TODO: 22/02/18 needed to see while condition when more than one character on party
        while (playerParty[0].isAlive()) {

            // Checks if a key was pressed, or sleeps for 1000 ms

            canvas.showActionMenu();

            if (keyPressed != null) {

                canvas.receivedAction(keyPressed);

                if (canvas.getCurrentAction() != null) {

                    playerTurn();

                    canvas.hideActionMenu();
                    canvas.resetCurrentAction();

                    if (!currentStage.getEnemies()[playerTarget].isAlive()) {

                        canvas.getEvilGuy().delete();

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        newStage();
                        continue;
                    }

                    enemyTurn();
                    characterStats();
                }

                keyPressed = null;
            }
        }

        gameOver();
    }

    public void receiveInput(KeyPress key) {

        if (keyPressed != null) {
            return;
        }

        keyPressed = key;
    }

    private void playerAttack(Character playerChar, Character enemyChar) {

        //TODO handle exceptions correctly

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (enemyChar.isAlive()) {
            playerChar.attack(enemyChar);
            System.out.println("\n");
        }

    }

    private void playerTurn() {

        switch (canvas.getCurrentAction()) {

            case ATTACK:

                try {
                    canvas.translateCharacter(canvas.getGoodGuy(), canvas.getEvilGuy());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                playerAttack(playerParty[0], currentStage.getEnemies()[playerTarget]);
                showDamage(playerParty[0]);
                break;

            case MAGIC:

                try {
                    canvas.drawMagicAttack();
                    canvas.translateMagic(canvas.getEvilGuy());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                playerAttack(playerParty[0], currentStage.getEnemies()[playerTarget]);
                showDamage(playerParty[0]);
                break;

            case DEFEND:

                playerParty[0].setDefending(true);
                break;

            default:
                System.out.println("JVM error");
        }
    }

    private void enemyTurn() {

        for (Character enemy : currentStage.getEnemies()) {

            try {
                canvas.translateCharacter(canvas.getEvilGuy(), canvas.getGoodGuy());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            enemy.attack(playerParty, playerParty.length);
            showDamage(enemy);

            System.out.println("\n");
        }

        isPlayerTurn = false;
    }

    private void characterStats() {

        canvas.showHitPoints(playerParty[0].getHp(), playerParty[0].getMaxHp());
    }

    private void showDamage(Character character) {

        if (character == playerParty[0]) {

            canvas.showDamage(playerParty[0].getDamage());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            canvas.clearDamageDealt();
            return;
        }

        canvas.showDamage(currentStage.getEnemies()[playerTarget].getDamage());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        canvas.clearDamageDealt();
    }

    private void newStage() {

        currentStage = new Stage(1);
        canvas.getEvilGuy().draw();
    }

    private void gameOver() {

        Picture gameover = new Picture(10, 10, "assets/gameover.png");
        gameover.draw();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
