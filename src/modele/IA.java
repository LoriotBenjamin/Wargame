package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import controleur.Jeu;

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
        for (Unite unite : this.getListeUnite()) {
            MyHashMap<Hexagone, Integer> deplacementPossible = unite.calculDeplacementPossible();
            Iterator<?> iterator = deplacementPossible.entrySet().iterator();
            totality: while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                Hexagone hexagone = (Hexagone) mapEntry.getKey();
                ArrayList<Hexagone> aPorteeDAttaque = unite.aPorte(hexagone.getX(),hexagone.getY());
                for(Joueur joueur : Jeu.getListeJoueurs()) {
                    if(joueur!=this) {
                        for(Unite uniteAdverse : joueur.getListeUnite()) {
                            if(aPorteeDAttaque.contains(Jeu.getMap()[uniteAdverse.getX()][uniteAdverse.getY()])) {
                                //unit� � port�e d'attaque trouv�e
                                unite.setX(hexagone.getX());
                                unite.setY(hexagone.getY());
                                unite.setPtDeDeplacement((Integer) mapEntry.getValue());
                                unite.attaquer(uniteAdverse);
                                break totality;
                            }
                        }
                    }
                }
            }
            if(unite.getPv() == unite.getPvMax()) {//si pas d'attaque possible et pas de soin possible alors d�placement al�atoire
                Object[] tabDeplacementPossible = deplacementPossible.keySet().toArray();
                Object key = tabDeplacementPossible[new Random().nextInt(tabDeplacementPossible.length)];
                Hexagone hexagone = (Hexagone) key;
                unite.setX(hexagone.getX());
                unite.setY(hexagone.getY());
                unite.setPtDeDeplacement((Integer) deplacementPossible.get(key));
            }
            else {
                unite.soin(Jeu.SOIN);
            }
        }
    }

}
