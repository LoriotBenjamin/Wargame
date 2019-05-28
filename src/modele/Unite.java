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
	
	int typeUnite; // peut être remplacé par un .getClass() supprimant cette variable mais un peu plus long dans les tests que des comparaisons avec un int je pense 
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
	
	
	public void verifierSiDeplacementPossible(int _x,int _y){ // avertir la vue si la position de l'unite change
		
		HashMap <Hexagone,Integer> deplacementPossible = calculDeplacementPossible();
		
		if(!deplacementPossible.isEmpty()){
			
			Iterator iterator = deplacementPossible.entrySet().iterator();
		    	while (iterator.hasNext()) {
		        	Map.Entry mapEntry = (Map.Entry) iterator.next();
		        	Hexagone h = (Hexagone) mapEntry.getKey();
		        	if(_x ==h.getX() && _y == h.getY()){	
		        		// surement ici ou a la fin de la fonction prevenir la vue 
		        		// a voir comment nous allons realiser l'algo si c'est ici que l'on 
		        		// regarde si il y a une unite ennemi sur la case cible 
		        		this.x= _x ;
		        		this.y = _y; 
		        		this.ptDeDeplacement = (Integer) mapEntry.getValue();
		        		break;
		        	}
		        } 
		}
		
		
	}

	/*
	 * retourne un tableau avec en premier position la liste des déplacements possibles et les points de mouvement restant 
	 * et en deuxiéme la liste des ennemis attaquable au corp à corp (si un tile de mer sépare deux unités peut on attaquer quand même? ligne de vue?) . 
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
			
			
			if( ptDeDeplacement != 0){ // si jamais un jour on donne la possibilité d'enlever des points de déplacement évite les tours de boucle inutile
				
				while(!pointAExplorer.isEmpty()){
					
					hexagoneCourant = (Hexagone) pointAExplorer.getFirstKey(); // on récupére le premier element de la liste
		
					for(Hexagone v : hexagoneCourant.listeVoisin){	// on parcourt la liste de ses voisins
							if(v.type != Jeu.MER && caseVisible.contains(v) ){
								
								if(deplacementPossible.containsKey(v)) {	// si il est déja dans la liste des déplacements possible
									
									if(pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement > deplacementPossible.get(v)){
									// si le cout actuel est moins grand que l'ancien coût.
										
										deplacementPossible.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
										if(pointAExplorer.containsKey(v))
											pointAExplorer.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
										else
											pointAExplorer.put(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
									}
								}
								if(pointAExplorer.containsKey(v)) {	// si il est déja en attente d'exploration
									
									if(pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement > pointAExplorer.get(v)){
									// si le cout actuel est moins grand que l'ancien coût.
										pointAExplorer.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
										
									}
								}
								if (v.coutDeDeplacement <= pointAExplorer.get(hexagoneCourant)){	
								// si le cout de deplacement est inferieur ou egal à la distance restante et qu'il n'est pas déja dans une des listes
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

	public void attaquer(Unite unite) {
		//si attaque possible
		unite.calculDegats(attaque);
	}
	
	public void calculDegats(int attaque) {
		double bonusDefense = Jeu.map[x][y].getBonusDefense();
		double degats=(attaque-(defense*(1+bonusDefense)))*getDoubleAleaBorne(0.5,1.5);
		pv-=(int)degats;
		if(pv<0) {
			pv=0;
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
