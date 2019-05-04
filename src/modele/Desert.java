package modele;

import controleur.Data;

public class Desert extends Hexagone {
	
	public Desert(int x,int y) {
		super(Data.DESERT, 0.1, 2,x,y); // 0.1 correspond aux 10% de bonus du desert 
		// TODO Auto-generated constructor stub
	}

}
