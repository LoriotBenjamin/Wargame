package modele;

import java.awt.Point;
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
 * <li>Son équipe</li>
 * </ul>
 * @author Solenn
 *
 */
public class Unite {
    /**
     * Type de l'unité représenté par un entier entre 1 et 5.
     * @see Unite#getTypeUnite()
     * @see Unite#setTypeUnite(int)
     */
    protected int typeUnite; // peut etre remplace par un .getClass() supprimant cette variable mais un peu
    // plus long dans les tests que des comparaisons avec un int je pense
    /**
     * Points d'attaque de l'unité.
     * @see Unite#getAttaque()
     * @see Unite#setAttaque(int)
     */
    protected int attaque;
    /**
     * Points de défense de l'unité.
     * @see Unite#getDefense()
     * @see Unite#setDefense(int)
     */
    protected int defense;
    /**
     * Points de vie restant de l'unité.
     * @see Unite#getPv()
     * @see Unite#setPv(int)
     */
    protected int pv;
    /**
     * Points de vie maximum de l'unité.
     * @see Unite#getPvMax()
     */
    protected int pvMax;
    /**
     * Points de déplacement restant de l'unité.
     * @see Unite#getPtDeDeplacement()
     * @see Unite#setPtDeDeplacement(int)
     */
    protected int ptDeDeplacement;
    /**
     * Points de déplacement maximum de l'unité par tour.
     * @see Unite#getPtDeDeplacementMax()
     */
    protected int ptDeDeplacementMax;
    /**
     * Points de vision de l'unité.
     * @see Unite#getVision()
     * @see Unite#setVision(int)
     */
    protected int vision;
    /**
     * Portée des attaques de l'unité.
     * @see Unite#getPorte()
     * @see Unite#setPorte(int)
     */
    protected int porte;
    /**
     * Numéro de ligne de l'unité.
     * @see Unite#getX()
     * @see Unite#setX(int)
     */
    protected int x;
    /**
     * Numéro de colonne de l'unité.
     * @see Unite#getY()
     * @see Unite#setY(int)
     */
    protected int y;
    /**
     * Liste des ennemis attaquables par l'unité.
     * @see Unite#getEnnemiAttaquable()
     * @see Unite#setEnnemiAttaquable(ArrayList)
     */
    protected ArrayList<Unite> ennemiAttaquable = new ArrayList<Unite>();
    /**
     * Numéro de l'équipe de l'unite.
     * @see Unite#setEquipe(int)
     */
    protected int equipe;
    /**
     * Droit d'action de l'unitér.
     */
    protected boolean acted;

    /**
     * Constructeur Unité.
     * @param typeUnite       Type de l'unité.
     * @param attaque         Points d'attaque de l'unité.
     * @param defense         Points de défense de l'unité.
     * @param pv              Points de vie restant de l'unité.
     * @param ptDeDeplacement Points de déplacement restant de l'unité.
     * @param vision          Vision de l'unité.
     * @param porte           Portée d'attaque de l'unité.
     * @param x               Numéro de ligne de l'unité.
     * @param y               Numéro de colonne de l'unité.
     * @param equipe          Numéro de l'équipe de l'unite.
     */
    public Unite(final int typeUnite, final int attaque, final int defense, final int pv, final int ptDeDeplacement,
            final int vision, final int porte, final int x, final int y, final int equipe) {
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
        this.equipe = equipe;
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
     * @param equipe             Numéro de l'équipe de l'unite.
     */
    public Unite(final int typeUnite, final int attaque, final int defense, final int pv, final int pvMax,
            final int ptDeDeplacement, final int ptDeDeplacementMax, final int vision, final int porte, final int x,
            final int y, final int equipe) {
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
        this.equipe = equipe;
    }

    // EN ATTENDANT LA VUE
    public String toString() {
        return "Type: " + typeUnite + " PV: " + pv + " / " + pvMax + " PtDepl: " + ptDeDeplacement + " / "
                + ptDeDeplacementMax + " position: " + x + " " + y;
    }

    // JAVADOC A FAIRE
    public boolean selected() {
    	HashMap<Hexagone, Integer> deplacementPossible = calculDeplacementPossible();
    	HashMap<Hexagone, String> action = actionPossible();
        //ArrayList<Hexagone> aPorteDAttaque = aPorte(this.x, this.y);
        Jeu.setDeplacementPossibleHash(deplacementPossible);
        Jeu.setActionPossibleHash(action);
        Jeu.affichageDeplacementPossible();
    	System.out.println(this.toString()+" A votre service!\n");
    	Point hexagone = new Point(-2, -2);
        do {
        	System.out.print("");//ABSOLUMENT NECESSAIRE!!
        	if(Jeu.getSkipFlag()||!Jeu.hasStarted()) {
        		Jeu.setSkipFlag(false);
            	return true;
        	}
        	if(Jeu.getClicFlag()) {
            	hexagone = Jeu.getCoordHexaClicked();
            	Jeu.setClicFlag(false);
        	}
        }while(hexagone.x == -2 || hexagone.y == -2);
    	System.out.println("CASE CLIQUEE LIGNE: "+hexagone.x+" COLONNE: "+hexagone.y);
    	
        if(secondClic(hexagone.x, hexagone.y,deplacementPossible))
        	return true;
        return false;
    }

    /**
     * Prend en parametre les coordoonees du seocnd clic et 
     * trouve l'hexagone sur lequelle le second clic a ete effectué,
     * cherche si c'est une unite ennemie, si c'est le cas alors declenche l'attaque ,
     * si c'est une unite allie verifie que l'ordre ne vient pas d'un pretre pour soigner
     * si c'est le cas soigne l'allie sinon si la case est vide alors deplace l'unite
     * 
     * 
     * @param _x
     * @param _y
     */
    public boolean secondClic(int _x, int _y,HashMap<Hexagone,Integer>deplacementPossible) { // avertir la vue si la position de l'unite change
        System.out.println("Test : X: " + _x + " Y: " + _y);

        if(_x >= 0 && _y >= 0) {
			Hexagone hexaVisee = Jeu.getMap()[_x][_y] ; 
			Hexagone hexaDeLunite = Jeu.getMap()[this.x][this.y];
			
			if (deplacementPossible.containsKey(Jeu.getMap()[_x][_y])){
			System.out.println("CASE VIDE");
			this.x = _x;
			this.y = _y;
			System.out.println("pm restant: "+deplacementPossible.get(hexaVisee));
			this.ptDeDeplacement = deplacementPossible.get(hexaVisee);
			System.out.println("JE SUIS EN " + x + " " + y);
			}else {
				tests : for (Joueur j : Jeu.getListeJoueurs()) {
	                for (Unite u : j.getListeUnite()) {
	
	                    if ( hexaVisee.getX() == u.getX() && hexaVisee.getY() == u.getY()) {
	                    	
	                        // Une unité est sur la case
	                        System.out.println("CASE OCCUPEE");
	                        if (u.getTeamUnite() == this.getTeamUnite()) {
	                            // L'unité est alliée
	                            System.out.println("UNITE ALLIEE");
	                            if (typeUnite == Jeu.PRETRE && acted == false &&
	                            		hexaDeLunite.getDistanceBetweenTwoPosition(hexaVisee) <= this.porte) {
	                                System.out.println("SOIN");
	                                int pdvAvSoin = u.getPv();
	                                ((Pretre)(this)).soigner(u);
	                                Jeu.setLastAttaque("Le prêtre a soigné de: "+(pdvAvSoin-u.getPv()));
	                            } else {
	                            	System.out.println("Changement d'unité");
	                                return u.selected();
	                            }
	                        } else {
	                            System.out.println("UNITE ENNEMIE");
	                            if (hexaDeLunite.getDistanceBetweenTwoPosition(hexaVisee) <= this.porte && acted == false) {
	                                System.out.println("TAPER");
	                                // L'unité est à porté d'attaque
	                                int pdvAvAtt = u.getPv();
	                                attaquer(u);
	                                Jeu.setLastAttaque("L'unité du joueur: "+j.getPseudo()+" a subi: "+(pdvAvAtt-u.getPv())+" \n de dégat(s)");
	                                break tests;
	                            }
	                        }
	                        
	                    }
	                    
	                }
	            }
				
			}
        }
		Jeu.affichageUnite();
		return false;
    }

    /**
     * Retourne la liste des déplacements possible avec les points de mouvement
     * restant une fois la case atteinte. Elle remplit aussi la liste des ennemis
     * attaquables.
     * 
     * @return la liste des déplacements possibles associés aux points de mouvement
     *         restants
     * @see MyHashMap
     */
    public MyHashMap<Hexagone, Integer> calculDeplacementPossible() { // donne tout les hexagones possible dans la range
                                                                      // de l'unite et les
        // points de deplacement restant si elle s'y dirige
        Hexagone h = Jeu.getMap()[x][y]; // hexagone ou se situe l'unite
        MyHashMap<Hexagone, Integer> deplacementPossible = new MyHashMap<Hexagone, Integer>();
        MyHashMap<Hexagone, Integer> pointAExplorer = new MyHashMap<Hexagone, Integer>(); // couple hexagone/ point de
                                                                                          // deplacement restant

        this.ennemiAttaquable.clear();

        Joueur joueurCourant = this.getPlayerWhoControlMe();
        ArrayList<Hexagone> caseVisible = joueurCourant.sansBrouillard();
        // ArrayList<Unite> ennemiAttaquable = new ArrayList<Unite>();

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
                    test: for (Joueur j : Jeu.getListeJoueurs()) {
                        for (Unite u : j.getListeUnite()) {
                            if (u.getX() == v.getX() && u.getY() == v.getY()) {
                                libre = false;                             
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
                                if (pointAExplorer.containsKey(v)) {
                                    pointAExplorer.replace(v,
                                            pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());
                                } else {
                                    pointAExplorer.put(v,
                                            pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());
                                }
                            }
                        } else if (pointAExplorer.containsKey(v)) { // si il est déja en attente d'exploration

                            if (pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement() > pointAExplorer
                                    .get(v)) {
                                // si le cout actuel est moins grand que l'ancien coût.
                                pointAExplorer.replace(v,
                                        pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());

                            }
                        } else if (v.getCoutDeDeplacement() <= pointAExplorer.get(hexagoneCourant)) {
                            // si le cout de deplacement est inferieur ou egal à la distance restante et
                            // qu'il n'est pas déja dans une des listes
                            pointAExplorer.put(v, pointAExplorer.get(hexagoneCourant) - v.getCoutDeDeplacement());

                        }

                    }
                } // fin du parcours des voisins
                if (!deplacementPossible.containsKey(hexagoneCourant)) {
                    deplacementPossible.put(hexagoneCourant, pointAExplorer.get(hexagoneCourant));
                }
                pointAExplorer.remove(hexagoneCourant);

            } // fin de la boucle principal
        } else {
            System.out.println("Pas de point de deplacement");
        }

        return deplacementPossible;

    }

   
    /**
     * Retourne le joueur propriétaire de l'unité.
     * 
     * @return le joueur propriétaire de l'unité.
     */
    public Joueur getPlayerWhoControlMe() {

        for (Joueur j : Jeu.getListeJoueurs()) {
            if (j.getNumeroJoueur() == this.equipe) {
                return j;
            }
        }
        return null;
    }

    // JAVADOC A FAIRE
    /**
     * Retourne tous les hexagones à portée d'une case pour une unité.
     * @return
     *      Une liste d'hexagones avec lesquels une interaction est possible.
     */
    public MyHashMap<Hexagone,String> actionPossible() { // donne tout les hexagones avec lesquels l'unité peut interagir
        Hexagone h = Jeu.getMap()[x][y]; // hexagone ou se situe l'unite
        MyHashMap<Hexagone, String> actionPossible = new MyHashMap<Hexagone,String>();
        MyHashMap<Hexagone, Integer> aExplorer = new MyHashMap<Hexagone, Integer>(); // couple hexagone/ point de
                                                                                     // deplacement restant

        Hexagone hexagoneCourant = h;
        aExplorer.put(hexagoneCourant, 0);

        while (!aExplorer.isEmpty()) {

            hexagoneCourant = (Hexagone) aExplorer.getFirstKey(); // on récupére le premier element de la liste
            for (Hexagone v : hexagoneCourant.getListeVoisin()) { // on parcourt la liste de ses voisins
                if (!actionPossible.containsKey(v) && !aExplorer.containsKey(v) && aExplorer.get(hexagoneCourant) + 1 <= porte) {
                    aExplorer.put(v, aExplorer.get(hexagoneCourant) + 1);
                }

            } // fin du parcours des voisins
            if (!actionPossible.containsKey(hexagoneCourant)) {
            	for(Joueur j : Jeu.getListeJoueurs()) {
            		for(Unite u : j.getListeUnite()) {
            			if(u.getX() == hexagoneCourant.getX() && u.getY() == hexagoneCourant.getY()) {
            				if(u.getTeamUnite() == this.getTeamUnite()) {
            					if(this.getTypeUnite()==Jeu.PRETRE && u!=this && acted == false)
                					actionPossible.put(hexagoneCourant, "allie");
            				}else if(acted == false){
            					actionPossible.put(hexagoneCourant, "ennemi");
            				}
            			}
            		}
            	}
            }
            aExplorer.remove(hexagoneCourant);

        } // fin de la boucle principal

        return actionPossible;

    }

    /**
     * Retourne tous les hexagones dans le champ de vision d'une unité.
     * @return
     *      Une liste d'hexagones dans le champ de vision d'une unité.
     */
    public ArrayList<Hexagone> vision() { // donne tout les hexagones visibles par l'unité
        Hexagone h = Jeu.getMap()[x][y]; // hexagone ou se situe l'unite
        ArrayList<Hexagone> nofog = new ArrayList<Hexagone>();
        MyHashMap<Hexagone, Integer> aExplorer = new MyHashMap<Hexagone, Integer>(); // couple hexagone/ point de
                                                                                     // deplacement restant

        Hexagone hexagoneCourant = h;
        aExplorer.put(hexagoneCourant, 0);

        while (!aExplorer.isEmpty()) {

            hexagoneCourant = (Hexagone) aExplorer.getFirstKey(); // on récupére le premier element de la liste
            for (Hexagone v : hexagoneCourant.getListeVoisin()) { // on parcourt la liste de ses voisins
                if (!aExplorer.containsKey(v) && aExplorer.get(hexagoneCourant) + 1 <= vision) {
                    aExplorer.put(v, aExplorer.get(hexagoneCourant) + 1);
                }

            } // fin du parcours des voisins
            if (!nofog.contains(hexagoneCourant)) {
                nofog.add(hexagoneCourant);
            }
            aExplorer.remove(hexagoneCourant);

        } // fin de la boucle principal

        return nofog;

    }

    /**
     * Applique la formule de calcul de dégâts sur l'unité à attaquer.
     * @param unite Unité à attaquer.
     * @see Unite#calculDegats(int)
     */
    public void attaquer(final Unite unite) {
        // si attaque possible
        if(unite.calculDegats(attaque) && porte > 1) {
        	x = unite.getX();
        	y = unite.getY();
        }
        acted = true;
        ptDeDeplacement = 0;
    }

    /**
     * Calcul les dégâts sur l'unité attaquée et les applique sur les PV.
     * @param attaque Points d'attaque de l'unité qui attaque.
     */
    public boolean calculDegats(final int attaque) {
        final double borneInf = 0.5;
        final double borneSup = 1.5;
        double bonusDefense = Jeu.getMap()[x][y].getBonusDefense();
        double degats = (attaque - (defense * (1 + bonusDefense))) * getDoubleAleaBorne(borneInf, borneSup);
        System.out.println(degats);
        if(degats > 0) {
            pv -= (int) degats;
            if (pv <= 0) {
                for (Joueur joueur : Jeu.getListeJoueurs()) {
                    if (joueur.getListeUnite().remove(this)) { // supprime l'unité morte
                    	System.out.println("JE SUIS MORTE!");
                        return true;
                    }
                }
            }
        }
        return false;

    }

    /**
     * Soigne une unité si elle ne s'est pas déplacée.
     * @param taux Taux de soin.
     */
    public void soin(final double taux) {
        if (this.ptDeDeplacement == this.ptDeDeplacementMax) {
            this.pv += (int) this.pvMax * taux;
            if (this.pv > this.pvMax) {
                this.pv = this.pvMax;
            }
        }
    }

    /**
     * Retourne un double aléatoire entre les bornes min et max incluses.
     * @param min Borne minimum.
     * @param max Borne maximum.
     * @return un double aléatoire entre min et max.
     */
    public double getDoubleAleaBorne(final double min, final double max) {
        double res = (Math.random() * ((max - min) + 1)) + min;
        return res;
    }
    
    public void soigner(Unite unite) {
        
    }
    
    /**
     * Redonne à l'unité tous ses points de déplacement et son droit d'action et la soigne.
     */
    public void preparerPourProchainTour() {
        soin(Jeu.SOIN);
        this.ptDeDeplacement = this.ptDeDeplacementMax;
        acted = false;
    }

    //////////////////////// Getter and Setter /////////////////////////

    /**
     * Retourne les points de défense de l'unité.
     * @return les points de défense de l'unité.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Met à jour les points de défense de l'unité.
     * @param defense Les nouveaux points de défense de l'unité.
     */
    public void setDefense(final int defense) {
        this.defense = defense;
    }

    /**
     * Retourne les points de vie restants de l'unité.
     * @return les points de vie restants de l'unité.
     */
    public int getPv() {
        return pv;
    }

    /**
     * Met à jour les points de vie restants de l'unité.
     * @param pv Les nouveaux points de vie restants de l'unité.
     */
    public void setPv(final int pv) {
        this.pv = pv;
    }

    /**
     * Retourne les points de vie maximum de l'unité.
     * @return les points de vie maximum de l'unité.
     */
    public int getPvMax() {
        return pvMax;
    }

    /**
     * Retourne les points de déplacement restants de l'unité.
     * @return les points de déplacement restants de l'unité.
     */
    public int getPtDeDeplacement() {
        return ptDeDeplacement;
    }

    /**
     * Met à jour les points de déplacement restants de l'unité.
     * @param ptDeDeplacement Les nouveaux points de déplacement restants de
     *                        l'unité.
     */
    public void setPtDeDeplacement(final int ptDeDeplacement) {
        this.ptDeDeplacement = ptDeDeplacement;
    }

    /**
     * Retourne les points de déplacement maximum de l'unité.
     * @return les points de déplacement maximum de l'unité.
     */
    public int getPtDeDeplacementMax() {
        return ptDeDeplacementMax;
    }

    /**
     * Retourne le numéro de ligne de l'unité.
     * @return le numéro de ligne de l'unité.
     */
    public int getX() {
        return x;
    }

    /**
     * Met à jour le numéro de ligne de l'unité.
     * @param x Le nouveau numéro de ligne de l'unité.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Retourne le numéro de colonne de l'unité.
     * @return le numéro de colonne de l'unité.
     */
    public int getY() {
        return y;
    }

    /**
     * Met à jour le numéro de colonne de l'unité.
     * @param y Le nouveau numéro de colonne de l'unité.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Retourne les points d'attaque de l'unité.
     * @return les points d'attaque de l'unité.
     */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Met à jour les points d'attaque de l'unité.
     * @param attaque Les nouveaux points d'attaque de l'unité.
     */
    public void setAttaque(final int attaque) {
        this.attaque = attaque;
    }

    /**
     * Retourne la vision de l'unité.
     * @return la vision de l'unité.
     */
    public int getVision() {
        return vision;
    }

    /**
     * Met à jour la vision de l'unité.
     * @param vision La nouvelle vision de l'unité.
     */
    public void setVision(final int vision) {
        this.vision = vision;
    }

    /**
     * Retourne la portée de tir de l'unité.
     * @return la portée de tir de l'unité.
     */
    public int getPorte() {
        return porte;
    }

    /**
     * Met à jour la portée de tir de l'unité.
     * @param porte La nouvelle portée de tir de l'unité.
     */
    public void setPorte(final int porte) {
        this.porte = porte;
    }

    /**
     * Retourne le type de l'unité.
     * @return le type de l'unité.
     */
    public int getTypeUnite() {
        return typeUnite;
    }

    /**
     * Met à jour le type de l'unité.
     * @param typeUnite Le nouveau type de l'unité.
     */
    public void setTypeUnite(final int typeUnite) {
        this.typeUnite = typeUnite;
    }

    /**
     * Retourne la liste d'ennemis attaquables.
     * @return la liste d'ennemis attaquables.
     */
    public ArrayList<Unite> getEnnemiAttaquable() {
        return ennemiAttaquable;
    }

    /**
     * Met à jour la liste d'ennemis attaquables.
     * @param ennemiAttaquable  La nouvelle liste d'ennemis attaquables.
     */
    public void setEnnemiAttaquable(ArrayList<Unite> ennemiAttaquable) {
        this.ennemiAttaquable = ennemiAttaquable;
    }

    /**
     * Retourne le type de l'unité.
     * @return le type de l'unité.
     */
    public int getTeamUnite() {
        return equipe;
    }

    /**
     * Met à jour l'équipe de l'unité.
     * @param equipe La nouvelle équipe de l'unité.
     */
    public void setEquipe(final int equipe) {
        this.equipe = equipe;
    }

}
