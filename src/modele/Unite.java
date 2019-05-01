package modele;

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
