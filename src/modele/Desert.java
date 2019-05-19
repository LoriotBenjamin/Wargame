package modele;

import controleur.Jeu;

public class Desert extends Hexagone {
	
	public Desert(int x,int y) {
		super(Jeu.DESERT, 0.1, 2,x,y); // 0.1 correspond aux 10% de bonus du desert 
		// TODO Auto-generated constructor stub
	}

}
