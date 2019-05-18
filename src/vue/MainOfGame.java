package vue;

import java.awt.EventQueue;

import modele.Guerrier;
import modele.Joueur; // à retirer d'ici 
import modele.Mage;
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
		Data.initListeVoisin();
		
		Guerrier guerrier=new Guerrier();
		Mage mage= new Mage();
		System.out.println("PV = " + guerrier.getPv());
		mage.attaquer(guerrier);
		System.out.println("PV = " + guerrier.getPv());
		guerrier.soin(0.1);
		System.out.println("PV = " + guerrier.getPv());
		
	}

	}


