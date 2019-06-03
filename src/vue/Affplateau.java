package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.Jeu;

/**
 * Affplateau est la classe fille de JPanel, elle affiche le plateau de jeu et
 * son contenu.
 * @author Stefano
 *
 */
public class Affplateau extends JPanel {
    /**
     * Numéro de serial Version.
     */
    private static final long serialVersionUID = -2264167392249814615L;
    /**
     * Taille du côté d'un hexagone.
     */
    static final int COTE = 30;
    /**
     * Polygone de la forme d'une hexagone.
     */
    private Polygon pol;
    /**
     * Graphics2D dans lequel on dessine les différents éléments.
     */
    private Graphics2D g2d;
    /**
     * Buffered Image qui aura l'image chargée depuis un fichier png.
     */
    private BufferedImage bim;
    /**
     * Rectangle le plus petit dans un hexagone.
     */
    private Rectangle r;
    /**
     * Graphic pris en paramètre de le fonction paint.
     */
    private Graphics graph;
    /**
     * String pour représenter le séparateur de fichier que ce soit sur Linux ou
     * Windows.
     */
    private String separateur = System.getProperty("file.separator");

    /**
     * Retourne un hexagone.
     * @param x Coordonée x du point de départ.
     * @param y Coordonnée y du point de départ.
     * @param cote Longueur du côté de l'hexagone.
     * @return un hexagone
     */
    public static Polygon getPolygon(final int x, final int y, final int cote) {
        int haut = cote / 2;
        int larg = (int) (cote * (Math.sqrt(3) / 2));
        Polygon p = new Polygon();
        p.addPoint(x, y + haut);
        p.addPoint(x + larg, y);
        p.addPoint(x + 2 * larg, y + haut);
        p.addPoint(x + 2 * larg, y + (int) (1.5 * cote));
        p.addPoint(x + larg, y + 2 * cote);
        p.addPoint(x, y + (int) (1.5 * cote));
        return p;
    }

    @Override
    /**
     * Dessine dans le JPanel les éléments du jeu (plateau, unités,
     * déplacement possible, brouillard).
     * @param graph Graphic.
     */
    public void paint(final Graphics graph) {
        Polygon hexagone = getPolygon(0, 0, COTE); // Crée un hexagone
        r = hexagone.getBounds(); // Récupère le plus petit rectangle aux bord de la fenêtre dans lequel
                                  // l'hexagone peut s'inscrire
        graph.setColor(Color.BLACK);
        super.paint(graph);
        g2d = (Graphics2D) graph;
        this.graph = graph;
        bim = null;
        for (int l = 0; l < Jeu.MAPLIGNE; l = l + 2) { // Remarquer le "+2" car la grille est constituées de 2 sous
                                                      // grilles (les lignes impaires sont décallées)
            for (int c = 0; c < Jeu.MAPCOLONNE; c++) {
                Polygon poly = getPolygon(c * r.width, (int) (l * COTE * 1.5), COTE);

                try {
                    switch (Jeu.getMap()[l][c].getType()) {
                    case 10:
                        bim = ImageIO.read(new File("images" + separateur + "plaine3.png"));
                        break;
                    case 11:
                        bim = ImageIO.read(new File("images" + separateur + "foret3.png"));
                        break;
                    case 12:
                        bim = ImageIO.read(new File("images" + separateur + "village3.png"));
                        break;
                    case 13:
                        bim = ImageIO.read(new File("images" + separateur + "riviere3.png"));
                        break;
                    case 14:
                        bim = ImageIO.read(new File("images" + separateur + "motagne3.png"));
                        break;
                    case 15:
                        bim = ImageIO.read(new File("images" + separateur + "mer3.png"));
                        break;
                    case 16:
                        bim = ImageIO.read(new File("images" + separateur + "desert3.png"));
                        break;
                    default:
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g2d.setColor(new Color(53, 196, 39));
                g2d.draw(poly);
                g2d.drawImage(bim, c * r.width, (int) (l * COTE * 1.5), this);
            }
        }
        for (int l = 1; l < Jeu.MAPLIGNE; l = l + 2) {
            for (int c = 0; c < Jeu.MAPCOLONNE; c++) {
                Polygon poly = getPolygon(c * r.width + r.width / 2, (int) (l * COTE * 1.5 + 0.5), COTE);
                try {
                    switch (Jeu.getMap()[l][c].getType()) {
                    case 10:
                        bim = ImageIO.read(new File("images" + separateur + "plaine3.png"));
                        break;
                    case 11:
                        bim = ImageIO.read(new File("images" + separateur + "foret3.png"));
                        break;
                    case 12:
                        bim = ImageIO.read(new File("images" + separateur + "village3.png"));
                        break;
                    case 13:
                        bim = ImageIO.read(new File("images" + separateur + "riviere3.png"));
                        break;
                    case 14:
                        bim = ImageIO.read(new File("images" + separateur + "motagne3.png"));
                        break;
                    case 15:
                        bim = ImageIO.read(new File("images" + separateur + "mer3.png"));
                        break;
                    case 16:
                        bim = ImageIO.read(new File("images" + separateur + "desert3.png"));
                        break;
                    default:
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g2d.setColor(new Color(53, 196, 39));
                g2d.draw(poly);
                g2d.drawImage(bim, c * r.width + r.width / 2, (int) (l * COTE * 1.5 + 0.5), this);
            }
        }
        for (ArrayList<Integer> listeUnite : Jeu.getInfoUnite()) {
            try {
                switch (listeUnite.get(1)) {
                case 1:
                    bim = ImageIO.read(new File("images" + separateur + "guerrier" + listeUnite.get(0) + ".png"));
                    break;
                case 2:
                    bim = ImageIO.read(new File("images" + separateur + "mage" + listeUnite.get(0) + ".png"));
                    break;
                case 3:
                    bim = ImageIO.read(new File("images" + separateur + "archer" + listeUnite.get(0) + ".png"));
                    break;
                case 4:
                    bim = ImageIO.read(new File("images" + separateur + "pretre" + listeUnite.get(0) + ".png"));
                    break;
                case 5:
                    bim = ImageIO.read(new File("images" + separateur + "chevalier" + listeUnite.get(0) + ".png"));
                    break;
                default:
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bim != null) {
                g2d = (Graphics2D) graph;
                if (listeUnite.get(2) % 2 == 0) {
                    if (listeUnite.get(1) == 2) {
                        g2d.drawImage(bim, listeUnite.get(3) * r.width + 5, (int) (listeUnite.get(2) * COTE * 1.5),
                                this);
                    } else {
                        g2d.drawImage(bim, listeUnite.get(3) * r.width + 5, (int) (listeUnite.get(2) * COTE * 1.5) + 7,
                                this);// +7 pour recentrer l'image
                    }
                } else {
                    if (listeUnite.get(1) == 2) {
                        g2d.drawImage(bim, listeUnite.get(3) * r.width + r.width / 2 + 5,
                                (int) (listeUnite.get(2) * COTE * 1.5 + 0.5), this);
                    } else {
                        g2d.drawImage(bim, listeUnite.get(3) * r.width + r.width / 2 + 5,
                                (int) (listeUnite.get(2) * COTE * 1.5 + 0.5) + 7, this);
                    }
                }
                repaint();
            }
        }
        Polygon poly = null;

        if (Jeu.getBrouillard() != null) {
            try {
                g2d = (Graphics2D) graph;
                bim = ImageIO.read(new File("images" + separateur + "brouillard.png"));
                for (ArrayList<Integer> brouillard : Jeu.getBrouillard()) {
                    int l = brouillard.get(0);
                    int c = brouillard.get(1);
                    if (l % 2 == 0) {
                        g2d.drawImage(bim, c * r.width, (int) (l * COTE * 1.5), this);
                    } else {
                        g2d.drawImage(bim, c * r.width + r.width / 2, (int) (l * COTE * 1.5 + 0.5), this);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (Jeu.getDeplacementPossible() != null) {
            for (ArrayList<Integer> deplacementPossible : Jeu.getDeplacementPossible()) {
                if (deplacementPossible.get(0) % 2 == 0) {
                    poly = getPolygon(deplacementPossible.get(1) * r.width,
                            (int) (deplacementPossible.get(0) * COTE * 1.5), COTE);
                } else {
                    poly = getPolygon(deplacementPossible.get(1) * r.width + r.width / 2,
                            (int) (deplacementPossible.get(0) * COTE * 1.5 + 0.5), COTE);
                }
                if (poly != null) {
                    g2d.setColor(Color.ORANGE);
                    g2d.draw(poly);
                }
            }
        }
        if (Jeu.getActionPossible() != null) {
            for (ArrayList<Object> actionPossible : Jeu.getActionPossible()) {
                if (((int) actionPossible.get(0)) % 2 == 0) {
                    poly = getPolygon(((int) actionPossible.get(1)) * r.width,
                            (int) (((int) actionPossible.get(0)) * COTE * 1.5), COTE);
                } else {
                    poly = getPolygon(((int) actionPossible.get(1)) * r.width + r.width / 2,
                            (int) (((int) actionPossible.get(0)) * COTE * 1.5 + 0.5), COTE);
                }
                if (poly != null) {
                    if ((String) actionPossible.get(2) == "allie") {
                        g2d.setColor(Color.GREEN);
                        g2d.draw(poly);
                    } else {
                        g2d.setColor(Color.RED);
                        g2d.draw(poly);
                    }
                }
            }
        }
    }
}
