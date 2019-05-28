package modele;

import controleur.Jeu;

/**
 * Plaine est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : 1</li>
 * <li>Bonus de d�fense : 10 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Plaine extends Hexagone {
    /**
     * Valeur des points de d�placement de la Plaine.
     */
    private static final int POINTDEPLACEMENT = 1;
    /**
     * Valeur du bonus de d�fense de la Plaine.
     */
    private static final double BONUSDEFENSE = 0.1;

    /**
     * Conctructeur Plaine.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Plaine(final int x, final int y) {
        super(Jeu.PLAINE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
