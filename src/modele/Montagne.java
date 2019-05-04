package modele;

import controleur.Data;

public class Montagne extends Hexagone {
	
	public Montagne(int x,int y) {
		super(Data.MONTAGNE, 0.7, 3,x,y); // 0.7 correspond aux 70% de bonus de la montagne 
		// TODO Auto-generated constructor stub
	}

}
