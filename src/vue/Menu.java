package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

import controleur.Jeu;
import controleur.MainJFrame;

public class Menu {
		
	private JFrame frame;
	String separateur = System.getProperty("file.separator"); //séparateur de fichier pour Linux ou Windows

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
	}

	/**
	 * Create the application.
	 */
	public Menu() {
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

		Image imagefond = null;
		try {
			imagefond = ImageIO.read(new File("images"+separateur+"back.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		CustomPanel panel = new CustomPanel(imagefond);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		panel.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);

		Integer[] items= {2,3,4};
        JComboBox<Integer> liste_1=new JComboBox<Integer>(items);
        liste_1.setBounds(145,161,272,36);
        liste_1.setPreferredSize(new Dimension(80,40));
        liste_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Dimension buttonSize = new Dimension(125, 50);
		JButton jvj = new JButton("Joueur VS Joueur");
		jvj.setBounds(145,161,272,36);
		jvj.setPreferredSize(new Dimension(200,40));
		jvj.setAlignmentX(Component.CENTER_ALIGNMENT);
		jvj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Integer nbJoueur = (Integer) liste_1.getSelectedItem();
                //frame.setVisible(false);
                Jeu.init(nbJoueur, 0);
                
                
            }
		});
		
		Integer[] items2= {0,1,2,3,4};
        JComboBox<Integer> liste_2=new JComboBox<Integer>(items2);
        liste_2.setBounds(145,161,272,36);
        liste_2.setPreferredSize(new Dimension(80,40));
        liste_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Integer[] items3= {0,1,2,3,4};
        JComboBox<Integer> liste_3=new JComboBox<Integer>(items3);
        liste_3.setBounds(145,161,272,36);
        liste_3.setPreferredSize(new Dimension(80,40));
        liste_3.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton jva = new JButton("Joueur Vs IA");
		jva.setBounds(145,161,272,36);
		jva.setPreferredSize(new Dimension(200,40));
		jva.setAlignmentX(Component.CENTER_ALIGNMENT);
		jva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Integer nbJoueur = (Integer) liste_2.getSelectedItem();
                Integer nbIA = (Integer) liste_3.getSelectedItem();
                if(nbJoueur + nbIA < 2 || nbJoueur + nbIA > 4) {
                    JOptionPane erreur = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Merci de sélectionner un nombre total de joueurs compris entre 2 et 4.", "Mauvais nombre de joueur", JOptionPane.WARNING_MESSAGE);
                } else {
                    frame.setVisible(false);
                    Jeu.init(nbJoueur, nbIA);
                    
                }
            }
        });
		
		
		
		JButton cp = new JButton("Charger une partie");
		cp.setBounds(145,161,272,36);
		cp.setPreferredSize(new Dimension(200,40));
		cp.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton r = new JButton("Règles");
		r.setBounds(145,161,272,36);
		r.setPreferredSize(new Dimension(200,40));
		r.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		JLabel label1 =new JLabel("Nb Joueur");
		label1.setFont(new Font("Serif",Font.BOLD,17));
		label1.setForeground(Color.white);
		
		JLabel label2 =new JLabel("Nb Joueur");
		label2.setFont(new Font("Serif",Font.BOLD,17));
		label2.setForeground(Color.white);
		
		JLabel label3=new JLabel("Nb IA");
		label3.setFont(new Font("Serif",Font.BOLD,17));
		label3.setForeground(Color.white);
		
		//jva.addActionListener((ActionEvent e) -> {
			//System.exit(0);
		//});
		
		sl_panel.putConstraint(SpringLayout.NORTH, jvj, 230, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, jvj, 550, SpringLayout.WEST, panel);
		
		sl_panel.putConstraint(SpringLayout.NORTH, liste_1, 230, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, liste_1, 780, SpringLayout.WEST, panel);
	
		
		sl_panel.putConstraint(SpringLayout.NORTH, label1, 230, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label1, 879, SpringLayout.WEST, panel);
		
		
		sl_panel.putConstraint(SpringLayout.WEST, jva, 0, SpringLayout.WEST, jvj);
		sl_panel.putConstraint(SpringLayout.SOUTH, jva, 100, SpringLayout.NORTH, jvj);
		
		sl_panel.putConstraint(SpringLayout.NORTH, liste_2, 0, SpringLayout.NORTH, jva);
		sl_panel.putConstraint(SpringLayout.WEST, liste_2, 230, SpringLayout.WEST, jva);
		
		sl_panel.putConstraint(SpringLayout.NORTH, label2, 0, SpringLayout.NORTH, jva);
		sl_panel.putConstraint(SpringLayout.WEST, label2, 330, SpringLayout.WEST, jva);
		
		sl_panel.putConstraint(SpringLayout.NORTH, liste_3, 0, SpringLayout.NORTH, jva);
		sl_panel.putConstraint(SpringLayout.WEST, liste_3, 420, SpringLayout.WEST, jva);
		
		sl_panel.putConstraint(SpringLayout.NORTH, label3, 0, SpringLayout.NORTH, jva);
		sl_panel.putConstraint(SpringLayout.WEST, label3, 510, SpringLayout.WEST, jva);
		
		sl_panel.putConstraint(SpringLayout.WEST, cp, 0, SpringLayout.WEST, jva);
		sl_panel.putConstraint(SpringLayout.SOUTH, cp, 100, SpringLayout.NORTH, jva);
		
		sl_panel.putConstraint(SpringLayout.WEST, r, 0, SpringLayout.WEST,cp);
		sl_panel.putConstraint(SpringLayout.SOUTH, r, 100, SpringLayout.NORTH, cp);
		
		panel.add(jva);
		panel.add(jvj);
		panel.add(cp);
		panel.add(r);
		panel.add(liste_1);
		panel.add(liste_2);
		panel.add(liste_3);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);

		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

}
