import java.util.Scanner;


public class ControleurPuissance4Txt {

    private Puissance4 puissance4;

    public ControleurPuissance4Txt(Puissance4 puissance4) {
        this.puissance4 = puissance4;
    }

    public void joue() {
        int tour = 0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            tour = this.puissance4.getTour();
            if (tour == Puissance4.JAUNE)
                System.out.print("Tour Jaune (x): ");
            else System.out.print("Tour Rouge (o): ");

            try {
                this.puissance4.joueColonne(sc.nextInt());
            } catch(Puissance4ColonneException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
