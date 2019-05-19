package modele;

import controleur.Jeu;

public class Riviere extends Hexagone {
	
	public Riviere(int x,int y) {
		super(Jeu.RIVIERE, 0.1, 2,x,y); // 0.1 correspond aux 10% de bonus de la riviere 
		// TODO Auto-generated constructor stub
	}

}
