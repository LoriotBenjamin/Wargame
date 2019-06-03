package controleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modele.Joueur;
import vue.Menu;

/**
 * Classe qui lance le main du programme.
 * @author Solenn
 *
 */
public class MainOfGame {

    /**
     * Fonction main du programme.
     * @param args Arguments de lancement.
     */
    public static void main(final String[] args) {
        totality: do {
            Menu menu = new Menu();
            Joueur winner = null;
            do {
                do {
                    System.out.print("");
                } while (!Jeu.hasStarted());
                Jeu.affichageUnite();

                do {
                    ArrayList<Joueur> perdant = new ArrayList<Joueur>();
                    Joueur joueur = Jeu.getListeJoueurs().get(Jeu.getTurn() - 1); // tour des joueurs chacun leur tour
                    joueur.jouerTour();
                    if (!Jeu.hasStarted()) {
                        continue totality;
                    }
                    if (joueur.getListeUnite().size() == 0) { // mise en mémoire des perdants
                        perdant.add(joueur);
                    }
                    if (!perdant.isEmpty()) { //on enlève les perdants de la liste
                        Jeu.getListeJoueurs().removeAll(perdant);
                    }
                    Jeu.nextTurn();
                } while (Jeu.getListeJoueurs().size() > 1 && Jeu.hasStarted());
                Jeu.affichageUnite();
                winner = Jeu.getListeJoueurs().get(0);
            } while (winner == null);
            Jeu.kill();
            JOptionPane.showMessageDialog(null, "Fin de la partie.\n" + winner.getPseudo() + " a gagné.",
                    "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
        } while (true);
    }

}
