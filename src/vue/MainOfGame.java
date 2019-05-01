package vue;

import java.awt.EventQueue;

import modele.Joueur; // à retirer d'ici 

import controleur.Data;

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
		Data.initMap(); // pour test
		Joueur j1 = new Joueur(1, "jean"); // juste pour tester
		
		
		
	}

	}


