package controleur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import modele.Desert;
import modele.Foret;
import modele.Hexagone;
import modele.Joueur;
import modele.Mer;
import modele.Montagne;
import modele.MyHashMap;
import modele.Plaine;
import modele.Riviere;
import modele.Unite;
import modele.Village;

public class Jeu implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 42317779892167959L;
	
	public static final int GUERRIER = 1;
	public static final int MAGE = 2;
	public static final int ARCHER = 3;
	public static final int PRETRE = 4;
	public static final int CHEVALIER = 5;
	
	public static final int PLAINE = 10;
	public static final int FORET = 11;
	public static final int VILLAGE = 12;
	public static final int RIVIERE = 13;
	public static final int MONTAGNE = 14;
	public static final int MER = 15;
	public static final int DESERT = 16;
	
	public static int mapLigne = 9;
	public static int mapColonne = 11;
		
	public static ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	public static Hexagone map [][]= new Hexagone[mapLigne][mapColonne];	
	
	
	
	public Jeu(Hexagone[][] map,ArrayList listeJoueurs){
		this.listeJoueurs = listeJoueurs;
		this.map = map; 
		
	}
	
	public static void initMap(){			// initialise une map aléatoire par regroupement de terrains 
		List<List<Integer>> listeMap = new ArrayList<List<Integer>>();
		List<Integer> lignePossible = new ArrayList<Integer>();
		List<Integer> terrains = new ArrayList<Integer>();

		for(int i=0;i<mapLigne;i++) { //récupère toutes les positions possibles
			List<Integer> listeLigne = new ArrayList<Integer>();
			for(int j=0;j<mapColonne;j++) {
				listeLigne.add(j);
			}
			listeMap.add(listeLigne);
			lignePossible.add(i);
		}

		for(int i=PLAINE;i<=DESERT;i++) { //récupère tous les terrains possibles
			terrains.add(i);
		}

		while(lignePossible.isEmpty() == false) { //tant que la map n'est pas remplie
			Integer ligne = getElementAleatoire(lignePossible); //ligne aléatoire
			Integer colonne = getElementAleatoire(listeMap.get(ligne)); //colonne aléatoire
			Integer terrain = getElementAleatoire(terrains); //terrain aléatoire

			int cpt = 0;

			while(cpt<=6) { //met le même terrain pour l'hexagone aléatoire et ces voisins
				if(ligne>=0 && colonne>=0 && ligne<mapLigne && colonne<mapColonne
						&& lignePossible.contains(ligne) && listeMap.get(ligne).contains(colonne)) {
					switch(terrain) {
					case PLAINE:
						map[ligne][colonne]= new Plaine(ligne,colonne);
						break;
					case FORET:
						map[ligne][colonne]= new Foret(ligne,colonne);
						break;
					case VILLAGE:
						map[ligne][colonne]= new Village(ligne,colonne);
						break;
					case RIVIERE:
						map[ligne][colonne]= new Riviere(ligne,colonne);
						break;
					case MONTAGNE:
						map[ligne][colonne]= new Montagne(ligne,colonne);
						break;
					case MER:
						map[ligne][colonne]= new Mer(ligne,colonne);
						break;
					case DESERT:
						map[ligne][colonne]= new Desert(ligne,colonne);
						break;
					}

					listeMap.get(ligne).remove(colonne);
					if(listeMap.get(ligne).isEmpty()) {
						lignePossible.remove(ligne);
					}
				}
				cpt++;
				switch(cpt) {
				case 1:
					colonne++; //hexagone à droite
					break;
				case 2:
					colonne-=2; //hexagone à gauche
					break;
				case 3:
					ligne--; //hexagone en haut à gauche
					break;
				case 4:
					colonne++; //hexagone en haut à droite
					break;
				case 5:
					ligne+=2; //hexagone en bas à droite
					break;
				case 6:
					colonne--; //hexagone en bas à gauche
					break;
				}
			}
		}

		for(int i=0;i<mapLigne;i++) {
			for(int j=0;j<mapColonne;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static int getElementAleatoire(List<Integer> liste) //récupére un élément aléatoire d'une liste d'entiers
    { 
        Random alea = new Random(); 
        return liste.get(alea.nextInt(liste.size())); 
    }
	
	/** 
	 * Initialise la liste des voisins de chaque case de la map 
	 */
	
	public static void initListeVoisin(){	// ajoute à chaque hexagone la liste des hexagones voisins 
		//( serait peut être plus pertinent dans la classe hexagone)
		
			for (int i =0; i < mapLigne; i++){
				for(int j=0; j < mapColonne;j++){
					if( i%2 != 0){
						if(i+1< mapLigne )
							map[i][j].ajoutHexagoneVoisin(map[i+1][j]);
						if(j+1 < mapColonne)
							map[i][j].ajoutHexagoneVoisin(map[i][j+1]);
						if(i-1 >= 0 && j+1 < mapColonne)
							map[i][j].ajoutHexagoneVoisin(map[i-1][j+1]);
						if(i-1 >= 0 )
							map[i][j].ajoutHexagoneVoisin(map[i-1][j]);
						if(i-1 >= 0 && j-1 >= 0)
							map[i][j].ajoutHexagoneVoisin(map[i-1][j-1]);
						if( j-1 >= 0)
							map[i][j].ajoutHexagoneVoisin(map[i][j-1]);
					}else{
						
						if(i+1< mapLigne )
							map[i][j].ajoutHexagoneVoisin(map[i+1][j]);
						if(i+1< mapLigne && j+1 < mapColonne)
							map[i][j].ajoutHexagoneVoisin(map[i+1][j+1]);
						if(j+1 < mapColonne)
							map[i][j].ajoutHexagoneVoisin(map[i][j+1]);
						if(i-1 >= 0 )
							map[i][j].ajoutHexagoneVoisin(map[i-1][j]);
						if(j-1 >= 0)
							map[i][j].ajoutHexagoneVoisin(map[i][j-1]);
						if(i+1< mapLigne && j-1 >= 0)
							map[i][j].ajoutHexagoneVoisin(map[i+1][j-1]);
						
					}
			}
		}
		
		System.out.println("Point 0 0");
		map[0][0].afficheVoisin();
		System.out.println("Point 3 3");
		map[3][3].afficheVoisin();
		System.out.println("Point 2;1 ");
		map[2][1].afficheVoisin();
		
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
	
	/*
	 *  compare la position de toutes les unités avec les coordonées rentré si une unité ennemie
	 *  est sur la position demandé retourne true sinon false
	 *  !! je ne sais pas si je dois la poser ici 
	 */
	public static boolean comparePosUniteAndTeamWithCoord (int x, int y,int numeroJoueur){
		
		for (Joueur j : Jeu.listeJoueurs){
			if(j.getNumeroJoueur() != numeroJoueur){// petite optimisation ne regarde pas l'equipe du joueur evite 1 tour de boucle inutile
				for(Unite u : j.getListeUnite()){
					if(u.getX() == x && u.getY() == y)
						return true; 
				}
			}
		}
		
		return false;
	}
	
	public static Unite getUniteByNumeroJoueurAndCoord (int x, int y, int numeroJoueur){
		ArrayList <Unite> uniteDuJoueur = Jeu.listeJoueurs.get(numeroJoueur).getListeUnite();
		for(Unite u: uniteDuJoueur){
			if(u.getX() == x && u.getY() == y)
				return u;
		}
		return null;
	}
	
	public static  void save (){
		
		File fichier =  new File("tmp/game.ser") ;

		 // ouverture d'un flux sur un fichier
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichier));
			Jeu game = new Jeu(Jeu.map,Jeu.listeJoueurs);
			oos.writeObject(game);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				

		
	}
	
	
}
