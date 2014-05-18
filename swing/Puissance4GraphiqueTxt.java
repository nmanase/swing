import java.awt.*;
import javax.swing.*;

public class Puissance4GraphiqueTxt {

    public static void main(String[] args) {
	Puissance4 p4 = new Puissance4(5,6);

	JFrame frame=new JFrame("Puissance 4");

	ControleurVuePuissance4Graphique vp4gr = new ControleurVuePuissance4Graphique(p4);
 	ControleurPuissance4Graphique cp4gr = new ControleurPuissance4Graphique(p4);
	VuePuissance4Txt vp4txt = new VuePuissance4Txt(p4);
	ControleurPuissance4Txt cp4txt = new ControleurPuissance4Txt(p4);
	
	frame.setContentPane(vp4gr);

    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(400, 400);
    frame.setVisible(true);

	// en dernier pour ne pas bloquer l'appel suivant
	// sinon utilisation de threads
	cp4txt.joue();
    }
}
