package modele;

import controleur.Jeu;
import java.awt.Point;

/**
 * Humain est la classe repr�sentant un joueur humain.
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
    /**
     *  Execute un tour d'un joueur 
     */
    public void jouerTour() {
    	int deplacable = 0;
    	
    	for (Unite unite : this.getListeUnite()) { //remise des points de deplacement au max
            unite.setPtDeDeplacement(unite.getPtDeDeplacementMax());
        }
    	totality : do {
    		//Attente de l'impossibilit� pour le joueur de continuer son tour
    		boolean selected = false;
	    	do {
	    		deplacable = 0;
	    		//Attente d'un clic sur une unit� alli�e
	    		selected = false;
	    		Point hexagone = new Point(-1, -1);
	    		System.out.println("\nJ'attends");
	            do {
	            	System.out.print("");//ABSOLUMENT NECESSAIRE!!
	            	if(Jeu.getSkipFlag()) {
	            		Jeu.setSkipFlag(false);
	                	break totality;
	            	}
	            	if(Jeu.getClicFlag()) {
	                	hexagone = Jeu.getHexagonClicked();
	                	System.out.println("CLIC");
	                	Jeu.setClicFlag(false);
	            	}
	            }while(hexagone.x == -1 || hexagone.y == -1);
		    	System.out.println("CASE CLIQUEE LIGNE: "+hexagone.x+" COLONNE: "+hexagone.y);
		    	for(Unite u : listeUnite) {
	        		if(u.getX() == hexagone.x && u.getY() == hexagone.y) {
	        			System.out.println("UNITE TROUVEE");
	        			u.selected();
	        			selected = true;
	        		}
	        		int mindep = 10;
	        		for(Hexagone h : Jeu.getMap()[u.getX()][u.getY()].getListeVoisin()) {
	        			mindep = Math.min(mindep, h.getCoutDeDeplacement());
	        		}
	        		if(mindep<=u.getPtDeDeplacement())
	        			deplacable++;
	        	}
		    	System.out.println(deplacable);
	    	}while(!selected);
    	}while(deplacable > 0);
    }
}
