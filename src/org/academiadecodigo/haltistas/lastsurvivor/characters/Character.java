package org.academiadecodigo.haltistas.lastsurvivor.characters;

import org.academiadecodigo.haltistas.lastsurvivor.interfaces.Drawable;

public class Character implements Drawable {

    private int hp;
    private int baseAttack;
    private boolean isAlive;

    public Character(int hp, int baseAttack) {
        this.hp = hp;
        this.baseAttack = baseAttack;

    }

    public void attack(Character target){

        target.getHit(baseAttack);

    }

    private void getHit(int damage) {

        hp -= hp - damage;

        if ( hp <= 0 ) {
            this.toggleAlive();
        }

    }

    public void toggleAlive(){
        isAlive = !isAlive;

    }

    @Override
    public void draw() {

    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }



}
