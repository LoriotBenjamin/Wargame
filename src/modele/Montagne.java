package modele;

import controleur.Jeu;

public class Montagne extends Hexagone {
	
	public Montagne(int x,int y) {
		super(Jeu.MONTAGNE, 0.7, 3,x,y); // 0.7 correspond aux 70% de bonus de la montagne 
		// TODO Auto-generated constructor stub
	}

}
