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
        canvas.draw();

        inputHandler = new InputHandler(this);


        enemies = new Character[ENEMIES_PER_LEVEL];
        playerParty = new Character[PLAYER_PARTY_SIZE];

        // Current party only has one character, expandable in the future

        playerParty[0] = CharacterFactory.createCharacter("Player", 3, 4);

        currentStage = new Stage(3);
    }

    public void start() throws InterruptedException {

        gameRunning = true;

        // Player is now targeting enemies sequentially until the menu is working

        int playerTarget = 0;

        while (gameRunning) {

            // Checks if a key was pressed, or sleeps for 1000 ms

            if (keyPressed != null) {

                //TODO add menu interaction
                /* PLACEHOLDER -- Here, we should see something from the InputHandler, and act on it
                * Menu logic (be something like this)
                * menu.processKey( keyPressed );
                *
                * and should return something that tells the game what to do.
                * For now, all it can do is fight();
                */

                fight(playerParty[0], currentStage.getEnemies()[playerTarget]);

                // Attack current target till it dies then get the next

                if (!currentStage.getEnemies()[playerTarget].isAlive()) {

                    playerTarget++;
                    if (playerTarget >= ENEMIES_PER_LEVEL) {
                        System.out.println("Game over for this level, all enemies dead.");
                        gameRunning = false;
                        currentStage = new Stage(3);
                    }
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
