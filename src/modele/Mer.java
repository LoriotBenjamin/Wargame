package modele;

import controleur.Jeu;

/**
 * Mer est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : aucun</li>
 * <li>Bonus de d�fense : 0 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Mer extends Hexagone {
    /**
     * Valeur des points de d�placement de la Mer. Aucune unit� ne peut s'y d�placer, donc ses points de d�placement
     * doivent �tre sup�rieur au plus grand potentiel de d�placement des unit�s.
     */
    private static final int POINTDEPLACEMENT = 20;
    /**
     * Valeur du bonus de d�fense de la Mer.
     */
    private static final double BONUSDEFENSE = 0;

    /**
     * Conctructeur Mer.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Mer(final int x, final int y) {
        super(Jeu.MER, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
