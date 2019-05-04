package modele;

import controleur.Data;

public class Unite {
	
	int typeUnite; // peut être remplacé par un .getClass() supprimant cette variable mais un peu plus long dans les tests que des comparaisons avec un int je pense 
	int attaque;
	int defense;
	int pv;
	int ptDeDeplacement;
	int vision;
	int porte;
	int x;
	int y;
	
	
	public Unite(int typeUnite,int attaque, int defense, int pv,
			int ptDeDeplacement, int vision, int porte, int x, int y) {

		this.typeUnite = typeUnite;
		this.attaque = attaque;
		this.defense = defense;
		this.pv = pv;
		this.ptDeDeplacement = ptDeDeplacement;
		this.vision = vision;
		this.porte = porte;
		this.x = x;
		this.y = y;
	}
	
	public void deplacer(int _x, int _y){	
		
		if (ptDeDeplacement != 0) {
			
			this.x = _x;
			this.y = _y;
		}else{
			System.out.println("Pas de point de déplacement ");
		}
	}
	
	public void calculDegats(int attaque,double bonusDefense) {
		double degats=(attaque-(this.defense*(1+bonusDefense)))*Data.getDoubleAleaBorne(0.5,1.5);
		this.pv-=(int)degats;
		if(this.pv<0) {
			this.pv=0;
		}
		
	}
	
public MyHashMap deplacementPossible (Hexagone h){
		
		MyHashMap <Hexagone,Integer> deplacementPossible = new MyHashMap();  
		MyHashMap <Hexagone,Integer> pointAExplorer = new MyHashMap(); // couple hexagone/ point de deplacement restant 
		
	
		Hexagone hexagoneCourant = h; 
		//deplacementPossible.put(hexagoneCourant, ptDeDeplacement);
		pointAExplorer.put(hexagoneCourant,ptDeDeplacement);
		
		
		if( ptDeDeplacement != 0){ // si jamais un jour on donne la possibilité d'enlever des points de déplacement évite les tours de boucle inutile
			
			while(!pointAExplorer.isEmpty()){
				
				hexagoneCourant = (Hexagone) pointAExplorer.getFirstKey(); // on récupére le premier element de la liste
	
				for(Hexagone v : hexagoneCourant.listeVoisin){	// on parcourt la liste de ses voisins 
					
					if(deplacementPossible.containsKey(v)) {
						
						if(pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement > deplacementPossible.get(v)){
						// si le cout actuel est moins grand que l'ancien coût.
							
							deplacementPossible.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
							if(pointAExplorer.containsKey(v))
								pointAExplorer.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
							else
								pointAExplorer.put(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
						}
					}
					if(pointAExplorer.containsKey(v)) {
						
						if(pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement > pointAExplorer.get(v)){
						// si le cout actuel est moins grand que l'ancien coût.
							pointAExplorer.replace(v, pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
							
						}
					}
					if (v.coutDeDeplacement <= pointAExplorer.get(hexagoneCourant) && !pointAExplorer.containsKey(v) && !deplacementPossible.containsKey(v) ){	
					// si le cout de deplacement est inferieur ou egal à la distance restante et qu'il n'est pas déja dans une des listes
						pointAExplorer.put(v,pointAExplorer.get(hexagoneCourant)-v.coutDeDeplacement);
						
					}
					
				
				}	// fin du parcours des voisins
				if(!deplacementPossible.containsKey(hexagoneCourant))
					deplacementPossible.put(hexagoneCourant,pointAExplorer.get(hexagoneCourant)); 
				pointAExplorer.remove(hexagoneCourant);
		
			
			} // fin de la boucle principal
		}else{
			System.out.println("Pas de point de deplacement"); 
		}
		
		return deplacementPossible;
		
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

	public int getPtDeDeplacement() {
		return ptDeDeplacement;
	}

	public void setPtDeDeplacement(int ptDeDeplacement) {
		this.ptDeDeplacement = ptDeDeplacement;
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
