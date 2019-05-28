package modele;

import java.util.ArrayList;

/**
 * Hexagone est la classe repr�sentant une case en forme d'hexagone du plateau
 * de jeu. Un hexagone est caract�ris� par :
 * <ul>
 * <li>Son type qui est un entier entre 10 et 16 repr�sentant un type de
 * terrain</li>
 * <li>Son bonus de d�fense qui est diff�rent pour chaque type de terrain</li>
 * <li>Son co�t de d�placement qui est diff�rent pour chaque type de
 * terrain</li>
 * <li>Ses coordonn�es sur le plateau : x et y</li>
 * <li>Sa liste d'hexagones voisins
 * </ul>
 * @author Solenn
 *
 */
public class Hexagone {
    /**
     * Le type de l'Hexagone. C'est un entier compris entre 10 et 16 repr�sentant les diff�rents types de terrains.
     * @see Hexagone#getType()
     * @see Hexagone#setType(int)
     */
    private int type;
    /**
     * Le bonus de d�fense d'un Hexagone.
     * @see Hexagone#getBonusDefense()
     * @see Hexagone#setBonusDefense(double)
     */
    private double bonusDefense;
    /**
     * Le co�t de d�placement d'un Hexagone.
     * @see Hexagone#getCoutDeDeplacement()
     * @see Hexagone#setCoutDeDeplacement(int)
     */
    private int coutDeDeplacement;
    /**
     * Le num�ro de ligne d'un Hexagone.
     * @see Hexagone#getX()
     * @see Hexagone#setX(int)
     */
    private int x;
    /**
     * Le num�ro de colonne d'un Hexagone.
     * @see Hexagone#getY()
     * @see Hexagone#setY(int)
     */
    private int y;
    /**
     * La liste des voisins d'un Hexagone.
     * @see Hexagone#getListeVoisin()
     * @see Hexagone#setListeVoisin(ArrayList)
     */
    private ArrayList<Hexagone> listeVoisin = new ArrayList<Hexagone>();

    /**
     * Constructeur Hexagone.
     * @param type
     *      Type de l'hexagone.
     * @param bonusDefense
     *      Bonus d�fense de l'hexagone.
     * @param coutDeDeplacement
     *      Co�t de d�placement de l'hexagone.
     * @param x
     *      Num�ro de ligne de l'hexagone.
     * @param y
     *      Num�ro de colonne de l'hexagone.
     */
    public Hexagone(final int type, final double bonusDefense, final int coutDeDeplacement, final int x, final int y) {
        this.type = type;
        this.bonusDefense = bonusDefense;
        this.coutDeDeplacement = coutDeDeplacement;
        this.x = x;
        this.y = y;
    }
    /**
     * Constructeur Hexagone.
     * @param type
     *      Type de l'hexagone.
     * @param bonusDefense
     *      Bonus de d�fense de l'hexagone.
     * @param coutDeDeplacement
     *      Co�t de d�placement de l'hexagone.
     * @param listeVoisin
     *      Liste des voisins de l'hexagone.
     */
    public Hexagone(final int type, final double bonusDefense, final int coutDeDeplacement,
            final ArrayList<Hexagone> listeVoisin) {
        // deuxieme constructeur utile seulement si on connait la liste des voisins a� voir
        //A SUPPRIMER SI NON UTILISE

        this.type = type;
        this.bonusDefense = bonusDefense;
        this.coutDeDeplacement = coutDeDeplacement;
        this.listeVoisin = listeVoisin;

    }

    // debug
    //A SUPPRIMER QUAND ON AURA LA VUE
    @Override
    public final String toString() {
        return " " + type + " ";
    }

    /**
     * Ajoute un hexagone � la liste des voisins.
     * @param h
     *      Hexagone � ajouter.
     * @see Hexagone#listeVoisin
     */
    public void ajoutHexagoneVoisin(final Hexagone h) {
        listeVoisin.add(h);
    }

    /**
     * A SUPPRIMER PLUS TARD.
     */
    public void afficheVoisin() {
        for (Hexagone h : this.listeVoisin) {
            System.out.println("Valeur i: " + String.valueOf(h.x));
            System.out.println("Valeur j: " + String.valueOf(h.y));
        }
    }

    //////////////////////// Getter and Setter /////////////////////////
    /**
     * Retourne le type de l'hexagone.
     * @return le type de l'hexagone.
     */
    public int getType() {
        return type;
    }

    /**
     * Met � jour le type de l'hexagone.
     * @param type
     *      Le nouveau type de l'hexagone.
     */
    public void setType(final int type) {
        this.type = type;
    }

    /**
     * Retourne le bonus de d�fense de l'hexagone.
     * @return le bonus de d�fense de l'hexagone.
     */
    public double getBonusDefense() {
        return bonusDefense;
    }

    /**
     * Met � jour le bonus de d�fense de l'hexagone.
     * @param bonusDefense
     *      Le nouveau bonus de d�fense de l'hexagone.
     */
    public void setBonusDefense(final double bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

    /**
     * Retourne le co�t de d�placement de l'hexagone.
     * @return le co�t de d�placement de l'hexagone.
     */
    public int getCoutDeDeplacement() {
        return coutDeDeplacement;
    }

    /**
     * Met � jour le co�t de d�placement de l'hexagone.
     * @param coutDeDeplacement
     *      Le nouveau co�t de d�placement de l'hexagone.
     */
    public void setCoutDeDeplacement(final int coutDeDeplacement) {
        this.coutDeDeplacement = coutDeDeplacement;
    }

    /**
     * Retourne le num�ro de ligne de l'hexagone.
     * @return le num�ro de ligne de l'hexagone.
     */
    public int getX() {
        return x;
    }

    /**
     * Met � jour le num�ro de ligne de l'hexagone.
     * @param x
     *      Le nouveau num�ro de ligne de l'hexagone.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Retourne le num�ro de colonne de l'hexagone.
     * @return le num�ro de colonne de l'hexagone.
     */
    public int getY() {
        return y;
    }

    /**
     * Met � jour le num�ro de colonne de l'hexagone.
     * @param y
     *      Le nouveau num�ro de colonne de l'hexagone.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Retourne la liste des voisins de l'hexagone.
     * @return la liste des voisins de l'hexagone.
     */
    public ArrayList<Hexagone> getListeVoisin() {
        return listeVoisin;
    }

    /**
     * Met � jour la liste des voisins de l'hexagone.
     * @param listeVoisin
     *      La nouvelle liste des voisins de l'hexagone.
     */
    public void setListeVoisin(final ArrayList<Hexagone> listeVoisin) {
        this.listeVoisin = listeVoisin;
    }

}
