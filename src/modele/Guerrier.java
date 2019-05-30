package modele;

import controleur.Jeu;

/**
 * Guerrier est la classe repr�sentant une unit� de Guerrier. Ses caract�ristiques sont :
 * <ul>
 * <li>Attaque : 18</li>
 * <li>D�fense : 8</li>
 * <li>PV : 36</li>
 * <li>D�placement : 3</li>
 * <li>Vision : 2</li>
 * <li>Port�e : 1</li>
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
     * Valeur de la d�fense du Guerrier.
     */
    private static final int DEFENSE = 8;
    /**
     * Valeur des PV du Guerrier.
     */
    private static final int PV = 36;
    /**
     * Valeur du d�placement du Guerrier.
     */
    private static final int DEPLACEMENT = 3;
    /**
     * Valeur de la vision du Guerrier.
     */
    private static final int VISION = 2;
    /**
     * Valeur de la port�e du Guerrier.
     */
    private static final int PORTEE = 1;

    /**
     * Constructeur Guerrier avec ses constantes.
     */
    public Guerrier(int equipe) {
        super(Jeu.GUERRIER, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, 0, 0,equipe);
    }

}
