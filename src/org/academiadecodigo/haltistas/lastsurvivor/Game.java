package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;

public class Game {

    private final int PLAYER_PARTY_SIZE = 4;
    private final int ENEMIES_PER_LEVEL = 4;
    private InputHandler inputHandler;
    private Character[] enemies;
    private Character[] playerParty;
    private CharacterFactory characterFactory;
    private Canvas canvas;

    /**
     * Game Class
     * Game preparation and game logic should go here
     */
    public void init() {

        inputHandler = new InputHandler();

        characterFactory = new CharacterFactory();

        canvas = new Canvas();

        enemies = new Character[ENEMIES_PER_LEVEL];
        playerParty = new Character[PLAYER_PARTY_SIZE];

    }

    public void start() throws InterruptedException {

        canvas.draw();

        //Temporary enemy for testing
        //@TODO remove temporary enemies

        for (int i = 0; i < enemies.length ; i++) {
            enemies[i] = characterFactory.createCharacter("Baddie " + (i+1), 1.23, 1);
        }

        playerParty[0] = characterFactory.createCharacter("Player",1,1.9);
        playerParty[1] = characterFactory.createCharacter("John",1.5,1.1);

        for (int i = 0; i < 5; i++) {

            for (Character enemy : enemies) {

                Thread.sleep(2500);
                if (enemy.isAlive()) {
                    playerParty[0].attack(enemies, enemies.length);
                    System.out.println("\n");
                }

                Thread.sleep(2500);
                enemy.attack(playerParty, playerParty.length);
                System.out.println("\n");

            }

        }

    }


}
