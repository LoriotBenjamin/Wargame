package modele;

import controleur.Jeu;

/**
 * Pr�tre est la classe repr�sentant une unit� de Pr�tre. Ses caract�ristiques sont :
 * <ul>
 * <li>Attaque : 6</li>
 * <li>D�fense : 2</li>
 * <li>PV : 30</li>
 * <li>D�placement : 4</li>
 * <li>Vision : 2</li>
 * <li>Port�e : 1</li>
 * </ul>
 * @author Solenn
 * @see Unite
 *
 */
public class Pretre extends Unite {
    /**
     * Valeur de l'attaque du Pr�tre.
     */
    private static final int ATTAQUE = 6;
    /**
     * Valeur de la d�fense du Pr�tre.
     */
    private static final int DEFENSE = 2;
    /**
     * Valeur des PV du Pr�tre.
     */
    private static final int PV = 30;
    /**
     * Valeur du d�placement du Pr�tre.
     */
    private static final int DEPLACEMENT = 4;
    /**
     * Valeur de la vision du Pr�tre.
     */
    private static final int VISION = 2;
    /**
     * Valeur de la port�e du Pr�tre.
     */
    private static final int PORTEE = 1;
    /**
     * Valeur du soin du Pr�tre.
     */
    private static final double SOIN = 0.3;

    /**
     * Constructeur Pr�tre avec ses constantes.
     */
    public Pretre(int equipe,int x,int y) {
        super(Jeu.PRETRE, ATTAQUE, DEFENSE, PV, DEPLACEMENT, VISION, PORTEE, x, y,equipe);
    }
}
