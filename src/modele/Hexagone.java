package modele;

import java.util.ArrayList;

public class Hexagone {
	
	int type;
	double bonusDefense;
	int coutDeDeplacement;
	int x;
	int y;
	ArrayList <Hexagone> listeVoisin = new ArrayList();
	
	
	public Hexagone(int type, double bonusDefense, int coutDeDeplacement,int x,int y) {
		
		this.type = type;
		this.bonusDefense = bonusDefense;
		this.coutDeDeplacement = coutDeDeplacement;
		this.x = x;
		this.y = y;

	}
	public Hexagone(int type, double bonusDefense, int coutDeDeplacement,ArrayList <Hexagone> listeVoisin ) { // deuxiéme constructeur utile seulement si on connait la liste des voisins à voir 
		
		this.type = type;
		this.bonusDefense = bonusDefense;
		this.coutDeDeplacement = coutDeDeplacement;
		this.listeVoisin = listeVoisin; 

	}
	
	//debug
	@Override
	public String toString() {
		return " "+type+" ";
	}
	
	
	public void ajoutHexagoneVoisin(Hexagone h){
		listeVoisin.add(h);
	}
	
	public void afficheVoisin(){
		for(Hexagone h: this.listeVoisin){
			System.out.println("Valeur i: "+String.valueOf(h.x));
			System.out.println("Valeur j: "+String.valueOf(h.y));
		}
	}

	
	////////////////////////Getter and Setter /////////////////////////
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getBonusDefense() {
		return bonusDefense;
	}

	public void setBonusDefense(double bonusDefense) {
		this.bonusDefense = bonusDefense;
	}

	public int getCoutDeDeplacement() {
		return coutDeDeplacement;
	}

	public void setCoutDeDeplacement(int coutDeDeplacement) {
		this.coutDeDeplacement = coutDeDeplacement;
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
	public ArrayList<Hexagone> getListeVoisin() {
		return listeVoisin;
	}
	public void setListeVoisin(ArrayList<Hexagone> listeVoisin) {
		this.listeVoisin = listeVoisin;
	}
	
	
	

}
