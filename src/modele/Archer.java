package modele;

import controleur.Jeu;

/**
 * Archer est la classe repr�sentant une unit� d'Archer. Ses caract�ristiques sont :
 * <ul>
 * <li>Attaque : 14</li>
 * <li>D�fense : 4</li>
 * <li>PV : 28</li>
 * <li>D�placement : 4</li>
 * <li>Vision : 4</li>
 * <li>Port�e : 3</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Archer extends Unite {
    /**
     * Valeur de l'attaque de l'Archer.
     */
    private static final int ATTAQUE = 14;
    /**
     * Valeur de la d�fense de l'Archer.
     */
    private static final int DEFENSE = 4;
    /**
     * Valeur des PV de l'Archer.
     */
    private static final int PV = 28;
    /**
     * Valeur du d�placement de l'Archer.
     */
    private static final int DEPLACEMENT = 4;
    /**
     * Valeur de la vision de l'Archer.
     */
    private static final int VISION = 4;
    /**
     * Valeur de la port�e de l'Archer.
     */
    private static final int PORTEE = 3;

    /**
     * Constructeur Archer avec ses constantes.
     */
    public Archer(int equipe,int x,int y) {
        super(Jeu.ARCHER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, x, y,equipe);
    }

}
