package modele;

import controleur.Jeu;

/**
 * For�t est la classe repr�sentant un type d'Hexagone. Ses caract�ristiques sont :
 * <ul>
 * <li>Points de d�placement : 2</li>
 * <li>Bonus de d�fense : 50 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Foret extends Hexagone {
    /**
     * Valeur des points de d�placement de la For�t.
     */
    private static final int POINTDEPLACEMENT = 2;
    /**
     * Valeur du bonus de d�fense de la For�t.
     */
    private static final double BONUSDEFENSE = 0.5;

    /**
     * Conctructeur For�t.
     * @param x
     *      Num�ro de ligne sur le plateau.
     * @param y
     *      Num�ro de colonne sur le plateau.
     */
    public Foret(final int x, final int y) {
        super(Jeu.FORET, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
        // TODO Auto-generated constructor stub
    }

}
