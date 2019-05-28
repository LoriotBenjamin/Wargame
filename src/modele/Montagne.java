package modele;

import controleur.Jeu;

/**
 * Montagne est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : 3</li>
 * <li>Bonus de d�fense : 70 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Montagne extends Hexagone {
    /**
     * Valeur des points de d�placement de la Montagne.
     */
    private static final int POINTDEPLACEMENT = 3;
    /**
     * Valeur du bonus de d�fense de la Montagne.
     */
    private static final double BONUSDEFENSE = 0.7;

    /**
     * Conctructeur Montagne.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Montagne(final int x, final int y) {
        super(Jeu.MONTAGNE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
