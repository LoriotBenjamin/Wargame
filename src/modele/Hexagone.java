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
     * @see Hexagone#setType(int)
     */
    private int type;
    /**
     * Le bonus de défense d'un Hexagone.
     * @see Hexagone#getBonusDefense()
     * @see Hexagone#setBonusDefense(double)
     */
    private double bonusDefense;
    /**
     * Le coût de déplacement d'un Hexagone.
     * @see Hexagone#getCoutDeDeplacement()
     * @see Hexagone#setCoutDeDeplacement(int)
     */
    private int coutDeDeplacement;
    /**
     * Le numéro de ligne d'un Hexagone.
     * @see Hexagone#getX()
     * @see Hexagone#setX(int)
     */
    private int x;
    /**
     * Le numéro de colonne d'un Hexagone.
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
     * Constructeur Hexagone.
     * @param type
     *      Type de l'hexagone.
     * @param bonusDefense
     *      Bonus de défense de l'hexagone.
     * @param coutDeDeplacement
     *      Coût de déplacement de l'hexagone.
     * @param listeVoisin
     *      Liste des voisins de l'hexagone.
     */
    public Hexagone(final int type, final double bonusDefense, final int coutDeDeplacement,
            final ArrayList<Hexagone> listeVoisin) {
        // deuxieme constructeur utile seulement si on connait la liste des voisins à voir
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
        String string = "";
        switch (type) {
        case Jeu.PLAINE:
            string += "Plaine ";
            break;
        case Jeu.FORET:
            string += "Forêt ";
            break;
        case Jeu.VILLAGE:
            string += "Vill ";
            break;
        case Jeu.RIVIERE:
            string += "Riv ";
            break;
        case Jeu.MONTAGNE:
            string += "Mont ";
            break;
        case Jeu.MER:
            string += "Mer ";
            break;
        case Jeu.DESERT:
            string += "Désert ";
            break;
        default:
            break;
        }
        for (Joueur joueur : Jeu.getListeJoueurs()) {
            for (Unite unite : joueur.getListeUnite()) {
                if (unite.getX() == x && unite.getY() == y) {
                    string += unite.getTypeUnite() + " " + joueur.getPseudo() + " ";
                }
            }
        }
        return string + "\t\t\t";
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

  //JAVADOC A COMPLETER
    /**
     * Initialise la liste des voisins d'un hexagone.
     * @see Hexagone#listeVoisin
     * @see Hexagone#ajoutHexagoneVoisin(Hexagone)
     */
    public void initListeVoisin() { // ajoute a� chaque hexagone la liste des hexagones voisins
        // ( serait peut etre plus pertinent dans la classe hexagone)
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
     * Donne la distance entre deux couples de coordonnees x,y et x2,y2 dans une
     * grille hexagonale.
     * 
     * @param h1  hexagone de départ
     * @param h2  hexagone cible 
     * @return int La distance entre les 2 points.
     */
    public int getDistanceBetweenTwoPosition(Hexagone h2) {

        double a = (double) this.x;
        double b = (double) this.y;
        double a2 = (double) h2.getX();
        double b2 = (double) h2.getY();

        //System.out.println(" a: " + a + "\n b: " + b + "\n a2: " + a2 + "\n b2: " + b2);

        double t1 = Math.abs((a - b / 2) - (a2 - b2 / 2));
        double t2 = Math.abs(b - b2);
        double t3 = Math.abs((a + b / 2) - (a2 + b2 / 2));

        //System.out.println(" t1: " + t1 + " t2: " + t2 + " t3: " + t3);
        double m = Math.max(Math.max(t1, t2), t3);

        int resultat = 0;

        if (((a == 0 && b == 0) && (a2% 2 == 1 && b2 % 2 == 1))
                || ((a % 2 == 1 && b % 2 == 1) && (a2 == 0 && b2 == 0))) { // si un des paramètres est 0,0 et que
                                                                           // l'autre a deux coordoonées impaires
            // TODO déclarer constante
            resultat = (int) Math.abs((m - 0.5)); // on arrondit à l'inférieur
        } else {
            resultat = (int) Math.abs((m + 0.5)); // on arrondit au supérieur
        }
        return resultat;
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
     * Met à jour le type de l'hexagone.
     * @param type
     *      Le nouveau type de l'hexagone.
     */
    public void setType(final int type) {
        this.type = type;
    }

    /**
     * Retourne le bonus de défense de l'hexagone.
     * @return le bonus de défense de l'hexagone.
     */
    public double getBonusDefense() {
        return bonusDefense;
    }

    /**
     * Met à jour le bonus de défense de l'hexagone.
     * @param bonusDefense
     *      Le nouveau bonus de défense de l'hexagone.
     */
    public void setBonusDefense(final double bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

    /**
     * Retourne le coût de déplacement de l'hexagone.
     * @return le coût de déplacement de l'hexagone.
     */
    public int getCoutDeDeplacement() {
        return coutDeDeplacement;
    }

    /**
     * Met à jour le coût de déplacement de l'hexagone.
     * @param coutDeDeplacement
     *      Le nouveau coût de déplacement de l'hexagone.
     */
    public void setCoutDeDeplacement(final int coutDeDeplacement) {
        this.coutDeDeplacement = coutDeDeplacement;
    }

    /**
     * Retourne le numéro de ligne de l'hexagone.
     * @return le numéro de ligne de l'hexagone.
     */
    public int getX() {
        return x;
    }

    /**
     * Met à jour le numéro de ligne de l'hexagone.
     * @param x
     *      Le nouveau numéro de ligne de l'hexagone.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Retourne le numéro de colonne de l'hexagone.
     * @return le numéro de colonne de l'hexagone.
     */
    public int getY() {
        return y;
    }

    /**
     * Met à jour le numéro de colonne de l'hexagone.
     * @param y
     *      Le nouveau numéro de colonne de l'hexagone.
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
     * Met à jour la liste des voisins de l'hexagone.
     * @param listeVoisin
     *      La nouvelle liste des voisins de l'hexagone.
     */
    public void setListeVoisin(final ArrayList<Hexagone> listeVoisin) {
        this.listeVoisin = listeVoisin;
    }
}
