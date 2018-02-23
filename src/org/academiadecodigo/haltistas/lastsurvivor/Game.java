package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.Character;
import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.characters.Role;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.haltistas.lastsurvivor.input.InputHandler;
import org.academiadecodigo.haltistas.lastsurvivor.input.KeyPress;
import org.academiadecodigo.haltistas.lastsurvivor.sound.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final int PLAYER_PARTY_SIZE = 3;

    private Character[] playerParty;
    private Stage stage;
    private Canvas canvas;
    private KeyPress keyPressed;
    private Sound sound;

    private int playerTarget = 0;
    private int currentStage;
    private int score;


    /**
     * Game Class
     * Game preparation and game logic should go here
     */
    public void init() {

        currentStage = 1;
        canvas = new Canvas();

        InputHandler inputHandler = new InputHandler(this);

        playerParty = new Character[PLAYER_PARTY_SIZE];

        // Current party only has one character, expandable in the future

        playerParty[0] = CharacterFactory.createCharacter("Player", Role.WARRIOR);
        //playerParty[0] = CharacterFactory.createCharacter("Player", Role.WIZARD);

        characterStats();

        stage = new Stage(1, currentStage);

        sound = new Sound("/assets/EyeOfTheTiger8Bit.wav");
    }

    /**
     * Game start
     * Logic for processing the turns, and declaring game over
     */

    public void start() {

        int currentKills = 0;
        int currentPlayer = 0;
        score = 0;
        sound.loopIndef();

        try {

            // TODO: 22/02/18 needed to see while condition when more than one character on party

            while (playerParty[currentPlayer].isAlive()) {

                canvas.drawScore(score);

                canvas.showActionMenu();

                if (keyPressed != null) {

                    canvas.receivedAction(keyPressed);

                    if (canvas.getCurrentAction() != null) {

                        playerTurn(currentPlayer);

                        canvas.hideActionMenu();
                        canvas.resetCurrentAction();

                        enemyTurn();
                        characterStats();
                    }

                    keyPressed = null;
                }

                if (!stage.getEnemies()[playerTarget].isAlive()) {
                    score += (currentStage * 100);

                    if (currentKills == 4) {
                        currentStage++;
                        currentKills = 0;
                    } else {
                        currentKills++;
                    }

                    canvas.getEvilGuy().delete();

                    Thread.sleep(1500);

                    newStage();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            gameOver();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public void receiveInput(KeyPress key) {

        if (keyPressed != null) {
            return;
        }

        keyPressed = key;
    }

    private void playerTurn(int playerIndex) throws InterruptedException {

        switch (canvas.getCurrentAction()) {

            case ATTACK:
                canvas.translateCharacter(canvas.getGoodGuy(), canvas.getEvilGuy());
                playerParty[playerIndex].attack(stage.getEnemies()[playerTarget]);
                showDamage(playerParty[playerIndex]);
                break;

            case MAGIC:
                if (score >= 50) {
                    score -= 50;
                    canvas.drawMagicAttack();
                    canvas.translateMagic(canvas.getEvilGuy());
                    playerParty[playerIndex].magicAttack(stage.getEnemies()[playerTarget]);
                    showDamage(playerParty[playerIndex]);
                }

                break;

            case DEFEND:
                playerParty[playerIndex].setDefending(true);
                break;

            case ITEMS:
                if (score >= 100) {
                    score -= 100;
                    playerParty[playerIndex].heal();
                }
                break;

            default:
                System.out.println("JVM error");
        }
    }

    private void enemyTurn() throws InterruptedException {

        if (!stage.getEnemies()[playerTarget].isAlive()) {
            return;
        }

        for (Character enemy : stage.getEnemies()) {

            canvas.translateCharacter(canvas.getEvilGuy(), canvas.getGoodGuy());
            enemy.attack(playerParty, playerParty.length);
            showDamage(enemy);

            playerParty[0].setDefending(false);

            System.out.println("\n");
        }

    }

    private void characterStats() {

        canvas.showHitPoints(playerParty[0].getHp(), playerParty[0].getMaxHp());
    }

    private void showDamage(Character character) throws InterruptedException {

        if (character == playerParty[0]) {

            canvas.showDamage(canvas.getGoodGuy(), playerParty[0].getDamage());

            Thread.sleep(500);

            canvas.clearDamageDealt();
            return;
        }

        if (playerParty[0].isDefending()) {
            canvas.showDamage(canvas.getEvilGuy(), stage.getEnemies()[playerTarget].getDamage() / 2);

        } else {
            canvas.showDamage(canvas.getEvilGuy(), stage.getEnemies()[playerTarget].getDamage());
        }

        Thread.sleep(500);

        canvas.clearDamageDealt();
    }

    private void newStage() {

        stage = new Stage(1, currentStage);
        canvas.newEnemy();
        canvas.getEvilGuy().draw();
    }

    private void gameOver() throws InterruptedException {

        Picture gameOver = new Picture(10, 10, "assets/gameover.jpg");
        gameOver.draw();

        Text finalScore = new Text(500, 600, "FINAL SCORE: " + score);
        finalScore.setColor(Color.BLACK);
        finalScore.grow(250, 50);
        finalScore.draw();

        Thread.sleep(5000);

        System.exit(0);
    }


}
