package modele;

import controleur.Jeu;

/**
 * Archer est la classe représentant une unité d'Archer. Ses caractéristiques sont :
 * <ul>
 * <li>Attaque : 14</li>
 * <li>Défense : 6</li>
 * <li>PV : 38</li>
 * <li>Déplacement : 4</li>
 * <li>Vision : 4</li>
 * <li>Portée : 3</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Archer extends Unite {
    /**
     * Valeur de l'attaque de l'Archer.
     */
    private static final int ATTAQUE = 14;
    /**
     * Valeur de la défense de l'Archer.
     */
    private static final int DEFENSE = 6;
    /**
     * Valeur des PV de l'Archer.
     */
    private static final int PV = 38;
    /**
     * Valeur du déplacement de l'Archer.
     */
    private static final int DEPLACEMENT = 4;
    /**
     * Valeur de la vision de l'Archer.
     */
    private static final int VISION = 4;
    /**
     * Valeur de la portée de l'Archer.
     */
    private static final int PORTEE = 3;

    /**
     * Constructeur Archer avec ses constantes.
     * @param equipe
     *      Le numéro du joueur associé à cette unité.
     * @param x
     *      Le numéro de ligne de l'unité.
     * @param y
     *      Le numéro de colonne de l'unité.
     */
    public Archer(final int equipe, final int x, final int y) {
        super(Jeu.ARCHER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, x, y, equipe);
    }

}
