package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;


public class CharacterFactory {

    public static Character createCharacter(String name, double constitution, double strength, double wisdow, Role role) {

        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);
        int magic = (int) Math.floor(Randomizer.rInt(10, 15) * wisdow);

        return new Character(name, hp, attack, magic, role);
    }

    public static Character createEnemy(String name, double constitution, double strength) {

        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);

        return new Character(name, hp, attack, 0, null);
    }
}
