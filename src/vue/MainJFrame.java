package vue;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Jeu;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * MainJFrame est la fenêtre du jeu.
 * @author Stefano
 *
 */
public class MainJFrame {
    /**
     * Fenetre principale du jeu.
     */
    private JFrame frame;

    /**
     * Coordonnées de la souris.
     */
    private Point mouse = new Point(-1, -1);
    /**
     * Caractéristiques de l'unité séléctionée.
     */
    private ArrayList<JLabel> listeCaractAffichage = new ArrayList<JLabel>();
    /**
     * String pour représenter le séparateur de fichier que ce soit sur Linux ou
     * Windows.
     */
    private String separateur = System.getProperty("file.separator");
    /**
     * Image de l'unité sélectionnée.
     */
    private PaintImage image = new PaintImage("images" + separateur + "ptInterrogation.png");

    /**
     * Dernière attaque.
     */
    private JLabel labelLastAtt;

    /**
     * Crée l'application.
     */
    public MainJFrame() {
        initialize();
    }

    /**
     * Initialise le contenu de la fenêtre.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1300, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Jeu.setPlateau(new Affplateau());
        Jeu.getPlateau().setBounds(0, 21, 1048, 591);
        Jeu.getPlateau().addMouseListener(new MouseListener() {

            public void mouseClicked(final MouseEvent e) {
            }

            public void mousePressed(final MouseEvent e) {
                mouse = e.getPoint();
                Jeu.setClicFlag(true);
                System.out.println();
                ArrayList<String> caracteristiquesUnite = Jeu.getCaractUniteEnMouvement(Jeu.getCoordHexaClicked());
                if (!caracteristiquesUnite.isEmpty()) {
                    listeCaractAffichage.get(0).setText(caracteristiquesUnite.get(0));
                    listeCaractAffichage.get(1).setText(caracteristiquesUnite.get(1));
                    listeCaractAffichage.get(2).setText(caracteristiquesUnite.get(2));
                    listeCaractAffichage.get(3).setText(caracteristiquesUnite.get(3));
                    listeCaractAffichage.get(4).setText(caracteristiquesUnite.get(4));
                    listeCaractAffichage.get(5).setText(caracteristiquesUnite.get(5));

                    switch (Integer.parseInt(caracteristiquesUnite.get(6))) {
                    case Jeu.ARCHER:
                        image = new PaintImage("images" + separateur + "GrandArcher.png");
                        break;
                    case Jeu.CHEVALIER:
                        image = new PaintImage("images" + separateur + "GrandChevalier.png");
                        break;
                    case Jeu.GUERRIER:
                        image = new PaintImage("images" + separateur + "GrandGuerrier.png");
                        break;
                    case Jeu.PRETRE:
                        image = new PaintImage("images" + separateur + "GrandPretre.png");
                        break;
                    case Jeu.MAGE:
                        image = new PaintImage("images" + separateur + "GrandMage.png");
                        break;
                    default:
                        break;
                    }
                }
                labelLastAtt.setText(Jeu.getLastAttaque());
            }

            public void mouseReleased(final MouseEvent e) {
            }

            public void mouseEntered(final MouseEvent e) {
            }

            public void mouseExited(final MouseEvent e) {
            }

        });
        frame.getContentPane().add(Jeu.getPlateau());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1300, 21);
        frame.getContentPane().add(menuBar);

        JMenu mnFichier = new JMenu("Fichier");

        menuBar.add(mnFichier);

        JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
        mntmEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                JFileChooser choix = new JFileChooser();
                choix.setCurrentDirectory(new File(
                        "." + System.getProperty("file.separator") + "saves" + System.getProperty("file.separator")));
                int retour = choix.showSaveDialog(frame);
                if (retour == JFileChooser.APPROVE_OPTION) {
                    Jeu.sauvegarderPartie("." + System.getProperty("file.separator") + "saves"
                            + System.getProperty("file.separator") + choix.getSelectedFile().getName());
                    JOptionPane.showMessageDialog(null, "Partie enregistrée", "Sauvegarde",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        mnFichier.add(mntmEnregistrer);

        JMenuItem mntmRetourMenu = new JMenuItem("Retour Menu");
        mntmRetourMenu.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                Jeu.kill();
            }
        });
        mnFichier.add(mntmRetourMenu);

        JPanel panel = new JPanel();
        panel.setBounds(1048, 21, 236, 591);
        frame.getContentPane().add(panel);

        JButton btnNewButton = new JButton("Fin de tour");
        btnNewButton.setBounds(61, 486, 116, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
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

        image.setBounds(10, 11, 216, 270);
        panel.add(image);

        labelLastAtt = new JLabel("");
        labelLastAtt.setBounds(10, 520, 216, 60);
        panel.add(labelLastAtt);

    }

    /**
     * Renvoie la fenêtre principale.
     * @return La fenêtre principale.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Renvoie la position du clic.
     * @return la position du clic.
     */
    public Point getClicPos() {
        return mouse;
    }
}
