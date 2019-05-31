package vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Jeu;


public class Affplateau extends JPanel{ // Classe personnelle qui cr�e une grile hexagonale.
	final static int cote=30; // Ceci d�finit la taille du c�t� d'un polygone
	//int numero=0; // Retien le n� du polygone sur lequel est la souris
	Polygon pol;
	
	
	public static Polygon getPolygon(int x,int y,int cote){
		int haut=cote/2;
		int larg=(int)(cote*(Math.sqrt(3)/2));
		Polygon p=new Polygon();
		p.addPoint(x,y+haut);
		p.addPoint(x+larg,y); 
		p.addPoint(x+2*larg,y+haut);
		p.addPoint(x+2*larg,y+(int)(1.5*cote)); 
		p.addPoint(x+larg,y+2*cote);
		p.addPoint(x,y+(int)(1.5*cote));
		return p;
	}		
	
	 public void paint(Graphics graph) {
		Polygon hexagone=getPolygon(0, 0, cote); // Cree un hexagone
		Rectangle r=hexagone.getBounds(); // Recupere le plus petit rectangle // aux bord de la fenetre dans lequel l'hexagone peut s'inscrire
		graph.setColor(Color.BLACK);
		super.paint(graph);
		Graphics2D g2d=(Graphics2D) graph;
		BufferedImage bim = null;
		
		for(int l=0;l<Jeu.MAPLIGNE;l=l+2){// Remarquer le "+2" car la grille est constituee de 2 sous grilles (les lignes impaires sont decallees)
			for(int c=0;c<Jeu.MAPCOLONNE;c++){
			    Polygon poly=getPolygon(c*r.width, (int)(l*cote*1.5),cote);
				
				try {
					switch(Jeu.getMap()[l][c].getType()) {
					case 10:
						bim=ImageIO.read(new File("plaine3.png"));
						break;
					case 11:
						bim=ImageIO.read(new File("foret3.png"));
						break;
					case 12:
						bim=ImageIO.read(new File("village3.png"));
						break;
					case 13:
						bim=ImageIO.read(new File("riviere3.png"));
						break;
					case 14:
						bim=ImageIO.read(new File("motagne3.png"));
						break;
					case 15:
						bim=ImageIO.read(new File("mer3.png"));
						break;
					case 16:
						bim=ImageIO.read(new File("desert3.png"));
					}
					} catch(IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				g2d.setColor(new Color(53,196,39));
				//g2d.fillRect(c*r.width, (int)(l*cote*1.5), 52, 60);
			    g2d.draw(poly);
			    g2d.drawImage(bim,c*r.width ,(int)(l*cote*1.5),this);
			}
		}
		for(int l=1;l<Jeu.MAPLIGNE;l=l+2){
			for(int c=0;c<Jeu.MAPCOLONNE;c++)
			{
				Polygon poly=getPolygon(c*r.width+r.width/2,  (int)(l*cote*1.5+0.5),cote);
				try {
					switch(Jeu.getMap()[l][c].getType()) {
					case 10:
						bim=ImageIO.read(new File("plaine3.png"));
						break;
					case 11:
						bim=ImageIO.read(new File("foret3.png"));
						break;
					case 12:
						bim=ImageIO.read(new File("village3.png"));
						break;
					case 13:
						bim=ImageIO.read(new File("riviere3.png"));
						break;
					case 14:
						bim=ImageIO.read(new File("motagne3.png"));
						break;
					case 15:
						bim=ImageIO.read(new File("mer3.png"));
						break;
					case 16:
						bim=ImageIO.read(new File("desert3.png"));
					}
					} catch(IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				g2d.setColor(new Color(53,196,39));
				g2d.draw(poly);
				g2d.drawImage(bim, c*r.width+r.width/2,(int)(l*cote*1.5+0.5),this);
			}
		}
	
	}

	

	



}
