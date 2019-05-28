package modele;

/**
 * IA est la classe repr�sentant un joueur Ordinateur.
 * @author Solenn
 * @see Joueur
 */
public class IA extends Joueur {
    /**
     * Num�ro de s�rial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = 4118767757581824513L;

    /**
     * Constructeur IA.
     * @param numeroJoueur
     *      Le num�ro du joueur.
     * @param pseudo
     *      Le pseudo du joueur.
     */
    public IA(final int numeroJoueur, final String pseudo) {
        super(numeroJoueur, pseudo);
    }

    /**
     * Joue un tour de jeu automatiquement avec une strat�gie agressive.
     */
    public void jouerTour() {
        for (Unite unite : listeUnite) {
            // si attaque possible sur un des d�placements possibles => d�placement puis
            // attaque
            /*
             * else { unite.soin(0.1); //g�rer le soin du pretre ? }
             */
        }
    }

}
