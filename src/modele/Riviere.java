package modele;

import controleur.Jeu;

/**
 * Rivi�re est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : 2</li>
 * <li>Bonus de d�fense : 10 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Riviere extends Hexagone {
    /**
     * Valeur des points de d�placement de la Rivi�re.
     */
    private static final int POINTDEPLACEMENT = 2;
    /**
     * Valeur du bonus de d�fense de la Rivi�re.
     */
    private static final double BONUSDEFENSE = 0.1;

    /**
     * Conctructeur Rivi�re.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Riviere(final int x, final int y) {
        super(Jeu.RIVIERE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
