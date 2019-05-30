package modele;

import controleur.Jeu;

/**
 * Mage est la classe repr�sentant une unit� de Mage. Ses caract�ristiques sont :
 * <ul>
 * <li>Attaque : 16</li>
 * <li>D�fense : 2</li>
 * <li>PV : 24</li>
 * <li>D�placement : 3</li>
 * <li>Vision : 3</li>
 * <li>Port�e : 2</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Mage extends Unite {
    /**
     * Valeur de l'attaque du Mage.
     */
    private static final int ATTAQUE = 16;
    /**
     * Valeur de la d�fense du Mage.
     */
    private static final int DEFENSE = 2;
    /**
     * Valeur des PV du Mage.
     */
    private static final int PV = 24;
    /**
     * Valeur du d�placement du Mage.
     */
    private static final int DEPLACEMENT = 3;
    /**
     * Valeur de la vision du Mage.
     */
    private static final int VISION = 3;
    /**
     * Valeur de la port�e du Mage.
     */
    private static final int PORTEE = 2;

    /**
     * Constructeur Mage avec ses constantes.
     */
    public Mage(int equipe) {
        super(Jeu.MAGE, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0,equipe);
    }

}
