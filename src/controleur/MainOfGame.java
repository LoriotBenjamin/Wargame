package controleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modele.Joueur; // à retirer d'ici 
import vue.Menu;

public class MainOfGame {

	public static void main(String[] args) {
		totality : do {
    		Menu menu = new Menu();
    		Joueur winner = null;
    		do {
    			System.out.println("HELLO");
    			do {System.out.print("");}while(Jeu.hasStarted() == false);
    			System.out.println("YOHOHOHO");
    			//Jeu.chargerPartie("save");
    			Jeu.affichageUnite();
    			
    			do {
    			    ArrayList<Joueur> perdant = new ArrayList<Joueur>();
    			    for (Joueur joueur : Jeu.getListeJoueurs()) { //tour des joueurs chacun leur tour
    			        joueur.jouerTour();
    			        if(!Jeu.hasStarted())
    			        	continue totality;
    			        if(joueur.getListeUnite().size() == 0) { //mise en mémoire des perdants
    			            perdant.add(joueur);
    			        }
    			    }
    			    if(!perdant.isEmpty()) {//on enlève les perdants de la liste
    			        Jeu.getListeJoueurs().removeAll(perdant);
    			    }
    			}while(Jeu.getListeJoueurs().size() > 1 && Jeu.hasStarted());
    			Jeu.affichageUnite();
    			winner = Jeu.getListeJoueurs().get(0);
    		}while(winner == null);
            Jeu.kill();
            JOptionPane.showMessageDialog(null, "Fin de la partie.\n"+winner.getPseudo() + " a gagné.", "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
		} while(true);
	}

}