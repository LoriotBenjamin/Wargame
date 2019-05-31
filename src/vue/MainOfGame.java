package vue;

import java.awt.EventQueue;

import modele.Archer;
import modele.Chevalier;
import modele.Guerrier;
import modele.Humain;
import modele.Hexagone;
import modele.IA;
import modele.Joueur; // à retirer d'ici 
import modele.Mage;
import controleur.Jeu;
import controleur.MainJFrame;

public class MainOfGame {

	public static void main(String[] args) {
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); */
		//Interface I =new Interface();
		Jeu.initMap(); // pour test
		Humain j1 = new Humain(1, "J1"); // juste pour tester
		Jeu.getListeJoueurs().add(j1);
		IA j2 = new IA(2, "IA2"); // juste pour tester
		Jeu.getListeJoueurs().add(j2);
		//Jeu.chargerPartie("save");
		Jeu.controlAffichageUnite();
		
		game : do {
		    for (Joueur joueur : Jeu.getListeJoueurs()) {
				int joueursEnVie = Jeu.getListeJoueurs().size();
		        joueur.jouerTour();
		        for(Joueur player : Jeu.getListeJoueurs()) {
		        	if(player.getListeUnite().size() == 0)
		        		joueursEnVie--;
		        }
		        if(joueursEnVie == 1)
		        	break game;
		    }
		}while(true);
		
		System.out.println("Un joueur a gagné");
	
		//Jeu.sauvegarderPartie("save");
		
	}

	}


