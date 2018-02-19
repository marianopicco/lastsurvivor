package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.haltistas.lastsurvivor.input.InputHandler;

public class Game {

    private final int PLAYER_PARTY_SIZE = 4;
    private final int ENEMIES_PER_LEVEL = 2;
    private InputHandler inputHandler;
    private Character[] enemies;
    private Character[] playerParty;
    private Canvas canvas;

    private boolean playerTurn = true;

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

        playerParty[0] = CharacterFactory.createCharacter("Player", 1, 1.9);

    }

    public void receiveInput() throws InterruptedException {

        if (playerTurn) {
            playerTurn = false;
            fight(playerParty[0], enemies[0]);

        }
    }

    private void fight(Character playerChar, Character enemyChar) throws InterruptedException {


        Thread.sleep(2500);
        if (enemyChar.isAlive()) {
            playerChar.attack(enemyChar);
            System.out.println("\n");
        }
        for (Character enemy : enemies) {

            Thread.sleep(2500);
            enemy.attack(playerParty, playerParty.length);
            System.out.println("\n");

        }

        playerTurn = true;
    }




}
