package controleur;

import modele.Hexagone;
import modele.Plaine;

public class Data {	// à renommer/refaire classe de dépannage pour tester 
	
	public static final int GUERRIER = 1;
	public static final int MAGE = 2;
	public static final int ARCHER = 3;
	public static final int PRETRE = 4;
	public static final int CHEVALIER = 5;
	
	public static final int PLAINE = 10;
	public static final int FORET = 11;
	public static final int VILLAGE = 13;
	public static final int RIVIERE = 14;
	public static final int MONTAGNE = 15;
	public static final int MER = 16;
	public static final int DESERT = 17;
	
	public static final int mapLongueur = 10;
	public static final int mapLargeur = 10;
		
	public static Hexagone map [][]= new Hexagone[10][10];
	
	
	public static void initMap(){
		for (int i =0; i < mapLargeur; i++){
			for(int j=0; j < mapLongueur;j++)
				map[i][j]= new Plaine(i,j);	// initialise une map remplie de plaine. 
				//System.out.println(map[i][j].toString()); 
		}
	}
	
	public static void initListeVoisin(){
		
		for (int i =0; i < mapLargeur; i++){
			for(int j=0; j < mapLongueur;j++){
				if(i+2 < mapLargeur )
					map[i][j].ajoutHexagoneVoisin(map[i+2][j]);
				if(i+1 < mapLargeur && j+1 < mapLongueur)
					map[i][j].ajoutHexagoneVoisin(map[i+1][j+1]);
				if(i-1 >= 0 && j+1 < mapLongueur)
					map[i][j].ajoutHexagoneVoisin(map[i-1][j+1]);
				if(i-2 >= 0 )
					map[i][j].ajoutHexagoneVoisin(map[i-2][j]);
				if(i-1 >= 0 && j-1 >= 0)
					map[i][j].ajoutHexagoneVoisin(map[i-1][j-1]);
				if(i+1 < mapLargeur && j-1 >= 0)
					map[i][j].ajoutHexagoneVoisin(map[i+1][j-1]);
			}
		}
		
		System.out.println("Point 0 0");
		map[0][0].afficheVoisin();
		System.out.println("Point 3 3");
		map[3][3].afficheVoisin();
	}
	
	public static double getDoubleAleaBorne(double min, double max) {
		double res=(Math.random()*((max-min)+1))+min;
		return res;
	}

	
	
	
}
