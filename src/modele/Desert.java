package modele;

import controleur.Jeu;

/**
 * Desert est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : 2</li>
 * <li>Bonus de d�fense : 10 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Desert extends Hexagone {
    /**
     * Valeur des points de d�placement du D�sert.
     */
    private static final int POINTDEPLACEMENT = 2;
    /**
     * Valeur du bonus de d�fense du D�sert.
     */
    private static final double BONUSDEFENSE = 0.1;

    /**
     * Conctructeur D�sert.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Desert(final int x, final int y) {
        super(Jeu.DESERT, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
