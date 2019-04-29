package wargame;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JPanel {
	/*public Interface(){
		this.setSize(300,300);
		this.setVisible(true);
		this.setIconImage(new ImageIcon(getClass().getResource("/background.jpg")).getImage());*/
	
JFrame window=new JFrame();
	Interface(){
	//window.setUndecorated(true);	
		try 
		{
			File sound=new File("sounds//warsound.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip=AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			
		}catch(Exception e) {System.out.println(e);}
	
	window.setLocation(50,50);
	window.add(this);
	window.setSize(900,500);
	window.setVisible(true);
	try{Thread.sleep(8000);
	window.dispose();
	Menu m=new Menu();}catch(Exception e) {System.out.println(e);}
	}
	public void paint(Graphics g)
	{
	// this.setIconImage (new ImageIcon(getClass().getResource("/background.jpg")).getImage());
		ImageIcon background=new ImageIcon("images//background.jpg");
		g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),null); 
	}}

