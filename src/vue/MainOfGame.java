package vue;

import java.awt.EventQueue;

import modele.Guerrier;
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
		Joueur j1 = new Joueur(1, "jean"); // juste pour tester
		Jeu.getListeJoueurs().add(j1);
		Joueur j2 = new Joueur(1, "Baptiste"); // juste pour tester
		Jeu.getListeJoueurs().add(j2);
		//Jeu.chargerPartie("save");
		Jeu.initListeVoisin();
		try{
			MainJFrame mainFrame = new MainJFrame();
			mainFrame.getFrame().setVisible(true);
			
		}catch(Exception e){
			
		}
	
		
		Guerrier guerrier1=(Guerrier) Jeu.getListeJoueurs().get(0).getListeUnite().get(0);
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
		Jeu.sauvegarderPartie("save");
		
	}

	}


