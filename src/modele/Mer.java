package modele;

import controleur.Jeu;

/**
 * Mer est la classe représentant un type d'Hexagone. Ses caractéristiques sont :
 * <ul>
 * <li>Points de déplacement : aucun</li>
 * <li>Bonus de défense : 0 %</li>
 * </ul>
 * @author Solenn
 * @see Hexagone
 *
 */
public class Mer extends Hexagone {
    /**
     * Valeur des points de déplacement de la Mer. Aucune unité ne peut s'y déplacer, donc ses points de déplacement
     * doivent être supérieurs au plus grand potentiel de déplacement des unités.
     */
    private static final int POINTDEPLACEMENT = 20;
    /**
     * Valeur du bonus de défense de la Mer.
     */
    private static final double BONUSDEFENSE = 0;

    /**
     * Conctructeur Mer.
     * @param x
     *      Numéro de ligne sur le plateau.
     * @param y
     *      Numéro de colonne sur le plateau.
     */
    public Mer(final int x, final int y) {
        super(Jeu.MER, BONUSDEFENSE, POINTDEPLACEMENT, x, y);
    }

}
