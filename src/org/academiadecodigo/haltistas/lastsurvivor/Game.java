package org.academiadecodigo.haltistas.lastsurvivor;

import org.academiadecodigo.haltistas.lastsurvivor.characters.CharacterFactory;
import org.academiadecodigo.haltistas.lastsurvivor.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private InputHandler inputHandler;
    private CharacterFactory characterFactory;
    private Canvas canvas;

    /**
     *  Game Class
     *  Game preparation and game logic should go here
     *
     */
    public void init(){

        inputHandler = new InputHandler();

        characterFactory = new CharacterFactory();

        canvas = new Canvas();

    }

    public void start(){

        canvas.draw();


    }



}
