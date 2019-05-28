package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import controleur.Jeu;

public class Unite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2569571978178827188L;
	
	int typeUnite; // peut Ãªtre remplacÃ© par un .getClass() supprimant cette variable mais un peu plus long dans les tests que des comparaisons avec un int je pense 
	int attaque;
	int defense;
	int pv;
	int pvMax;
	int ptDeDeplacement;
	int ptDeDeplacementMax;
	int vision;
	int porte;
	int x;
	int y;
	boolean estAttaquee;
	ArrayList <Unite> ennemiAttaquable = new ArrayList<Unite>();
	
	
	public Unite(int typeUnite,int attaque, int defense, int pv,
			int ptDeDeplacement, int vision, int porte, int x, int y) {

		this.typeUnite = typeUnite;
		this.attaque = attaque;
		this.defense = defense;
		this.pv = pv;
		this.pvMax = pv;
		this.ptDeDeplacement = ptDeDeplacement;
		this.ptDeDeplacementMax = ptDeDeplacement;
		this.vision = vision;
		this.porte = porte;
		this.x = x;
		this.y = y;
		this.estAttaquee = false;
	}
	
	public Unite(int typeUnite,int attaque, int defense, int pv, int pvMax,
			int ptDeDeplacement, int ptDeDeplacementMax, int vision, int porte, int x, int y) {

		this.typeUnite = typeUnite;
		this.attaque = attaque;
		this.defense = defense;
		this.pv = pv;
		this.pvMax = pvMax;
		this.ptDeDeplacement = ptDeDeplacement;
		this.ptDeDeplacementMax = ptDeDeplacementMax;
		this.vision = vision;
		this.porte = porte;
		this.x = x;
		this.y = y;
		this.estAttaquee = false;
	}

	
	public void attendreSecondClic() {
		//Récupérer les coordonnées du second clic et les transformer en coordonnées map
		int x=0, y=0;
		secondClic(x, y);
	}
	
	public void secondClic(int _x,int _y){ // avertir la vue si la position de l'unite change
		System.out.println("Test : X: " + _x + " Y: " + _y);
		
		HashMap <Hexagone,Integer> deplacementPossible = calculDeplacementPossible();
		ArrayList<Hexagone> aPorteDAttaque = aPorte();
		
		if(!deplacementPossible.isEmpty()){
			
			Iterator iterator = deplacementPossible.entrySet().iterator();
		    totality : while (iterator.hasNext()) {
		       	Map.Entry mapEntry = (Map.Entry) iterator.next();
		       	Hexagone h = (Hexagone) mapEntry.getKey();
		       	if(_x ==h.getX() && _y == h.getY()){
		       		//La case a été trouvée
		       		for(Joueur j : Jeu.listeJoueurs) {
		       			for(Unite u : j.getListeUnite()) {
		       				if(_x == u.getX() && _y == u.getY()) {
		       					//Une unité est sur la case
		       					System.out.println("Unité présente");
		       					if(j.listeUnite.contains(this)){
		       						//L'unité est alliée
		       						u.attendreSecondClic();
		       					} else {
		       						if(aPorteDAttaque.contains(h)){
		       							//L'unité est à porté
		       							attaquer(u);
		       						}
		       					}
       							break totality;
		       				}
		       			}
		       		}
		       		//Il n'y a pas d'unité sur la case
   					System.out.println("Pas d'unité");
			       	this.x= _x ;
			       	this.y = _y; 
			       	this.ptDeDeplacement = (Integer) mapEntry.getValue();
		       		break totality;
		       		}
		       	}
		}
	}

	/*
	 * retourne un tableau avec en premier position la liste des dÃ©placements possibles et les points de mouvement restant 
	 * et en deuxiÃ©me la liste des ennemis attaquable au corp Ã  corp (si un tile de mer sÃ©pare deux unitÃ©s peut on attaquer quand mÃªme? ligne de vue?) . 
	 */
	public MyHashMap calculDeplacementPossible (){ // donne tout les hexagones possible dans la range de l'unite et les points de deplacement restant si elle s'y dirige
			Hexagone h = Jeu.map[x][y];	// hexagone ou se situe l'unite 
			MyHashMap <Hexagone,Integer> deplacementPossible = new MyHashMap<Hexagone, Integer>();  
			MyHashMap <Hexagone,Integer> pointAExplorer = new MyHashMap<Hexagone, Integer>(); // couple hexagone/ point de deplacement restant 
			ArrayList <Hexagone> caseVisible= Jeu.vision(this);
			ArrayList <Unite> ennemiAttaquable = new ArrayList<Unite>();
			
		
			/*for(Hexagone hex : caseVisible){
				System.out.println("coord en x: "+hex.x);
				System.out.println("coord en y: "+hex.y);
			}*/
			Hexagone hexagoneCourant = h; 
			//deplacementPossible.put(hexagoneCourant, ptDeDeplacement);
			pointAExplorer.put(hexagoneCourant,ptDeDeplacement);
			
			
			if( ptDeDeplacement != 0){ // si jamais un jour on donne la possibilitÃ© d'enlever des points de dÃ©placement Ã©vite les tours de boucle inutile
				
				while(!pointAExplorer.isEmpty()){
					
					hexagoneCourant = (Hexagone) pointAExplorer.getFirstKey(); // on rÃ©cupÃ©re le premier element de la liste
		
					for(Hexagone v : hexagoneCourant.listeVoisin){	// on parcourt la liste de ses voisins
							if(v.type != Jeu.MER && caseVisible.contains(v) ){
								
								if(deplacementPossible.containsKey(v)) {	// si il est dÃ©ja dans la liste des dÃ©placements possible
									
									if(pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement > deplacementPossible.get(v)){
									// si le cout actuel est moins grand que l'ancien coÃ»t.
										
										deplacementPossible.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
										if(pointAExplorer.containsKey(v))
											pointAExplorer.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
										else
											pointAExplorer.put(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
									}
								}
								if(pointAExplorer.containsKey(v)) {	// si il est dÃ©ja en attente d'exploration
									
									if(pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement > pointAExplorer.get(v)){
									// si le cout actuel est moins grand que l'ancien coÃ»t.
										pointAExplorer.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
										
									}
								}
								if (v.coutDeDeplacement <= pointAExplorer.get(hexagoneCourant)){	
								// si le cout de deplacement est inferieur ou egal Ã  la distance restante et qu'il n'est pas dÃ©ja dans une des listes
									pointAExplorer.put(v,pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
								
									
								}
								
						
						}	
					}// fin du parcours des voisins
					if(!deplacementPossible.containsKey(hexagoneCourant))
						deplacementPossible.put(hexagoneCourant,pointAExplorer.get(hexagoneCourant)); 
					pointAExplorer.remove(hexagoneCourant);
			
				
				} // fin de la boucle principal
			}else{
				System.out.println("Pas de point de deplacement"); 
			}
			
			return deplacementPossible;
			
		}

	public ArrayList<Hexagone> aPorte (){ // donne tout les hexagones visibles par l'unitï¿½
		Hexagone h = Jeu.map[x][y];	// hexagone ou se situe l'unite 
		ArrayList <Hexagone> aPorte = new ArrayList();  
		MyHashMap <Hexagone,Integer> AExplorer = new MyHashMap(); // couple hexagone/ point de deplacement restant 
		
	
		Hexagone hexagoneCourant = h; 
		aPorte.add(hexagoneCourant);
		AExplorer.put(hexagoneCourant,0);
		
		while(!AExplorer.isEmpty()){
				
			hexagoneCourant = (Hexagone) AExplorer.getFirstKey(); // on rÃ©cupÃ©re le premier element de la liste
			for(Hexagone v : hexagoneCourant.getListeVoisin()){	// on parcourt la liste de ses voisins 
				if(!aPorte.contains(v) && !AExplorer.containsKey(v) && AExplorer.get(hexagoneCourant)+1 <= porte)
					AExplorer.put(v, AExplorer.get(hexagoneCourant)+1);
			
			}	// fin du parcours des voisins
			if(!aPorte.contains(hexagoneCourant))
				aPorte.add(hexagoneCourant);
			AExplorer.remove(hexagoneCourant);
	
		
		} // fin de la boucle principal
		
		return aPorte;
		
	}
	
	public void attaquer(Unite unite) {
		//si attaque possible
		unite.calculDegats(attaque);
		ptDeDeplacement = 0;
	}
	
	public void calculDegats(int attaque) {
		estAttaquee = true;
		double bonusDefense = Jeu.map[x][y].getBonusDefense();
		double degats=(attaque-(defense*(1+bonusDefense)))*getDoubleAleaBorne(0.5,1.5);
		pv-=(int)degats;
		if(pv<0) {
			pv=0;
			//Retirer l'unité du jeu?
		}
		
	}
	
	public void soin(double taux) {
		if(this.ptDeDeplacement == this.ptDeDeplacementMax && this.estAttaquee == false) {
			this.pv+=(int)this.pv*taux;
			if(this.pv>this.pvMax) {
				this.pv=this.pvMax;
			}
		}
	}
	
	public double getDoubleAleaBorne(double min, double max) {
		double res=(Math.random()*((max-min)+1))+min;
		return res;
	}
	
	
	//////////////////////// Getter and Setter /////////////////////////

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public int getPvMax() {
		return pvMax;
	}

	public int getPtDeDeplacement() {
		return ptDeDeplacement;
	}

	public void setPtDeDeplacement(int ptDeDeplacement) {
		this.ptDeDeplacement = ptDeDeplacement;
	}
	
	public int getPtDeDeplacementMax() {
		return ptDeDeplacementMax;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}

	public int getPorte() {
		return porte;
	}

	public void setPorte(int porte) {
		this.porte = porte;
	}

	public int getTypeUnite() {
		return typeUnite;
	}

	public void setTypeUnite(int typeUnite) {
		this.typeUnite = typeUnite;
	}
	
	
	

}
