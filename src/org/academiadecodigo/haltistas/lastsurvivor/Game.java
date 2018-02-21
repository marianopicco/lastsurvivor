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

        int playerTarget = 0;

        while (gameRunning) {

            // Checks if a key was pressed, or sleeps for 1000 ms

            canvas.showActionMenu();

            if (keyPressed != null) {

                //TODO finish menu interaction

                canvas.receivedAction(keyPressed);

                if (canvas.getCurrentAction() != null) {

                    switch (canvas.getCurrentAction()) {

                        case ATTACK:

                            fight(playerParty[0], currentStage.getEnemies()[playerTarget]);
                            break;

                        case DEFEND:
                            break;

                        default:
                            System.out.println("JVM error");

                    }

                    canvas.hideActionMenu();
                    canvas.resetCurrentAction();
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

    // Fight is the only method for our characters right now

    private void fight(Character playerChar, Character enemyChar) {

        while (!receivedMenuChoice) {
            return;
        }


        //TODO handle exceptions correctly

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (enemyChar.isAlive()) {
            playerChar.attack(enemyChar);
            System.out.println("\n");
        }
        for (Character enemy : currentStage.getEnemies()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            enemy.attack(playerParty, playerParty.length);
            System.out.println("\n");

        }

        // Menu should reset so we can get a new command

        receivedMenuChoice = false;
    }

}
