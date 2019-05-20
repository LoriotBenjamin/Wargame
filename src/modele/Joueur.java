package modele;

import java.util.ArrayList;

public class Joueur {
	
	int numeroJoueur;
	String pseudo;
	ArrayList <Unite> listeUnite = new ArrayList(); 
	
	
	
	public Joueur(int numeroJoueur, String pseudo) {
		
		this.numeroJoueur = numeroJoueur;
		this.pseudo = pseudo;
		
		
		listeUnite.add(new Guerrier());
		listeUnite.add(new Guerrier()); // ajout de 2 guerriers pour tester
		
	}


	
	public void setUnite (Unite u){
		this.listeUnite.add(u);
	}
	
	////////////////////////Getter and Setter /////////////////////////
	public int getNumeroJoueur() {
		return numeroJoueur;
	}



	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}



	public String getPseudo() {
		return pseudo;
	}



	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	public ArrayList<Unite> getListeUnite() {
		return listeUnite;
	}



	public void setListeUnite(ArrayList<Unite> listeUnite) {
		this.listeUnite = listeUnite;
	}
	



}
