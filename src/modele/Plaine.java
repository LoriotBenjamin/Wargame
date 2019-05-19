package modele;

import controleur.Jeu;

public class Plaine extends Hexagone {

	public Plaine(int x,int y) {
		super(Jeu.PLAINE, 0.1, 1,x,y); // 0.1 correspond aux 10% de bonus de la plaine 
		// TODO Auto-generated constructor stub
	}
		

}
