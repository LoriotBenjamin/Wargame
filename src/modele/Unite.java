package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import controleur.Jeu;

/**
 * Unité est la classe représentant un type de personnage. Ses caractéristiques
 * sont :
 * <ul>
 * <li>Son type, qui est un entier entre 1 et 5 représentant chacun un type
 * différent</li>
 * <li>Ses points d'attaque</li>
 * <li>Ses points de défense</li>
 * <li>Ses points de vie ou PV restants</li>
 * <li>Ses PV maximum</li>
 * <li>Ses points de déplacement restants</li>
 * <li>Ses points de déplacement maximum</li>
 * <li>Ses points de vision</li>
 * <li>Sa portée</li>
 * <li>Ses coordonnées sur le plateau</li>
 * </ul>
 * @author Solenn
 *
 */
public class Unite implements Serializable {
    /**
     * Numéro de sérial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = 2569571978178827188L;
    /**
     * Type de l'unité représenté par un entier entre 1 et 5.
     * @see Unite#getTypeUnite()
     * @see Unite#setTypeUnite(int)
     */
    private int typeUnite; // peut etre remplace par un .getClass() supprimant cette variable mais un peu
    // plus long dans les tests que des comparaisons avec un int je pense
    /**
     * Points d'attaque de l'unité.
     * @see Unite#getAttaque()
     * @see Unite#setAttaque(int)
     */
    private int attaque;
    /**
     * Points de défense de l'unité.
     * @see Unite#getDefense()
     * @see Unite#setDefense(int)
     */
    private int defense;
    /**
     * Points de vie restant de l'unité.
     * @see Unite#getPv()
     * @see Unite#setPv(int)
     */
    private int pv;
    /**
     * Points de vie maximum de l'unité.
     * @see Unite#getPvMax()
     */
    private int pvMax;
    /**
     * Points de déplacement restant de l'unité.
     * @see Unite#getPtDeDeplacement()
     * @see Unite#setPtDeDeplacement(int)
     */
    private int ptDeDeplacement;
    /**
     * Points de déplacement maximum de l'unité par tour.
     * @see Unite#getPtDeDeplacementMax()
     */
    private int ptDeDeplacementMax;
    /**
     * Points de vision de l'unité.
     * @see Unite#getVision()
     * @see Unite#setVision(int)
     */
    private int vision;
    /**
     * Portée des attaques de l'unité.
     * @see Unite#getPorte()
     * @see Unite#setPorte(int)
     */
    private int porte;
    /**
     * Numéro de ligne de l'unité.
     * @see Unite#getX()
     * @see Unite#setX(int)
     */
    private int x;
    /**
     * Numéro de colonne de l'unité.
     * @see Unite#getY()
     * @see Unite#setY(int)
     */
    private int y;
    /**
     * Permet de savoir si l'unitée a été attaquée pendant le tour ou non.
     */
    private boolean estAttaquee;
    /**
     * Liste des ennemis attaquable par l'unité.
     */
    private ArrayList<Unite> ennemiAttaquable = new ArrayList<Unite>();

    /**
     * Constructeur Unité.
     * @param typeUnite       Le type de l'unité.
     * @param attaque         Les points d'attaque de l'unité.
     * @param defense         Les points de défense de l'unité.
     * @param pv              Les points de vie de l'unité.
     * @param ptDeDeplacement Les points de déplacement de l'unité.
     * @param vision          La vision de l'unité.
     * @param porte           La portée de l'unité.
     * @param x               Le numéro de ligne de l'unité.
     * @param y               Le numéro de colonne de l'unité.
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
     * Constructeur Unité.
     * @param typeUnite          Type de l'unité.
     * @param attaque            Points d'attaque de l'unité.
     * @param defense            Points de défense de l'unité.
     * @param pv                 Points de vie restant de l'unité.
     * @param pvMax              Points de vie maximum de l'unité.
     * @param ptDeDeplacement    Points de déplacement restant de l'unité.
     * @param ptDeDeplacementMax Points de déplacement maximum de l'unité.
     * @param vision             Vision de l'unité.
     * @param porte              Portée d'attaque de l'unité.
     * @param x                  Numéro de ligne de l'unité.
     * @param y                  Numéro de colonne de l'unité.
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
        // Récupérer les coordonnées du second clic et les transformer en coordonnées
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
                    // La case a été trouvée
                    for (Joueur j : Jeu.getListeJoueurs()) {
                        for (Unite u : j.getListeUnite()) {
                            if (_x == u.getX() && _y == u.getY()) {
                                // Une unité est sur la case
                                if (j.getListeUnite().contains(this)) {
                                    // L'unité est alliée
                                    u.attendreSecondClic();
                                } else {
                                    if (aPorteDAttaque.contains(h)) {
                                        // L'unité est à porté
                                        attaquer(u);
                                    }
                                }
                                break totality;
                            }
                        }
                    }
                    // Il n'y a pas d'unité sur la case
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
     * retourne un tableau avec en premier position la liste des dÃ©placements
     * possibles et les points de mouvement restant et en deuxiÃ©me la liste des
     * ennemis attaquable au corp Ã  corp (si un tile de mer sÃ©pare deux unitÃ©s
     * peut on attaquer quand mÃªme? ligne de vue?) .
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

        if (ptDeDeplacement != 0) { // si jamais un jour on donne la possibilitÃ© d'enlever des points de
                                    // dÃ©placement Ã©vite les tours de boucle inutile

            while (!pointAExplorer.isEmpty()) {

                hexagoneCourant = (Hexagone) pointAExplorer.getFirstKey(); // on rÃ©cupÃ©re le premier element de la
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

                        if (deplacementPossible.containsKey(v)) { // si il est dÃ©ja dans la liste des dÃ©placements
                                                                  // possible

                            if (pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement() > deplacementPossible
                                    .get(v)) {
                                // si le cout actuel est moins grand que l'ancien coÃ»t.

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
                        if (pointAExplorer.containsKey(v)) { // si il est dÃ©ja en attente d'exploration

                            if (pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement() > pointAExplorer
                                    .get(v)) {
                                // si le cout actuel est moins grand que l'ancien coÃ»t.
                                pointAExplorer.replace(v,
                                        pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());

                            }
                        }
                        if (v.getCoutDeDeplacement() <= pointAExplorer.get(hexagoneCourant)) {
                            // si le cout de deplacement est inferieur ou egal Ã  la distance restante et
                            // qu'il n'est pas dÃ©ja dans une des listes
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
    public ArrayList<Hexagone> aPorte(int x, int y) { // donne tout les hexagones visibles par l'unitï¿½
        Hexagone h = Jeu.getMap()[x][y]; // hexagone ou se situe l'unite
        ArrayList<Hexagone> aPorte = new ArrayList();
        MyHashMap<Hexagone, Integer> AExplorer = new MyHashMap(); // couple hexagone/ point de deplacement restant

        Hexagone hexagoneCourant = h;
        aPorte.add(hexagoneCourant);
        AExplorer.put(hexagoneCourant, 0);

        while (!AExplorer.isEmpty()) {

            hexagoneCourant = (Hexagone) AExplorer.getFirstKey(); // on rÃ©cupÃ©re le premier element de la liste
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
     * Applique la formule de calcul de dégâts sur l'unité à attaquer.
     * 
     * @param unite Unité à attaquer.
     * @see Unite#calculDegats(int)
     */
    public void attaquer(final Unite unite) {
        // si attaque possible
        unite.calculDegats(attaque);
    }

    /**
     * Calcul les dégâts sur l'unité attaquée et les applique sur les PV.
     * 
     * @param attaque Points d'attaque de l'unité qui attaque.
     */
    public void calculDegats(final int attaque) {
        final double borneInf = 0.5;
        final double borneSup = 1.5;
        double bonusDefense = Jeu.getMap()[x][y].getBonusDefense();
        double degats = (attaque - (defense * (1 + bonusDefense))) * getDoubleAleaBorne(borneInf, borneSup);
        pv -= (int) degats;
        if (pv <= 0) {
            for(Joueur joueur : Jeu.getListeJoueurs()) {
                if(joueur.getListeUnite().remove(this)) { //supprime l'unité morte
                    return;
                }
            }
        }

    }

    /**
     * Soigne une unité si elle ne s'est pas déplacée et n'a pas été attaquée.
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
     * Retourne un double aléatoire entre les bornes min et max incluses.
     * 
     * @param min Borne minimum.
     * @param max Borne maximum.
     * @return un double aléatoire entre min et max.
     */
    public double getDoubleAleaBorne(final double min, final double max) {
        double res = (Math.random() * ((max - min) + 1)) + min;
        return res;
    }

    //////////////////////// Getter and Setter /////////////////////////

    /**
     * Retourne les points de défense de l'unité.
     * 
     * @return les points de défense de l'unité.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Met à jour les points de défense de l'unité.
     * 
     * @param defense Les nouveaux points de défense de l'unité.
     */
    public void setDefense(final int defense) {
        this.defense = defense;
    }

    /**
     * Retourne les points de vie restants de l'unité.
     * 
     * @return les points de vie restants de l'unité.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Met à jour les points de vie restants de l'unité.
     * 
     * @param pv Les nouveaux points de vie restants de l'unité.
     */
    public void setPv(final int pv) {
        this.pv = pv;
    }

    /**
     * Retourne les points de vie maximum de l'unité.
     * 
     * @return les points de vie maximum de l'unité.
     */
    public int getPvMax() {
        return pvMax;
    }

    /**
     * Retourne les points de déplacement restants de l'unité.
     * 
     * @return les points de déplacement restants de l'unité.
     */
    public int getPtDeDeplacement() {
        return ptDeDeplacement;
    }

    /**
     * Met à jour les points de déplacement restants de l'unité.
     * 
     * @param ptDeDeplacement Les nouveaux points de déplacement restants de
     *                        l'unité.
     */
    public void setPtDeDeplacement(final int ptDeDeplacement) {
        this.ptDeDeplacement = ptDeDeplacement;
    }

    /**
     * Retourne les points de déplacement maximum de l'unité.
     * 
     * @return les points de déplacement maximum de l'unité.
     */
    public int getPtDeDeplacementMax() {
        return ptDeDeplacementMax;
    }

    /**
     * Retourne le numéro de ligne de l'unité.
     * 
     * @return le numéro de ligne de l'unité.
     */
    public int getX() {
        return x;
    }

    /**
     * Met à jour le numéro de ligne de l'unité.
     * 
     * @param x Le nouveau numéro de ligne de l'unité.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Retourne le numéro de colonne de l'unité.
     * 
     * @return le numéro de colonne de l'unité.
     */
    public int getY() {
        return y;
    }

    /**
     * Met à jour le numéro de colonne de l'unité.
     * 
     * @param y Le nouveau numéro de colonne de l'unité.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Retourne les points d'attaque de l'unité.
     * 
     * @return les points d'attaque de l'unité.
     */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Met à jour les points d'attaque de l'unité.
     * 
     * @param attaque Les nouveaux points d'attaque de l'unité.
     */
    public void setAttaque(final int attaque) {
        this.attaque = attaque;
    }

    /**
     * Retourne la vision de l'unité.
     * 
     * @return la vision de l'unité.
     */
    public int getVision() {
        return vision;
    }

    /**
     * Met à jour la vision de l'unité.
     * 
     * @param vision La nouvelle vision de l'unité.
     */
    public void setVision(final int vision) {
        this.vision = vision;
    }

    /**
     * Retourne la portée de tir de l'unité.
     * 
     * @return la portée de tir de l'unité.
     */
    public int getPorte() {
        return porte;
    }

    /**
     * Met à jour la portée de tir de l'unité.
     * 
     * @param porte La nouvelle portée de tir de l'unité.
     */
    public void setPorte(final int porte) {
        this.porte = porte;
    }

    /**
     * Retourne le type de l'unité.
     * 
     * @return le type de l'unité.
     */
    public int getTypeUnite() {
        return typeUnite;
    }

    /**
     * Met à jour le type de l'unité.
     * 
     * @param typeUnite Le nouveau type de l'unité.
     */
    public void setTypeUnite(final int typeUnite) {
        this.typeUnite = typeUnite;
    }

}

