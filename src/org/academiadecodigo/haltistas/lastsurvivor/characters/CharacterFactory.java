package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;


public class CharacterFactory {

    public static Character createCharacter(String name, double constitution, double strength) {

        int hp = (int)Math.floor(Randomizer.rInt(50, 70)*constitution);
        int attack = (int)Math.floor(Randomizer.rInt(10, 15)*strength);


        return new Character(name, hp, attack);

    }

}
