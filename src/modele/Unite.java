package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import controleur.Jeu;

/**
 * Unit� est la classe repr�sentant un type de personnage. Ses caract�ristiques
 * sont :
 * <ul>
 * <li>Son type, qui est un entier entre 1 et 5 repr�sentant chacun un type
 * diff�rent</li>
 * <li>Ses points d'attaque</li>
 * <li>Ses points de d�fense</li>
 * <li>Ses points de vie ou PV restants</li>
 * <li>Ses PV maximum</li>
 * <li>Ses points de d�placement restants</li>
 * <li>Ses points de d�placement maximum</li>
 * <li>Ses points de vision</li>
 * <li>Sa port�e</li>
 * <li>Ses coordonn�es sur le plateau</li>
 * </ul>
 * @author Solenn
 *
 */
public class Unite implements Serializable {
    /**
     * Num�ro de s�rial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = 2569571978178827188L;
    /**
     * Type de l'unit� repr�sent� par un entier entre 1 et 5.
     * @see Unite#getTypeUnite()
     * @see Unite#setTypeUnite(int)
     */
    private int typeUnite; // peut etre remplace par un .getClass() supprimant cette variable mais un peu
    // plus long dans les tests que des comparaisons avec un int je pense
    /**
     * Points d'attaque de l'unit�.
     * @see Unite#getAttaque()
     * @see Unite#setAttaque(int)
     */
    private int attaque;
    /**
     * Points de d�fense de l'unit�.
     * @see Unite#getDefense()
     * @see Unite#setDefense(int)
     */
    private int defense;
    /**
     * Points de vie restant de l'unit�.
     * @see Unite#getPv()
     * @see Unite#setPv(int)
     */
    private int pv;
    /**
     * Points de vie maximum de l'unit�.
     * @see Unite#getPvMax()
     */
    private int pvMax;
    /**
     * Points de d�placement restant de l'unit�.
     * @see Unite#getPtDeDeplacement()
     * @see Unite#setPtDeDeplacement(int)
     */
    private int ptDeDeplacement;
    /**
     * Points de d�placement maximum de l'unit� par tour.
     * @see Unite#getPtDeDeplacementMax()
     */
    private int ptDeDeplacementMax;
    /**
     * Points de vision de l'unit�.
     * @see Unite#getVision()
     * @see Unite#setVision(int)
     */
    private int vision;
    /**
     * Port�e des attaques de l'unit�.
     * @see Unite#getPorte()
     * @see Unite#setPorte(int)
     */
    private int porte;
    /**
     * Num�ro de ligne de l'unit�.
     * @see Unite#getX()
     * @see Unite#setX(int)
     */
    private int x;
    /**
     * Num�ro de colonne de l'unit�.
     * @see Unite#getY()
     * @see Unite#setY(int)
     */
    private int y;
    /**
     * Permet de savoir si l'unit�e a �t� attaqu�e pendant le tour ou non.
     */
    private boolean estAttaquee;
    /**
     * Liste des ennemis attaquable par l'unit�.
     */
    private ArrayList<Unite> ennemiAttaquable = new ArrayList<Unite>();

    /**
     * Constructeur Unit�.
     * @param typeUnite       Le type de l'unit�.
     * @param attaque         Les points d'attaque de l'unit�.
     * @param defense         Les points de d�fense de l'unit�.
     * @param pv              Les points de vie de l'unit�.
     * @param ptDeDeplacement Les points de d�placement de l'unit�.
     * @param vision          La vision de l'unit�.
     * @param porte           La port�e de l'unit�.
     * @param x               Le num�ro de ligne de l'unit�.
     * @param y               Le num�ro de colonne de l'unit�.
     */
    public Unite(final int typeUnite, final int attaque, final int defense, final int pv, final int ptDeDeplacement,
            final int vision, final int porte, final int x, final int y) {
        this.typeUnite = typeUnite;
        this.attaque = attaque;
        this.defense = defense;
        this.pv = pv;
        this.pvMax = pv;
        this.ptDeDeplacement = ptDeDeplacement;
        this.ptDeDeplacementMax = ptDeDeplacement;
        this.vision = vision;
        this.porte = porte;
        this.x = x;
        this.y = y;
        this.estAttaquee = false;
    }

    /**
     * Constructeur Unit�.
     * @param typeUnite          Type de l'unit�.
     * @param attaque            Points d'attaque de l'unit�.
     * @param defense            Points de d�fense de l'unit�.
     * @param pv                 Points de vie restant de l'unit�.
     * @param pvMax              Points de vie maximum de l'unit�.
     * @param ptDeDeplacement    Points de d�placement restant de l'unit�.
     * @param ptDeDeplacementMax Points de d�placement maximum de l'unit�.
     * @param vision             Vision de l'unit�.
     * @param porte              Port�e d'attaque de l'unit�.
     * @param x                  Num�ro de ligne de l'unit�.
     * @param y                  Num�ro de colonne de l'unit�.
     */
    public Unite(final int typeUnite, final int attaque, final int defense, final int pv, final int pvMax,
            final int ptDeDeplacement, final int ptDeDeplacementMax, final int vision, final int porte, final int x,
            final int y) {
        this.typeUnite = typeUnite;
        this.attaque = attaque;
        this.defense = defense;
        this.pv = pv;
        this.pvMax = pvMax;
        this.ptDeDeplacement = ptDeDeplacement;
        this.ptDeDeplacementMax = ptDeDeplacementMax;
        this.vision = vision;
        this.porte = porte;
        this.x = x;
        this.y = y;
        this.estAttaquee = false;
    }
    
    //EN ATTENDANT LA VUE
    public String toString() {
        return "Type: "+typeUnite+" PV: "+pv+" / "+pvMax+" PtDepl: "+ptDeDeplacement+" / "+ptDeDeplacementMax+" position: "+x+" "+y;
    }

    // JAVADOC A FAIRE
    public void attendreSecondClic() {
        // R�cup�rer les coordonn�es du second clic et les transformer en coordonn�es
        // map
        int x = 0, y = 0;
        secondClic(x, y);
    }

    // JAVADOC A FAIRE
    public void secondClic(int _x, int _y) { // avertir la vue si la position de l'unite change
        System.out.println("Test : X: " + _x + " Y: " + _y);

        HashMap<Hexagone, Integer> deplacementPossible = calculDeplacementPossible();
        ArrayList<Hexagone> aPorteDAttaque = aPorte(this.x, this.y);

        if (!deplacementPossible.isEmpty()) {

            Iterator iterator = deplacementPossible.entrySet().iterator();
            totality: while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                Hexagone h = (Hexagone) mapEntry.getKey();
                if (_x == h.getX() && _y == h.getY()) {
                    // La case a �t� trouv�e
                    for (Joueur j : Jeu.getListeJoueurs()) {
                        for (Unite u : j.getListeUnite()) {
                            if (_x == u.getX() && _y == u.getY()) {
                                // Une unit� est sur la case
                                if (j.getListeUnite().contains(this)) {
                                    // L'unit� est alli�e
                                    u.attendreSecondClic();
                                } else {
                                    if (aPorteDAttaque.contains(h)) {
                                        // L'unit� est � port�
                                        attaquer(u);
                                    }
                                }
                                break totality;
                            }
                        }
                    }
                    // Il n'y a pas d'unit� sur la case
                    this.x = _x;
                    this.y = _y;
                    this.ptDeDeplacement = (Integer) mapEntry.getValue();
                    break totality;
                }
            }
        }
    }

    // JAVADOC A FAIRE + CORRIGER WARNINGS
    /*
     * retourne un tableau avec en premier position la liste des déplacements
     * possibles et les points de mouvement restant et en deuxiéme la liste des
     * ennemis attaquable au corp à corp (si un tile de mer sépare deux unités
     * peut on attaquer quand même? ligne de vue?) .
     */
    public MyHashMap<Hexagone, Integer> calculDeplacementPossible() { // donne tout les hexagones possible dans la range de l'unite et les
                                                   // points de deplacement restant si elle s'y dirige
        Hexagone h = Jeu.getMap()[x][y]; // hexagone ou se situe l'unite
        MyHashMap<Hexagone, Integer> deplacementPossible = new MyHashMap<Hexagone, Integer>();
        MyHashMap<Hexagone, Integer> pointAExplorer = new MyHashMap<Hexagone, Integer>(); // couple hexagone/ point de
                                                                                          // deplacement restant
        ArrayList<Hexagone> caseVisible = Jeu.vision(this);
        //ArrayList<Unite> ennemiAttaquable = new ArrayList<Unite>();

        /*
         * for(Hexagone hex : caseVisible){ System.out.println("coord en x: "+hex.x);
         * System.out.println("coord en y: "+hex.y); }
         */
        Hexagone hexagoneCourant = h;
        // deplacementPossible.put(hexagoneCourant, ptDeDeplacement);
        pointAExplorer.put(hexagoneCourant, ptDeDeplacement);

        if (ptDeDeplacement != 0) { // si jamais un jour on donne la possibilité d'enlever des points de
                                    // déplacement évite les tours de boucle inutile

            while (!pointAExplorer.isEmpty()) {

                hexagoneCourant = (Hexagone) pointAExplorer.getFirstKey(); // on récupére le premier element de la
                                                                           // liste

                for (Hexagone v : hexagoneCourant.getListeVoisin()) { // on parcourt la liste de ses voisins
                	boolean libre = true;
                    test : for(Joueur j : Jeu.getListeJoueurs()) {
                    	for(Unite u: j.getListeUnite()) {
                    		if(u.getX()==v.getX() && u.getY()==v.getY()) {
                    			libre=false;
                    			break test;
                    		}
                    	}
                    }
                    if (v.getType() != Jeu.MER && caseVisible.contains(v) && libre) {

                        if (deplacementPossible.containsKey(v)) { // si il est déja dans la liste des déplacements
                                                                  // possible

                            if (pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement() > deplacementPossible
                                    .get(v)) {
                                // si le cout actuel est moins grand que l'ancien coût.

                                deplacementPossible.replace(v,
                                        pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());
                                if (pointAExplorer.containsKey(v))
                                    pointAExplorer.replace(v,
                                            pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());
                                else
                                    pointAExplorer.put(v,
                                            pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());
                            }
                        }
                        if (pointAExplorer.containsKey(v)) { // si il est déja en attente d'exploration

                            if (pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement() > pointAExplorer
                                    .get(v)) {
                                // si le cout actuel est moins grand que l'ancien coût.
                                pointAExplorer.replace(v,
                                        pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());

                            }
                        }
                        if (v.getCoutDeDeplacement() <= pointAExplorer.get(hexagoneCourant)) {
                            // si le cout de deplacement est inferieur ou egal à la distance restante et
                            // qu'il n'est pas déja dans une des listes
                            pointAExplorer.put(v, pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());

                        }

                    }
                } // fin du parcours des voisins
                if (!deplacementPossible.containsKey(hexagoneCourant))
                    deplacementPossible.put(hexagoneCourant, pointAExplorer.get(hexagoneCourant));
                pointAExplorer.remove(hexagoneCourant);

            } // fin de la boucle principal
        } else {
            System.out.println("Pas de point de deplacement");
        }

        return deplacementPossible;

    }

    // JAVADOC A FAIRE
    public ArrayList<Hexagone> aPorte(int x, int y) { // donne tout les hexagones visibles par l'unit�
        Hexagone h = Jeu.getMap()[x][y]; // hexagone ou se situe l'unite
        ArrayList<Hexagone> aPorte = new ArrayList();
        MyHashMap<Hexagone, Integer> AExplorer = new MyHashMap(); // couple hexagone/ point de deplacement restant

        Hexagone hexagoneCourant = h;
        aPorte.add(hexagoneCourant);
        AExplorer.put(hexagoneCourant, 0);

        while (!AExplorer.isEmpty()) {

            hexagoneCourant = (Hexagone) AExplorer.getFirstKey(); // on récupére le premier element de la liste
            for (Hexagone v : hexagoneCourant.getListeVoisin()) { // on parcourt la liste de ses voisins
                if (!aPorte.contains(v) && !AExplorer.containsKey(v) && AExplorer.get(hexagoneCourant) + 1 <= porte)
                    AExplorer.put(v, AExplorer.get(hexagoneCourant) + 1);

            } // fin du parcours des voisins
            if (!aPorte.contains(hexagoneCourant))
                aPorte.add(hexagoneCourant);
            AExplorer.remove(hexagoneCourant);

        } // fin de la boucle principal

        return aPorte;

    }

    /**
     * Applique la formule de calcul de d�g�ts sur l'unit� � attaquer.
     * 
     * @param unite Unit� � attaquer.
     * @see Unite#calculDegats(int)
     */
    public void attaquer(final Unite unite) {
        // si attaque possible
        unite.calculDegats(attaque);
    }

    /**
     * Calcul les d�g�ts sur l'unit� attaqu�e et les applique sur les PV.
     * 
     * @param attaque Points d'attaque de l'unit� qui attaque.
     */
    public void calculDegats(final int attaque) {
        final double borneInf = 0.5;
        final double borneSup = 1.5;
        double bonusDefense = Jeu.getMap()[x][y].getBonusDefense();
        double degats = (attaque - (defense * (1 + bonusDefense))) * getDoubleAleaBorne(borneInf, borneSup);
        pv -= (int) degats;
        if (pv <= 0) {
            for(Joueur joueur : Jeu.getListeJoueurs()) {
                if(joueur.getListeUnite().remove(this)) { //supprime l'unit� morte
                    return;
                }
            }
        }

    }

    /**
     * Soigne une unit� si elle ne s'est pas d�plac�e et n'a pas �t� attaqu�e.
     * 
     * @param taux Taux de soin.
     */
    public void soin(final double taux) {
        if (this.ptDeDeplacement == this.ptDeDeplacementMax && !this.estAttaquee) {
            this.pv += (int) this.pv * taux;
            if (this.pv > this.pvMax) {
                this.pv = this.pvMax;
            }
        }
    }

    /**
     * Retourne un double al�atoire entre les bornes min et max incluses.
     * 
     * @param min Borne minimum.
     * @param max Borne maximum.
     * @return un double al�atoire entre min et max.
     */
    public double getDoubleAleaBorne(final double min, final double max) {
        double res = (Math.random() * ((max - min) + 1)) + min;
        return res;
    }

    //////////////////////// Getter and Setter /////////////////////////

    /**
     * Retourne les points de d�fense de l'unit�.
     * 
     * @return les points de d�fense de l'unit�.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Met � jour les points de d�fense de l'unit�.
     * 
     * @param defense Les nouveaux points de d�fense de l'unit�.
     */
    public void setDefense(final int defense) {
        this.defense = defense;
    }

    /**
     * Retourne les points de vie restants de l'unit�.
     * 
     * @return les points de vie restants de l'unit�.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Met � jour les points de vie restants de l'unit�.
     * 
     * @param pv Les nouveaux points de vie restants de l'unit�.
     */
    public void setPv(final int pv) {
        this.pv = pv;
    }

    /**
     * Retourne les points de vie maximum de l'unit�.
     * 
     * @return les points de vie maximum de l'unit�.
     */
    public int getPvMax() {
        return pvMax;
    }

    /**
     * Retourne les points de d�placement restants de l'unit�.
     * 
     * @return les points de d�placement restants de l'unit�.
     */
    public int getPtDeDeplacement() {
        return ptDeDeplacement;
    }

    /**
     * Met � jour les points de d�placement restants de l'unit�.
     * 
     * @param ptDeDeplacement Les nouveaux points de d�placement restants de
     *                        l'unit�.
     */
    public void setPtDeDeplacement(final int ptDeDeplacement) {
        this.ptDeDeplacement = ptDeDeplacement;
    }

    /**
     * Retourne les points de d�placement maximum de l'unit�.
     * 
     * @return les points de d�placement maximum de l'unit�.
     */
    public int getPtDeDeplacementMax() {
        return ptDeDeplacementMax;
    }

    /**
     * Retourne le num�ro de ligne de l'unit�.
     * 
     * @return le num�ro de ligne de l'unit�.
     */
    public int getX() {
        return x;
    }

    /**
     * Met � jour le num�ro de ligne de l'unit�.
     * 
     * @param x Le nouveau num�ro de ligne de l'unit�.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Retourne le num�ro de colonne de l'unit�.
     * 
     * @return le num�ro de colonne de l'unit�.
     */
    public int getY() {
        return y;
    }

    /**
     * Met � jour le num�ro de colonne de l'unit�.
     * 
     * @param y Le nouveau num�ro de colonne de l'unit�.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Retourne les points d'attaque de l'unit�.
     * 
     * @return les points d'attaque de l'unit�.
     */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Met � jour les points d'attaque de l'unit�.
     * 
     * @param attaque Les nouveaux points d'attaque de l'unit�.
     */
    public void setAttaque(final int attaque) {
        this.attaque = attaque;
    }

    /**
     * Retourne la vision de l'unit�.
     * 
     * @return la vision de l'unit�.
     */
    public int getVision() {
        return vision;
    }

    /**
     * Met � jour la vision de l'unit�.
     * 
     * @param vision La nouvelle vision de l'unit�.
     */
    public void setVision(final int vision) {
        this.vision = vision;
    }

    /**
     * Retourne la port�e de tir de l'unit�.
     * 
     * @return la port�e de tir de l'unit�.
     */
    public int getPorte() {
        return porte;
    }

    /**
     * Met � jour la port�e de tir de l'unit�.
     * 
     * @param porte La nouvelle port�e de tir de l'unit�.
     */
    public void setPorte(final int porte) {
        this.porte = porte;
    }

    /**
     * Retourne le type de l'unit�.
     * 
     * @return le type de l'unit�.
     */
    public int getTypeUnite() {
        return typeUnite;
    }

    /**
     * Met � jour le type de l'unit�.
     * 
     * @param typeUnite Le nouveau type de l'unit�.
     */
    public void setTypeUnite(final int typeUnite) {
        this.typeUnite = typeUnite;
    }

}

