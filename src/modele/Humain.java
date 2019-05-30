package modele;

import controleur.Jeu;
import java.awt.Point;

/**
 * Humain est la classe représentant un joueur humain.
 * @author Solenn
 * @see Joueur
 */
public class Humain extends Joueur {

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
    
    public void jouerTour() {
    	int dep = 0;
    	do {
    		//Attente de l'impossibilité pour le joueur de continuer son tour
	    	boolean selected = false;
	    	do {
	    		//Attente d'un clic sur une unité alliée
		    	Point mouse;
		    	int hX = -1;
		    	int hY = -1;
		    	selected = false;
		    	do {
		    		//Attante d'un clic sur un hexagone
				    do {
				    	//Attente d'un cic dans la fenetre du plateau
				       	mouse = Jeu.getFrame().getClicPos();
				       	System.out.println(mouse);
				    }while(mouse.x == -1 && mouse.y == -1);
			        int X = mouse.y;
			        int Y = mouse.x;
			        find : for(int ligne=0;ligne<Jeu.MAPLIGNE;ligne++) {
			        	for(int colonne=0;colonne<Jeu.MAPCOLONNE;colonne++) {
			        		int refX = 30 + 45*ligne;
			        		int refY = 26*colonne%2 + 52*colonne;
			        		if(Y >= refY && Y <= refY+52) {
			        			int dX = (int)(30- 15.0 / 26.0 * (Math.abs(refY+26-Y)));
			        			if(X >= refX-dX && X <= refX+dX) {
			        				hX = ligne;
			        				hY = colonne;
			        				break find;
			        			}
			        		}
			        	}
			        }
		    	}while(hX < 0 || hY < 0 || hX >= Jeu.MAPLIGNE || hY >= Jeu.MAPCOLONNE);
		    	for(Unite u : listeUnite) {
	        		if(u.getX() == hX && u.getY() == hY) {
	        			u.selected();
	        			selected = true;
	        		}
	        		dep+=u.getPtDeDeplacement();
	        	}
	    	}while(!selected);
    	}while(dep > 0);
    }
}
