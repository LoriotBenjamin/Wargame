package modele;

import controleur.Jeu;

/**
 * Plaine est la classe représentant un type d'Hexagone. Ses caractéristiques sont :
 * <ul>
 * <li>Points de déplacement : 1</li>
 * <li>Bonus de défense : 10 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Plaine extends Hexagone {
    /**
     * Valeur des points de déplacement de la Plaine.
     */
    private static final int POINTDEPLACEMENT = 1;
    /**
     * Valeur du bonus de défense de la Plaine.
     */
    private static final double BONUSDEFENSE = 0.1;

    /**
     * Conctructeur Plaine.
     * @param x
     *      Numéro de ligne sur le plateau.
     * @param y
     *      Numéro de colonne sur le plateau.
     */
    public Plaine(final int x, final int y) {
        super(Jeu.PLAINE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
