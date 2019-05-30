package modele;

import controleur.Jeu;

/**
 * Chevalier est la classe repr�sentant une unit� de Chevalier. Ses caract�ristiques sont :
 * <ul>
 * <li>Attaque : 20</li>
 * <li>D�fense : 6</li>
 * <li>PV : 40</li>
 * <li>D�placement : 6</li>
 * <li>Vision : 2</li>
 * <li>Port�e : 1</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Chevalier extends Unite {
    /**
     * Valeur de l'attaque du Chevalier.
     */
    private static final int ATTAQUE = 20;
    /**
     * Valeur de la d�fense du Chevalier.
     */
    private static final int DEFENSE = 6;
    /**
     * Valeur des PV du Chevalier.
     */
    private static final int PV = 40;
    /**
     * Valeur du d�placement du Chevalier.
     */
    private static final int DEPLACEMENT = 6;
    /**
     * Valeur de la vision du Chevalier.
     */
    private static final int VISION = 2;
    /**
     * Valeur de la port�e du Chevalier.
     */
    private static final int PORTEE = 1;

    /**
     * Constructeur Chevalier avec ses constantes.
     */
    public Chevalier(int equipe) {
        super(Jeu.CHEVALIER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0,equipe);
    }

}
