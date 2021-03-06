package modele;

import controleur.Jeu;
import java.awt.Point;

/**
 * Humain est la classe représentant un joueur humain.
 * @author Solenn
 * @see Joueur
 */
public class Humain extends Joueur {

    /**
     * Constructeur Humain.
     * @param numeroJoueur Le numéro du joueur.
     * @param pseudo       Le pseudo du joueur.
     */
    public Humain(final int numeroJoueur, final String pseudo) {
        super(numeroJoueur, pseudo);
    }

    @Override
    /**
     * Execute un tour d'un joueur.
     */
    public void jouerTour() {
        int deplacable = 0;

        totality: do {
            Jeu.afficheBrouillard(sansBrouillard());
            // Attente de l'impossibilité pour le joueur de continuer son tour
            boolean selected = false;
            do {
                deplacable = 0;
                // Attente d'un clic sur une unité alliée
                selected = false;
                Point hexagone = new Point(-1, -1);
                do {
                    System.out.print(""); // ABSOLUMENT NECESSAIRE!!
                    if (Jeu.getSkipFlag() || !Jeu.hasStarted()) {
                        Jeu.setSkipFlag(false);
                        break totality;
                    }
                    if (Jeu.getClicFlag()) {
                        hexagone = Jeu.getCoordHexaClicked();
                        Jeu.setClicFlag(false);
                    }
                } while (hexagone.x == -1 || hexagone.y == -1);
                for (Unite u : listeUnite) {
                    if (u.getX() == hexagone.x && u.getY() == hexagone.y) {
                        if (u.selected()) {
                            break totality;
                        }
                        selected = true;
                    }
                    int mindep = 10;
                    for (Hexagone h : Jeu.getMap()[u.getX()][u.getY()].getListeVoisin()) {
                        mindep = Math.min(mindep, h.getCoutDeDeplacement());
                    }
                    if (mindep <= u.getPtDeDeplacement() || !u.acted) {
                        deplacable++;
                    }
                }
            } while (!selected);
        } while (deplacable > 0);

        for (Unite unite : this.getListeUnite()) {
            unite.preparerPourProchainTour();
        }
    }
}
