package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Joueur est la classe repr�sentant un joueur du jeu. Un joueur est caract�ris� par :
 * <ul>
 * <li>Son num�ro de joueur qui correspond au tour du passage du joueur</li>
 * <li>Son pseudo</li>
 * <li>Ses unit�s pr�sentes sur le plateau</li>
 * </ul>
 * @author Solenn
 *
 */
public class Joueur implements Serializable {

    /**
     * Num�ro de s�rial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = 916267121420154488L;
    /**
     * Le num�ro du joueur qui correspond au tour de passage du joueur.
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
     * Les unit�s du joueur pr�sentes sur le plateau.
     * @see Joueur#getListeUnite()
     * @see Joueur#setListeUnite(ArrayList)
     */
    protected ArrayList<Unite> listeUnite = new ArrayList<Unite>();

    /**
     * Constructeur Joueur.
     * @param numeroJoueur
     *      Le num�ro du joueur.
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
     *      Le num�ro du joueur.
     * @param pseudo
     *      Le pseudo du joueur.
     * @param listeunite
     *      Les unit�s du joueur.
     */
    //A SUPPRIMER SI ON S'EN SERT PAS
    public Joueur(final int numeroJoueur, final String pseudo, final ArrayList<Unite> listeunite) {
        this.numeroJoueur = numeroJoueur;
        this.pseudo = pseudo;
        this.listeUnite = listeunite;
    }

    /**
     * Ajoute une unit� � la liste des unit�s.
     * @param u
     *      Unit� � ajouter.
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
     * Retourne le num�ro du joueur.
     * @return le num�ro du joueur.
     */
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    /**
     * Met � jour le num�ro du joueur.
     * @param numeroJoueur
     *      Le nouveau num�ro du joueur.
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
     * Met � jour le pseudo du joueur.
     * @param pseudo
     *      Le nouveau pseudo du joueur.
     */
    public void setPseudo(final String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Retourne la liste des unit�s du joueur.
     * @return la liste des unit�s du joueur.
     */
    public ArrayList<Unite> getListeUnite() {
        return listeUnite;
    }

    /**
     * Met � jour la liste des unit�s du joueur.
     * @param listeUnite
     *      La nouvelle liste des unit�s du joueur.
     */
    public void setListeUnite(final ArrayList<Unite> listeUnite) {
        this.listeUnite = listeUnite;
    }

    

}
