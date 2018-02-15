package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;


public class CharacterFactory {



    public Character createCharacter(String name) {

        int randomLife = Randomizer.rInt(50, 70);
        int randomAttack = Randomizer.rInt(10, 15);

        return new Character(name, randomLife, randomAttack);


    }

}
