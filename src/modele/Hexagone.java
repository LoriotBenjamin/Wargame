package modele;

import java.util.ArrayList;

import controleur.Jeu;

/**
 * Hexagone est la classe représentant une case en forme d'hexagone du plateau de jeu. Un hexagone est caractérisé par :
 * <ul>
 * <li>Son type qui est un entier entre 10 et 16 représentant un type de terrain</li>
 * <li>Son bonus de défense qui est différent pour chaque type de terrain</li>
 * <li>Son coût de déplacement qui est différent pour chaque type de terrain</li>
 * <li>Ses coordonnées sur le plateau : x et y</li>
 * <li>Sa liste d'hexagones voisins
 * </ul>
 * @author Solenn
 *
 */
public class Hexagone {
    /**
     * Le type de l'Hexagone. C'est un entier compris entre 10 et 16 représentant les différents types de terrains.
     * @see Hexagone#getType()
     */
    private int type;
    /**
     * Le bonus de défense d'un Hexagone.
     * @see Hexagone#getBonusDefense()
     */
    private double bonusDefense;
    /**
     * Le coût de déplacement d'un Hexagone.
     * @see Hexagone#getCoutDeDeplacement()
     */
    private int coutDeDeplacement;
    /**
     * Le numéro de ligne d'un Hexagone.
     * @see Hexagone#getX()
     */
    private int x;
    /**
     * Le numéro de colonne d'un Hexagone.
     * @see Hexagone#getY()
     */
    private int y;
    /**
     * La liste des voisins d'un Hexagone.
     * @see Hexagone#getListeVoisin()
     */
    private ArrayList<Hexagone> listeVoisin = new ArrayList<Hexagone>();

    /**
     * Constructeur Hexagone.
     * @param type
     *      Type de l'hexagone.
     * @param bonusDefense
     *      Bonus défense de l'hexagone.
     * @param coutDeDeplacement
     *      Coût de déplacement de l'hexagone.
     * @param x
     *      Numéro de ligne de l'hexagone.
     * @param y
     *      Numéro de colonne de l'hexagone.
     */
    public Hexagone(final int type, final double bonusDefense, final int coutDeDeplacement, final int x, final int y) {
        this.type = type;
        this.bonusDefense = bonusDefense;
        this.coutDeDeplacement = coutDeDeplacement;
        this.x = x;
        this.y = y;
    }

    /**
     * Ajoute un hexagone à la liste des voisins.
     * @param h
     *      Hexagone à ajouter.
     * @see Hexagone#listeVoisin
     */
    public void ajoutHexagoneVoisin(final Hexagone h) {
        listeVoisin.add(h);
    }

    /**
     * Initialise la liste des voisins d'un hexagone.
     * @see Hexagone#listeVoisin
     * @see Hexagone#ajoutHexagoneVoisin(Hexagone)
     */
    public void initListeVoisin() {
        if (x % 2 == 0) {
            if (x + 1 < Jeu.MAPLIGNE) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x + 1][y]);
            }
            if (y + 1 < Jeu.MAPCOLONNE) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x][y + 1]);
            }
            if (x + 1 < Jeu.MAPLIGNE && y - 1 >= 0) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x + 1][y - 1]);
            }
            if (x - 1 >= 0) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x - 1][y]);
            }
            if (x - 1 >= 0 && y - 1 >= 0) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x - 1][y - 1]);
            }
            if (y - 1 >= 0) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x][y - 1]);
            }
        } else {
            if (x + 1 < Jeu.MAPLIGNE) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x + 1][y]);
            }
            if (x + 1 < Jeu.MAPLIGNE && y + 1 < Jeu.MAPCOLONNE) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x + 1][y + 1]);
            }
            if (y + 1 < Jeu.MAPCOLONNE) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x][y + 1]);
            }
            if (x - 1 >= 0) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x - 1][y]);
            }
            if (y - 1 >= 0) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x][y - 1]);
            }
            if (x - 1 >= 0 && y + 1 < Jeu.MAPCOLONNE) {
                this.ajoutHexagoneVoisin(Jeu.getMap()[x - 1][y + 1]);
            }
        }
    }
    /**
     * Donne la distance entre deux hexagones.
     * @param h2  Hexagone cible
     * @return La distance entre les 2 hexagones.
     */
    public int getDistanceBetweenTwoPosition(final Hexagone h2) {

        double a = (double) this.x;
        double b = (double) this.y;
        double a2 = (double) h2.getX();
        double b2 = (double) h2.getY();

        double t1 = Math.abs((a - b / 2) - (a2 - b2 / 2));
        double t2 = Math.abs(b - b2);
        double t3 = Math.abs((a + b / 2) - (a2 + b2 / 2));

        double m = Math.max(Math.max(t1, t2), t3);

        int resultat = 0;

        final double arrondi = 0.5;

        if (((a == 0 && b == 0) && (a2 % 2 == 1 && b2 % 2 == 1))
                || ((a % 2 == 1 && b % 2 == 1) && (a2 == 0 && b2 == 0))
                || Math.abs(a - a2) == 1 && Math.abs(b - b2) == 1) { // si un des paramètres est 0,0 et que
                                                                           // l'autre a deux coordoonées impaires
            resultat = (int) Math.abs((m - arrondi)); // on arrondit à l'inférieur
        } else {
            resultat = (int) Math.abs((m + arrondi)); // on arrondit au supérieur
        }
        return resultat;
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
     * Retourne le bonus de défense de l'hexagone.
     * @return le bonus de défense de l'hexagone.
     */
    public double getBonusDefense() {
        return bonusDefense;
    }

    /**
     * Retourne le coût de déplacement de l'hexagone.
     * @return le coût de déplacement de l'hexagone.
     */
    public int getCoutDeDeplacement() {
        return coutDeDeplacement;
    }

    /**
     * Retourne le numéro de ligne de l'hexagone.
     * @return le numéro de ligne de l'hexagone.
     */
    public int getX() {
        return x;
    }

    /**
     * Retourne le numéro de colonne de l'hexagone.
     * @return le numéro de colonne de l'hexagone.
     */
    public int getY() {
        return y;
    }

    /**
     * Retourne la liste des voisins de l'hexagone.
     * @return la liste des voisins de l'hexagone.
     */
    public ArrayList<Hexagone> getListeVoisin() {
        return listeVoisin;
    }
}
