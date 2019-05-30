package modele;

import controleur.Jeu;

/**
 * Mage est la classe représentant une unité de Mage. Ses caractéristiques sont :
 * <ul>
 * <li>Attaque : 16</li>
 * <li>Défense : 2</li>
 * <li>PV : 24</li>
 * <li>Déplacement : 3</li>
 * <li>Vision : 3</li>
 * <li>Portée : 2</li>
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
     * Valeur de la défense du Mage.
     */
    private static final int DEFENSE = 2;
    /**
     * Valeur des PV du Mage.
     */
    private static final int PV = 24;
    /**
     * Valeur du déplacement du Mage.
     */
    private static final int DEPLACEMENT = 3;
    /**
     * Valeur de la vision du Mage.
     */
    private static final int VISION = 3;
    /**
     * Valeur de la portée du Mage.
     */
    private static final int PORTEE = 2;

    /**
     * Constructeur Mage avec ses constantes.
     */
    public Mage() {
        super(Jeu.MAGE, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0);
    }

}
