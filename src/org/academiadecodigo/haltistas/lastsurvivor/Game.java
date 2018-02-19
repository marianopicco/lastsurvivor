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
    private boolean receivedMenuChoice;
    private KeyPress keyPressed;

    /**
     * Game Class
     * Game preparation and game logic should go here
     */
    public void init() {

        inputHandler = new InputHandler(this);

        canvas = new Canvas();

        enemies = new Character[ENEMIES_PER_LEVEL];
        playerParty = new Character[PLAYER_PARTY_SIZE];

        canvas.draw();

        //Temporary enemy for testing
        //@TODO remove temporary enemies

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = CharacterFactory.createCharacter("Baddie " + (i + 1), 1.23, 1);
        }

        playerParty[0] = CharacterFactory.createCharacter("Player", 1.8, 1.9);

    }

    public void start() throws InterruptedException {

        while(true) {

            if (keyPressed != null){
                //logica();
                receivedMenuChoice = true;
                System.out.println("pressed");
                fight(playerParty[0], enemies[0]);
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

        /*
        // Game needs to talk to the menu depending on which key was pressed:
        switch (key) {
            case UP:
                break;
            case DOWN:
                break;
            case SPACE:
                 break;
            default:
                break;

        }
*/
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
