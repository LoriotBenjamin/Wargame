package vue;

import java.awt.EventQueue;

import modele.Archer;
import modele.Chevalier;
import modele.Guerrier;
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
		IA j1 = new IA(1, "IA1"); // juste pour tester
		Jeu.getListeJoueurs().add(j1);
		IA j2 = new IA(2, "IA2"); // juste pour tester
		Jeu.getListeJoueurs().add(j2);
		//Jeu.chargerPartie("save");
		Jeu.initListeVoisin();
		try{
			MainJFrame mainFrame = new MainJFrame();
			mainFrame.getFrame().setVisible(true);
			
		}catch(Exception e){
			
		}
		
		for(Joueur joueur : Jeu.getListeJoueurs()) {
		    Archer archer = new Archer();
		    
		    Chevalier chevalier = new Chevalier();
		    
		    Guerrier guerrier = new Guerrier();
		    
		    if(joueur == j1) {
		        archer.setX(0);
		        archer.setY(0);
		        chevalier.setX(0);
                chevalier.setY(1);
                guerrier.setX(0);
                guerrier.setY(2);
		    } else {
		        archer.setX(8);
                archer.setY(10);
                chevalier.setX(8);
                chevalier.setY(9);
                guerrier.setX(8);
                guerrier.setY(8); 
		    }
		    joueur.getListeUnite().add(archer);
		    joueur.getListeUnite().add(chevalier);
		    joueur.getListeUnite().add(guerrier);
		}
		
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
	
		
		/*Guerrier guerrier1=(Guerrier) Jeu.getListeJoueurs().get(0).getListeUnite().get(0);
		Guerrier guerrier2=(Guerrier) Jeu.getListeJoueurs().get(1).getListeUnite().get(0);

		guerrier2.setX(1);
		guerrier2.setY(0);
		System.out.println("pos x:"+guerrier2.getX()+" y: "+guerrier2.getY()+" ptDeDeplacementRestant: "+guerrier2.getPtDeDeplacement());
		
		Mage mage= new Mage();
		System.out.println("PV = " + guerrier1.getPv());
		mage.attaquer(guerrier1);
		System.out.println("PV = " + guerrier1.getPv());
		guerrier1.soin(0.1);
		System.out.println("PV = " + guerrier1.getPv());
		
		System.out.println("pos x:"+guerrier1.getX()+" y: "+guerrier1.getY()+" ptDeDeplacementRestant: "+guerrier1.getPtDeDeplacement());
		guerrier1.secondClic(8,8);	// impossible car 3 point de deplacement
		System.out.println("pos x:"+guerrier1.getX()+" y: "+guerrier1.getY()+" ptDeDeplacementRestant: "+guerrier1.getPtDeDeplacement());
		//guerrier.verifierSiDeplacementPossible(3,3);	// possible
		System.out.println("PV guerrier ennemi= " + guerrier2.getPv());
		guerrier1.secondClic(1,0);
		System.out.println("PV guerrier ennemi= " + guerrier2.getPv());
		System.out.println("pos x:"+guerrier1.getX()+" y: "+guerrier1.getY()+" ptDeDeplacementRestant: "+guerrier1.getPtDeDeplacement());
		
		guerrier1.secondClic(5,0);
		System.out.println("pos x:"+guerrier1.getX()+" y: "+guerrier1.getY()+" ptDeDeplacementRestant: "+guerrier1.getPtDeDeplacement());
		
		Jeu.save();
		Jeu.sauvegarderPartie("save");*/
		
	}

	}


