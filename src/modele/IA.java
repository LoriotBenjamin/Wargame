package modele;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import controleur.Jeu;

/**
 * IA est la classe représentant un joueur Ordinateur.
 * @author Solenn
 * @see Joueur
 */
public class IA extends Joueur {

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
    @Override
    public void jouerTour() {
        for (Unite unite : this.getListeUnite()) {
            boolean attaque = false;
            MyHashMap<Hexagone, Integer> deplacementPossible = unite.calculDeplacementPossible();
            Iterator<Map.Entry<Hexagone, Integer>> iterator = deplacementPossible.entrySet().iterator();

            while (!attaque && iterator.hasNext()) {
                Map.Entry<Hexagone, Integer> mapEntry = iterator.next();
                Hexagone hexagone = mapEntry.getKey();

                recherche: for (Joueur joueur : Jeu.getListeJoueurs()) {
                    if (joueur != this) {
                        for (Unite uniteAdverse : joueur.getListeUnite()) {
                            if (unite.getTypeUnite() != Jeu.PRETRE && hexagone.getDistanceBetweenTwoPosition(
                                            Jeu.getMap()[uniteAdverse.getX()][uniteAdverse.getY()] ) <= unite.getPorte()) {
                                // unité à portée d'attaque trouvée
                                unite.setX(hexagone.getX());
                                unite.setY(hexagone.getY());
                                unite.setPtDeDeplacement((Integer) mapEntry.getValue());
                                Jeu.jeRepaint();
                                System.out.println("Attaque de " + joueur.getPseudo());
                                System.out.println(unite);
                                System.out.println("sur " + uniteAdverse);
                                unite.attaquer(uniteAdverse);
                                System.out.println("Résultat :");
                                System.out.println(unite);
                                System.out.println(uniteAdverse);

                                attaque = true;

                                deplacementPossible = unite.calculDeplacementPossible();
                                
                                break recherche;

                            }
                        }
                    } 
                }
            }
            
            if(unite.getTypeUnite() == Jeu.PRETRE) {
                for(Unite uniteAlliee : listeUnite) {
                    if(uniteAlliee != unite && uniteAlliee.getPv() != uniteAlliee.getPvMax() 
                            && Jeu.getMap()[unite.getX()][unite.getY()].getDistanceBetweenTwoPosition(
                                    Jeu.getMap()[uniteAlliee.getX()][uniteAlliee.getY()]) <= unite.getPorte()) {
                        //soigne unités alliées à portée
                        System.out.println(unite + "\nsoigne" + "\n" + uniteAlliee);
                        unite.soigner(uniteAlliee);
                    }
                }
            }
            
            final double pourcentagePV = 0.75;
   
            if (!deplacementPossible.isEmpty() &&  unite.getPv() >= (int) (pourcentagePV * unite.getPvMax())) {
                // si deplacement possible et plus de 75% de PV restant alors déplacement aléatoire

                Object[] tabDeplacementPossible = deplacementPossible.keySet().toArray();
                Object key = tabDeplacementPossible[new Random().nextInt(tabDeplacementPossible.length)];
                Hexagone hexagone = (Hexagone) key;
                unite.setX(hexagone.getX());
                unite.setY(hexagone.getY());
                unite.setPtDeDeplacement((Integer) deplacementPossible.get(key));
                Jeu.jeRepaint();
                System.out.println("Déplacement sans attaquer:");
                System.out.println(unite);
            } 
            
        }
        for (Unite unite : this.getListeUnite()) {
            unite.preparerPourProchainTour();
        }
    }
}
