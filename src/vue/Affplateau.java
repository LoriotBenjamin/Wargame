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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Jeu;


public class Affplateau extends JPanel{ // Classe personnelle qui crï¿½e une grile hexagonale.
	final static int cote=30; // Ceci dï¿½finit la taille du cï¿½tï¿½ d'un polygone
	//int numero=0; // Retien le nï¿½ du polygone sur lequel est la souris
	Polygon pol;
	Graphics2D g2d;
	BufferedImage bim;
	Rectangle r;
	Graphics graph;
	
	
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
		Polygon hexagone=getPolygon(0, 0, cote); // Crï¿½e un hexagone
		r=hexagone.getBounds(); // Rï¿½cupï¿½re le plus petit rectangle // aux bord de la fenï¿½tre dans lequel l'hexagone peut s'inscrire
		graph.setColor(Color.BLACK);
		super.paint(graph);
		g2d=(Graphics2D) graph;
		this.graph=graph;
		bim = null;
		
		for(int l=0;l<Jeu.MAPLIGNE;l=l+2){// Remarquer le "+2" car la grille est constituï¿½e de 2 sous grilles (les lignes impaires sont dï¿½callï¿½es)
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
		for(ArrayList<Integer> listeUnite:Jeu.getInfoUnite()) {
			try {
				switch(listeUnite.get(1)) {
					case 1:
						bim=ImageIO.read(new File("guerrier"+listeUnite.get(0)+".png"));
						break;
					case 2:
						bim=ImageIO.read(new File("mage"+listeUnite.get(0)+".png"));
						break;
					case 3:
						bim=ImageIO.read(new File("archer"+listeUnite.get(0)+".png"));
						break;
					case 4:
						bim=ImageIO.read(new File("pretre"+listeUnite.get(0)+".png"));
						break;
					case 5:
						bim=ImageIO.read(new File("chevalier"+listeUnite.get(0)+".png"));
						break;
					
				}
			}
			catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bim!=null) {
				g2d =(Graphics2D) graph;
				if(listeUnite.get(2)%2==0) {
					if(listeUnite.get(1)==2) {
						g2d.drawImage(bim, listeUnite.get(3)*r.width+5,(int)(listeUnite.get(2)*cote*1.5), this);
					}
					else {
						g2d.drawImage(bim, listeUnite.get(3)*r.width+5,(int)(listeUnite.get(2)*cote*1.5)+7, this);//+7 pour recentrer l'image
					}
				}
				else {
					if(listeUnite.get(1)==2) {
						g2d.drawImage(bim, listeUnite.get(3)*r.width+r.width/2+5,(int)(listeUnite.get(2)*cote*1.5+0.5),this);
					}
					else {
						g2d.drawImage(bim, listeUnite.get(3)*r.width+r.width/2+5,(int)(listeUnite.get(2)*cote*1.5+0.5)+7,this);
					}
				}
				repaint();
			}
		}
		Polygon poly = null;
		if(Jeu.getDeplacementPossible()!=null) {
			for(ArrayList<Integer>deplacementPossible:Jeu.getDeplacementPossible()) {
				if (deplacementPossible.get(0)%2==0) {
					poly=getPolygon(deplacementPossible.get(1)*r.width,(int)(deplacementPossible.get(0)*cote*1.5),cote);
				}
				else {
					poly=getPolygon(deplacementPossible.get(1)*r.width+r.width/2,(int)(deplacementPossible.get(0)*cote*1.5+0.5),cote);
				}
				if(poly!=null) {
					g2d.setColor(Color.PINK);
					g2d.draw(poly);
				}
			}
		}
	
	}

}
