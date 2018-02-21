package org.academiadecodigo.haltistas.lastsurvivor.input;

import org.academiadecodigo.haltistas.lastsurvivor.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private KeyboardEvent keyboardEvent;
    private Game game;

    public InputHandler(Game game) {

        this.game = game;

        keyboard = new Keyboard(this);


        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_UP);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                System.out.println("Key Up");
                game.receiveInput(KeyPress.UP);
                break;

            case KeyboardEvent.KEY_DOWN:
                System.out.println("Key Down");
                game.receiveInput(KeyPress.DOWN);
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println("Key Space");
                game.receiveInput(KeyPress.SPACE);
                break;
            default:
                System.out.println("Error");

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
