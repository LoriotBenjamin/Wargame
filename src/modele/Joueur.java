package modele;

import java.io.Serializable;
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
public class Joueur implements Serializable {

    /**
     * Numéro de sérial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = 916267121420154488L;
    /**
     * Le numéro du joueur qui correspond au tour de passage du joueur.
     * @see Joueur#getNumeroJoueur()
     * @see Joueur#setNumeroJoueur(int)
     */
    protected int numeroJoueur;
    /**
     * Le pseudo du joueur.
     * @see Joueur#getPseudo()
     * @see Joueur#setPseudo(String)
     */
    protected String pseudo;
    /**
     * Les unités du joueur présentes sur le plateau.
     * @see Joueur#getListeUnite()
     * @see Joueur#setListeUnite(ArrayList)
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

        //A MODIFIER
        //listeUnite.add(new Guerrier());
        //listeUnite.add(new Guerrier()); // ajout de 2 guerriers pour tester
    }

    /**
     * Constructeur Joueur.
     * @param numeroJoueur
     *      Le numéro du joueur.
     * @param pseudo
     *      Le pseudo du joueur.
     * @param listeunite
     *      Les unités du joueur.
     */
    //A SUPPRIMER SI ON S'EN SERT PAS
    public Joueur(final int numeroJoueur, final String pseudo, final ArrayList<Unite> listeunite) {
        this.numeroJoueur = numeroJoueur;
        this.pseudo = pseudo;
        this.listeUnite = listeunite;
    }

    /**
     * Ajoute une unité à la liste des unités.
     * @param u
     *      Unité à ajouter.
     * @see Joueur#listeUnite
     */
    public void setUnite(final Unite u) {
        this.listeUnite.add(u);
    }
    
    public void jouerTour() {
        
    }
    
  //JAVADOC A FAIRE
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
     * Retourne le numéro du joueur.
     * @return le numéro du joueur.
     */
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    /**
     * Met à jour le numéro du joueur.
     * @param numeroJoueur
     *      Le nouveau numéro du joueur.
     */
    public void setNumeroJoueur(final int numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }

    /**
     * Retourne le pseudo du joueur.
     * @return le pseudo du joueur.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Met à jour le pseudo du joueur.
     * @param pseudo
     *      Le nouveau pseudo du joueur.
     */
    public void setPseudo(final String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Retourne la liste des unités du joueur.
     * @return la liste des unités du joueur.
     */
    public ArrayList<Unite> getListeUnite() {
        return listeUnite;
    }

    /**
     * Met à jour la liste des unités du joueur.
     * @param listeUnite
     *      La nouvelle liste des unités du joueur.
     */
    public void setListeUnite(final ArrayList<Unite> listeUnite) {
        this.listeUnite = listeUnite;
    }

    

}
