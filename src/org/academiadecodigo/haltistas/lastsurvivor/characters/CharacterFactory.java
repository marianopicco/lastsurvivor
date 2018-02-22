package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;


public class CharacterFactory {

    private Role role;
    private double constitution;
    private double strength;
    private double wisdom;

    private int hp;
    private int attack;
    private int magic;

    public static Character createCharacter(String name, Role role) {

        double constitution = 0;
        double strength = 0;
        double wisdom = 0;

        if (role == Role.WARRIOR) {

            constitution = Randomizer.rDouble(7, 10);
            strength = Randomizer.rDouble(6, 8);
            wisdom = Randomizer.rDouble(1, 2);

        } else if (role == Role.WIZARD) {

            constitution = Randomizer.rDouble(4, 6);
            strength = Randomizer.rDouble(1, 2);
            wisdom = Randomizer.rDouble(6, 8);
        }

        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);
        int magic = (int) Math.floor(Randomizer.rInt(10, 15) * wisdom);

        return new Character(name, hp, attack, magic);
    }

    /*public static Character createCharacter(String name, double constitution, double strength, double wisdom, Role role) {

        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);
        int magic = (int) Math.floor(Randomizer.rInt(10, 15) * wisdom);

        return new Character(name, hp, attack, magic);
    }*/

    public static Character createEnemy(String name, double constitution, double strength) {

        int hp = (int) Math.floor(Randomizer.rInt(50, 70) * constitution);
        int attack = (int) Math.floor(Randomizer.rInt(10, 15) * strength);

        // Enemies don't have neither magic power or role
        return new Character(name, hp, attack, 0);
    }
}
