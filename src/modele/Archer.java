package modele;

import controleur.Jeu;

/**
 * Archer est la classe représentant une unité d'Archer. Ses caractéristiques sont :
 * <ul>
 * <li>Attaque : 14</li>
 * <li>Défense : 4</li>
 * <li>PV : 28</li>
 * <li>Déplacement : 4</li>
 * <li>Vision : 4</li>
 * <li>Portée : 3</li>
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
     * Valeur de la défense de l'Archer.
     */
    private static final int DEFENSE = 4;
    /**
     * Valeur des PV de l'Archer.
     */
    private static final int PV = 28;
    /**
     * Valeur du déplacement de l'Archer.
     */
    private static final int DEPLACEMENT = 4;
    /**
     * Valeur de la vision de l'Archer.
     */
    private static final int VISION = 4;
    /**
     * Valeur de la portée de l'Archer.
     */
    private static final int PORTEE = 3;

    /**
     * Constructeur Archer avec ses constantes.
     */
    public Archer() {
        super(Jeu.ARCHER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0);
    }

}
