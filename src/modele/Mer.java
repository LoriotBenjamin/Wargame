package modele;

import controleur.Data;

public class Mer extends Hexagone {
	
	public Mer(int x,int y) {
		super(Data.MER, 0, 10,x,y); // 0 correspond aux 0% de bonus de la mer et 10 car aucune unité ne pourra s'y déplacer 
		// TODO Auto-generated constructor stub
	}

}
