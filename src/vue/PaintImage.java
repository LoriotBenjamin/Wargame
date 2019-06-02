package vue;

import javax.swing.*; 
import java.io.*; 
import java.awt.*; 
import java.awt.image.*; 
import javax.imageio.*; 
/**
 * PaintImage qui peint une image de l'unité selectionnée.
 * @author Stefano
 *
 */
public class PaintImage extends JPanel {
	/**
	 * Image que l'on veut peindre.
	 */
  public static BufferedImage image; 
  /**
	 * Image que l'on veut peindre.
	 */
  public PaintImage (String path) { 
    super(); 
    try{
    	
      image = ImageIO.read(new File(path)); 
    } 
    catch (IOException e) 
    { 
      //Not handled. 
    } 
  } 
  /**
	 * Lit l'image du fichier.
	 */
  public void setImage(String path){
	  try {
		image = ImageIO.read(new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  /**
	 * Fonction appellé automatiquement à la création de l'objet.
	 */
  public void paintComponent(Graphics g) 
  { 
	  Color coul = new Color(255,255,255);
    g.drawImage(image, 0, 0,coul,null); 
    repaint(); 
  } 

  
}