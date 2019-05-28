package modele;

import controleur.Jeu;

public class Pretre extends Unite {
	private double txSoin;

	public Pretre() {
		super(Jeu.PRETRE,6, 2, 30, 4, 2, 1, 0, 0);
		// TODO Auto-generated constructor stub
		setTxSoin(0.3);
	}
	
	//Getters and Setters

	public double getTxSoin() {
		return txSoin;
	}

	public void setTxSoin(double txSoin) {
		this.txSoin = txSoin;
	}

}
