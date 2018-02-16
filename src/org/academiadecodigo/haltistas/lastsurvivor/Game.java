package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;

public class Game {

    private InputHandler inputHandler;
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


    }

    public void start() {

        canvas.draw();

        //Temporary enemy for testing
        //@TODO remove temporary enemies
        Character tempEnemy = characterFactory.createCharacter("Baddie");
        Character playerCharacter = characterFactory.createCharacter("Player");

        for (int i = 0; i < 5; i++) {

            if (tempEnemy.isAlive()) {
                playerCharacter.attack(tempEnemy);
            }
            tempEnemy.attack(playerCharacter);
        }

    }


}
