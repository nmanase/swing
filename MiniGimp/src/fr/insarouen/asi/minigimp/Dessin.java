package fr.insarouen.asi.minigimp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// TODO compléter la classe
public class Dessin extends JPanel implements Observer{

    private DessinablesData dessinables;

    /**
     * Constructeur
     */
    public Dessin() {
        super();

        setOpaque(true);
        setBackground(Color.white);
        setPreferredSize(new Dimension(300,200));

    }

    /**
     * Associe les données à la zone de dessin et les déclare observables par Dessin
     */
    public void setModel(DessinablesData dessinables) {

        this.dessinables = dessinables;
        this.dessinables.addObserver(this);
        
    }


    /**
     * Dessine le ou les figures contenues dans les données
     * si une figure est reçu ne dessiner que celle-ci
     * sinon tout redessinner
     */
    public void update(Observable obs, Object o) {

        if (o instanceof Dessinable) 
            
            ((Dessinable)o).dessine(this.getGraphics());
        
        else this.repaint();

    }

    /**
     * Dessine les toutes les figure contenues dans le modèle de données
     */
    public void paintComponent(Graphics gc) {

        super.paintComponent(gc);
        Dessinable dessinable;

        while (this.dessinables.iterator().hasNext()) {
           
            this.dessinables.iterator().next().dessine(gc);

        }

    }

}



