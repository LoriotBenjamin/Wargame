package modele;

import controleur.Jeu;

public class Mer extends Hexagone {
	
	public Mer(int x,int y) {
		super(Jeu.MER, 0, 10,x,y); // 0 correspond aux 0% de bonus de la mer et 10 car aucune unit� ne pourra s'y d�placer 
		// TODO Auto-generated constructor stub
	}

}
