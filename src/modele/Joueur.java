package modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Joueur est la classe représentant un joueur du jeu. Un joueur est caractérisé par :
 * <ul>
 * <li>Son numéro de joueur qui correspond au tour du passage du joueur</li>
 * <li>Son pseudo</li>
 * <li>Ses unités présentes sur le plateau</li>
 * </ul>
 * @author Solenn
 *
 */
public class Joueur {
    /**
     * Le numéro du joueur qui correspond au tour de passage du joueur.
     * @see Joueur#getNumeroJoueur()
     */
    protected int numeroJoueur;
    /**
     * Le pseudo du joueur.
     * @see Joueur#getPseudo()
     */
    protected String pseudo;
    /**
     * Les unités du joueur présentes sur le plateau.
     * @see Joueur#getListeUnite()
     */
    protected ArrayList<Unite> listeUnite = new ArrayList<Unite>();

    /**
     * Constructeur Joueur.
     * @param numeroJoueur
     *      Le numéro du joueur.
     * @param pseudo
     *      Le pseudo du joueur.
     */
    public Joueur(final int numeroJoueur, final String pseudo) {
        this.numeroJoueur = numeroJoueur;
        this.pseudo = pseudo;

        if (numeroJoueur == 1) {
            listeUnite.add(new Archer(1, 0, 2));
            listeUnite.add(new Mage(1, 1, 1));
            listeUnite.add(new Guerrier(1, 2, 1));
            listeUnite.add(new Chevalier(1, 3, 0));
            listeUnite.add(new Pretre(1, 4, 0));
        } else if (numeroJoueur == 2) {
            listeUnite.add(new Archer(2, 11, 16));
            listeUnite.add(new Mage(2, 10, 17));
            listeUnite.add(new Guerrier(2, 9, 17));
            listeUnite.add(new Chevalier(2, 8, 18));
            listeUnite.add(new Pretre(2, 7, 18));
        } else if (numeroJoueur == 3) {
            listeUnite.add(new Archer(3, 11, 2));
            listeUnite.add(new Mage(3, 10, 2));
            listeUnite.add(new Guerrier(3, 9, 1));
            listeUnite.add(new Chevalier(3, 8, 1));
            listeUnite.add(new Pretre(3, 7, 0));
        } else {
            listeUnite.add(new Archer(4, 0, 16));
            listeUnite.add(new Mage(4, 1, 16));
            listeUnite.add(new Guerrier(4, 2, 17));
            listeUnite.add(new Chevalier(4, 3, 17));
            listeUnite.add(new Pretre(4, 4, 18));
      }
  }

    /**
     * Joue un tour.
     */
    public void jouerTour() {

    }

    /**
     * Retourne une liste contenant les hexagones qui n'ont pas de brouillard de guerre.
     * @return une liste d'hexagones sans brouillard de guerre
     */
    public ArrayList<Hexagone> sansBrouillard() {
        HashSet<Hexagone> nonfog = new HashSet<Hexagone>();
        ArrayList<Hexagone> list = new ArrayList<Hexagone>();
        for (Unite unite : this.listeUnite) {
            nonfog.addAll(unite.vision());
        }
        Iterator<Hexagone> i = nonfog.iterator();
        while (i.hasNext()) {
            Hexagone h = i.next();
            list.add(h);
        }
        return list;
    }

    //////////////////////// Getter and Setter /////////////////////////
    /**
     * Retourne le numero du joueur.
     * @return le numero du joueur.
     */
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    /**
     * Retourne le pseudo du joueur.
     * @return le pseudo du joueur.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Met à jour la liste des unités du joueur.
     * @param listeUnite La nouvelle liste des unités du joueur.
     */
    public void setListeUnite(final ArrayList<Unite> listeUnite) {
        this.listeUnite = listeUnite;
    }

    /**
     * Retourne la liste des unités du joueur.
     * @return la liste des unités du joueur.
     */
    public ArrayList<Unite> getListeUnite() {
        return listeUnite;
    }
}
