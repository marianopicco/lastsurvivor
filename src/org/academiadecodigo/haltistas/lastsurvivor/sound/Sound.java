package org.academiadecodigo.haltistas.lastsurvivor.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private Clip clip;
    private URL soundURL;

    public Sound(String path) {
        initClip(path);
    }

    /**
     * Plays the clip from the point it was stopped or from start if passed with the fromStart argument false or true
     * @param fromStart should be true if want to replay the sound from the start or false otherwise
     */
    public void play(boolean fromStart) {

        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {

        clip.stop();
    }

    public void close() {

        clip.close();
    }

    public int getLength(){return clip.getFrameLength();}

    public void loopIndef() {

        //sets loop points at start and end of track
        clip.setLoopPoints(0,(int)(getLength()*0.94));

        //activates loop
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void reOpen() {

        AudioInputStream inputStream = null;

        try {

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(inputStream);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initClip(String path) {

        soundURL = Sound.class.getResource(path); //if loading from jar
        AudioInputStream inputStream = null;

        try {

            if (soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                soundURL = file.toURI().toURL(); //if executing on intellij
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
