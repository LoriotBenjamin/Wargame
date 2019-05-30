package modele;

import controleur.Jeu;

/**
 * Chevalier est la classe représentant une unité de Chevalier. Ses caractéristiques sont :
 * <ul>
 * <li>Attaque : 20</li>
 * <li>Défense : 6</li>
 * <li>PV : 40</li>
 * <li>Déplacement : 6</li>
 * <li>Vision : 2</li>
 * <li>Portée : 1</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Chevalier extends Unite {
    /**
     * Valeur de l'attaque du Chevalier.
     */
    private static final int ATTAQUE = 20;
    /**
     * Valeur de la défense du Chevalier.
     */
    private static final int DEFENSE = 6;
    /**
     * Valeur des PV du Chevalier.
     */
    private static final int PV = 40;
    /**
     * Valeur du déplacement du Chevalier.
     */
    private static final int DEPLACEMENT = 6;
    /**
     * Valeur de la vision du Chevalier.
     */
    private static final int VISION = 2;
    /**
     * Valeur de la portée du Chevalier.
     */
    private static final int PORTEE = 1;

    /**
     * Constructeur Chevalier avec ses constantes.
     * @param equipe
     *      Le numéro du joueur associé à cette unité.
     * @param x
     *      Le numéro de ligne de l'unité.
     * @param y
     *      Le numéro de colonne de l'unité.
     */
    public Chevalier(final int equipe, final int x, final int y) {
        super(Jeu.CHEVALIER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, x, y, equipe);
    }

}
