package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.haltistas.lastsurvivor.input.InputHandler;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;

public class Game {

    private final int PLAYER_PARTY_SIZE = 4;
    private final int ENEMIES_PER_LEVEL = 2;
    private InputHandler inputHandler;
    private Character[] enemies;
    private Character[] playerParty;
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


        //Temporary enemy for testing
        //@TODO remove temporary enemies

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = CharacterFactory.createCharacter("Baddie " + (i + 1), 1.23, 1);
        }

        playerParty[0] = CharacterFactory.createCharacter("Player", 1.8, 1.9);

    }

    public void start() throws InterruptedException {

        gameRunning = true;

        while (gameRunning) {

            // Checks if a key was pressed, or sleeps for 1000 ms

            if (keyPressed != null) {
                /* PLACEHOLDER -- Here, we should see something from the InputHandler, and act on it
                * Menu logic (be something like this)
                * menu.processKey( keyPressed );
                *
                * and should return something that tells the game what to do.
                * For now, all it can do is fight();
                */

                fight(playerParty[0], enemies[0]);
                receivedMenuChoice = true;
                Thread.sleep(800);


                keyPressed = null;

            }

            Thread.sleep(1000);
        }
    }

    public void receiveInput(KeyPress key) {

        if (keyPressed != null) {
            return;
        }

        keyPressed = key;

    }

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
        for (Character enemy : enemies) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            enemy.attack(playerParty, playerParty.length);
            System.out.println("\n");

        }

        receivedMenuChoice = false;
    }
}
