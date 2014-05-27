package fr.insarouen.asi.minigimp;

import java.util.*;
import java.awt.Color;

public class Utilitaires {
    private static Random alea = new Random();

    public static int getIntAlea_1_Max(int max) {
	return 1+Math.abs( alea.nextInt() ) % max;
    }

    public static Color randomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return new Color(r, g, b).brighter();
    }
}
