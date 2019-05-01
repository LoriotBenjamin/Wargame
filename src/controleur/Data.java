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
	public static final int VILLE = 13;
	public static final int RIVIERE = 14;
	public static final int MONTAGNE = 15;
	public static final int MER = 16;
		
	public static Hexagone map [][]= new Hexagone[10][10];
	
	public static void initMap(){
		for (int i =0; i < 10; i++){
			for(int j=0; j < 10;j++){
				map[i][j]= new Plaine();	// initialise une map remplie de plaine. 
				System.out.println(map[i][j].toString()); 
			}
		}
	}
	

}
