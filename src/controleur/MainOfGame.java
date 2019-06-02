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
import vue.Menu;

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
		Menu menu = new Menu();
		int joueurs = 0;
		int ias = 0;
		System.out.println("HELLO");
		do {
			System.out.print("");
			joueurs = Jeu.getHumains();
			ias = Jeu.getIAs();
		}while(joueurs == 0 && ias == 0);
		System.out.println("YOHOHOHO");
		for(int i=1;i<=joueurs;i++) {
            Humain joueur = new Humain(i,"J"+i);
            Jeu.getListeJoueurs().add(joueur);
        }
        for(int i=joueurs+1;i<=joueurs+ias;i++) {
            IA ia = new IA(i,"IA"+i);
            Jeu.getListeJoueurs().add(ia);
        }
        Jeu.start();
		Jeu.initMap(); // pour test
        System.out.println(Jeu.getListeJoueurs());
        Jeu.getFrame().getFrame().setVisible(true);
		//Jeu.chargerPartie("save");
		Jeu.controlAffichageUnite();
		Jeu.affichageUnite();
		
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