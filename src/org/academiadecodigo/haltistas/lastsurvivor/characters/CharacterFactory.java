package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CharacterFactory {

    public static Character createCharacter(String name, Role role) {

        double constitution = 0;
        double strength = 0;
        double wisdom = 0;

        switch (role) {
            case WARRIOR:
                constitution = Randomizer.rDouble(4, 6);
                strength = Randomizer.rDouble(3, 6);
                wisdom = Randomizer.rDouble(1, 2);
                break;
            case WIZARD:
                constitution = Randomizer.rDouble(2, 4);
                strength = Randomizer.rDouble(1, 2);
                wisdom = Randomizer.rDouble(4, 6);
                break;
            case HEALER:
                // Not implemented
                break;
            default:
                System.out.println("Error in CharacterCreator");

        }


        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);
        int magic = (int) Math.floor(Randomizer.rInt(10, 15) * wisdom);

        return new Character(name, hp, attack, magic);
    }

    public static Character createEnemy(String name, double constitution, double strength) {

        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);

        // Enemies don't have neither magic power or role
        return new Character(name, hp, attack, 0);
    }

    public static Picture getEnemyPicture(double x, double y) {

        int r = Randomizer.rInt(0, CharacterPictures.values().length - 1);
        System.out.println(r);
        System.out.println(CharacterPictures.values()[r]);
        return new Picture(x, y, CharacterPictures.values()[r].getFilePath());

    }
}
