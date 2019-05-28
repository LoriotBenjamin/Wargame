package modele;

import controleur.Jeu;

/**
 * Village est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : 1</li>
 * <li>Bonus de d�fense : 30 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Village extends Hexagone {
    /**
     * Valeur des points de d�placement du Village.
     */
    private static final int POINTDEPLACEMENT = 1;
    /**
     * Valeur du bonus de d�fense du Village.
     */
    private static final double BONUSDEFENSE = 0.3;

    /**
     * Conctructeur Village.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Village(final int x, final int y) {
        super(Jeu.VILLAGE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
