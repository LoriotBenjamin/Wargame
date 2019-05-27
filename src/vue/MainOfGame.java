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
		//Joueur j1 = new Joueur(1, "jean"); // juste pour tester
		//Jeu.listeJoueurs.add(j1);
		Jeu.chargerPartie("save");
		Jeu.initListeVoisin();
		try{
			MainJFrame mainFrame = new MainJFrame();
			mainFrame.getFrame().setVisible(true);
			
		}catch(Exception e){
			
		}
	
		
		Guerrier guerrier=new Guerrier();
		Mage mage= new Mage();
		System.out.println("PV = " + Jeu.listeJoueurs.get(0).getListeUnite().get(0).getPv());
		mage.attaquer(Jeu.listeJoueurs.get(0).getListeUnite().get(0));
		System.out.println("PV = " + Jeu.listeJoueurs.get(0).getListeUnite().get(0).getPv());
		Jeu.listeJoueurs.get(0).getListeUnite().get(0).soin(0.1);
		System.out.println("PV = " + Jeu.listeJoueurs.get(0).getListeUnite().get(0).getPv());
		
		System.out.println("pos x:"+guerrier.getX()+" y: "+guerrier.getY()+" ptDeDeplacementRestant: "+guerrier.getPtDeDeplacement());
		guerrier.verifierSiDeplacementPossible(8,8);	// impossible car 3 point de deplacement
		System.out.println("pos x:"+guerrier.getX()+" y: "+guerrier.getY()+" ptDeDeplacementRestant: "+guerrier.getPtDeDeplacement());
		guerrier.verifierSiDeplacementPossible(6,0);
		System.out.println("pos x:"+guerrier.getX()+" y: "+guerrier.getY()+" ptDeDeplacementRestant: "+guerrier.getPtDeDeplacement());
		//guerrier.verifierSiDeplacementPossible(3,3);	// possible
		guerrier.verifierSiDeplacementPossible(1,1);
		System.out.println("pos x:"+guerrier.getX()+" y: "+guerrier.getY()+" ptDeDeplacementRestant: "+guerrier.getPtDeDeplacement());
		guerrier.verifierSiDeplacementPossible(2,0);
		System.out.println("pos x:"+guerrier.getX()+" y: "+guerrier.getY()+" ptDeDeplacementRestant: "+guerrier.getPtDeDeplacement());
		
		
		guerrier.verifierSiDeplacementPossible(5,0);
		System.out.println("pos x:"+guerrier.getX()+" y: "+guerrier.getY()+" ptDeDeplacementRestant: "+guerrier.getPtDeDeplacement());
		
		Jeu.save();
		Jeu.sauvegarderPartie("save");
		
	}

	}


