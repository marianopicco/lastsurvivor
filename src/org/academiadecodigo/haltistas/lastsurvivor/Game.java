package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.haltistas.lastsurvivor.input.InputHandler;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;

public class Game {

    private final int PLAYER_PARTY_SIZE = 3;
    private final int ENEMIES_PER_LEVEL = 3;

    private InputHandler inputHandler;
    private Character[] enemies;
    private Character[] playerParty;
    private Stage currentStage;
    private Canvas canvas;
    private boolean gameRunning;
    private boolean receivedMenuChoice;
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

        playerParty[0] = CharacterFactory.createCharacter("Player", 3, 4);

        currentStage = new Stage(1);
    }

    public void start() throws InterruptedException {

        gameRunning = true;

        // Player is now targeting enemies sequentially until the menu is working

        //int playerTarget = 0;

        while (gameRunning) {

            // Checks if a key was pressed, or sleeps for 1000 ms

            canvas.showActionMenu();

            if (keyPressed != null) {

                //TODO finish menu interaction

                canvas.receivedAction(keyPressed);

                if (canvas.getCurrentAction() != null) {

                    playerTurn();

                    canvas.hideActionMenu();
                    canvas.resetCurrentAction();

                    enemyTurn();
                }

                receivedMenuChoice = true;
                Thread.sleep(500);

                keyPressed = null;

            }

            Thread.sleep(500);
        }
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

        // Menu should reset so we can get a new command

        receivedMenuChoice = false;
    }

    private void playerTurn() {

        switch (canvas.getCurrentAction()) {

            case ATTACK:
                playerAttack(playerParty[0], currentStage.getEnemies()[playerTarget]);
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            enemy.attack(playerParty, playerParty.length);
            System.out.println("\n");
        }

        isPlayerTurn = false;
    }
}
