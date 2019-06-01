package controleur;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import vue.Affplateau;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import modele.Joueur;
import modele.Unite;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainJFrame {

	private JFrame frame;
	private boolean state = false;
	private Point mouse = new Point(-1,-1);
	private ArrayList <JLabel> listeCaractAffichage = new ArrayList<JLabel>();


	/**
	 * Create the application.
	 */
	public MainJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Jeu.setPlateau(new Affplateau());
		Jeu.getPlateau().setBounds(0, 21, 1048, 591);
		Jeu.getPlateau().addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				mouse = e.getPoint();
				Jeu.setClicFlag(true);
				Unite uniteSelec = getUniteEnMouvement(Jeu.getHexagonClicked());
				if(uniteSelec != null){
					listeCaractAffichage.get(0).setText(String.valueOf(uniteSelec.getPv()));
					listeCaractAffichage.get(1).setText(String.valueOf(uniteSelec.getPvMax()));
					listeCaractAffichage.get(2).setText(String.valueOf(uniteSelec.getDefense()));
					listeCaractAffichage.get(3).setText(String.valueOf(uniteSelec.getAttaque()));
					listeCaractAffichage.get(4).setText(String.valueOf(uniteSelec.getVision()));
					listeCaractAffichage.get(5).setText(String.valueOf(uniteSelec.getPtDeDeplacement()));
				}else
					System.out.println("Trouve pas unite");
			}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}
			
		});
		frame.getContentPane().add(Jeu.getPlateau());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1300, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
		mnFichier.add(mntmEnregistrer);
		
		JMenuItem mntmRetourMenu = new JMenuItem("Retour Menu");
		mnFichier.add(mntmRetourMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(1048, 21, 236, 591);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Fin de tour");
		btnNewButton.setBounds(73, 486, 116, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jeu.setSkipFlag(true);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Attaque :");
		lblNewLabel.setBounds(10, 379, 91, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9fense :");
		lblNewLabel_1.setBounds(10, 354, 129, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vision :");
		lblNewLabel_2.setBounds(10, 404, 91, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblPv = new JLabel("PV max : ");
		lblPv.setBounds(10, 329, 91, 14);
		panel.add(lblPv);
		
		JLabel lblPointDeVie = new JLabel("PV restant : ");
		lblPointDeVie.setBounds(10, 304, 116, 14);
		panel.add(lblPointDeVie);
		
		JLabel lblPointDeDeplacement = new JLabel("Point de mouvement : ");
		lblPointDeDeplacement.setBounds(10, 435, 158, 14);
		panel.add(lblPointDeDeplacement);
		

		JLabel lblNewLabelAffichagePvRest = new JLabel("Pv rest");
		lblNewLabelAffichagePvRest.setBounds(94, 304, 46, 14);
		panel.add(lblNewLabelAffichagePvRest);
		listeCaractAffichage.add(lblNewLabelAffichagePvRest);
		
		JLabel labelAffichagePvMax = new JLabel("Pv max");
		labelAffichagePvMax.setBounds(93, 329, 46, 14);
		panel.add(labelAffichagePvMax);
		listeCaractAffichage.add(labelAffichagePvMax);
		
		JLabel labelAffichageDefense = new JLabel("Def");
		labelAffichageDefense.setBounds(94, 354, 46, 14);
		panel.add(labelAffichageDefense);
		listeCaractAffichage.add(labelAffichageDefense);
		
		JLabel labelAffichageAttaque = new JLabel("Att");
		labelAffichageAttaque.setBounds(93, 379, 46, 14);
		panel.add(labelAffichageAttaque);
		listeCaractAffichage.add(labelAffichageAttaque);
		
		JLabel labelVision = new JLabel("Vision");
		labelVision.setBounds(94, 404, 46, 14);
		panel.add(labelVision);
		listeCaractAffichage.add(labelVision);
		
		JLabel labelAffichagePtDeDeplacement = new JLabel("PM");
		labelAffichagePtDeDeplacement.setBounds(136, 435, 46, 14);
		panel.add(labelAffichagePtDeDeplacement);
		listeCaractAffichage.add(labelAffichagePtDeDeplacement);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	  public static Unite getUniteEnMouvement(Point hexa){
			
	    	int px=(int)hexa.getX();
			int py=(int)hexa.getY();
			
	    	for(Joueur j: Jeu.getListeJoueurs() ){
	    		for(Unite u : j.getListeUnite()){
	    			if(px == u.getX() && py == u.getY())
	    				return u; 
	    		}
	    			    			
	    	}
	    	return null;
	    	
	    }
	
	public Point getClicPos() {
		System.out.println(mouse);
		return mouse;
	}
	/*
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}*/
}
