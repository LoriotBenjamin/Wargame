package modele;

import controleur.Jeu;

public class Foret extends Hexagone {
	
	public Foret(int x,int y) {
		super(Jeu.FORET, 0.5, 2,x,y); // 0.5 correspond aux 50% de bonus de la foret 
		// TODO Auto-generated constructor stub
	}

}
