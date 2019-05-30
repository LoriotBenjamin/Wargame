package modele;

import controleur.Jeu;

/**
 * Prêtre est la classe représentant une unité de Prêtre. Ses caractéristiques sont :
 * <ul>
 * <li>Attaque : 6</li>
 * <li>Défense : 2</li>
 * <li>PV : 30</li>
 * <li>Déplacement : 4</li>
 * <li>Vision : 2</li>
 * <li>Portée : 1</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Pretre extends Unite {
    /**
     * Valeur de l'attaque du Prêtre.
     */
    private static final int ATTAQUE = 6;
    /**
     * Valeur de la défense du Prêtre.
     */
    private static final int DEFENSE = 2;
    /**
     * Valeur des PV du Prêtre.
     */
    private static final int PV = 30;
    /**
     * Valeur du déplacement du Prêtre.
     */
    private static final int DEPLACEMENT = 4;
    /**
     * Valeur de la vision du Prêtre.
     */
    private static final int VISION = 2;
    /**
     * Valeur de la portée du Prêtre.
     */
    private static final int PORTEE = 1;
    /**
     * Valeur du soin du Prêtre.
     */
    private static final double SOIN = 0.3;

    /**
     * Constructeur Prêtre avec ses constantes.
     */
    public Pretre() {
        super(Jeu.PRETRE, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0);
    }
}
