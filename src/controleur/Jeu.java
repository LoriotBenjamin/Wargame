package controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
     * Simple indicateur
     */
    private static boolean event = false;
    /**
     * Plateau de jeu.
     */
    private static Hexagone[][] map = new Hexagone[MAPLIGNE][MAPCOLONNE];
    /**
     * Fenetre de jeu.
     */
    private static MainJFrame frame = new MainJFrame();

    /**
     * Initialise un plateau aléatoirement en faisant des regroupements de types d'hexagone.
     */
    public static void initMap() {
    	frame.getFrame().setVisible(true);
        List<List<Integer>> listeMap = new ArrayList<List<Integer>>();
        List<Integer> lignePossible = new ArrayList<Integer>();
        List<Integer> terrains = new ArrayList<Integer>();

        for (int i = 0; i < MAPLIGNE; i++) { // recupere toutes les positions possibles
            List<Integer> listeLigne = new ArrayList<Integer>();
            for (int j = 0; j < MAPCOLONNE; j++) {
                listeLigne.add(j);
            }
            listeMap.add(listeLigne);
            lignePossible.add(i);
        }

        for (int i = PLAINE; i <= DESERT; i++) { // recupere tous les terrains possibles
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
            } while(terrain == MER && (ligne <= 6 || ligne >= MAPLIGNE-7) && (colonne <= 4 || colonne >= MAPCOLONNE-5));
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
                    colonne++; // hexagone a  droite
                    break;
                case 1:
                    colonne -= 2; // hexagone a  gauche
                    break;
                case 2:
                    ligne--; // hexagone en haut a  gauche
                    break;
                case 3:
                    colonne++; // hexagone en haut a  droite
                    break;
                case 4:
                    ligne += 2; // hexagone en bas a  droite
                    break;
                case 5:
                    colonne--; // hexagone en bas a  gauche
                    break;
                default:
                    break;
                }
            }
        }

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
    
    public void controlAffichageUnite() {
        ArrayList<Integer> infoUnite = new ArrayList<Integer>();
        for(Joueur joueur : listeJoueurs) {
            for(Unite unite : joueur.getListeUnite()) {
                infoUnite.clear();
                infoUnite.add(joueur.getNumeroJoueur());
                infoUnite.add(unite.getTypeUnite());
                infoUnite.add(unite.getX());
                infoUnite.add(unite.getY());
                //appel fonction affichage
            }
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
                        save.write(Integer.toString(map[y][x].getType()));
                        if (x < MAPCOLONNE - 1) {
                            save.write("\t");
                        }
                    }
                    save.write("\n");
                }
                save.write(listeJoueurs.size() + "\n");
                for (Joueur joueur : listeJoueurs) {
                    save.write(joueur.getPseudo() + "\n");
                    for (Unite unite : joueur.getListeUnite()) {
                        save.write(Integer.toString(unite.getTypeUnite()) + "\t");
                        save.write(Integer.toString(unite.getAttaque()) + "\t");
                        save.write(Integer.toString(unite.getDefense()) + "\t");
                        save.write(Integer.toString(unite.getPv()) + "\t");
                        save.write(Integer.toString(unite.getPvMax()) + "\t");
                        save.write(Integer.toString(unite.getPtDeDeplacement()) + "\t");
                        save.write(Integer.toString(unite.getPtDeDeplacementMax()) + "\t");
                        save.write(Integer.toString(unite.getVision()) + "\t");
                        save.write(Integer.toString(unite.getPorte()) + "\t");
                        save.write(Integer.toString(unite.getX()) + "\t");
                        save.write(Integer.toString(unite.getY()) + "\t");
                        save.write(Integer.toString(unite.getTeamUnite()) + "\n");
                    }
                    save.write("\n");
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
            final BufferedReader br = new BufferedReader(save);
            try {
                int ligne, colonne;
                for (ligne = 0; ligne < MAPLIGNE; ligne++) {
                    String lignelue = br.readLine();
                    StringTokenizer tok = new StringTokenizer(lignelue, "\t");
                    for (colonne = 0; colonne < MAPCOLONNE; colonne++) {
                        switch (Integer.parseInt(tok.nextToken())) {
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
                        }
                    }
                }
                int playerCount = Integer.parseInt(br.readLine());
                for (int p = 1; p <= playerCount; p++) {
                    System.out.println(p);
                    String nom = br.readLine();
                    String infoUnite = br.readLine();
                    ArrayList<Unite> unites = new ArrayList<Unite>();
                    while (!(infoUnite.isEmpty())) {
                        StringTokenizer tok = new StringTokenizer(infoUnite, "\t");
                        switch (Integer.parseInt(tok.nextToken())) {
                        case GUERRIER:
                            unites.add(new Unite(GUERRIER, Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
                            break;
                        case PRETRE:
                            unites.add(new Unite(PRETRE, Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
                            break;
                        case MAGE:
                            unites.add(new Unite(MAGE, Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
                            break;
                        case ARCHER:
                            unites.add(new Unite(ARCHER, Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
                            break;
                        case CHEVALIER:
                            unites.add(new Unite(CHEVALIER, Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()),
                                    Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
                            break;
                        }
                        infoUnite = br.readLine();
                    }
                    Joueur player = new Joueur(p, nom, unites);
                    listeJoueurs.add(player);
                }
            } finally {
                save.close();
            }
        } catch (IOException e) {
            System.out.println("Impossible de creer le fichier");
        }
    }

    ////////////GETTERS AND SETTERS /////////////////
    /**
     * Retourne l'indicateur.
     * @return l'indicateur.
     */
    public static boolean getEvent() {
        return event;
    }

    /**
     * Met à jour l'indicateur.
     * @param le nouvel indicateur
     */
    public static void setEvent(final boolean event) {
        Jeu.event = event;
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

}
