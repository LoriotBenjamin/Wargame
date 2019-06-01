package controleur;

import java.awt.EventQueue;
import java.util.ArrayList;

import modele.Archer;
import modele.Chevalier;
import modele.Guerrier;
import modele.Humain;
import modele.Hexagone;
import modele.IA;
import modele.Joueur; // à retirer d'ici 
import modele.Mage;

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
		Humain j1 = new Humain(1, "IA1"); // juste pour tester
		Jeu.getListeJoueurs().add(j1);
		IA j2 = new IA(2, "IA2"); // juste pour tester
		Jeu.getListeJoueurs().add(j2);
		//Jeu.chargerPartie("save");
		Jeu.controlAffichageUnite();
		
		do {
		    ArrayList<Joueur> perdant = new ArrayList<Joueur>();
		    for (Joueur joueur : Jeu.getListeJoueurs()) { //tour des joueurs chacun leur tour
		        joueur.jouerTour();
		        if(joueur.getListeUnite().size() == 0) { //mise en mémoire des perdants
		            perdant.add(joueur);
		        }
		    }
		    if(!perdant.isEmpty()) {//on enlève les perdants de la liste
		        Jeu.getListeJoueurs().removeAll(perdant);
		    }
		}while(Jeu.getListeJoueurs().size() > 1);
		
		System.out.println("Un joueur a gagné");
	
		//Jeu.sauvegarderPartie("save");
		
	}

	}


