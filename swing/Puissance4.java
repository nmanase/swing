import java.util.Observable;
import java.util.Observer;

public class Puissance4 extends Observable {
    public static final int VIDE=0, JAUNE=1, ROUGE=2;
    
    private int largeur, hauteur;
    private int[][] plateau;
    private int tourJeton;

    public Puissance4(int _largeur, int _hauteur) {
	largeur = Math.min(_largeur,10);
	hauteur = Math.min(_hauteur,10);
	plateau = new int[largeur][hauteur];
	for(int j=0; j<hauteur; j++)
	    for(int i=0; i<largeur; i++)
		plateau[i][j] = VIDE;
	tourJeton = JAUNE;
    }

    public int getLargeur() {
	return largeur;
    }

    public int getHauteur() {
	return hauteur;
    }

    public int getJeton(int colonne, int ligne) {
	return plateau[colonne][ligne];
    }

    public int getTour() {
	return tourJeton;
    }
    
    public void joueColonne(int numeroColonne) throws Puissance4ColonneException {
	if (numeroColonne<0 || numeroColonne>=largeur)
	    throw new Puissance4ColonneException("Colonne "+numeroColonne+" inexistante");
	descenteJeton(numeroColonne);
	tourJeton = tourJeton%2 +1;

    // Implentation du pattern Observer
    setChanged();
    notifyObservers();
    }

    private void descenteJeton(int numeroColonne) throws Puissance4ColonneException {
	for(int j=0; j<hauteur ; j++)
	    if (plateau[numeroColonne][j] == VIDE) {
		plateau[numeroColonne][j] = tourJeton;
		return;
	    }
	throw new Puissance4ColonneException("Colonne pleine");
    }
}
