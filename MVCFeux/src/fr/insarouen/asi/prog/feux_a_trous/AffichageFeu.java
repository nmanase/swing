/*
 * AffichageFeu.java
 *
 * Created on 20 juin 2006, 17:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux_a_trous;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 *
 * @author nicolas
 */
public class AffichageFeu extends JPanel implements Observer {
 
    /**
     * Le feu controlé
     */
    private Feu feu;    
    private int size = 50;

    /** Creates a new instance of AffichageFeu */
    public AffichageFeu(Feu feu) {
        this.feu = feu;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(this.size, this.size*3));
        this.feu.addObserver(this);
    }
    
    public void eteindre() {
       
    }

    @Override
    public void paintComponent(Graphics g) {
        if(this.feu.getEtat() == Feu.Etat.ARRET)
            g.setColor(Color.RED);
        else g.setColor(Color.BLACK);

        g.fillOval(0, 0, size, size);

         if(this.feu.getEtat() == Feu.Etat.ATTENTION)
            g.setColor(Color.ORANGE);
        else g.setColor(Color.BLACK);

        g.fillOval(0, size, size, size);

        if(this.feu.getEtat() == Feu.Etat.PASSE)
            g.setColor(Color.GREEN);
        else g.setColor(Color.BLACK);

        g.fillOval(0, size*2, size, size);
    }

    /**
     * Implémentation de l'interface Observer
     */
    public void update(Observable o, Object ob){
        this.repaint();
    }
}
