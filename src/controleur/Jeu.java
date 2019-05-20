package controleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import modele.Foret;
import modele.Hexagone;
import modele.Joueur;
import modele.Mer;
import modele.MyHashMap;
import modele.Plaine;
import modele.Unite;

public class Jeu {	// à renommer/refaire classe de dépannage pour tester 
	
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
	
	public static int mapLongueur = 10;
	public static int mapLargeur = 10;
		
	public static ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	public static Hexagone map [][]= new Hexagone[10][10];
	
	
	public static void initMap(){			// initialise une map remplie de plaine. 
		for (int i =0; i < mapLongueur; i++){
			for(int j=0; j < mapLargeur;j++)
				if((i == 2 && j == 0))
					map[i][j]= new Mer(i,j);	// ajout de deux hexa de mer pour tester
				else if(i == 4 && j==4)
					map[i][j]= new Foret(i,j);
				else
					map[i][j]= new Plaine(i,j);	
		}
	}
	
	public static void initListeVoisin(){	// ajoute à chaque hexagone la liste des hexagones voisins 
		//( serait peut être plus pertinent dans la classe hexagone)
		
		for (int i =0; i < mapLongueur; i++){
			for(int j=0; j < mapLargeur;j++){
				if(i+2 < mapLongueur )
					map[i][j].ajoutHexagoneVoisin(map[i+2][j]);
				if(i+1 < mapLongueur && j+1 < mapLargeur)
					map[i][j].ajoutHexagoneVoisin(map[i+1][j+1]);
				if(i-1 >= 0 && j+1 < mapLargeur)
					map[i][j].ajoutHexagoneVoisin(map[i-1][j+1]);
				if(i-2 >= 0 )
					map[i][j].ajoutHexagoneVoisin(map[i-2][j]);
				if(i-1 >= 0 && j-1 >= 0)
					map[i][j].ajoutHexagoneVoisin(map[i-1][j-1]);
				if(i+1 < mapLongueur && j-1 >= 0)
					map[i][j].ajoutHexagoneVoisin(map[i+1][j-1]);
			}
		}
		
		System.out.println("Point 0 0");
		map[0][0].afficheVoisin();
		System.out.println("Point 3 3");
		map[3][3].afficheVoisin();
	}
	
	public static void ajouterJoueur(Joueur joueur) {
		joueurs.add(joueur);
	}

	public static ArrayList<Hexagone>  sansBrouillard(Joueur joueur){
		HashSet<Hexagone> nonfog = new HashSet<Hexagone>();
		ArrayList<Hexagone> list = new ArrayList<Hexagone>();
		for(Unite unite : joueur.getListeUnite()) {
			nonfog.addAll(vision(unite));
		}
		Iterator<Hexagone> i = nonfog.iterator();
		while(i.hasNext()) {
			Hexagone h = i.next();
			list.add(h);
		}
		return list;
	}
	
	public static ArrayList<Hexagone> vision (Unite unite){ // donne tout les hexagones visibles par l'unit�
		Hexagone h = Jeu.map[unite.getX()][unite.getY()];	// hexagone ou se situe l'unite 
		ArrayList <Hexagone> nofog = new ArrayList();  
		MyHashMap <Hexagone,Integer> AExplorer = new MyHashMap(); // couple hexagone/ point de deplacement restant 
		
	
		Hexagone hexagoneCourant = h; 
		nofog.add(hexagoneCourant);
		AExplorer.put(hexagoneCourant,0);
		
		while(!AExplorer.isEmpty()){
				
			hexagoneCourant = (Hexagone) AExplorer.getFirstKey(); // on récupére le premier element de la liste
			for(Hexagone v : hexagoneCourant.getListeVoisin()){	// on parcourt la liste de ses voisins 
				if(!nofog.contains(v) && !AExplorer.containsKey(v) && AExplorer.get(hexagoneCourant)+1 <= unite.getVision())
					AExplorer.put(v, AExplorer.get(hexagoneCourant)+1);
			
			}	// fin du parcours des voisins
			if(!nofog.contains(hexagoneCourant))
				nofog.add(hexagoneCourant);
			AExplorer.remove(hexagoneCourant);
	
		
		} // fin de la boucle principal
		
		return nofog;
		
	}
	
	
}
