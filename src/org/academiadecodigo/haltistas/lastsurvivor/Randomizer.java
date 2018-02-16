package org.academiadecodigo.haltistas.lastsurvivor;

import java.util.Random;

public class Randomizer {

    public static int rInt(int min, int max) {

        if (max < 0) {
            return 0;
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double rDouble(double min, double max) {

        double res;

        if (max < 0) {
            return 0;
        }
        Random r = new Random();
        res= min + (r.nextDouble() * ((max - min) + 1));

        return Math.round(res*100.0)/100.0;

    }


}
