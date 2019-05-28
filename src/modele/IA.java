package modele;

public class IA extends Joueur {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4118767757581824513L;

	public IA(int numeroJoueur,String Pseudo) {
		super(numeroJoueur,Pseudo);
	}
	
	public void jouerTour() {
		for(Unite unite : listeUnite) {
			//si attaque possible sur un des déplacements possibles => déplacement puis attaque
			/*else {
				unite.soin(0.1);
				//gérer le soin du pretre ?
			}*/
		}
	}

}
