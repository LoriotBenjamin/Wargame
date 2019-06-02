package controleur;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import modele.Desert;
import modele.Foret;
import modele.Hexagone;
import modele.Joueur;
import modele.Mer;
import modele.Montagne;
import modele.Plaine;
import modele.Riviere;
import modele.Unite;
import modele.Village;
import vue.Affplateau;
import vue.MainJFrame;
import modele.IA;
import modele.Humain;

/**
 * Jeu est la classe représentant le contrôleur de la partie.
 * @author Solenn
 *
 */
public final class Jeu {
    /**
     * Entier représentant le type d'unité Guerrier.
     */
    public static final int GUERRIER = 1;
    /**
     * Entier représentant le type d'unité Mage.
     */
    public static final int MAGE = 2;
    /**
     * Entier représentant le type d'unité Archer.
     */
    public static final int ARCHER = 3;
    /**
     * Entier représentant le type d'unité Prêtre.
     */
    public static final int PRETRE = 4;
    /**
     * Entier représentant le type d'unité Chevalier.
     */
    public static final int CHEVALIER = 5;
    /**
     * Entier représentant le type d'hexagone Plaine.
     */
    public static final int PLAINE = 10;
    /**
     * Entier représentant le type d'hexagone Forêt.
     */
    public static final int FORET = 11;
    /**
     * Entier représentant le type d'hexagone Village.
     */
    public static final int VILLAGE = 12;
    /**
     * Entier représentant le type d'hexagone Rivière.
     */
    public static final int RIVIERE = 13;
    /**
     * Entier représentant le type d'hexagone Montagne.
     */
    public static final int MONTAGNE = 14;
    /**
     * Entier représentant le type d'hexagone Mer.
     */
    public static final int MER = 15;
    /**
     * Entier représentant le type d'hexagone Désert.
     */
    public static final int DESERT = 16;
    /**
     * Constante représentant le taux de soin général.
     */
    public static final double SOIN = 0.1;
    /**
     * Nombre de lignes du plateau.
     */
    public static final int MAPLIGNE = 12;
    /**
     * Nombre de colonne du plateau.
     */
    public static final int MAPCOLONNE = 19;
    /**
     * Liste des joueurs participant à la partie.
     */
    private static ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
    /**
     * Indicateur de clic.
     */
    private static boolean clicFlag = false;
    /**
     * Indicateur de passage de tour.
     */
    private static boolean skipFlag = false;
    /**
     * Indicateur de début de jeu.
     */
    private static boolean started = false;
    /**
     * Plateau de jeu.
     */
    private static Hexagone[][] map = new Hexagone[MAPLIGNE][MAPCOLONNE];
    /**
     * Fenêtre de jeu.
     */
    private static MainJFrame frame;
    /**
     * Plateau visuel de la vue.
     */
    private static Affplateau plateau;
    /**
     * Liste des informations des unités en jeu pour la vue.
     */
    private static ArrayList<ArrayList<Integer>> infoUnite = new ArrayList<ArrayList<Integer>>();
    /**
     * Liste contentant les hexagones où il est possible de se déplacer.
     */
    private static HashMap<Hexagone, Integer> deplacementPossibleHash = new HashMap<Hexagone, Integer>();
    /**
     * Liste contenant les coordonnées des hexagones où il est possible de se
     * déplacer.
     */
    private static ArrayList<ArrayList<Integer>> deplacementPossible = new ArrayList<ArrayList<Integer>>();
    /**
     * Liste contentant les hexagones avec lesquels il est possible d'interagir.
     */
    private static HashMap<Hexagone, String> actionPossibleHash = new HashMap<Hexagone, String>();
    /**
     * Liste contenant les coordonnées des hexagones avec lesquels il est possible
     * d'interagir.
     */
    private static ArrayList<ArrayList<Object>> actionPossible = new ArrayList<ArrayList<Object>>();
    /**
     * Liste contenant les coordonnées des hexagones embrumés.
     */
    private static ArrayList<ArrayList<Integer>> brouillard = new ArrayList<ArrayList<Integer>>();
    
    /**
     * derniere attaque
     */
    private static String lastAttaque = new String(); 
    /**
     * Constructeur jeu.
     */
    private Jeu() {

    }
    
    public static void start(int nbJoueur, int nbIA) { //nouvelle partie
        for(int i=1;i<=nbJoueur;i++) {
            Humain joueur = new Humain(i,"J"+i);
            listeJoueurs.add(joueur);
        }
        for(int i=nbJoueur+1;i<=nbJoueur+nbIA;i++) {
            IA ia = new IA(i,"IA"+i);
            listeJoueurs.add(ia);
        }
    	frame = new MainJFrame();
    	plateau = new Affplateau();
		Jeu.initMap(); // pour test
        frame.getFrame().setVisible(true);
		Jeu.affichageUnite();
    	started = true;
    }
    
    public static void start() { //reprise partie
        frame = new MainJFrame();
        plateau = new Affplateau();
        frame.getFrame().setVisible(true);
        Jeu.initVoisins();
		Jeu.affichageUnite();
        started = true;
    }

    public static void kill() {
        started = false;
        frame.getFrame().dispose();
        for(Joueur j : Jeu.listeJoueurs) {
        	j.getListeUnite().clear();
        }
        Jeu.listeJoueurs.clear();
        infoUnite.clear();
        deplacementPossibleHash.clear();
        deplacementPossible.clear();
        actionPossibleHash.clear();
        actionPossible.clear();
        brouillard.clear();
    	frame = null;
    	plateau = null;
    }

    /**
     * Initialise un plateau aléatoirement en faisant des regroupements de types
     * d'hexagone.
     */
    public static void initMap() {
        List<List<Integer>> listeMap = new ArrayList<List<Integer>>();
        List<Integer> lignePossible = new ArrayList<Integer>();
        List<Integer> terrains = new ArrayList<Integer>();

        for (int i = 0; i < MAPLIGNE; i++) { // récupère toutes les positions possibles
            List<Integer> listeLigne = new ArrayList<Integer>();
            for (int j = 0; j < MAPCOLONNE; j++) {
                listeLigne.add(j);
            }
            listeMap.add(listeLigne);
            lignePossible.add(i);
        }

        for (int i = PLAINE; i <= DESERT; i++) { // récupère tous les terrains possibles
            terrains.add(i);
        }

        while (!lignePossible.isEmpty()) { // tant que le plateau n'est pas rempli
            Integer ligne;
            Integer colonne;
            Integer terrain;

            // pour éviter l'apparition de la mer près des zones de départ
            final int ligneZoneDepart = 7;
            final int colonneZoneDepart = 5;
            do {
                ligne = getElementAleatoire(lignePossible); // ligne aléatoire
                colonne = getElementAleatoire(listeMap.get(ligne)); // colonne aléatoire
                terrain = getElementAleatoire(terrains); // terrain aléatoire
            } while (terrain == MER && (ligne < ligneZoneDepart || ligne >= MAPLIGNE - ligneZoneDepart)
                    && (colonne < colonneZoneDepart || colonne >= MAPCOLONNE - colonneZoneDepart));

            final int nbVoisin = 6;
            for (int cpt = 0; cpt <= nbVoisin; cpt++) { // met le même terrain pour l'hexagone aléatoire et ces voisins
                if (ligne >= 0 && colonne >= 0 && ligne < MAPLIGNE && colonne < MAPCOLONNE
                        && lignePossible.contains(ligne) && listeMap.get(ligne).contains(colonne)) {
                    switch (terrain) {
                    case PLAINE:
                        map[ligne][colonne] = new Plaine(ligne, colonne);
                        break;
                    case FORET:
                        map[ligne][colonne] = new Foret(ligne, colonne);
                        break;
                    case VILLAGE:
                        map[ligne][colonne] = new Village(ligne, colonne);
                        break;
                    case RIVIERE:
                        map[ligne][colonne] = new Riviere(ligne, colonne);
                        break;
                    case MONTAGNE:
                        map[ligne][colonne] = new Montagne(ligne, colonne);
                        break;
                    case MER:
                        map[ligne][colonne] = new Mer(ligne, colonne);
                        break;
                    case DESERT:
                        map[ligne][colonne] = new Desert(ligne, colonne);
                        break;
                    default:
                        break;
                    }

                    listeMap.get(ligne).remove(colonne); // retire les coordonnées de la liste
                    if (listeMap.get(ligne).isEmpty()) {
                        lignePossible.remove(ligne);
                    }
                }
                switch (cpt) {
                case 0:
                    colonne++; // hexagone à droite
                    break;
                case 1:
                    colonne -= 2; // hexagone à gauche
                    break;
                case 2:
                    ligne--; // hexagone en haut à gauche
                    break;
                case 3:
                    colonne++; // hexagone en haut à droite
                    break;
                case 4:
                    ligne += 2; // hexagone en bas à droite
                    break;
                case 5:
                    colonne--; // hexagone en bas à gauche
                    break;
                default:
                    break;
                }
            }
        }
        initVoisins();
    }

    /**
     * Initialise les voisins de chaque hexagone.
     */
    public static void initVoisins() {
        for (int i = 0; i < MAPLIGNE; i++) {
            for (int j = 0; j < MAPCOLONNE; j++) {
                map[i][j].initListeVoisin();
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Retourne un élément aléatoire d'une liste d'entiers.
     * @param liste Liste d'entiers.
     * @return Un élément aléatoire de liste
     */
    public static int getElementAleatoire(final List<Integer> liste) {
        Random alea = new Random();
        return liste.get(alea.nextInt(liste.size()));
    }

    /**
     * Récupère pour chaque unité le numéro de joueur, son type et sa position et
     * les met dans la liste infoUnite.
     * @see Jeu#infoUnite
     */
    public static void controlAffichageUnite() {
        infoUnite.clear();
        for (Joueur joueur : listeJoueurs) {
            for (Unite unite : joueur.getListeUnite()) {
                ArrayList<Integer> unites = new ArrayList<Integer>();
                unites.add(joueur.getNumeroJoueur());
                unites.add(unite.getTypeUnite());
                unites.add(unite.getX());
                unites.add(unite.getY());
                infoUnite.add(unites);
            }
        }
    }

    /**
     * Récupère la HashMap contenant les déplacements possibles de l'unité
     * sélectionnée, et envoie les coordonnées des hexagones à la vue pour surligner
     * les cases où le déplacement est possible.
     * @param deplacementPossibleHash HashMap contenant les hexagones où il est
     *                                possible de se déplacer.
     * @param actionPossibleHash HashMap contenant les hexagones sur lesquels il est possible d'interagir.
     */
    public static void controlSurligne(final HashMap<Hexagone, Integer> deplacementPossibleHash,
            final HashMap<Hexagone, String> actionPossibleHash) {
        deplacementPossible.clear();
        actionPossible.clear();

        for (Hexagone i : deplacementPossibleHash.keySet()) {
            ArrayList<Integer> deplacementP = new ArrayList<Integer>();
            deplacementP.add(i.getX());
            deplacementP.add(i.getY());
            deplacementPossible.add(deplacementP);
        }

        for (Hexagone i : actionPossibleHash.keySet()) {
            ArrayList<Object> actionP = new ArrayList<Object>();
            actionP.add(i.getX());
            actionP.add(i.getY());
            actionP.add(actionPossibleHash.get(i));
            actionPossible.add(actionP);
        }
    }

    /**
     * Envoie les coordonnées des unités et les coordonnées des déplacements
     * possibles à la vue pour les afficher.
     */
    public static void affichageDeplacementPossible() {
        controlAffichageUnite();
        controlSurligne(deplacementPossibleHash, actionPossibleHash);
        plateau.repaint();
    }

    /**
     * Envoie les infos des unités à la vue pour mettre à jour l'affichage.
     */
    public static void affichageUnite() {
        controlAffichageUnite();
        deplacementPossible.clear();
        actionPossible.clear();
        // controlSurligne(deplacementPossibleHash);
        plateau.repaint();
    }
    
    /**
     * Récupère l'arraylist contenant les hexagones non enfumés,
     * et envoie les coordonnées des hexagones à la vue pour surligner les cases où le
     * déplacement est possible.
     * @param deplacementPossible2 HashMap contenant les hexagones où il est possible de se déplacer.
     */
    public static void afficheBrouillard(ArrayList<Hexagone> clair) {
    	brouillard.clear();
    	
    	for(int ligne = 0;ligne < MAPLIGNE;ligne++) {
    		for(int colonne = 0;colonne < MAPCOLONNE;colonne++) {
    			if(!(clair.contains(map[ligne][colonne]))) {
        	    	ArrayList<Integer> embrume=new ArrayList<Integer>();
        	    	embrume.add(map[ligne][colonne].getX());
        	    	embrume.add(map[ligne][colonne].getY());
        	    	brouillard.add(embrume);
    			}
        	}
    	}
    }
    	

    // TODO changement des variables X et Y en un nom de variable commençant par une
    // majuscule
    // TODO déclarer les constantes (à quoi elles correspondent ?)
    /**
     * Renvoie les coordonnées de l'hexagone cliqué.
     * @return les coordonnées de l'hexagone cliqué
     */
    public static Point getCoordHexaClicked() {
        System.out.println("HOY");
        Point mouse = new Point(-1, -1);
        int hX = -1;
        int hY = -1;
        // System.out.print("");//ABSOLUMENT NECESSAIRE (Mais je sais pas pourquoi)
        mouse = Jeu.getFrame().getClicPos();
        System.out.println("CLIC X: " + mouse.x + " Y: " + mouse.y);
        int X = mouse.y;
        int Y = mouse.x;
        find: for (int ligne = 0; ligne < Jeu.MAPLIGNE; ligne++) {
            for (int colonne = 0; colonne < Jeu.MAPCOLONNE; colonne++) {
                int refX = 30 + 45 * ligne;
                int refY = 25 * (ligne & 1) + colonne * 50;
                if (Y >= refY && Y < refY + 50) {
                    int dX = (int) (30 - 15.0 / 25.0 * (Math.abs(refY + 25 - Y)));
                    if (X >= refX - dX && X <= refX + dX) {
                        System.out.println("\n\nX: " + (refX + 30) + " Y: " + (refY + 25));
                        System.out.println("X: " + (refX + 15) + " Y: " + refY);
                        System.out.println("X: " + (refX + 15) + " Y: " + (refY + 50));
                        System.out.println("X: " + (refX - 15) + " Y: " + refY);
                        System.out.println("X: " + (refX - 15) + " Y: " + (refY + 50));
                        System.out.println("X: " + (refX - 30) + " Y: " + (refY + 25));
                        hX = ligne;
                        hY = colonne;
                        break find;
                    }
                }
            }
        }
        System.out.println(hX + " " + hY);
        return new Point(hX, hY);
    }

    /**
     * Sauvegarde les données du jeu dans un fichier.
     * @param saveName Nom du fichier de sauvegarde.
     */
    public static void sauvegarderPartie(final String saveName) {
        final File saveFile = new File("./" + saveName);
        try {
            if (!saveFile.exists()) {
                System.out.println("Fichier inexistant");
                saveFile.createNewFile();
            }
            final FileWriter save = new FileWriter(saveFile);
            try {
                int x, y;
                for (y = 0; y < MAPLIGNE; y++) {
                    for (x = 0; x < MAPCOLONNE; x++) {
                        save.write(map[y][x].getType());
                    }
                }
                save.write(listeJoueurs.size());
                for (Joueur joueur : listeJoueurs) {
                    save.write(joueur.getPseudo().length());
                    for (int i = 0; i < joueur.getPseudo().length(); i++) {
                        save.write(joueur.getPseudo().charAt(i));
                    }
                    save.write(joueur.getListeUnite().size());
                    for (Unite unite : joueur.getListeUnite()) {
                        save.write(unite.getTypeUnite());
                        save.write(unite.getAttaque());
                        save.write(unite.getDefense());
                        save.write(unite.getPv());
                        save.write(unite.getPvMax());
                        save.write(unite.getPtDeDeplacement());
                        save.write(unite.getPtDeDeplacementMax());
                        save.write(unite.getVision());
                        save.write(unite.getPorte());
                        save.write(unite.getX());
                        save.write(unite.getY());
                    }
                }
            } finally {
                save.close();
            }
        } catch (IOException e) {
            System.out.println("Impossible de creer le fichier");
        }
    }

    /**
     * Charge une partie à partir d'un fichier.
     * @param fichier Nom du fichier à charger.
     */
    public static void chargerPartie(final String fichier) {
    	listeJoueurs.clear();
    	for(Joueur j : Jeu.listeJoueurs) {
            System.out.println("Joueur: "+j.getNumeroJoueur());
        	for(Unite u  : j.getListeUnite()) {
                System.out.println("Unite: "+u.toString());
        	}
        }
        System.out.println("\n\n\nDEBUT DE CHARGEMENT\n\n");
        final File saveFile = new File("./" + fichier);
        if(saveFile.exists()) {
	        try {
	            final FileReader save = new FileReader(saveFile);
	            try {
	                int ligne, colonne;
	                for (ligne = 0; ligne < MAPLIGNE; ligne++) {
	                    for (colonne = 0; colonne < MAPCOLONNE; colonne++) {
	                        switch (save.read()) {
	                        case PLAINE:
	                            map[ligne][colonne] = new Plaine(ligne, colonne);
	                            break;
	                        case FORET:
	                            map[ligne][colonne] = new Foret(ligne, colonne);
	                            break;
	                        case VILLAGE:
	                            map[ligne][colonne] = new Village(ligne, colonne);
	                            break;
	                        case RIVIERE:
	                            map[ligne][colonne] = new Riviere(ligne, colonne);
	                            break;
	                        case MONTAGNE:
	                            map[ligne][colonne] = new Montagne(ligne, colonne);
	                            break;
	                        case MER:
	                            map[ligne][colonne] = new Mer(ligne, colonne);
	                            break;
	                        case DESERT:
	                            map[ligne][colonne] = new Desert(ligne, colonne);
	                            break;
	                        default:
	                            break;
	                        }
	                    }
	                }
	                int playerCount = save.read();
	                for (int p = 1; p <= playerCount; p++) {
	                	System.out.println("Joueur: "+p);
	                    int namelength = save.read();
	                    String nom = "";
	                    for (int c = 0; c < namelength; c++) {
	                        char carac = (char) save.read();
	                        nom = nom + String.valueOf(carac);
	                    }
	                    Joueur joueur;
	                    if (nom.matches("(.*)IA(.*)")) {
	                        System.out.println("IA");
	                        joueur = new IA(p, nom);
	                    } else {
	                        System.out.println("Humain");
	                        joueur = new Humain(p, nom);
	                    }
	                    joueur.setListeUnite(new ArrayList<Unite>());
	                    listeJoueurs.add(joueur);
	                    int uniteCount = save.read();
	                    System.out.println("Count: " + uniteCount);
	                    for (int u = 0; u < uniteCount; u++) {
	                        int typeUnite = save.read();
	                        System.out.println("Type: " + typeUnite);
	                        switch (typeUnite) {
	                        case GUERRIER:
	                            joueur.getListeUnite()
	                                    .add(new Unite(GUERRIER, save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), p));
	                            break;
	                        case PRETRE:
	                            joueur.getListeUnite()
	                                    .add(new Unite(PRETRE, save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), p));
	                            break;
	                        case MAGE:
	                            joueur.getListeUnite()
	                                    .add(new Unite(MAGE, save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), p));
	                            break;
	                        case ARCHER:
	                            joueur.getListeUnite()
	                                    .add(new Unite(ARCHER, save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), p));
	                            break;
	                        case CHEVALIER:
	                            joueur.getListeUnite()
	                                    .add(new Unite(CHEVALIER, save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), save.read(), save.read(), save.read(), save.read(),
	                                            save.read(), p));
	                            break;
	                        default:
	                            break;
	                        }
	                        System.out.println(joueur.getListeUnite().get(joueur.getListeUnite().size()-1));
	                    }
	                }
	            } finally {
	                save.close();
	            }
	        } catch (IOException e) {
	            System.out.println("Impossible de creer le fichier");
	        }
	        Jeu.start();
        }
    }
    
	public static ArrayList<String> getCaractUniteEnMouvement(Point hexa){
		  
		  	ArrayList<String> listeCaractAffichage= new ArrayList<String>();
		  	listeCaractAffichage.clear();
	    	int px=(int)hexa.getX();
			int py=(int)hexa.getY();
			
	    	for(Joueur j: Jeu.getListeJoueurs() ){
	    		for(Unite u : j.getListeUnite()){
	    			if(px == u.getX() && py == u.getY()){
	    				listeCaractAffichage.add(String.valueOf(u.getPv()));
						listeCaractAffichage.add(String.valueOf(u.getPvMax()));
						listeCaractAffichage.add(String.valueOf(u.getDefense()));
						listeCaractAffichage.add(String.valueOf(u.getAttaque()));
						listeCaractAffichage.add(String.valueOf(u.getVision()));
						listeCaractAffichage.add(String.valueOf(u.getPtDeDeplacement()));
						listeCaractAffichage.add(String.valueOf(u.getTypeUnite()));
						break;  
	    		}
	    	}	    			
	    }
	    	return listeCaractAffichage;
	    
	}
    //////////// GETTERS AND SETTERS /////////////////
    /**
     * Retourne l'indicateur de clic.
     * @return l'indicateur de clic.
     */
    public static boolean getClicFlag() {
        return clicFlag;
    }

    /**
     * Met à jour l'indicateur de clic.
     * @param clicFlag le nouvel indicateur de clic
     */
    public static void setClicFlag(final boolean clicFlag) {
        Jeu.clicFlag = clicFlag;
    }

    /**
     * Met à jour l'indicateur de passage de tour.
     * @param skipFlag le nouvel indicateur de passage de tour
     */
    public static void setSkipFlag(final boolean skipFlag) {
        Jeu.skipFlag = skipFlag;
    }

    /**
     * Retourne l'indicateur de passage de tour.
     * @return l'indicateur de passage de tour.
     */
    public static boolean getSkipFlag() {
        return skipFlag;
    }

    /**
     * Met à jour l'état du jeu.
     * @param started l'état du jeu
     */
    public static void setStarted(final boolean started) {
        Jeu.started = started;
    }

    /**
     * Retourne l'état du jeu.
     * @return l'état du jeu.
     */
    public static boolean hasStarted() {
        return started;
    }

    /**
     * Retourne la liste des joueurs de la partie.
     * @return la liste des joueurs de la partie.
     */
    public static ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * Retourne le plateau de jeu.
     * @return le plateau de jeu.
     */
    public static Hexagone[][] getMap() {
        return map;
    }

    /**
     * Retourne la fenêtre de jeu.
     * @return la fenêtre de jeu.
     */
    public static MainJFrame getFrame() {
        return frame;
    }

    /**
     * Retourne le plateau visuel de la vue.
     * @return le plateau visuel de la vue.
     */
    public static Affplateau getPlateau() {
        return plateau;
    }

    /**
     * Met à jour le plateau visuel de la vue.
     * @param plateau Le nouveau plateau visuel de la vue.
     */
    public static void setPlateau(final Affplateau plateau) {
        Jeu.plateau = plateau;
    }

    /**
     * Retourne la liste des infos des unités.
     * @return la liste des infos des unités
     */
    public static ArrayList<ArrayList<Integer>> getInfoUnite() {
        return infoUnite;
    }

    /**
     * Retourne la liste des coordonnées des déplacements possibles.
     * @return la liste des coordonnées des déplacements possibles.
     */
    public static ArrayList<ArrayList<Integer>> getDeplacementPossible() {
        return deplacementPossible;
    }

    /**
     * Retourne la liste des coordonnées des actions possibles.
     * @return la liste des coordonnées des actions possibles.
     */
    public static ArrayList<ArrayList<Object>> getActionPossible() {
        return actionPossible;
    }
    
    /**
     * Retroune la liste des coordonnées des cases embrumées.
     * @return la liste des coordonnées des cases embruméess.
     */
    public static ArrayList<ArrayList<Integer>> getBrouillard() {
		return brouillard;
	}

    /**
     * Met à jour la liste des hexagones où il est possible de se déplacer.
     * @param deplacementPossibleHash la liste des hexagones où il est possible de
     *                                se déplacer.
     */
    public static void setDeplacementPossibleHash(final HashMap<Hexagone, Integer> deplacementPossibleHash) {
        Jeu.deplacementPossibleHash = deplacementPossibleHash;
    }

    /**
     * Met à jour la liste des hexagones avec lesquels il est possible d'interagir.
     * @param actionPossibleHash la liste des hexagones avec lesquels il est
     *                                possible d'interagir.
     */
    public static void setActionPossibleHash(final HashMap<Hexagone, String> actionPossibleHash) {
        Jeu.actionPossibleHash = actionPossibleHash;
    }
    /**
     * retourne la derniere attaque
     * @return String
     */
	public static String getLastAttaque() {
		return lastAttaque;
	}
	/**
	 * permet de changer la derniere attaque
	 * @param lastAttaque
	 */
	public static void setLastAttaque(String lastAttaque) {
		Jeu.lastAttaque = lastAttaque;
	}

}