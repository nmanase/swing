/*
 * ControleurFeuAuto.java
 *
 * Created on 21 juin 2006, 00:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package fr.insarouen.asi.prog.feux_a_trous;


/**
 *
 * @author nicolas
 */
public class ControleurFeuAuto implements Runnable {
    
    private Feu feu;
    private int tpsPasse;
    private int tpsAttention;
    private int tpsArret;
    private boolean stop = false; 
    
    /** Creates a new instance of ControleurFeuAuto */
    public ControleurFeuAuto(Feu feu, int tpsPasse, int tpsAttention, int tpsArret) {
      this.feu = feu;
      this.tpsPasse = tpsPasse;
      this.tpsAttention = tpsAttention;
      this.tpsArret = tpsArret;
    }
    
    public void run() {
        
        Thread thread = Thread.currentThread();

        try {
            while(!stop) {
                if(!this.stop){
                    this.feu.setEtat(Feu.Etat.PASSE);
                    thread.sleep(tpsPasse*1000);
                }

                if(!this.stop){
                    this.feu.setEtat(Feu.Etat.ATTENTION);
                    thread.sleep(tpsAttention*1000);
                }

                if(!this.stop){
                    this.feu.setEtat(Feu.Etat.ARRET);
                    thread.sleep(tpsArret*1000);
                }
            }
        } catch(InterruptedException e) {
            stop();
        }
        // fin while
        this.stop = false;
    }// fin méthode
        
    public void stop() {
       this.stop = true; 
    }
}
