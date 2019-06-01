package vue;

import javax.swing.*; 
import java.io.*; 
import java.awt.*; 
import java.awt.image.*; 
import javax.imageio.*; 

public class PaintImage extends JPanel {
	
  public static BufferedImage image; 
  
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

  public void setImage(String path){
	  try {
		image = ImageIO.read(new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public void paintComponent(Graphics g) 
  { 
	  Color coul = new Color(255,255,255);
    g.drawImage(image, 0, 0,coul,null); 
    repaint(); 
  } 

  
}