package modele;

import controleur.Jeu;

public class Village extends Hexagone {
	
	public Village(int x,int y) {
		super(Jeu.VILLAGE, 0.3, 1,x,y); // 0.3 correspond aux 30% de bonus du village 
		// TODO Auto-generated constructor stub
	}

}
