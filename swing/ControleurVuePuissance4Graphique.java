import java.util.Observable;
import java.util.Observer;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControleurVuePuissance4Graphique extends JPanel implements Observer {

    private Puissance4 puissance4;
    public int tokenSize;
    
    public ControleurVuePuissance4Graphique(Puissance4 puissance4) {
        this.puissance4 = puissance4;
        this.puissance4.addObserver(this);
        this.addMouseListener(new Ecouteur());
    }

    @Override
    public void paintComponent(Graphics g) {
        int jeton;
        int largeur = this.puissance4.getLargeur();
        int hauteur= this.puissance4.getHauteur();

        for (int i=hauteur-1; i>=0; i--) {
            for (int j=0; j<largeur; j++) {
                jeton = this.puissance4.getJeton(j, i);

                if(jeton == Puissance4.JAUNE)
                    g.setColor(Color.YELLOW);
                else if (jeton == Puissance4.ROUGE)
                    g.setColor(Color.RED);
                else g.setColor(Color.GRAY);

                int value = (int) Math.min(this.getWidth(), this.getHeight());
                int max = (int) Math.max(largeur, hauteur);
                int side = 0;
                if (value == this.getWidth())
                    side = value / max;
                else side = value / max;

                
                if (max == largeur)
                    side = value / largeur;
                else side = value / hauteur;

                this.tokenSize = side;

                g.fillOval(
                        (int)j*side,
                        (int)(largeur-i)*side,
                        side,
                        side); 
            }
        }
    }

    public void update(Observable observable, Object o) {
        this.repaint();
    }

    class Ecouteur extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int column = e.getX();
            column = column/ControleurVuePuissance4Graphique.this.tokenSize;
            try {
                ControleurVuePuissance4Graphique.this.puissance4.joueColonne(column);
            } catch(Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
