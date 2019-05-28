package modele;

/**
 * IA est la classe représentant un joueur Ordinateur.
 * @author Solenn
 * @see Joueur
 */
public class IA extends Joueur {
    /**
     * Numéro de sérial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = 4118767757581824513L;

    /**
     * Constructeur IA.
     * @param numeroJoueur
     *      Le numéro du joueur.
     * @param pseudo
     *      Le pseudo du joueur.
     */
    public IA(final int numeroJoueur, final String pseudo) {
        super(numeroJoueur, pseudo);
    }

    /**
     * Joue un tour de jeu automatiquement avec une stratégie agressive.
     */
    public void jouerTour() {
        for (Unite unite : listeUnite) {
            // si attaque possible sur un des déplacements possibles => déplacement puis
            // attaque
            /*
             * else { unite.soin(0.1); //gérer le soin du pretre ? }
             */
        }
    }

}
