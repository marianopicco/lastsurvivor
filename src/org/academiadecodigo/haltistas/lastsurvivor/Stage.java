package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;



public class Stage {

    private Character[] enemies;
    private Character[] playerParty;
    private int numEnemies;

    public Stage(int numEnemies) {
        if(numEnemies>3 || numEnemies<=0){
            System.out.println("Pick a number of enemies between 1 and 3");
            return;
        }
        this.numEnemies = numEnemies;
        this.enemies = new Character[numEnemies];


        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = CharacterFactory.createCharacter("Baddie " + (i + 1), 1.23, 1);
        }
/*
        if(.isDead ){
            numEnemies--;
        } */


    }

    //geter enemie live




}

