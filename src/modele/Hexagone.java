package modele;

import java.util.ArrayList;

public class Hexagone {
	
	int type;
	double bonusDefense;
	int coutDeDeplacement;
	ArrayList <Hexagone> listeVoisin = new ArrayList();
	
	
	public Hexagone(int type, double bonusDefense, int coutDeDeplacement) {
		
		this.type = type;
		this.bonusDefense = bonusDefense;
		this.coutDeDeplacement = coutDeDeplacement;

	}
	public Hexagone(int type, double bonusDefense, int coutDeDeplacement,ArrayList <Hexagone> listeVoisin ) { // deuxiéme constructeur utile? 
		
		this.type = type;
		this.bonusDefense = bonusDefense;
		this.coutDeDeplacement = coutDeDeplacement;
		this.listeVoisin = listeVoisin; 

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


	
	

}
