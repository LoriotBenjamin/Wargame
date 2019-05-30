package modele;

import controleur.Jeu;

/**
 * Village est la classe représentant un type d'Hexagone. Ses caractéristiques sont :
 * <ul>
 * <li>Points de déplacement : 1</li>
 * <li>Bonus de défense : 30 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Village extends Hexagone {
    /**
     * Valeur des points de déplacement du Village.
     */
    private static final int POINTDEPLACEMENT = 1;
    /**
     * Valeur du bonus de défense du Village.
     */
    private static final double BONUSDEFENSE = 0.3;

    /**
     * Conctructeur Village.
     * @param x
     *      Numéro de ligne sur le plateau.
     * @param y
     *      Numéro de colonne sur le plateau.
     */
    public Village(final int x, final int y) {
        super(Jeu.VILLAGE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
