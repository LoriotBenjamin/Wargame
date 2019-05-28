package modele;

import controleur.Jeu;

/**
 * Forêt est la classe représentant un type d'Hexagone. Ses caractéristiques sont :
 * <ul>
 * <li>Points de déplacement : 2</li>
 * <li>Bonus de défense : 50 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Foret extends Hexagone {
    /**
     * Valeur des points de déplacement de la Forêt.
     */
    private static final int POINTDEPLACEMENT = 2;
    /**
     * Valeur du bonus de défense de la Forêt.
     */
    private static final double BONUSDEFENSE = 0.5;

    /**
     * Conctructeur Forêt.
     * @param x
     *      Numéro de ligne sur le plateau.
     * @param y
     *      Numéro de colonne sur le plateau.
     */
    public Foret(final int x, final int y) {
        super(Jeu.FORET, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
        // TODO Auto-generated constructor stub
    }

}
