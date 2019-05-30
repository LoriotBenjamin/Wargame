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
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MainJFrame {

	private JFrame frame;
	private boolean state = false;
	private Point mouse = new Point(-1,-1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu.initMap();
					MainJFrame window = new MainJFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		Affplateau scrollPane = new Affplateau();
		scrollPane.setBounds(0, 21, 1048, 591);
		scrollPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				mouse = e.getPoint();
				Jeu.setClicFlag(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		frame.getContentPane().add(scrollPane);
		
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
	}

	public JFrame getFrame() {
		return frame;
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
