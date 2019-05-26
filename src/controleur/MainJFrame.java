package controleur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


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
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 21, 1048, 591);
		frame.getContentPane().add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1184, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
		mnFichier.add(mntmEnregistrer);
		
		JPanel panel = new JPanel();
		panel.setBounds(1048, 21, 136, 591);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Fin de tour");
		btnNewButton.setBounds(10, 484, 116, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Attaque :");
		lblNewLabel.setBounds(10, 379, 65, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Defense :");
		lblNewLabel_1.setBounds(10, 354, 65, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vision :");
		lblNewLabel_2.setBounds(10, 404, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblPv = new JLabel("PV max : ");
		lblPv.setBounds(10, 329, 46, 14);
		panel.add(lblPv);
		
		JLabel lblPointDeVie = new JLabel("PV restant : ");
		lblPointDeVie.setBounds(10, 304, 76, 14);
		panel.add(lblPointDeVie);
		
		JLabel lblPointDeDeplacement = new JLabel("PM : ");
		lblPointDeDeplacement.setBounds(10, 435, 116, 14);
		panel.add(lblPointDeDeplacement);
	}

	public JFrame getFrame() {
		return frame;
	}
	/*
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}*/
}
