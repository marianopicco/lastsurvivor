package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;

import java.util.LinkedList;
import java.util.NoSuchElementException;


public class Stage {

    private Character[] enemies;
    private int numEnemies;
    private Character enemyChar;

    public Stage(int numEnemies) {
        enemies = new Character[numEnemies];
        this.numEnemies = numEnemies;

        populateEnemies();

    }

    private void populateEnemies() {
        for (int i = 0; i < numEnemies; i++) {
            enemies[i] = CharacterFactory.createCharacter("Baddie " + (i + 1), 1, 1);
        }

    }

    public Character[] getEnemies() {
            return enemies;
    }

}
