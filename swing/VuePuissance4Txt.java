import java.util.Observable;
import java.util.Observer;

public class VuePuissance4Txt implements Observer {

    private Puissance4 puissance4;

    public VuePuissance4Txt(Puissance4 puissance4) {
        this.puissance4 = puissance4;
        this.puissance4.addObserver(this);
    }

    public void paintView() {
        int largeur = puissance4.getLargeur();
        int hauteur = puissance4.getHauteur();

        for (int i=hauteur-1; i>=-1; i--) {
            for (int j=0; j<largeur; j++) {
                if(i >= 0) {
                    int jeton = puissance4.getJeton(j,i);
                    if(jeton == Puissance4.JAUNE)
                        System.out.print("x");
                    else if (jeton == Puissance4.ROUGE)
                        System.out.print("o");
                    else System.out.print(" ");

                }
                else System.out.print(j);
                    
                if (j== largeur-1)
                    System.out.println("");
            }
        }
    }

    public void update(Observable observable, Object o) {
        this.paintView();
    }
}
