package modele;

import controleur.Jeu;

/**
 * Desert est la classe représentant un type d'Hexagone. Ses caractéristiques sont :
 * <ul>
 * <li>Points de déplacement : 2</li>
 * <li>Bonus de défense : 10 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Desert extends Hexagone {
    /**
     * Valeur des points de déplacement du Désert.
     */
    private static final int POINTDEPLACEMENT = 2;
    /**
     * Valeur du bonus de défense du Désert.
     */
    private static final double BONUSDEFENSE = 0.1;

    /**
     * Conctructeur Désert.
     * @param x
     *      Numéro de ligne sur le plateau.
     * @param y
     *      Numéro de colonne sur le plateau.
     */
    public Desert(final int x, final int y) {
        super(Jeu.DESERT, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
