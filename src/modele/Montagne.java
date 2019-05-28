package modele;

import controleur.Jeu;

/**
 * Montagne est la classe représentant un type d'Hexagone. Ses caractéristiques sont :
 * <ul>
 * <li>Points de déplacement : 3</li>
 * <li>Bonus de défense : 70 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Montagne extends Hexagone {
    /**
     * Valeur des points de déplacement de la Montagne.
     */
    private static final int POINTDEPLACEMENT = 3;
    /**
     * Valeur du bonus de défense de la Montagne.
     */
    private static final double BONUSDEFENSE = 0.7;

    /**
     * Conctructeur Montagne.
     * @param x
     *      Numéro de ligne sur le plateau.
     * @param y
     *      Numéro de colonne sur le plateau.
     */
    public Montagne(final int x, final int y) {
        super(Jeu.MONTAGNE, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
