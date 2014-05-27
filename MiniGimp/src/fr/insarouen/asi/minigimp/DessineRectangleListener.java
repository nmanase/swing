package fr.insarouen.asi.minigimp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Listener qui modifie les données (dessinables) lors d'un click dans la zone de dessin
 */
public class DessineRectangleListener extends MouseAdapter {

    private DessinablesData dessinables;
    private int x, y;
    
    public DessineRectangleListener(DessinablesData dessinables) {

        this.dessinables = dessinables;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int rX = e.getX();
        int rY = e.getY();

        // System.out.println(this.x + " , "+ this.y +" , "+ lastX +" , "+ lastY);        

        //Rectangle rect = new Rectangle(Math.min(this.x, lastX), Math.min(this.y, lastY),
         //           Math.max(this.x, lastX), Math.max(this.y, lastY), Color.RED);
        Rectangle rect = new Rectangle(Math.min(this.x, rX), Math.min(this.y, rY),
                Math.abs(rX-this.x), Math.abs(rY-this.y), Utilitaires.randomColor());

        this.dessinables.addDessinable(rect);
                    
    }
}

