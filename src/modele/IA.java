package modele;

import java.util.ArrayList;
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
        for (Unite unite : this.getListeUnite()) {
            Unite adversaire = null; //sauvegarde l'unité adverse en cas d'attaque pour décider si fuite après ou non
           
            MyHashMap<Hexagone, Integer> deplacementPossible = unite.calculDeplacementPossible();
            Iterator<?> iterator = deplacementPossible.entrySet().iterator();
            
            totality: while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                Hexagone hexagone = (Hexagone) mapEntry.getKey();
                ArrayList<Hexagone> aPorteeDAttaque = unite.aPorte(hexagone.getX(),hexagone.getY());
                for(Joueur joueur : Jeu.getListeJoueurs()) {
                    if(joueur!=this) {
                        for(Unite uniteAdverse : joueur.getListeUnite()) {
                            if(uniteAdverse.getX() != hexagone.getX() && uniteAdverse.getY() != hexagone.getY() 
                                    && aPorteeDAttaque.contains(Jeu.getMap()[uniteAdverse.getX()][uniteAdverse.getY()])) {
                                //unité à portée d'attaque trouvée
                                unite.setX(hexagone.getX());
                                unite.setY(hexagone.getY());
                                unite.setPtDeDeplacement((Integer) mapEntry.getValue());
                                System.out.println("Attaque de "+joueur.getPseudo());
                                System.out.println(unite);
                                System.out.println("sur "+uniteAdverse);
                                unite.attaquer(uniteAdverse);
                                System.out.println("Résultat :");
                                System.out.println(unite);
                                System.out.println(uniteAdverse);
                                
                                adversaire = uniteAdverse;
                                
                                deplacementPossible = unite.calculDeplacementPossible();
                                
                                break totality;
                            }
                        }
                    }
                }
            }
            if(!deplacementPossible.isEmpty() && 
                    ((adversaire != null && adversaire.getPorte() >= unite.getPorte()) 
                            || unite.getPv() >= (int) (0.75*unite.getPvMax()))) {
              //si portée adverse > à portée unité ou plus de 75% de PV restant alors déplacement aléatoire
                Object[] tabDeplacementPossible = deplacementPossible.keySet().toArray();
                Object key = tabDeplacementPossible[new Random().nextInt(tabDeplacementPossible.length)];
                Hexagone hexagone = (Hexagone) key;
                unite.setX(hexagone.getX());
                unite.setY(hexagone.getY());
                unite.setPtDeDeplacement((Integer) deplacementPossible.get(key));
                System.out.println("Déplacement sans attaquer :");
                System.out.println(unite);
            }
            else {
                System.out.println("Soin :");
                System.out.println(unite);
                unite.soin(Jeu.SOIN);
                System.out.println(unite);
            }
        }
        for (Unite unite : this.getListeUnite()) {
            unite.setPtDeDeplacement(unite.getPtDeDeplacementMax());
        }
    }
}
