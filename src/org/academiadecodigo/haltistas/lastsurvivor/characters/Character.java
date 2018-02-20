package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;

public class Character implements Drawable {

    private String name;
    private int hp;
    private int baseAttack;
    private boolean isAlive;

    public Character(String name, int hp, int baseAttack) {
        this.name = name;
        this.hp = hp;
        this.baseAttack = baseAttack;
        this.isAlive = true;

        // Souts for testing
        // @TODO remove souts after testing

        System.out.println("Created character " + name + " with " + hp + " hp.\n");
    }

    public void attack(Character[] enemies, int numberOfEnemies) {
        Character target = null;

        // Souts for testing
        // @TODO remove the souts after testing


        if (!this.isAlive) {
            return;
        }

        while (target == null)  {

            int random = Randomizer.rInt(0, numberOfEnemies-1);

            if (enemies[random] == null){
                continue;
            }

            if (enemies[random].isAlive()) {
                target = enemies[random];
            }

        }

        if (!target.isAlive) {
            System.out.println(name + ": Target is dead\n");
            return;
        }

        System.out.println(name + ": I'm attacking " + target);

        target.getHit(baseAttack);

    }

    public void attack(Character target) {

        // Souts for testing
        // @TODO remove the souts after testing


        if (!this.isAlive) {
            return;
        }

        if (!target.isAlive) {
            System.out.println(name + ": Target is dead\n");
            return;
        }

        System.out.println(name + ": I'm attacking " + target);

        target.getHit(baseAttack);

    }

    private void getHit(int damage) {

        // Souts for testing
        // @TODO remove souts after testing


        hp = hp - damage;

        if (hp <= 0 && isAlive) {
            this.toggleAlive();
            System.out.println(this + " dead.\n");
        }


    }

    public void toggleAlive() {
        isAlive = !isAlive;

    }

    @Override
    public void draw() {

    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", baseAttack=" + baseAttack +
                ", isAlive=" + isAlive +
                '}';
    }

    public boolean isAlive() {
        return isAlive;
    }

}
