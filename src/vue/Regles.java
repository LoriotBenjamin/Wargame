package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
//import javafx.stage.Stage;
import javax.swing.border.LineBorder;

public class Regles {
	
	private JFrame frame;
	/**
     * String pour représenter le séparteur de fichier que ce sois sur linux ou windows.
     */
	private String separateur = System.getProperty("file.separator"); //séparateur de fichier pour Linux ou Windows


	/**
	 * Create the application.
	 */
	public Regles() {
		//@Override
	//	public void start(Stage primaryStage)
		//{}
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		Dimension size = new Dimension(1300, 650);
		frame = new JFrame("Wargame");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
	
		
	
		JLabel label=new JLabel();
		JLabel labelP1=new JLabel();
		JLabel labelP2=new JLabel();
		JLabel labelP3=new JLabel();
		JLabel labelP4=new JLabel();
		JLabel labelP5=new JLabel();
		JLabel labelTerrain=new JLabel();
	
		
		label.setText("<html><body><font size=\"+1\">Wargame est une succession de tours de jeu. Chaque tour permet successivement aux </font><p><b> " +
	            "<font size=\"+1\">adversaires d'effectuer diverses actions. Un joueur peut jouer tant qu'une de ses unités   </font>" +
	            "</b><p>possèdent  des points de déplacement. Quand un adversaire a terminé ses déplacements,  il "+  "</b><p> passe la main au joueur suivant. Eventuellement, "
	            		+ "il peut rester des points de déplacement  "+"</b><p>à certaines de ces unités. "+"</b><p>Dans un scénario, "
	            	+ "chaque adversaire peut avoir des conditions de victoire différentes." + 
	            		  "</b><p>Deux conditions de victoire sont possibles :Destruction complète de l'armée adverse : cela  "+ "</b><p>représente la réussite de l'attaque d'un objectif"
	            		  		+ ", ou Atteindre un numéro de tour sans avoir été "+  
	                  		  "</b><p>détruit, et après un nombre donné de tours,si un joueur possède encore au moins une unité : cela "+
	                  		"</b><p>correspond à la réussite de la défense d'un objectif"+
	                     " "+  "</body></html>" );
		label.setFont(new Font("Serif",Font.BOLD,17));
		label.setForeground(Color.white);
		labelP1.setText("<html><body><font size=\"+1\">Le Guerrier dispose d'un potentiel d'attaque égale à 18 points </font><p><b> " +
	            "<font size=\"+1\">Un potentiel de défense égale à 10 points   </font>" +
	            "</b><p>Des points de vie égaux à 46, une vitesse de déplacement égale à 3 "
	            		 +"</b><p>vision est égale à 2 et portée est égale à 1 points"+
	                     " "+  "</body></html>" );
		
		
		 labelP1.setFont(new Font("Serif",Font.BOLD,17));
		 labelP1.setForeground(Color.white);
		 
		 labelP2.setText("<html><body><font size=\"+1\">Le Mage dispose d'un potentiel d'attaque égale à 16 points </font><p><b> " +
		            "<font size=\"+1\">Un potentiel de défense égale à 4 points   </font>" +
		            "</b><p>Des points de vie égaux à 34, une vitesse de déplacement égale à 3 "
		            		 +"</b><p>vision est égale à 3 et portée est égale à 2 points"+
		                     " "+  "</body></html>" );
			
			
		 labelP2.setFont(new Font("Serif",Font.BOLD,17));
		 labelP2.setForeground(Color.white);
		 
		 labelP3.setText("<html><body><font size=\"+1\">Le Archer dispose d'un potentiel d'attaque égale à 14 points </font><p><b> " +
		            "<font size=\"+1\">Un potentiel de défense égale à 6 points   </font>" +
		            "</b><p>Des points de vie égaux à 38, une vitesse de déplacement égale à 4 "
		            		 +"</b><p>Une vision égale à 4 et portée est égale à 3 points"+
		                     " "+  "</body></html>" );
			
			
		 labelP3.setFont(new Font("Serif",Font.BOLD,17));
		 labelP3.setForeground(Color.white);
		 
		 labelP4.setText("<html><body><font size=\"+1\">Le Prêtre dispose d'un potentiel d'attaque égale à 6 points </font><p><b> " +
		            "<font size=\"+1\">Un potentiel de défense égale à 4 points   </font>" +
		            "</b><p>Des points de vie égaux à 40, une vitesse de déplacement est égale à 4 "
		            		 +"</b><p>Une vision égale à 2 et portée est égale à 1 points"+
		                     " "+  "</body></html>" );
			
			
		 labelP4.setFont(new Font("Serif",Font.BOLD,17));
		 labelP4.setForeground(Color.white);
		 
		 labelP5.setText("<html><body><font size=\"+1\">Le Chevalier dispose d'un potentiel d'attaque égale à 20 points </font><p><b> " +
		            "<font size=\"+1\">Un potentiel de défense égale à 8 points   </font>" +
		            "</b><p>Des points de vie est égale à 50, une vitesse de déplacement est égale à 6 "
		            		 +"</b><p>Une vision égale à 2 et portée est égale à 1 points"+
		                     " "+  "</body></html>" );
			
			
		 labelP5.setFont(new Font("Serif",Font.BOLD,17));
		 labelP5.setForeground(Color.white);
		 
		 labelTerrain.setText("<html><body><font size=\"+1\">La forêt utilise 2 points de déplacement et octroit 50% de défense.</font><p><b>"+
				 "<font size=\"+1\">La montagne utilise 3 points de déplacement et octroit 70% de défense.</font></b><p>"+
				 "<font size=\"+1\">La plaine utilise 1 point de déplacement et octroit 10% de défense.</font></b><p>"+
				 "<font size=\"+1\">La désert utilise 2 point de déplacement et octroit 10% de défense.</font></b><p>"+
				 "<font size=\"+1\">La rivière utilise 2 point de déplacement et octroit 10% de défense.</font></b><p>"+
				 "<font size=\"+1\">La mer utilise 0 point de déplacement et octroit 0% de défense.</font></b><p>"+
				 "<font size=\"+1\">La Ville/village utilise 1 point de déplacement et octroit 30% de défense.</font>"+" "+  "</body></html>");
		 labelTerrain.setFont(new Font("Serif",Font.BOLD,17));
		 labelTerrain.setForeground(Color.white);
	
	
		Image imagefond = null;
		try {
			imagefond = ImageIO.read(new File("images"+separateur+"regles.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	
		JButton exit=new JButton("Retour au Menu");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		CustomPanel panel = new CustomPanel(imagefond);
		
		SpringLayout sl_panel = new SpringLayout();
		panel.setPreferredSize(new Dimension(1250,1300));
		panel.setLayout(sl_panel);
		panel.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		sl_panel.putConstraint(SpringLayout.NORTH, label, 150, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 290, SpringLayout.WEST, panel);
		
		sl_panel.putConstraint(SpringLayout.WEST, labelP1, 100, SpringLayout.WEST, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelP1, 360, SpringLayout.NORTH, label);
		
		sl_panel.putConstraint(SpringLayout.WEST, labelP2, 0, SpringLayout.WEST, labelP1);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelP2, 200, SpringLayout.NORTH, labelP1);
		
		sl_panel.putConstraint(SpringLayout.WEST, labelP3, 0, SpringLayout.WEST, labelP2);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelP3, 200, SpringLayout.NORTH, labelP2);
		
		sl_panel.putConstraint(SpringLayout.WEST, labelP4, 0, SpringLayout.WEST, labelP3);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelP4, 200, SpringLayout.NORTH, labelP3);
		
		sl_panel.putConstraint(SpringLayout.WEST, labelP5, 0, SpringLayout.WEST, labelP4);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelP5, 200, SpringLayout.NORTH, labelP4);
		
		sl_panel.putConstraint(SpringLayout.WEST, labelTerrain, 0, SpringLayout.WEST, labelP5);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelTerrain, 300, SpringLayout.NORTH, labelP5);
	
		sl_panel.putConstraint(SpringLayout.WEST, exit, 100, SpringLayout.WEST, labelTerrain);
		sl_panel.putConstraint(SpringLayout.SOUTH, exit, 250, SpringLayout.NORTH, labelTerrain);
	   
		panel.add(label);
		panel.add(labelP1);
		panel.add(labelP2);
		panel.add(labelP3);
		panel.add(labelP4);
		panel.add(labelP5);
		panel.add(labelTerrain);
		panel.add(exit);
	
	   JScrollPane sp = new JScrollPane();
	   
	   sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_ALWAYS);
	   sp.setViewportView(panel);
	   sp.setPreferredSize(new Dimension(1300, 650));
	    
	  frame.add(sp); // add acrollpane to frame
		
	  
		
		
	
		//frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

}

