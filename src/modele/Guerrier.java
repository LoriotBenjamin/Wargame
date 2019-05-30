package modele;

import controleur.Jeu;

/**
 * Guerrier est la classe représentant une unité de Guerrier. Ses caractéristiques sont :
 * <ul>
 * <li>Attaque : 18</li>
 * <li>Défense : 8</li>
 * <li>PV : 36</li>
 * <li>Déplacement : 3</li>
 * <li>Vision : 2</li>
 * <li>Portée : 1</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Guerrier extends Unite {
    /**
     * Valeur de l'attaque du Guerrier.
     */
    private static final int ATTAQUE = 18;
    /**
     * Valeur de la défense du Guerrier.
     */
    private static final int DEFENSE = 8;
    /**
     * Valeur des PV du Guerrier.
     */
    private static final int PV = 36;
    /**
     * Valeur du déplacement du Guerrier.
     */
    private static final int DEPLACEMENT = 3;
    /**
     * Valeur de la vision du Guerrier.
     */
    private static final int VISION = 2;
    /**
     * Valeur de la portée du Guerrier.
     */
    private static final int PORTEE = 1;

    /**
     * Constructeur Guerrier avec ses constantes.
     */
    public Guerrier() {
        super(Jeu.GUERRIER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0);
    }

}
