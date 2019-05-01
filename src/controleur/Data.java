package controleur;

import modele.Hexagone;

public class Data {	// à renommer/refaire classe de dépannage pour tester 
		
	public static Hexagone map [][]= new Hexagone[10][10];
	
	public static void initMap(){
		for (int i =0; i < 10; i++){
			for(int j=0; j < 10;j++){
				map[i][j]= new Hexagone(0, 1.1, 2);	
			}
		}
	}
	

}
