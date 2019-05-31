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
		
		
		for(int cpt=0;cpt<10;cpt++) {
		    for(Joueur joueur : Jeu.getListeJoueurs()) {
		        System.out.println();
		        for (int i = 0; i < Jeu.MAPLIGNE; i++) {
		            for (int j = 0; j < Jeu.MAPCOLONNE; j++) {
		                System.out.print(Jeu.getMap()[i][j]);
		            }
		            System.out.println();
		        }
		        
		        joueur.jouerTour();
		        
		        System.out.println();
		        for (int i = 0; i < Jeu.MAPLIGNE; i++) {
                    for (int j = 0; j < Jeu.MAPCOLONNE; j++) {
                        System.out.print(Jeu.getMap()[i][j]);
                    }
                    System.out.println();
                }
		    }
		}
	
		Jeu.sauvegarderPartie("save");
		
	}

	}


