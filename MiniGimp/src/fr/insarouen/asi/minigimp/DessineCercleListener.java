package fr.insarouen.asi.minigimp;

import java.awt.*;
import java.awt.event.*;

// TODO Listener qui modifie les données (dessinables) lors d'un click dans la zone de dessin
public class DessineCercleListener extends MouseAdapter {


    private DessinablesData dessinables;
    private int x, y;

    public DessineCercleListener(DessinablesData dessinables) {

        this.dessinables = dessinables;

    }

    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {

        int rX = e.getX();
        int rY = e.getY();
        int rayon =  (int)Math.sqrt(Math.pow(Math.abs(rX - this.x), 2) + Math.pow(Math.abs(rY-this.y), 2));

        Cercle cerc =  new Cercle(Math.min(this.x, rX), Math.min(this.y, rY) ,rayon, Utilitaires.randomColor()); 
        this.dessinables.addDessinable(cerc);

    }

}


