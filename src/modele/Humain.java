package modele;

/**
 * Humain est la classe représentant un joueur humain.
 * @author Solenn
 * @see Joueur
 */
public class Humain extends Joueur {

    /**
     * Numéro de sérial Version pour la sauvegarde.
     */
    private static final long serialVersionUID = -6558755708485039078L;

    /**
     * Constructeur Humain.
     * @param numeroJoueur
     *      Le numéro du joueur.
     * @param pseudo
     *      Le pseudo du joueur.
     */
    public Humain(final int numeroJoueur, final String pseudo) {
        super(numeroJoueur, pseudo);
    }

}
