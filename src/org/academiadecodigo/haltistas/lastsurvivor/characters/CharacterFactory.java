package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;


public class CharacterFactory {



    public Character createCharacter(String name, double constitution, double strength) {

        int randomLife = (int)Math.floor(Randomizer.rInt(50, 70)*constitution);
        int randomAttack = (int)Math.floor(Randomizer.rInt(10, 15)*strength);

        return new Character(name, randomLife, randomAttack);


    }

}
