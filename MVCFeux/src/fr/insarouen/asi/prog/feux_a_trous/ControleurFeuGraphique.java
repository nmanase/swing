/*
 * ControleurFeuGraphique.java
 *
 * Created on 20 juin 2006, 23:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux_a_trous;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author nicolas
 */
public class ControleurFeuGraphique extends JPanel {

    /**
     * Le feu controlé
     */
    private Feu feu;    
    private JCheckBox check;
    private JButton go, attention, stop;
    private ControleurFeuAuto controleurFeuAuto; 
   
    /** Creates a new instance of ControleurFeuGraphique */
    public ControleurFeuGraphique(Feu feu) {
        this.feu = feu;
        this.controleurFeuAuto = new ControleurFeuAuto(feu,1,2,3);

        go = new JButton("Go");
        go.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ControleurFeuGraphique.this.feu.setEtat(Feu.Etat.PASSE);
            }
        });
        this.add(go);

        attention = new JButton("Attention");
        attention.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ControleurFeuGraphique.this.feu.setEtat(Feu.Etat.ATTENTION);
            }
        });
        this.add(attention);


        stop = new JButton("Stop");
        stop.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ControleurFeuGraphique.this.feu.setEtat(Feu.Etat.ARRET);
            }
        });
        this.add(stop);

        check = new JCheckBox();
        check.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JCheckBox box = ControleurFeuGraphique.this.check;

                if (box.isSelected()) {
                    ControleurFeuGraphique.this.go.setEnabled(false);
                    ControleurFeuGraphique.this.attention.setEnabled(false);
                    ControleurFeuGraphique.this.stop.setEnabled(false);
                    
                    // Lancer le thread   
                    new Thread(ControleurFeuGraphique.this.controleurFeuAuto).start();
          
                }    
                else {
                    ControleurFeuGraphique.this.controleurFeuAuto.stop();
                    ControleurFeuGraphique.this.go.setEnabled(true);
                    ControleurFeuGraphique.this.attention.setEnabled(true);
                    ControleurFeuGraphique.this.stop.setEnabled(true);
                }
            }
        });
        this.add(check);
    }
}
