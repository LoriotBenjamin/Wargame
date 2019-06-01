package controleur;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

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
import modele.IA;
import modele.Humain;

/**
 * Jeu est la classe représentant le contrôleur de la partie.
 * @author Solenn
 *
 */
public class Jeu {
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
     * Simple indicateur de clic
     */
    private static boolean clicFlag = false;
    /**
     * Simple indicateur de passage de tour
     */
    private static boolean skipFlag = false;
    /**
     * Plateau de jeu.
     */
    private static Hexagone[][] map = new Hexagone[MAPLIGNE][MAPCOLONNE];
    /**
     * Fenêtre de jeu.
     */
    private static MainJFrame frame = new MainJFrame();
    /**
     * Plateau visuel de la vue.
     */
    private static Affplateau plateau= new Affplateau();
    
    private static ArrayList<ArrayList<Integer>> infoUnite =new ArrayList<ArrayList<Integer>>();
    
    private static HashMap<Hexagone,Integer>deplacementPossibleHash=new HashMap<Hexagone,Integer>();
    private static ArrayList<ArrayList<Integer>> deplacementPossible=new ArrayList<ArrayList<Integer>>();

    /**
     * Initialise un plateau aléatoirement en faisant des regroupements de types d'hexagone.
     */
    public static void initMap() {
        List<List<Integer>> listeMap = new ArrayList<List<Integer>>();
        List<Integer> lignePossible = new ArrayList<Integer>();
        List<Integer> terrains = new ArrayList<Integer>();

        for (int i = 0; i < MAPLIGNE; i++) { // récupèere toutes les positions possibles
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

        while (!lignePossible.isEmpty()) { // tant que la map n'est pas remplie
            Integer ligne;
            Integer colonne;
            Integer terrain;
            do {
                ligne = getElementAleatoire(lignePossible); // ligne aleatoire
                colonne = getElementAleatoire(listeMap.get(ligne)); // colonne aleatoire
                terrain = getElementAleatoire(terrains); // terrain aleatoire
            } while (terrain == MER && (ligne <= 6 || ligne >= MAPLIGNE - 7)
                    && (colonne <= 4 || colonne >= MAPCOLONNE - 5));
            //pas de mer dans les zones de depart
            final int nbVoisin = 6;
            for (int cpt = 0; cpt <= nbVoisin; cpt++) { // met le meme terrain pour l'hexagone aleatoire et ces voisins
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

                    listeMap.get(ligne).remove(colonne);
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
    
    public static void initVoisins() {
    	frame.getFrame().setVisible(true);
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
     * @param liste
     *      Liste d'entiers.
     * @return un élément aléatoire de liste
     */
    public static int getElementAleatoire(final List<Integer> liste){
        Random alea = new Random();
        return liste.get(alea.nextInt(liste.size()));
    }

    /**
     * Récupère pour chaque unité le numéro de joueur, son type et sa position
     * puis appelle la fonction d'affichage des unités.
     */
    public static void controlAffichageUnite() {
        infoUnite.clear();
        for (Joueur joueur : listeJoueurs) {
            for (Unite unite : joueur.getListeUnite()) {
                ArrayList<Integer> unites =new ArrayList<Integer>();
                unites.add(joueur.getNumeroJoueur());
                unites.add(unite.getTypeUnite());
                unites.add(unite.getX());
                unites.add(unite.getY());
                infoUnite.add(unites);
                //plateau.afficheUnite(infoUnite);
            }
        }
    }
    
    
    /**
     * Récupère la HashMap contenant les déplacement possible de l'unité sélection,
     * et envoie deux integers x et y à la vue pour surligné les cases où le déplacement est possible.
     */
    public static void controlSurligne(HashMap<Hexagone,Integer>deplacementPossible2) {
    	deplacementPossible.clear();
    	
    	for(Hexagone i:deplacementPossible2.keySet()) {
    		ArrayList<Integer> deplacementP=new ArrayList<Integer>();
    		deplacementP.add(i.getX());
    		deplacementP.add(i.getY());
    		deplacementPossible.add(deplacementP);
    	}
    }

    
    //JAVADOC A FAIRE + DEPLACER DANS LA CLASSE JOUEUR (JE PENSE) + A SUPPRIMER EN FIN DE PROJET SI NON UTILISEE
    /*
     * compare la position de toutes les unites avec les coordonees rentrees si une
     * unite ennemie est sur la position demandee, retourne true sinon false !! je
     * ne sais pas si je dois la poser ici
     */
    public static boolean comparePosUniteAndTeamWithCoord(int x, int y, int numeroJoueur) {

        for (Joueur j : Jeu.listeJoueurs) {
            if (j.getNumeroJoueur() != numeroJoueur) {// petite optimisation ne regarde pas l'equipe du joueur evite 1
                                                      // tour de boucle inutile
                for (Unite u : j.getListeUnite()) {
                    if (u.getX() == x && u.getY() == y)
                        return true;
                }
            }
        }

        return false;
    }

    //JAVADOC A FAIRE + DEPLACER DANS JOUEUR 
    public static Unite getUniteByNumeroJoueurAndCoord(int x, int y, int numeroJoueur) {
        ArrayList<Unite> uniteDuJoueur = Jeu.listeJoueurs.get(numeroJoueur).getListeUnite();
        for (Unite u : uniteDuJoueur) {
            if (u.getX() == x && u.getY() == y)
                return u;
        }
        return null;
    }
    
    public static void jeRepaint() {
    	controlAffichageUnite();
    	deplacementPossible.clear();
    	//controlSurligne(deplacementPossibleHash);
    	plateau.repaint();
    }
    
    public static void jeRepaint2() {
    	controlAffichageUnite();
    	controlSurligne(deplacementPossibleHash);
    	plateau.repaint();
    }
    
    public static Point getHexagonClicked() {
    	System.out.println("HOY");
    	Point mouse = new Point(-1,-1);
    	int hX = -1;
    	int hY = -1;
	    //System.out.print("");//ABSOLUMENT NECESSAIRE (Mais je sais pas pourquoi)
		mouse = Jeu.getFrame().getClicPos();
		System.out.println("CLIC X: "+mouse.x+" Y: "+mouse.y);
	    int X = mouse.y;
	    int Y = mouse.x;
	    find : for(int ligne=0;ligne<Jeu.MAPLIGNE;ligne++) {
	       	for(int colonne=0;colonne<Jeu.MAPCOLONNE;colonne++) {
	       		int refX = 30 + 45*ligne;
	       		int refY = 25*(ligne & 1) + colonne*50;
	       		if(Y >= refY && Y < refY+50) {
	       			int dX = (int)(15 + 15.0 / 25.0 * (Math.abs(refY+25-Y)));
	       			if(X >= refX-dX && X <= refX+dX) {
			       		System.out.println("\n\nX: "+(refX+30)+" Y: "+(refY+25));
			       		System.out.println("X: "+(refX+15)+" Y: "+refY);
			       		System.out.println("X: "+(refX+15)+" Y: "+(refY+50));
			       		System.out.println("X: "+(refX-15)+" Y: "+refY);
			       		System.out.println("X: "+(refX-15)+" Y: "+(refY+50));
			       		System.out.println("X: "+(refX-30)+" Y: "+(refY+25));
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

    //JAVADOC A FAIRE
    public static void sauvegarderPartie(String saveName) {
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
                    for(int i=0;i<joueur.getPseudo().length();i++) {
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

    public static void chargerPartie(String fichier) {
        final File saveFile = new File("./" + fichier);
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
                	int namelength = save.read();
                	String nom = "";
                	for(int c=0;c<namelength;c++) {
                		char carac = (char)save.read();
                		nom = nom+String.valueOf(carac);
                	}
                	Joueur joueur;
                    if(nom.matches("(.*)IA(.*)")) {
                    	System.out.println("IA");
                    	joueur = new IA(p, nom);
                    }else {
                    	System.out.println("Humain");
                    	joueur = new Humain(p, nom);
                    }
                    listeJoueurs.add(joueur);
                	int uniteCount = save.read();
                	System.out.println("Count: "+uniteCount);
                    for(int u=0;u<uniteCount;u++) {
                        int typeUnite = save.read();
                        System.out.println("Type: "+typeUnite);
                        switch (typeUnite) {
                        case GUERRIER:
                            joueur.getListeUnite().add(new Unite(GUERRIER, save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(),p));
                            break;
                        case PRETRE:
                        	joueur.getListeUnite().add(new Unite(PRETRE, save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(),p));
                            break;
                        case MAGE:
                        	joueur.getListeUnite().add(new Unite(MAGE, save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(),p));
                            break;
                        case ARCHER:
                        	joueur.getListeUnite().add(new Unite(ARCHER, save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(),p));
                            break;
                        case CHEVALIER:
                        	joueur.getListeUnite().add(new Unite(CHEVALIER, save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(), save.read(),
                            		save.read(),p));
                            break;
                        default:
                            break;
                        }
                    }
                }
            } finally {
                save.close();
            }
        } catch (IOException e) {
            System.out.println("Impossible de creer le fichier");
        }
        initVoisins();
    }

    ////////////GETTERS AND SETTERS /////////////////
    /**
     * Retourne l'indicateur de clic.
     * @return l'indicateur de clic.
     */
    public static boolean getClicFlag() {
        return clicFlag;
    }

    /**
     * Met à jour l'indicateur de passage de tour.
     * @param le nouvel indicateur de passage de tour
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
     * Met à jour l'indicateur de clic.
     * @param le nouvel indicateur de clic
     */
    public static void setClicFlag(final boolean clicFlag) {
        Jeu.clicFlag = clicFlag;
    }
    /**
     * Retourne la liste des joueurs de la partie.
     * @return la liste des joueurs de la partie.
     */
    public static ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * Met à jour la liste des joueurs de la partie.
     * @param listeJoueurs
     *      La nouvelle liste des joueurs de la partie.
     */
    public static void setListeJoueurs(final ArrayList<Joueur> listeJoueurs) {
        Jeu.listeJoueurs = listeJoueurs;
    }

    /**
     * Retourne le plateau de jeu.
     * @return le plateau de jeu.
     */
    public static Hexagone[][] getMap() {
        return map;
    }

    /**
     * Met à jour le plateau de jeu.
     * @param map
     *      Le nouveau plateau de jeu.
     */
    public static void setMap(final Hexagone[][] map) {
        Jeu.map = map;
    }

    /**
     * Retourne la fenetre de jeu.
     * @return la fenetre de jeu.
     */
    public static MainJFrame getFrame() {
        return frame;
    }

	public static Affplateau getPlateau() {
		return plateau;
	}

	public static void setPlateau(Affplateau plateau) {
		Jeu.plateau = plateau;
	}

	public static ArrayList<ArrayList<Integer>> getInfoUnite() {
		return infoUnite;
	}

	public static void setInfoUnite(ArrayList<ArrayList<Integer>> infoUnite) {
		Jeu.infoUnite = infoUnite;
	}

	public static ArrayList<ArrayList<Integer>> getDeplacementPossible() {
		return deplacementPossible;
	}

	public static void setDeplacementPossible(ArrayList<ArrayList<Integer>> deplacementPossible) {
		Jeu.deplacementPossible = deplacementPossible;
	}

	public static HashMap<Hexagone, Integer> getDeplacementPossibleHash() {
		return deplacementPossibleHash;
	}

	public static void setDeplacementPossibleHash(HashMap<Hexagone, Integer> deplacementPossibleHash) {
		Jeu.deplacementPossibleHash = deplacementPossibleHash;
	}

	

}
