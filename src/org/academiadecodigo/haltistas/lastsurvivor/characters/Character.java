package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.Randomizer;
import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;

public class Character implements Drawable {

    private String name;
    private int hp;
    private int maxHp;
    private int baseAttack;
    private int baseMagic;
    private int realDamage;
    private boolean isAlive;
    private boolean isDefending;

    public Character(String name, int hp, int baseAttack, int baseMagic) {

        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.baseAttack = baseAttack;
        this.baseMagic = baseMagic;
        this.isAlive = true;
        this.isDefending = false;

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

        while (target == null) {

            int random = Randomizer.rInt(0, numberOfEnemies - 1);

            if (enemies[random] == null) {
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

        target.getHit(realDamage());
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

        target.getHit(realDamage());
    }

    public void magicAttack(Character target) {

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

        target.getHit(baseMagic);
    }

    private void getHit(int damage) {

        // @TODO remove souts after testing

        if (isDefending) {
            damage = damage / 2;
        }

        hp = hp - damage;

        System.out.println(name + ": Getting hit for " + damage);

        if (hp <= 0 && isAlive) {
            hp = 0;
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

    public void heal() {
        int healing = Randomizer.rInt(40, 75);
        hp += healing;

        if (hp >= maxHp){
            hp = maxHp;
        }

    }

    private int realDamage() {

        realDamage = baseAttack + Randomizer.rInt(-2, 2);
        return realDamage;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", baseAttack=" + baseAttack +
                ", baseMagic=" + baseMagic +
                ", isAlive=" + isAlive +
                '}';
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDamage() {
        return realDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDefending(boolean defending) {

        System.out.println(name + ": I'm defending!");
        isDefending = defending;
    }

    public boolean isDefending() {
        return isDefending;
    }
}
