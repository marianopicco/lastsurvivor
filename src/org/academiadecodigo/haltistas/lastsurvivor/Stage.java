package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;

public class Stage {

    private Character[] enemies;
    private int numEnemies;

    public Stage(int numEnemies, int stageDifficulty) {

        enemies = new Character[numEnemies];
        this.numEnemies = numEnemies;

        populateEnemies(stageDifficulty);
    }

    private void populateEnemies(int stageDifficulty) {

        double constitution = 1 + (stageDifficulty / 2);
        double strength = 1 + (stageDifficulty / 2);

        for (int i = 0; i < numEnemies; i++) {
            enemies[i] = CharacterFactory.createEnemy("Baddie " + (i + 1), constitution, strength);

        }
    }

    public Character[] getEnemies() {
            return enemies;

    }
}
